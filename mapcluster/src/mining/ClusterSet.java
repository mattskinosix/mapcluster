package mining;
import data.*;

public class ClusterSet {
	private static final Cluster NULL = null;
	Cluster [] C;
	int i =0;
	
	public String toString(Data data) {
		String str="";
		for(int i=0;i<C.length;i++){
			if (C[i]!=null){
				str+=i+":"+C[i].toString(data)+"\n";
				}
			}
		return str; 
	}

	
	
	
	public ClusterSet(int k){
		C=new Cluster[k];
	}
	
	public void add(Cluster c) {
		C[i]=c;
		i++;
		
	}
	
	public Cluster get(int i ) {
		return C[i];
	}
	
	
	public void initializeCentroids(Data data) throws OutOfRangeSampleSize { 
		int centroidIndexes[] = null;
		centroidIndexes = data.sampling(C.length);
		for(int i=0;i<centroidIndexes.length;i++)   {
		  Tuple centroidI=data.getItemSet(centroidIndexes[i]);
		  add(new Cluster(centroidI));
		  }
		}
	
	
	public Cluster nearestCluster(Tuple tuple) {
		double min=0;
	    min=tuple.getDistance(C[0].getCentroid());//errore get cntroid la posizione 0 risulta nulla
		int j=1,indice=0;
		while (j<C.length) {
			double temp=tuple.getDistance(get(j).getCentroid());
			if (temp<min) {
				min =temp;
				indice=j;
			}
			j++;
		}
		return get(indice);
	}

	public Cluster currentCluster(int id) {
		int i=0;
		int indice=-1;
		while (i<C.length) {
			if (C[i].contain(id)) indice=i;
		i++;
		}
		if (indice==-1) return NULL;
		else return C[indice];
	}
	
	
	
	public void updateCentroids(Data data) {
		int j =0;
		while (j<C.length) {
			get(j).computeCentroid(data);
			j++;
		}
	}
	public String toString() {
		int j =0;
		String out= new String();
		while (j<C.length) {
			out=j+get(i).getCentroid().toString()+" ";
			j++;
		}
		return out;
	}

}
