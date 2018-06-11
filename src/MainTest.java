
import java.sql.SQLException;

import data.Data;
import data.OutOfRangeSampleSize;
import database.NoValueException;
import mining.KMeansMiner;
import keyboardinput.Keyboard;

public class MainTest {

	/**
	 * @param args
	 * @throws NoValueException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) {
		int k;
		char scelta;

		do {

			Data data = new Data("playtennis");
			System.out.print(data);
			System.out.println("Inserisci il numero di cluster volute:  ");
			k = Keyboard.readInt();
			KMeansMiner kmeans = null;
			kmeans = new KMeansMiner(k);
			int numIter = 0;
			try {
				numIter = kmeans.kmeans(data);
			} catch (OutOfRangeSampleSize e) {

				System.out.println("Il numero di cluster è troppo elevato!!!!! Prova con un numero più basso");
			}
			System.out.println("Numero di Iterazione:" + numIter);
			System.out.println(kmeans.getC().toString(data));
			System.out.println("Vuoi ripete l'esecuzione?y/n");
			scelta = Keyboard.readChar();

		} while (scelta == 'y' | scelta == 'Y');

	}

}
