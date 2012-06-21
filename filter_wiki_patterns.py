#Takes a file as an argument (see wiki_patterns_list as an example) and returns the ont names that contain all necessary relations for that pattern


from SPARQLWrapper import SPARQLWrapper, JSON, XML, N3, RDF
import pdb
import codecs, sys, re
sys.stdout = codecs.getwriter('utf8')(sys.stdout)

first_cap_re = re.compile('(.)([A-Z][a-z]+)')
all_cap_re = re.compile('([a-z0-9])([A-Z])')

def checkPattern(objList,elements):
	for rel in elements:
		if not checkPatternRelation(objList,rel):
			return False
	return True
	
def checkPatternRelation(objList,elem):
	for row in objList["results"]["bindings"]:
		name=row["label"]["value"]
		no_camel=uncamel(elem)
		if elem in name: #or no_camel in name or no_camel.replace("_"," ") in name or no_camel.replace("_","-") in name:
			return True
	return False
	

def uncamel(name):
    s1 = first_cap_re.sub(r'\1_\2', name)
    return all_cap_re.sub(r'\1_\2', s1).lower()

if __name__ == "__main__":
    in_file = open(sys.argv[1],'r')
    plist=dict()
    for line in in_file:
        name,val=line.strip().split("|")
        plist[name]=val.split(";")
    
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
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
SELECT distinct ?label
WHERE { 
  
  GRAPH <""" + result["graph"]["value"] + """> { 
  
        {
        ?c a owl:ObjectProperty .
	?c rdfs:label ?label . 
        }
        UNION
    	{
        ?c a owl:DataProperty .
		?c rdfs:label ?label . 
        }
        UNION
        {
        ?label a owl:DataProperty .
        }
        UNION
        {
        ?label a owl:ObjectProperty .
        }
        UNION
        {
        ?d ?label ?e
        }
  }
        
}
"""
        sparql.setQuery(query_string)
        obj_results = sparql.query().convert()
        #for each pattern
        for key,val in plist.items():
        	if checkPattern(obj_results,val):
        		print "|".join([result["name"]["value"],result["id"]["value"],key])
                    
