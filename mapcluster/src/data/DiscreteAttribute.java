package data;
import utility.ArraySet;
class DiscreteAttribute extends Attribute {
    private String values[];
    

    DiscreteAttribute(String name, int index , String values[]){
        super(name,index);
        this.values=values;
    }


    public int getNumberOfDistinctValues(){
        return values.length;
    }
    public String getValues(int i){
        return values[i];
    }
    
    public int frequency (Data data, ArraySet idList, String v) {
    	int i=0,j=0;
    	int freq=0;
    	while (i<data.getNumberOfExamples()) {
    		if(idList.get(i)) while (j<data.getNumberOfAttributes()) {
    			if(v.equals(data.getAttributeValue(i,j))) freq++;
    			j++;
    		}
    	i++;
    	}
    	return freq; 
    }
    
}

	