package data;

import java.util.HashSet;

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
		
		public void update (Data data,HashSet clusteredData) {
			value=data.computePrototype(clusteredData,attribute);
			
		}
		
}
