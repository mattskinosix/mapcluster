package data;
import java.util.Random;
import utility.ArraySet;
public class Data {
// Le visibilità di classi , attributi e metodi devono essere decise dagli studenti	
	private Object data [][];
	private int numberOfExamples;
	private Attribute attributeSet[];
	private int distinctTuples;
	
	public Data(){
		
		
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
		data[13][0]="Rain";data[13][1]="Mild";data[13][2]="High";data[13][3]="Strong";data[13][4]="No";
// numberOfExamples
		
		 numberOfExamples=14;
		
		//explanatory Set
		
		attributeSet = new Attribute[5];

		// TO DO : avvalorare ciascune elemento di attributeSet con un oggetto della classe DiscreteAttribute che modella il corrispondente attributo (e.g. outlook, temperature,etc)
		// nel seguito si fornisce l'esempio per outlook
		
		String outLookValues[]=new String[3];
		outLookValues[0]="Overcast";
		outLookValues[1]="Rain";
		outLookValues[2]="Sunny";
		attributeSet[0] = new DiscreteAttribute("Outlook",0, outLookValues);
        String Temperature[]=new String[3];
        Temperature[0]="Hot";
        Temperature[1]="Mild";
        Temperature[2]="Cool";
        attributeSet[1]= new DiscreteAttribute("Temperature",1, Temperature);
        String humidity[]=new String[3];
        humidity[0]="High";
        humidity[1]="Normal";
        humidity[2]="Low";
        attributeSet[2]= new DiscreteAttribute("Umidita",2, humidity);
        String wind[]= new String[2];
        wind[0]="Weak";
        wind[1]="Strong";
        attributeSet[3]= new DiscreteAttribute("Vento",3,wind);
        String playtennis[]= new String[2];
        playtennis[0]="Yes";
        playtennis[1]="No";
        attributeSet[4]= new DiscreteAttribute("Playtennis",4,playtennis);

        distinctTuples=countDistinctTuples();
	

		// similmente per gli altri attributi
		
		
	}
	
	public int getNumberOfExamples(){
		return numberOfExamples;
	}
	
	public int getNumberOfAttributes(){
		return attributeSet.length;
	}
	
	
	
	public Object getAttributeValue(int exampleIndex, int attributeIndex){
        return data[exampleIndex][attributeIndex];
	}
	
	public Attribute getAttribute(int index){
		return attributeSet[index];
	}
	
	
	public String toString(){
		String out=new String();
		out= attributeSet[0].getName()+","+attributeSet[1].getName()+","+attributeSet[2].getName()+","+attributeSet[3].getName()+","+attributeSet[4].getName()+"\n";
		for(int i=0;i<getNumberOfExamples(); i++) {
			out = out +i+":";
			for(int j=0;j<getNumberOfAttributes(); j++) out = out+getAttributeValue(i,j)+":";
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
			  if(k<0 || k>distinctTuples) {
				  throw new OutOfRangeSampleSize();
			  }
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
	
	
	public Object computePrototype(ArraySet idList,Attribute attribute) {
		return computePrototype(idList,(DiscreteAttribute)attribute);
	}
	
	
	
	public String computePrototype(ArraySet idList,DiscreteAttribute attribute) {
		int max=0;
		int indice=0;
		int i =0;
		int temp=0;
		while (i<attribute.getNumberOfDistinctValues()) {
			temp=attribute.frequency((Data)this, idList, attribute.getValues(i));//get value a la singola stringa mente get name dava tutto quindi vaffanculo
			if (temp>max) {
				indice=i;
				max=temp;
			}
			i++;
		}
		return attribute.getValues(indice);
	}
	
	
	
	public int countDistinctTuples() {
		boolean trovato=false;
		int out=0;
		for (int i=0;i<getNumberOfExamples();i++) {
			for (int j=0;j<getNumberOfExamples();j++) if(compare(i,j)) {
			trovato=true;
			}
			if (trovato) {
				trovato = false;
				out++;
			}
		}
	
		return out;
	}
	/*
	
	
	public static void main(String args[]){
		Data trainingSet=new Data();
		System.out.println(trainingSet);
		}
 	*/
}
