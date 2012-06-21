#takes a list of upper onts as an argument an outputs the ontologies that potientially use that upper ont

from SPARQLWrapper import SPARQLWrapper, JSON, XML, N3, RDF
import pdb
import codecs, sys
sys.stdout = codecs.getwriter('utf8')(sys.stdout)

def checkULO(clist,cname):
	for row in clist["results"]["bindings"]:
		if cname.lower() in row["c"]["value"].lower() or cname.lower() in row["prefLabel"]["value"].lower():
			return True
	return False

if __name__ == "__main__":
	in_file = open(sys.argv[1],'r')
	u_list=dict()
	for line in in_file:
		name,val=line.strip().split("|")
		u_list[name]=val
    
	#Eventually alphasparql will be moved to http://sparql.bioontology.org/sparql/
	sparql_service = "http://sparql.bioontology.org/sparql/"
    #To get your API key register at http://bioportal.bioontology.org/accounts/new
	api_key = ''
	g_query = """
PREFIX omv: <http://omv.ontoware.org/2005/05/ontology#>
PREFIX meta: <http://bioportal.bioontology.org/metadata/def/> 

SELECT DISTINCT ?id ?graph ?name
WHERE { 
    ?id meta:hasVersion ?version .
    ?version meta:hasDataGraph ?graph .
    ?version omv:name ?name . 
}
"""
	sparql = SPARQLWrapper(sparql_service)
	sparql.addCustomParameter("apikey",api_key)
	sparql.setQuery(g_query)
	sparql.setReturnFormat(JSON)
	results = sparql.query().convert()
	for result in results["results"]["bindings"]:
		query_string = """ 
PREFIX owl:  <http://www.w3.org/2002/07/owl#>
PREFIX skos: <http://www.w3.org/2004/02/skos/core#>
SELECT distinct ?c ?prefLabel
FROM <http://bioportal.bioontology.org/ontologies/globals> 
FROM <""" + result["graph"]["value"] + """>
WHERE { ?c a owl:Class.
		?c skos:prefLabel ?prefLabel .
} 
"""
		sparql.setQuery(query_string)
		class_results = sparql.query().convert()
		for key,value in u_list.items():
			if checkULO(class_results,value):
				print "|".join([result["name"]["value"],result["id"]["value"],key])
