
import data.Data;
import data.OutOfRangeSampleSize;
import mining.KMeansMiner;
import keyboardinput.Keyboard;
public class MainTest {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int k;
		char scelta;
		do {
		Data data =new Data();
		Sys
		System.out.println(data);
		System.out.println("Inserisci il numero di cluster volute:  ");
		k=Keyboard.readInt();
		KMeansMiner kmeans = null;
		kmeans=new KMeansMiner(k);
		int numIter=0;
		try {
			numIter = kmeans.kmeans(data);
		} catch (OutOfRangeSampleSize e) {
		
			System.out.println("Errore catturata eccezione ");
			e.printStackTrace();
		}
		
		System.out.println("Numero di Iterazione:"+numIter);
		System.out.println(kmeans.getC().toString(data));
		System.out.println("Vuoi ripete l'esecuzione?y/n");
		scelta=Keyboard.readChar();
		}while(scelta=='y' | scelta=='Y');
		
	}

}
