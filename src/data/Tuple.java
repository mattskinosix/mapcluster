package data;


public class Tuple {
	Item [] tuple;
	
	Tuple(int size){
		tuple=new Item[size];
		}
	public int getLength() {
		return tuple.length;
	}
	public Item get (int i) {
		return tuple[i];
	}
	public void add(Item c , int i) {
		tuple[i]=c;
	}
	public double getDistance(Tuple obj) {
		double distance=0;
		int i=0;
		while(i<this.getLength()) {// era this
			distance=distance+this.get(i).distance(obj.get(i).getValue());//forse errore
			i++;
		}
		return distance;
		
	}
	
	public double avgDistance(Data data, Integer[] array){
		double p=0.0,sumD=0.0;
		for(int i=0;i<array.length;i++){
			double d= getDistance(data.getItemSet(array[i]));
			sumD+=d;
			}
		p=sumD/array.length;
		return p;  
	} 
	
 } 
	
	

