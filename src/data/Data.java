package data;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public class Data {
// Le visibilità di classi , attributi e metodi devono essere decise dagli studenti	
	private List<Example> data;
	private int numberOfExamples;
	private List<Attribute> attributeSet;
	
	public Data(){
		
		/*
		//data
		data = new Object [14][5];

		// TO DO : memorizzare le transazioni secondo lo schema della tabella nelle specifiche
		
		data[0][0]="Sunny"; data[0][1]="Hot"; data[0][2]="High"; data[0][3]="Weak"; data[0][4]="No";
		data[1][0]="Sunny";data[1][1]="Hot";data[1][2]="High";data[1][3]="Strong";data[1][4]="No";
		data[2][0]="Overcast";data[2][1]="Hot";data[2][2]="High";data[2][3]="Weak";data[2][4]="Yes";
		data[3][0]="Rain";data[3][1]="Mild";data[3][2]="High";data[3][3]="Weak";data[3][4]="Yes";
		data[4][0]="Rain";data[4][1]="Cool";data[4][2]="Normal";data[4][3]="Weak";data[4][4]="Yes";
		data[5][0]="Rain";data[5][1]="Cool";data[5][2]="Normal";data[5][3]="Strong";data[5][4]="No";
		data[6][0]="Overcast";data[6][1]="Cool";data[6][2]="Normal";data[6][3]="Strong";data[6][4]="Yes";
		data[7][0]="Sunny";data[7][1]="Mild";data[7][2]="High";data[7][3]="Weak";data[7][4]="No";
		data[8][0]="Sunny";data[8][1]="Cool";data[8][2]="Normal";data[8][3]="Weak";data[8][4]="Yes";
	    data[9][0]="Rain";data[9][1]="Mild";data[9][2]="Normal";data[9][3]="Weak";data[9][4]="Yes";
		data[10][0]="Sunny";data[10][1]="Mild";data[10][2]="Normal";data[10][3]="Strong";data[10][4]="Yes";
		data[11][0]="Overcast";data[11][1]="Mild";data[11][2]="High";data[11][3]="Strong";data[11][4]="Yes";
		data[12][0]="Overcast";data[12][1]="Hot";data[12][2]="Normal";data[12][3]="Weak";data[12][4]="Yes";
		data[13][0]="Rain";data[13][1]="Mild";data[13][2]="High";data[13][3]="Strong";data[13][4]="No"; */
		
		
		TreeSet<Example> tempdata= new TreeSet<Example>();
//	gia fsttto da mirko 
//		Example ex0=new Example();
//		Example ex1=new Example();
//		Example ex2=new Example();
//		Example ex3=new Example();
//		Example ex4=new Example();
//		ex0.add(new String ("Sunny"));
//		ex0.add(new String ("Hot"));
//		ex0.add(new String ("High"));
//		ex0.add(new String ("Weak"));
//		ex0.add(new String ("No"));
//		ex1.add(new String ("Sunny"));
//		
//		
		
		
// numberOfExamples
		
		 numberOfExamples=14;
		
		//explanatory Set
		//forse fatta da mirko data= new ArrayList<Example>(tempData);
		attributeSet = new LinkedList<Attribute>();

		// TO DO : avvalorare ciascune elemento di attributeSet con un oggetto della classe DiscreteAttribute che modella il corrispondente attributo (e.g. outlook, temperature,etc)
		// nel seguito si fornisce l'esempio per outlook
		
		TreeSet <String> outLookValues=new TreeSet<String>();
		outLookValues.add("Overcast");
		outLookValues.add("Rain");
		outLookValues.add("Sunny");
		attributeSet.add(new DiscreteAttribute("Outlook",0,outLookValues));
		TreeSet<String>Temperature=new TreeSet<String>();
        Temperature.add("Hot");
        Temperature.add("Mild");
        Temperature.add("Cool");
        attributeSet.add(new DiscreteAttribute("Temperature",1,Temperature));
        TreeSet <String> humidity=new TreeSet<String>();
        humidity.add("High");
        humidity.add("Normal");
        humidity.add("Low");
        attributeSet.add( new DiscreteAttribute("Umidita",2, humidity));
        TreeSet<String> wind= new TreeSet<String>();
        wind.add("Weak");
        wind.add("Strong");
        attributeSet.add(new DiscreteAttribute("Vento",3,wind));
        TreeSet<String> playtennis= new TreeSet<String>();
        playtennis.add("Yes");
        playtennis.add("No");
        attributeSet.add(new DiscreteAttribute("Playtennis",4,playtennis));

        //distinctTuples=countDistinctTuples();    eliminato
	

		// similmente per gli altri attributi
		
		
	}
	//frindly
	class Example implements Comparable<Example>{
		private List<Object> example= new ArrayList<Object>();
		
		public void add(Object a) {
		example.add(a);
		}
	
		public Object get(int i) {
			return example.get(i);
		}
		public int compareTo(Example ex) {
			Iterator<Object> it= ex.example.iterator();
			Iterator<Object> it2= this.example.iterator();
			while (it.hasNext() ) {
				Object ob1=it.next();
				Object ob2=it2.next();
				int r=((Comparable<Object>)ob1).compareTo(ob2);
				if(r>0) {
					return 1;
				}else if(r<0) return -1;
			}
			return 0;
		}
		// forse sbagliato, incerto
		
		public String toString() {
			String out = null;
			for(Object o: example) {
				out+=o.toString();
			}
			return out;
		}
		
	}	
	
	public int getNumberOfExamples(){
		return numberOfExamples;
	}
	
	public int getNumberOfAttributes(){
		return attributeSet.size();
	}
	
	
	
	public Object getAttributeValue(int exampleIndex, int attributeIndex){
        return attributeSet.get(exampleIndex).getName();   // Attenzione fai vedere
	}
	
	public Attribute getAttribute(int index){
		return attributeSet.get(index);
	}
	
	
	public String toString(){
		String out=new String(); // Attenzione fai vedere
		out= attributeSet.get(0).getName()+","+attributeSet.get(1).getName()+","+attributeSet.get(2).getName()+","+attributeSet.get(3).getName()+","+attributeSet.get(4).getName()+"\n";
		for(int i=0;i<getNumberOfExamples(); i++) {
			out = out +i+":";
			for(int j=0;j<getNumberOfAttributes(); j++) out = out+getAttributeValue(i,j)+":"; // Attenzione fai vedere
			out=out+"\n";
		}                                                                                
		out=out+"\n";
		return out ;
}
		
	
	public Tuple getItemSet(int index) {
			Tuple tuple=new Tuple(getNumberOfAttributes());
			for(int i=0;i<getNumberOfAttributes();i++) {
				tuple.add(new DiscreteItem( (DiscreteAttribute)getAttribute(i),(String)getAttributeValue(index,i)),i);   
			}
			return tuple;
			
		}
	
	public int[] sampling(int k) throws OutOfRangeSampleSize{ 
//			  if(k<0 || k>distinctTuples) {
//				  throw new OutOfRangeSampleSize();
//			  }
			  int centroidIndexes[]=new int[k];
			  
			  //choose k random different centroids in data.
			  Random rand=new Random();
			  rand.setSeed(System.currentTimeMillis());
			  for (int i=0;i<k;i++){
				  boolean found=false;
				  int c;
				  do    {
					  found=false;
					  c=rand.nextInt(getNumberOfExamples());
					  // verify that centroid[c] is not equal to a centroide already stored in CentroidIndexes 
					  for(int j=0;j<i;j++)  if(compare(centroidIndexes[j],c)){
						  found=true;
						  break;
						  }
					  }
				  while(found);
				  centroidIndexes[i]=c;
				  }
	  return centroidIndexes;  
}
		
		
		
		
	private boolean compare(int i, int j) {
		int k=0;
		boolean bool=true;
		while ((k<this.getNumberOfAttributes())) {
			if(!this.getAttributeValue(i, k).equals(this.getAttributeValue(j, k))) bool=false;
			k++;
		}
		return bool;
	}
	
	
	public Object computePrototype(HashSet<Boolean> idList,Attribute attribute) {
		return computePrototype(idList,(DiscreteAttribute)attribute);
	}
	
	
	
	public String computePrototype(HashSet<Boolean> idList,DiscreteAttribute attribute) {
		int max=0;
		int temp=0;
		Iterator<String> x=attribute.iterator();
		String appoggio,out=null;
		while (x.hasNext()) {
			appoggio=x.next();
			temp=attribute.frequency((Data)this, idList,appoggio);//get value a la singola stringa mente get name dava tutto quindi vaffanculo
			if (temp>max) {
				max=temp;
				out=appoggio;
			}
		}
		return out;
	}
	
	
	
//	public int countDistinctTuples() {
//		boolean trovato=false;
//		int out=0;
//		for (int i=0;i<getNumberOfExamples();i++) {
//			for (int j=0;j<getNumberOfExamples();j++) if(compare(i,j)) {
//			trovato=true;
//			}
//			if (trovato) {
//				trovato = false;
//				out++;
//			}
//		}
//	
//		return out;
//	}
	/*
	
	
	public static void main(String args[]){
		Data trainingSet=new Data();
		System.out.println(trainingSet);
		}
 	*/
}
