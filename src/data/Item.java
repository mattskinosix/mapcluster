package data;
import java.util.Set;

public abstract class Item {
		private Attribute attribute;
		Object value;
		
		
		public Item (Attribute attribute, Object value){
			this.attribute=attribute;
			this.value=value;
		}
		
		public Attribute getAttribute() {
			return attribute;
		}
		public Object getValue() {
			return value;
		}
		public String toString() {
			return value.toString();
		}
		public abstract double distance(Object a);
		
		public void update (Data data,Set<Integer> clusteredData) {
			value=data.computePrototype(clusteredData,attribute);
			
		}
		
}
