import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.coode.oppl.ChangeExtractor;
import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.OPPLParser;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.ParserFactory;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.QuickFailRuntimeExceptionHandler;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.utils.ClassHash;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.LoggerErrorListener;
import org.coode.parsers.common.exception.UnrecognisedSymbolParsingException;
import org.semanticweb.HermiT.Reasoner;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.ClassExpressionType;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owlapi.model.OWLObjectAllValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectUnionOf;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.reasoner.NodeSet;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.util.SimpleIRIMapper;

import uk.ac.manchester.cs.owlapi.modularity.ModuleType;
import uk.ac.manchester.cs.owlapi.modularity.SyntacticLocalityModuleExtractor;

import com.google.common.collect.HashMultimap;


public class queryOPPL {

	public static void main(String args[]){


		//checks if an ontology contains a pattern
		//if either ontology or screipts are folder, will loop through files, non-recursive
		if(args.length >= 3 && args[0].equals("-f")){
			File onto = new File(args[2]);
			File script = new File(args[1]);
			if(args.length==4 && args[3].equals("-n"))
				checkOntologyDirectory(onto, script, true);
			else{
				checkOntologyDirectory(onto, script);
			}
			System.exit(0);
		}
//		else if(args.length == 2 && args[0].equals("-p")){
//			File onto = new File(args[1]);
//			checkOntologyDirectory(onto);
//			System.exit(0);
//		}
//
//
//		//converts an opplscript to owl for visualization
//		else if(args.length == 3 && args[0].equals("-v")){
//			File script = new File(args[1]);
//			File output = new File(args[2]);
//
//			OPPL2OWL(script,output);
//			System.exit(0);
//		}
//
//		else if(args.length == 2 && args[0].equals("-c")){
//			File onto = new File(args[1]);
//			OWLOntologyManager m = OWLManager.createOWLOntologyManager();
//			getCanonicalForm(loadOntology(onto,m,true),IRI.create(onto));
//		}

		else{
			printUsage();
			System.exit(1);
		}

	}

