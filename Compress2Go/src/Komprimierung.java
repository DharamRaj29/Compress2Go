
public class Komprimierung {
	static int pbm[][] = {
		{0, 0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 1, 1, 1, 1},
		{0, 0, 0, 0, 0, 0, 1, 1, 1}
};

public static void main(String[] args) {
	// Auswahl der Komprimierungsvariante
	int variant = 1;
	
	// pbm komprimieren mit Variante 1:
	System.out.println("Komprimiertes Bild:");
	String compr = compress(pbm, variant);
	
	// komprimierte pbm ausgeben:
	System.out.println(compr);
	
	// komprimierte pbm dekomprimieren und ausgeben (nur für Variante 1!):
	if(variant == 1) {
		System.out.println("\nDekomprimiertes Bild:");
		System.out.println(printArray(decompress(compr, 3, 9)));
	}
}

/**
 * Gibt das zweidimensionale Array aus
 * 
 * @param array Das auszugebende Array
 * @return
 */
public static String printArray(int[][] array) {
	String out = "";
	
	for(int i = 0; i != array.length; i++) {
		for(int j = 0; j != array[i].length; j++) {
			out = out + array[i][j];
		}
		// füge Zeilenumbruch ("\n") hinzu für nächste Zeile
		out = out + "\n";
	}
	
	return out;
}

/**
 * Komprimiere das Array pbm mit Variante 0 (mittlere Tabellenspalte) oder Variante 1 (rechte Tabellenspalte).
 * Falls Variante 1 gewählt wird, ist die erste Zahl die Anzahl an Nullen.
 * 
 * @param eingabe Das zu komprimierende Array
 * @param variant Das zu nutzende Kompressionsverfahren
 * @return
 */
private static String compress(int[][] eingabe, int variant) {
	boolean lastBitWasOne = false;
	if(eingabe[0][0] == 0) {
		lastBitWasOne = true;
	}
	boolean currentBitIsOne;
	int counter = 0;

	// setze eine Null nach vorne, wenn Variante 1 gewählt ist und das Array mit einer Eins beginnt:
	String compressed = "";
	if(eingabe[0][0] == 1 && variant == 1) {
		compressed = "0,";
	}
	
	for(int i = 0; i != eingabe.length; i++) {
		for(int j = 0; j != eingabe[i].length; j++) {

			// Speichere, ob die aktuelle Zahl eine Eins ist.
			if(eingabe[i][j] == 1) {
				currentBitIsOne = true;
			}else {
				currentBitIsOne = false;
			}
			
			if(currentBitIsOne && !lastBitWasOne) { // hier fangen die Einsen an
				// Erweitere den String um die vorherige gezählte Zahl, setze counter zurück und zähle neu für aktuelle Zahl
				if(counter > 0) {
					compressed = compressed + counter + ",";
				}
				if(variant == 0) {
					compressed = compressed + "1,";
				}
				counter = 0;
				counter++;
				
			}else if(currentBitIsOne && lastBitWasOne) { // es kommen noch weitere Einsen
				// zähle counter hoch
				counter++;
				
			}else if(!currentBitIsOne && lastBitWasOne) { // nun kommen Nullen
				// Erweitere den String um die vorherige gezählte Zahl, setze counter zurück und zähle neu für aktuelle Zahl
				if(counter > 0) {
					compressed = compressed + counter + ",";
				}
				if(variant == 0) {
					compressed = compressed + "0,";
				}
				counter = 0;
				counter++;
				
			}else if(!currentBitIsOne && !lastBitWasOne) { // es kommen weitere Nullen
				// zähle counter hoch
				counter++;
				
			}
			
			// Speichere für nächsten Durchlauf, ob aktuelle Zahl eine Eins ist.
			lastBitWasOne = eingabe[i][j] == 1;
			
		}
	}
	
	// füge nochmal die letztgezählte Zahl hinzu
	compressed = compressed + counter;
	return compressed;
}

/**
 * Diese Methode dekomprimiert einen Bitstrom, der mit einer Lauflängenkodierung komprimiert wurde.
 * 
 * @param bitstrom Der komprimierte Bitstrom
 * @param n Anzahl der Zeilen des Datenteils
 * @param m Anzahl der Spalten des Datenteils
 * @return
 */
public static int[][] decompress(String bitstrom, int n, int m){
	int array[][] = new int[n][m];
	// teile bitstrom in Zahlen auf (Nutzung von String.split() im Abitur verboten)
	int[] split_bitstrom = convert(bitstrom);
	int x = 0, y = 0;
	
	for(int i = 0; i != split_bitstrom.length; i++) {
		
		for(int j = 0; j != split_bitstrom[i]; j++) {
			if(x == m) { // falls nächste Zeile angefangen werden muss:
				x = 0;
				y++;
			}
			if(i % 2 == 0) { // füge dem Array die Eins oder Null hinzu
				array[y][x] = 0;
			}else {
				array[y][x] = 1;
			}
			x++;
		}
		
	}
	
	return array;
}

/**
 * Die Methode convert konvertiert einen String zu einem Array.
 * 
 * @param a Zu konvertierender String
 * @return eine Reihung wird zurückgegeben
 */
public static int[] convert(String a) {
	int[] numbers = new int[a.length()];
	int counter = 0;
	for (int i = 0; i < a.length(); i++) {
		/* Sobald der Buchstabe des Strings "a" an der Stelle "i" einen Zahlenwert besitzt,
		 * wird dieser der Reihung "numbers" an der Stelle "counter" angefügt, der bestehende
		 * Wert in der Reihung wird mit 10 multipliziert, um auch mehrstellige Zahlen
		 * darstellen zu können.
		 */
		if (java.lang.Character.isDigit(a.charAt(i))) {
			numbers[counter] = numbers[counter] * 10 + java.lang.Character.getNumericValue(a.charAt(i));
		} else {
			counter++;
		}
	}
	return numbers;
}

}
