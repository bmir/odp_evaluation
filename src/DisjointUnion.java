
public class DisjointUnion {

	public static String getValuePartition(int size){
		StringBuilder vp = new StringBuilder();
		vp.append(getValueClasses(size,"v") + ", ?param:CLASS\n"
				+"SELECT \n"
				+"ASSERTED ?param "+getEQCS(size,"v")+", \n"
				+"ASSERTED "+ getDisjointAxiom(size,"v") +"\n"
				+"BEGIN \n"
				+"ADD ?v0 subClassOf Thing \n"
				+"END;");
		return vp.toString();
	}
	
	//might want to make the has_feature and has_value more general
	public static String getEntityFeatureValue(int m_size, int a_size){
		StringBuilder ev = new StringBuilder();
		ev.append("?feat:CLASS, ?x_feat:CLASS, ?cat:CLASS, ?main_cat:CLASS, ?ent:CLASS, ?ent_cat:CLASS, \n"
				+getValueClasses(m_size,"mv")+", "+getValueClasses(a_size,"av") +",\n"
				+"?prop:OBJECTPROPERTY, \n" +
				"?hv:OBJECTPROPERTY = MATCH(\"[hH][aA][sS][_\\s\\-]*[vV][aA][lL][uU][eE]\"), \n" +
				"?hf:OBJECTPROPERTY = MATCH(\"[hH][aA][sS][_\\s\\-]*[fF][eE][aA][tT][uU][rR][eE] \" ) \n"
				+"SELECT \n"
				+"ASSERTED Functional ?prop, \n"
				+"ASSERTED ?prop Domain ?feat, \n"
				+"ASSERTED ?prop Range ?cat, \n"
				+"ASSERTED ?cat "+getEQCS(a_size,"av")+", \n"
				+"ASSERTED ?main_cat "+getEQCS(m_size,"mv")+", \n"
				+"ASSERTED "+ getDisjointAxiom(a_size,"av") +", \n"
				+"ASSERTED "+ getDisjointAxiom(m_size,"mv") +", \n"
				+"ASSERTED ?x_feat subClassOf ?feat, \n"
				+"ASSERTED ?x_feat subClassOf ?prop some ?av0, \n"
				+"ASSERTED ?x_feat subClassOf ?hv some ?mv0, \n"
				+"ASSERTED ?ent subClassOf ?ent_cat, \n"
				+"ASSERTED ?ent subClassOf ?hf exactly 1 ?x_feat \n"
				+"BEGIN \n"
				+"ADD ?feat subClassOf Thing \n"
				+"END;");
		return ev.toString();
	}
	
	public static String getSelector(int size){
		StringBuilder sel = new StringBuilder();
		sel.append("?use:CLASS, ?ent:CLASS, ?sel:CLASS, "+getValueClasses(size,"sv") +", ?prop1:OBJECTPROPERTY, ?prop2:OBJECTPROPERTY \n"
					+"SELECT \n"
					+"ASSERTED ?ent subClassOf ?prop1 some ?sel, \n"
					+"ASSERTED ?sel "+getEQCS(size,"sv")+", \n"
					+"ASSERTED "+getDisjointAxiom(size,"sv")+", \n"
					+"ASSERTED ?use subClassOf ?prop2 some (?ent and ?prop1 some ?sv1) \n"
					+"BEGIN \n"
					+"ADD ?use subClassOf Thing \n"
					+"END;");
		return sel.toString();
	}
	
	public static String getEntityQualityA(int size){
		StringBuilder sel = new StringBuilder();
		sel.append("?qual:CLASS, ?cat:CLASS, ?ent:CLASS, "+getValueClasses(size,"qv")+", ?prop:OBJECTPROPERTY \n"
				+"SELECT \n"
				+"ASSERTED ?qual subClassOf inv(?prop) only ?cat, \n"
				+"ASSERTED ?cat subClassOf ?prop exactly 1 ?qual, \n"
				+"ASSERTED ?qual "+getEQCS(size,"qv")+", \n"
				+"ASSERTED "+getDisjointAxiom(size,"qv")+", \n"
				+"ASSERTED ?ent subClassOf ?cat, \n"
				+"ASSERTED ?ent subClassOf ?prop exactly 1 ?qv1 \n"
				+"BEGIN \n"
				+"ADD ?qv0 subClassOf Thing \n"
				+"END;");
		return sel.toString();
	}
	
	public static String getEntityQualityB(int size){
		StringBuilder sel = new StringBuilder();
		sel.append("?qual:CLASS, ?cat:CLASS, ?ent:CLASS, "+getValueClasses(size,"qv")+", ?prop:OBJECTPROPERTY \n"
				+"SELECT \n"
				+"ASSERTED ?qual subClassOf inv(?prop) only ?cat, \n"
				+"ASSERTED ?cat subClassOf ?prop max 1 ?qual, \n"
				+"ASSERTED ?qual "+getEQCS(size,"qv")+", \n"
				+"ASSERTED "+getDisjointAxiom(size,"qv")+", \n"
				+"ASSERTED ?ent subClassOf ?cat, \n"
				+"ASSERTED ?ent subClassOf ?prop exactly 1 ?qv1 \n"
				+"BEGIN \n"
				+"ADD ?qv0 subClassOf Thing \n"
				+"END;");
		return sel.toString();
	}
	
	public static String getEntityPropertyQuality(int size){
		StringBuilder sel = new StringBuilder();
		sel.append("?qual:CLASS, ?ent:CLASS, ?cat:CLASS, "+getValueClasses(size,"qv") +", ?prop:OBJECTPROPERTY \n"
					+"SELECT \n"
					+"ASSERTED Functional ?prop, \n"
					+"ASSERTED ?prop Range ?qual, \n"
					+"ASSERTED ?prop Domain ?cat, \n"
					+"ASSERTED ?ent subClassOf ?cat, \n"
					+"ASSERTED ?qual "+getEQCS(size,"qv")+", \n"
					+"ASSERTED "+getDisjointAxiom(size,"qv")+", \n"
					+"ASSERTED ?ent subClassOf ?prop some ?qv1 \n"
					+"BEGIN \n"
					+"ADD ?cat subClassOf Thing \n"
					+"END;");
		return sel.toString();
	}

	private static String getValueClasses(int size,String name) {
		StringBuilder vals = new StringBuilder();
		for (int i=0;i<size;i++){
			vals.append("?"+name+i+":CLASS");
			if(i<size-1)
				vals.append(", ");
				
		}
		return vals.toString();
	}

	private static String getEQCS(int size,String name) {
		StringBuilder eqcs = new StringBuilder();
		eqcs.append("EquivalentTo (");
		for (int i=0;i<size;i++){
			eqcs.append("?"+name+i);
			if(i<size-1)
				eqcs.append(" or ");				
		}
		eqcs.append(")");
		return eqcs.toString();
	}

	private static String getDisjointAxiom(int size,String name){
		StringBuilder da = new StringBuilder();
		da.append("DisjointClasses: set(");
		for (int i=0;i<size;i++){
			da.append("?"+name+i);
			if(i<size-1)
				da.append(",");
		}
		da.append(")");
		return da.toString();
	}

}