	private static void checkAllCodedPatterns(OWLOntology o, OWLReasoner r) {
		int max = findEQCSize(o);
		try{
			Method vp = DisjointUnion.class.getDeclaredMethod("getValuePartition", new Class[]{int.class});
			if(max>1 && checkForPattern(o,r,(String)vp.invoke(null, new Object[] {max}))){
				for(Method m:DisjointUnion.class.getDeclaredMethods())
					if(Modifier.isPublic(m.getModifiers()))
						printResult(o,m.getName(),checkCodedPattern(o,r,m,max));
			}
			else{
				printHardCodedPatternsAsFalse(o);
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static boolean checkCodedPattern(OWLOntology o, OWLReasoner r, Method m, int max) {
		for(int i=2;i<=max;i++){
			try {
				if(!m.getName().equals("getEntityFeatureValue") && checkForPattern(o,r,(String)m.invoke(null, new Object[] {i})))
					return true;
				else if(m.getName().equals("getEntityFeatureValue")){
					for(int j=2;j<=max;j++){
						if(checkForPattern(o,r,(String)m.invoke(null, new Object[] {i,j})))
							return true;
					}
				}
				else{
					//keep looping
				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

//	private static void checkDirectoryForProfiles(File o) {
//		if (o.isDirectory()){
//			for (File onto: o.listFiles()){
//				if(onto.isFile()){
//					OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
//					OWLOntology curr = loadOntology(onto,manager,false);
//					if(curr!=null){
//						checkProfile(curr);
//						manager.removeOntology(curr);
//					}
//				}
//			}
//		}
//		else{
//			OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
//			OWLOntology curr = loadOntology(o,manager,false);
//			if (curr!=null){
//				checkProfile(curr);
//				manager.removeOntology(curr);
//			}
//		}
//	}

	private static boolean checkForPattern(OWLOntology o, OWLReasoner r, String script_contents) {

		ParserFactory pfactory = new ParserFactory(o.getOWLOntologyManager(),o, r);

		Logger logger = Logger.getLogger(queryOPPL.class.getName());
		ErrorListener eListen = new LoggerErrorListener(logger);

		OPPLParser opplparser = pfactory.build(eListen);

		OPPLScript opplscript = null;
		try{
			opplscript = opplparser.parse(script_contents);
		}
		catch(UnrecognisedSymbolParsingException e){
//			e.printStackTrace();
//			System.out.println(script_contents);
			return false;
		}

		RuntimeExceptionHandler exceptionhandler = new QuickFailRuntimeExceptionHandler();
		ChangeExtractor extractor = new ChangeExtractor(exceptionhandler,true);
		extractor.visit(opplscript);
		ConstraintSystem cs = opplscript.getConstraintSystem();
		Set<BindingNode> nodes = cs.getLeaves();
		
		if (nodes.size()>0){
//			for (BindingNode n: nodes){
//				System.out.print(n);
//			}
			return true;
		}
		else{
			return false;
		}
	}

	private static void checkOntology(OWLOntology o,File p){
		OWLReasoner r = loadReasoner(o);
		ClassHash.instance.hashStuff(o);
		if(p.isDirectory()){
			for(File pattern: p.listFiles()){
				if(pattern.isFile()){
					printResult(o,pattern.getName(),checkForPattern(o,r,File2String(pattern)));
				}
			}
			printResult(o,"adaptedSEP",adaptedSEPPattern(o));
			printResult(o,"list",listPattern(o));
			printResult(o,"definedClassDescription",definedClassPattern(o));
			printResult(o,"closure",closurePattern(o));
			checkAllCodedPatterns(o,r);
			printResult(o,"normalization",normalization(o));
		}
		else{
			printResult(o,p.getName(),checkForPattern(o,r,File2String(p)));
		}

	}

//	private static void checkOntologyDirectory(File o){
//		checkDirectoryForProfiles(o);
//	}

	private static void checkOntologyDirectory(File o, File p){
		checkOntologyDirectory(o,p,false);
	}

	//	public static
	//	<T extends Comparable<? super T>> List<T> asSortedList(Collection<T> c) {
	//	  List<T> list = new ArrayList<T>(c);
	//	  java.util.Collections.sort(list);
	//	  return list;
	//	}

	private static void checkOntologyDirectory(File o, File p,boolean norm){
		if (o.isDirectory()){
			for (File onto: o.listFiles()){
				if(onto.isFile()){
					OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
					OWLOntology curr = loadOntology(onto,manager,norm);
					if(curr!=null){
						checkOntology(curr,p);
						manager.removeOntology(curr);
					}
				}
			}
		}
		else{
			OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
			OWLOntology curr = loadOntology(o,manager,norm);
			if (curr!=null){
				checkOntology(curr,p);
				manager.removeOntology(curr);
			}
		}
	}

//	private static void checkProfile(OWLOntology o){
//		FileWriter fstream = null;
//		try {
//			fstream = new FileWriter("./profile_report/"+getOntFileName(o));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		BufferedWriter report = new BufferedWriter(fstream);
//		List<OWLProfile> p_list = new LinkedList<OWLProfile>();
//		p_list.add(new OWL2Profile());
//		p_list.add(new OWL2DLProfile());
//		p_list.add(new OWL2ELProfile());
//		p_list.add(new OWL2QLProfile());
//		p_list.add(new OWL2RLProfile());
//		for(OWLProfile p:p_list){
//			OWLProfileReport r = p.checkOntology(o);
//			HashSet<String> violations = new HashSet<String>();
//			for (OWLProfileViolation v: r.getViolations()){
//				violations.add(v.getClass().getSimpleName());
//			}
//			printProfile(o,p,r.isInProfile(),violations);
//			printReport(o,p,r.isInProfile(),r.getViolations(),report);
//		}
//		try {
//			report.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	private static boolean closurePattern(OWLOntology o){		
		for(OWLClass c: o.getClassesInSignature()){
			HashMultimap<OWLObjectPropertyExpression,OWLClassExpression> somevalues = HashMultimap.create();
			HashMap<OWLObjectPropertyExpression,Set<OWLClassExpression>> closure = new HashMap<OWLObjectPropertyExpression,Set<OWLClassExpression>>();
			for(OWLSubClassOfAxiom s: o.getSubClassAxiomsForSubClass(c)){
				if(s.getSuperClass().isAnonymous() && s.getSuperClass().getClassExpressionType()==ClassExpressionType.OBJECT_ALL_VALUES_FROM){
					OWLObjectAllValuesFrom ac = (OWLObjectAllValuesFrom)s.getSuperClass();
					closure.put((OWLObjectPropertyExpression) ac.getProperty(), ac.getFiller().asDisjunctSet());
				}
				else if(s.getSuperClass().isAnonymous() && s.getSuperClass().getClassExpressionType()==ClassExpressionType.OBJECT_SOME_VALUES_FROM){
					OWLObjectSomeValuesFrom sc = (OWLObjectSomeValuesFrom)s.getSuperClass();
					somevalues.put(sc.getProperty(), sc.getFiller());
				}
				else{
					//nothing
				}
			}

			for(Map.Entry pair:closure.entrySet()){
				if(somevalues.get((OWLObjectPropertyExpression) pair.getKey()).equals(pair.getValue())){
//					System.out.println(c.get);
					return true;
				}
			}

		}

		return false;
	}

	private static boolean definedClassPattern(OWLOntology o){
		for(OWLClass c:o.getClassesInSignature()){
			if(containsSomeValuesFromInEQC(o,c)){
				for(OWLSubClassOfAxiom s:o.getSubClassAxiomsForSubClass(c)){
					if(s.getSuperClass().isAnonymous() && s.getSuperClass().getClassExpressionType()==ClassExpressionType.OBJECT_SOME_VALUES_FROM)
						return true;
				}
			}
		}
		return false;
	}
	
	private static boolean containsSomeValuesFromInEQC(OWLOntology o, OWLClass c) {
		for(OWLEquivalentClassesAxiom eq: o.getEquivalentClassesAxioms(c)){
			for(OWLClassExpression e:eq.getClassExpressions()){
				if(e.getClassExpressionType()==ClassExpressionType.OBJECT_SOME_VALUES_FROM){
					return true;
				}
			}
		}
		return false;
	}

	private static String File2String(File script){
		String script_contents=null;
		try {
			script_contents = FileUtils.readFileToString(script);
		} catch (IOException e1) {
			e1.printStackTrace();
			return null;
		}
		return script_contents;
	}

	private static int findEQCSize(OWLOntology o) {
		int max=0;
		boolean union=true;
		for(OWLEquivalentClassesAxiom eq:o.getAxioms(AxiomType.EQUIVALENT_CLASSES)){
			for (OWLClassExpression r:eq.getClassExpressions()){
				if(r.getClassExpressionType()==ClassExpressionType.OBJECT_UNION_OF){
					for(OWLClassExpression e: ((OWLObjectUnionOf) r).getOperands()){
						if(e.getClassExpressionType()!=ClassExpressionType.OWL_CLASS){
							union=false;
						}
					}
					if(union && r.asDisjunctSet().size()>max){
						max=r.asDisjunctSet().size();
					}
				}
				union=true;
			}
		}
		return max;
	}

	private static OWLOntology getCanonicalForm(OWLOntology o,IRI file){
		OWLOntology result = null;
		OWLOntologyManager m = o.getOWLOntologyManager();
		try {
			IRI ontologyIRI = IRI.create("http://canonicalForm#");
			IRI documentIRI = file;
			SimpleIRIMapper mapper = new SimpleIRIMapper(ontologyIRI, documentIRI);
			m.addIRIMapper(mapper);
			result = m.createOntology(ontologyIRI);
		} catch (OWLOntologyCreationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		OWLAxiomTransformer canonicalForm = new OWLAxiomTransformer();

		for(OWLAxiom a:o.getAxioms()){
			m.addAxioms(result, a.accept(canonicalForm));
		}
		return result;
	}

	private static boolean adaptedSEPPattern(OWLOntology o){
		for(OWLSubClassOfAxiom s : o.getAxioms(AxiomType.SUBCLASS_OF) ){
			if(s.getSuperClass().isAnonymous() && s.getSuperClass().getClassExpressionType()==ClassExpressionType.OBJECT_SOME_VALUES_FROM){
				OWLObjectSomeValuesFrom svf = (OWLObjectSomeValuesFrom)s.getSuperClass();
				if(svf.getFiller().getClassExpressionType()==ClassExpressionType.OBJECT_UNION_OF){
					OWLObjectUnionOf u = (OWLObjectUnionOf) svf.getFiller();
					if(u.asDisjunctSet().size()==2){
						OWLClass c1 =null;
						OWLClass c2=null;
						for(OWLClassExpression e:u.asDisjunctSet()){
							if(!e.isAnonymous() && c1==null){
								c1=e.asOWLClass();
							}
							else if(!e.isAnonymous() && c1!=null){
								c1=null;
							}
							else if(e.isAnonymous() && c2==null && e.getClassExpressionType()==ClassExpressionType.OBJECT_SOME_VALUES_FROM){
								OWLClassExpression in = ((OWLObjectSomeValuesFrom)e).getFiller();
								if(!in.isAnonymous())
									c2=in.asOWLClass();
							}
							else if(e.isAnonymous() && c2!=null){
								c2=null;
							}
						}
						if(c1!=null && c2!=null && c1.equals(c2)){
							return true;
						}
					}
				}
			}
		}



		return false;
	}

	private static Set<OWLClass> getDirectDisjointClasses(OWLClass c,
			OWLReasoner r) {
		OWLClassExpression comp = c.getObjectComplementOf();
		NodeSet<OWLClass> temp = r.getSubClasses(comp,true);
		Set<OWLClass> sub = temp.getFlattened();
		Set<OWLClass> eq = r.getEquivalentClasses(comp).getEntities();
		sub.addAll(eq);
		return sub;
	}

	private static String getOntFileName(OWLOntology o){
		String path = o.getOWLOntologyManager().getOntologyDocumentIRI(o).toString();
		String start = o.getOWLOntologyManager().getOntologyDocumentIRI(o).getStart();
		return path.split(start)[1];
	}

	private static boolean listPattern(OWLOntology o){
		Iterator<OWLEntity> s = o.getSignature().iterator();
		boolean found=false;
		int count=0;
		OWLEntity r = null;
		OWLEntity n = null;
		while(s.hasNext() && !found){
			OWLEntity e = s.next();
			if(e.isOWLClass() && e.getIRI().getFragment().toLowerCase().equals("emptylist")){
				count++;
			}
			else if(e.isOWLObjectProperty() && e.getIRI().getFragment().toLowerCase().equals("contents") && e.asOWLObjectProperty().isFunctional(o)){
				count++;
			}
			else if(e.isOWLObjectProperty() && e.getIRI().getFragment().toLowerCase().equals("rest") && e.asOWLObjectProperty().isTransitive(o)){
				count++;
				r=e;
			}
			else if(e.isOWLObjectProperty() && e.getIRI().getFragment().toLowerCase().equals("next") && e.asOWLObjectProperty().isFunctional(o)){
				count++;
				n=e;
			}
			else{
				//its not a match
			}
			if(count>=4){
				//all have been matched, hopefully.
				found=true;
			}

		}

		if(count>=4 && n.asOWLObjectProperty().getSuperProperties(o).contains(r)){
			return true;
		}
		else{
			return false;
		}



	}

//	private static OWLOntology loadOntology(File ont, OWLOntologyManager m){
//		return loadOntology(ont,m,false);
//	}

	private static OWLOntology loadOntology(File onto, OWLOntologyManager manager,boolean norm){
		OWLOntology o = null;
		try {
			o = manager.loadOntologyFromOntologyDocument(onto);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			System.out.println(onto.getName() + "|" + "Error: Unable to load ontology");
			return null;
		}

		if(norm){
			manager.setOntologyDocumentIRI(o, IRI.create("old"));
			OWLOntology old = o;
			o=getCanonicalForm(old,IRI.create(onto));
			manager.removeOntology(old);
		}

		return o;
	}

	private static OWLReasoner loadReasoner(OWLOntology o){
		OWLReasoner r=null;
		//			try{
		//				r = new Reasoner(o);
		//			}
		//			catch(Exception e){
		//				e.printStackTrace();
		//				System.out.println(getOntFileName(o) + "|" + "Error: Unable to load Reasoner");
		//			}


		return r;
	}

	private static boolean normalization(OWLOntology o){

		for (OWLClass c:o.getClassesInSignature()){
			if (!c.isDefined(o)){
				int count=0;
				//first check it has only one parent
				for(OWLSubClassOfAxiom s:o.getSubClassAxiomsForSubClass(c)){
					if(!s.getSuperClass().isAnonymous()){
						count++;
					}
					if(count>=2)
						return false;
				}
				//next check all children are disjoint
				Set<OWLEntity> children = new HashSet<OWLEntity>();
				for(OWLSubClassOfAxiom s:o.getSubClassAxiomsForSuperClass(c)){
					if(!s.getSubClass().isAnonymous()){
						children.add(s.getSubClass().asOWLClass());
					}
				}
				
				if(children.size()>0){
				//Make a module extractor
				SyntacticLocalityModuleExtractor me = new SyntacticLocalityModuleExtractor(o.getOWLOntologyManager(),o,ModuleType.STAR);
				//extract the module
				OWLOntology mod=null;
				try {
					mod = me.extractAsOntology(children, IRI.create("localmod"));
				} catch (OWLOntologyCreationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//classify
//				OWLReasonerFactory f = new ElkReasonerFactory();
//				OWLReasonerFactory f = new JFactFactory();
//				OWLReasoner r = f.createReasoner(mod);
//				r.precomputeInferences(InferenceType.CLASS_HIERARCHY);
				OWLReasoner r = new Reasoner(mod);
				Set<OWLClass> disjoint=null;
				//ask if all children are disjoint with each other...return false if not.
				for(OWLEntity s: children){
					if(!s.asOWLClass().isDefined(mod)){
						Set<OWLClass> curr = getDirectDisjointClasses(s.asOWLClass(),r);
						curr.add(s.asOWLClass());
						if(disjoint!=null && ! curr.equals(disjoint)){
							o.getOWLOntologyManager().removeOntology(mod);
							return false;
						}
						disjoint=curr;
					}
				}
				o.getOWLOntologyManager().removeOntology(mod);
				}
			}
		}

		return true;
	}

//	private static void OPPL2OWL(File script, File output) {
//		String script_contents=File2String(script);
//
//		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
//		IRI ontIRI = IRI.create("http://www.bmi.stanford.edu/OPPLViz.owl");
//		IRI docIRI = IRI.create(output);
//		SimpleIRIMapper mapper = new SimpleIRIMapper(ontIRI,docIRI);
//		manager.addIRIMapper(mapper);
//		OWLOntology o = null;
//		try {
//			o = manager.createOntology(ontIRI);
//		} catch (OWLOntologyCreationException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//			return;
//		}
//
//		//Reasoner hermit=new Reasoner(o);
//		//		OWLReasoner r = new Reasoner(o);
//		OWLReasoner r = null;
//		ParserFactory pfactory = new ParserFactory(manager,o, r);
//
//
//		Logger logger = Logger.getLogger(queryOPPL.class.getName());
//		ErrorListener eListen = new LoggerErrorListener(logger);
//
//		OPPLParser opplparser = pfactory.build(eListen);
//
//		OPPLScript opplscript = null;
//		try{
//			opplscript = opplparser.parse(script_contents);
//		}
//		catch(UnrecognisedSymbolParsingException e){
//			e.printStackTrace();
//			return;
//		}
//		Set<OWLAxiom> axiomset = new HashSet<OWLAxiom>();
//		axiomset.addAll(opplscript.getQuery().getAssertedAxioms());
//		axiomset.addAll(opplscript.getQuery().getAxioms());
//		manager.addAxioms(o, axiomset);
//
//		try {
//			manager.saveOntology(o);
//		} catch (OWLOntologyStorageException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return;
//		}
//		return;
//	}

	private static void printHardCodedPatternsAsFalse(OWLOntology o) {
		for(Method m:DisjointUnion.class.getDeclaredMethods())
			if(Modifier.isPublic(m.getModifiers()))
				printResult(o,m.getName(),false);
	}

//	private static void printProfile(OWLOntology o, OWLProfile p,
//			boolean inProfile, HashSet<String> violations) {
//		String result = getOntFileName(o)+"|"+p.getName()+"|";
//		if(inProfile)
//			result+="1|No Violations";
//		else{
//			result+="0|"+Arrays.toString(violations.toArray());
//		}
//		System.out.println(result);
//
//	}

//	private static void printReport(OWLOntology o, OWLProfile p,
//			boolean inProfile, List<OWLProfileViolation> violations, BufferedWriter report) {
//		try {
//			report.write(p.getName()+"\n\n");
//			List<OWLProfileViolation> report_list = new ArrayList<OWLProfileViolation>(violations);
//			Collections.sort(report_list, new Comparator<OWLProfileViolation>(){
//
//				@Override
//				public int compare(OWLProfileViolation a,
//						OWLProfileViolation b) {
//					// TODO Auto-generated method stub
//					return a.getClass().getSimpleName().compareTo(b.getClass().getSimpleName());
//				}
//
//			});
//			if(!inProfile){
//				for (OWLProfileViolation v : report_list){
//					report.write(v.getClass().getSimpleName() +"|"+v.getAxiom()+"\n");
//				}
//			}
//			report.write("---------------------------------------------------\n");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

	private static void printResult(OWLOntology o,String name,boolean res){
		String result = name +"|"+ getOntFileName(o) +"|";
		if(res)
			result+="1";
		else
			result+="0";
		
		System.out.println(result);
	}

	private static void printUsage() {
		System.out.println("specify query and ontology against which to check \n returns | delimited result 0 being no match, 1 being match");
	}

}
