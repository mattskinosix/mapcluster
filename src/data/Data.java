package data;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import data.Data.Example;

public class Data {
	private List<Example> data;
	private int numberOfExamples;
	private List<Attribute> attributeSet;
	
	public Data(){
		TreeSet<Example> tempdata= new TreeSet<Example>();
		Example ex0=new Example();
		Example ex1=new Example();
		Example ex2=new Example();
		Example ex3=new Example();
		Example ex4=new Example();
		Example ex5=new Example();
		Example ex6=new Example();
		Example ex7=new Example();
		Example ex8=new Example();
		Example ex9=new Example();
		Example ex10=new Example();
		Example ex11=new Example();
		Example ex12=new Example();
		Example ex13=new Example();
		ex0.add(new String("Sunny"));
		//ex0.add(new String("Hot"));
		ex0.add(new Double(37.5));
		ex0.add(new String("High"));
		ex0.add(new String("Weak"));
		ex0.add(new String("No"));
		ex1.add(new String("Sunny"));
		//ex1.add(new String("Hot"));
		ex1.add(new Double(38.7));
		ex1.add(new String("High"));
		ex1.add(new String("Strong"));
		ex1.add(new String("No"));
		ex2.add(new String("Overcast"));
		//ex2.add(new String("Hot"));
		ex2.add(new Double(37.5));
		ex2.add(new String("High"));
		ex2.add(new String("Weak"));
		ex2.add(new String("Yes"));
		ex3.add(new String("Rain"));
	    //ex3.add(new String("Mild"));
		ex3.add(new Double(20.5));
		ex3.add(new String("High"));
		ex3.add(new String("Weak"));
		ex3.add(new String("Yes"));
		ex4.add(new String("Rain"));
		//ex4.add(new String("Cool"));
		ex4.add(new Double(20.7));
		ex4.add(new String("Normal"));
		ex4.add(new String("Weak"));
		ex4.add(new String("Yes"));
		ex5.add(new String("Rain"));
	    //ex5.add(new String("Cool"));
		ex5.add(new Double(21.2));
		ex5.add(new String("Normal"));
		ex5.add(new String("Strong"));
		ex5.add(new String("No"));
		ex6.add(new String("Overcast"));
		//ex6.add(new String("Cool"));
		ex6.add(new Double(20.5));
		ex6.add(new String("Normal"));
		ex6.add(new String("Strong"));
		ex6.add(new String("Yes"));
		ex7.add(new String("Sunny"));
		//ex7.add(new String("Mild"));
		ex7.add(new Double(21.2));
		ex7.add(new String("High"));
		ex7.add(new String("Weak"));
		ex7.add(new String("No"));
		ex8.add(new String("Sunny"));
		//ex8.add(new String("Cool"));
		ex8.add(new Double(21.2));
		ex8.add(new String("Normal"));
		ex8.add(new String("Weak"));
		ex8.add(new String("Yes"));
		ex9.add(new String("Rain"));
		//ex9.add(new String("Mild"));
		ex9.add(new Double(19.8));
		ex9.add(new String("Normal"));
		ex9.add(new String("Weak"));
		ex9.add(new String("Yes"));
		ex10.add(new String("Sunny"));
		//ex10.add(new String("Mild"));
		ex10.add(new Double(3.5));
		ex10.add(new String("Normal"));
		ex10.add(new String("Strong"));
		ex10.add(new String("Yes"));
		ex11.add(new String("Overcast"));
	    //ex11.add(new String("Mild"));
		ex11.add(new Double(3.6));
		ex11.add(new String("High"));
		ex11.add(new String("Strong"));
		ex11.add(new String("Yes"));
		ex12.add(new String("Overcast"));
		//ex12.add(new String("Hot"));
		ex12.add(new Double(3.5));
		ex12.add(new String("Normal"));
		ex12.add(new String("Weak"));
		ex12.add(new String("Yes"));
		ex13.add(new String("Rain"));
		ex13.add(new Double(3.2));
	    //ex13.add(new String("Mild"));
		ex13.add(new String("High"));
		ex13.add(new String("Strong"));
		ex13.add(new String("No"));
		
		tempdata.add(ex0);
		tempdata.add(ex1);
		tempdata.add(ex2);
		tempdata.add(ex3);
		tempdata.add(ex4);
		tempdata.add(ex5);
		tempdata.add(ex6);
		tempdata.add(ex7);
		tempdata.add(ex8);
		tempdata.add(ex9);
		tempdata.add(ex10);
		tempdata.add(ex11);
		tempdata.add(ex12);
		tempdata.add(ex13);
		data=new ArrayList<Example>(tempdata);
		// numberOfExamples
		numberOfExamples=data.size();
		//explanatory Set
		attributeSet = new LinkedList<Attribute>();
		TreeSet<String> outLookValues= new TreeSet<String>();
		outLookValues.add("Overcast");
		outLookValues.add("Rain");
		outLookValues.add("Sunny");
		attributeSet.add( new DiscreteAttribute("Outlook",0, outLookValues));
		TreeSet<String> Temperature= new TreeSet<String>();
        Temperature.add("Hot");
        Temperature.add("Mild");
        Temperature.add("Cool");
        //attributeSet.add( new DiscreteAttribute("Temperature",1, Temperature));
        attributeSet.add(new ContinuousAttribute("Temperature",1,3.2,38.7));
        TreeSet<String> humidity= new TreeSet<String>();
        humidity.add("High");
        humidity.add("Normal");
        humidity.add("Low");
        attributeSet.add( new DiscreteAttribute("Humidity",2, humidity));
        TreeSet<String> wind= new TreeSet<String>();
        wind.add("Weak");
        wind.add("Strong");
        attributeSet.add(new DiscreteAttribute("Wind",3,wind));
        TreeSet<String> playtennis= new TreeSet<String>();
        playtennis.add("Yes");
        playtennis.add("No");
        attributeSet.add(new DiscreteAttribute("Playtennis",4,playtennis));	
	}
	
	
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
				int r=((Comparable)ob1).compareTo(ob2);
				if(r>0) return 1;
				else if(r<0) return -1;
			}
			return 0;
		}
		
		public String toString() {
			String out = new String();
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
       return data.get(exampleIndex).get(attributeIndex);
	}
	
	public Attribute getAttribute(int index){
		return attributeSet.get(index);
	}
	
	
	public String toString(){
		String out=new String();
		out= attributeSet.get(0).getName()+","+attributeSet.get(1).getName()+","+attributeSet.get(2).getName()+","+attributeSet.get(3).getName()+","+attributeSet.get(4).getName()+"\n";
		for(int i=0;i<getNumberOfExamples(); i++) {
			out = out +i+":";
			for(int j=0;j<getNumberOfAttributes(); j++) out = out+getAttributeValue(i,j)+":"; 
			out=out+"\n";
		}                                                                                
		out=out+"\n";
		return out ;
}

	public Tuple getItemSet(int index) {
		Tuple tuple = new Tuple(getNumberOfAttributes());
		for (int i = 0; i < getNumberOfAttributes(); i++) {
			if(this.getAttribute(i) instanceof ContinuousAttribute)
				tuple.add(new ContinuousItem((ContinuousAttribute) getAttribute(i), (Double) getAttributeValue(index, i)), i);			
			else
				tuple.add(new DiscreteItem((DiscreteAttribute) getAttribute(i), (String) getAttributeValue(index, i)), i);
		}
		return tuple;
	}
	
	
	public int[] sampling(int k) throws OutOfRangeSampleSize{ 
			  if(k<0 || k>getNumberOfExamples()) {
				  throw new OutOfRangeSampleSize();
		  }
			  int centroidIndexes[]=new int[k];
			  Random rand=new Random();
			  rand.setSeed(System.currentTimeMillis());
			  for (int i=0;i<k;i++){
				  boolean found=false;
				  int c;
				  do    {
					  found=false;
					  c=rand.nextInt(getNumberOfExamples());
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
	
	

	public Object computePrototype(Set<Integer> clusteredData, Attribute attribute) {
		if (attribute instanceof ContinuousAttribute)
			return computePrototype(clusteredData, (ContinuousAttribute) attribute);
		else
			return computePrototype(clusteredData, (DiscreteAttribute) attribute);
	}
	
	
	public String computePrototype(Set<Integer> idList,DiscreteAttribute attribute) {
		int max=0;
		int temp=0;
		
		Iterator<Integer> x=idList.iterator();
		String out=null;
		while (x.hasNext()) {
			Integer i=x.next();
			temp=attribute.frequency(this, idList, (String) getAttributeValue(i,attribute.getIndex()));
			if (temp>max) {
				max=temp;
				out=(String) getAttributeValue(i,attribute.getIndex());
			}
		}
		return out;
	}
	
	private Double computePrototype(Set<Integer> idList, ContinuousAttribute attribute) {
		Double prototipo = 0.0;
		Iterator<Integer> it = idList.iterator();
		while (it.hasNext()) {
			prototipo += (Double) this.getAttributeValue(it.next(), attribute.getIndex());
		}
		prototipo = prototipo / idList.size();
		return prototipo;
	}
}
