package data;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

class DiscreteAttribute extends Attribute implements Iterable<String> {
    private TreeSet<String> values;

    
    public Iterator<String> iterator(){
    	return values.iterator();
    }
    
    DiscreteAttribute(String name, int index , TreeSet<String> values){
        super(name,index);
        this.values=values;
    }


    public int getNumberOfDistinctValues(){
        return values.size();
    }
    /*
    public String getValues(int i){
        return values.;
    }
    */
    public int frequency (Data data, HashSet<Boolean> idList, String v) {
    	int i=0,j=0;
    	int freq=0;
    	for (Boolean elem: idList) {
    		if(elem.booleanValue()) while (j<data.getNumberOfAttributes()) {
    			if(v.equals(data.getAttributeValue(i,j))) freq++;
    			j++;
    		}
    	i++;
    	}
    	return freq; 
    }
    
    
}

	