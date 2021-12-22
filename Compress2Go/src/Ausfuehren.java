/*
In dieser Klasse wird die uebergebene Bilddatei sowohl komprimiert als auch dekomprimiert.
Es gibt zwei Methoden: komprimieren(String) und dekomprimieren(String), welche jeweils eine neue ppm-Datei erstellen 
und an einem vorher festgelegten Ort speichern.
Zuletzt bearbeitet am 22.12.2021 von Dharam Raj und Arian Lösing
*/

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ausfuehren {
	static String text =  "";
	static String text2 = "";
	//Geben Sie hier den Dateipfad mit gewünschtem Dateinamen an, bei dem die komprimierte Datei gespeichert werden soll
	//Beispiel: C:\\Users\\Arian Lösing\\Desktop\\Schule\\Informatik\\Kreis2.ppm
	static String komprimierteAusgabe = "C:\\Users\\Arian Lösing\\Desktop\\Schule\\Informatik\\Kreis2.ppm";
    public static void main(String[] args) throws IOException {
     
    
    //Komprimierung der Bilddatei
    /////////////////////////////////////////////////////////////////////////////	
		// Windows Schule:
        //Path filePath = Paths.get("H:/", "Desktop", "Informatik", "Kreis.ppm");

		//Windows Arian:
		Path filePath = Paths.get("C:/", "Users/", "Arian Lösing/", "Desktop/", "Schule", "Informatik/", "Kreis.ppm");
		
		// Mac:
		//Path filePath = Paths.get("/Users/", "dharamraj/", "Documents/", "Schule/", "Informatik/", "Kreis.ppm");
		
		
		
		//Die Bilddatei wird ausgelesen und in einer Zeichenkette / String gespeichert
    	try {
			text = Files.readString(filePath);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Bitte geben Sie einen korrekten Bildpfad an!");
		}
    	
    	//Im folgenden Teil werden die ersten vier Zeilen der Datei unkomprimiert in der neuen Datei gespeichert
    	//die darauf folgenden Zeilen werden mit der Methode "komprimieren" komprimiert und ebenfalls in der Datei gespeichert
		int i = 0;
    	String zeile = "";
    	String aufZeile = "";
    	boolean erfolg = false;
    	try (Scanner fileScanner = new Scanner(text)){
			while(fileScanner.hasNextLine()) {
			i = i + 1;
			if(i > 4){
				zeile = fileScanner.nextLine();
				aufZeile = (komprimieren(zeile) + System.getProperty("line.separator"));
				}
				else{
					aufZeile = fileScanner.nextLine() + System.getProperty("line.separator");
				}
			//Im Folgenden wird die neue Datei erstellt und beschrieben
			try {
	    		@SuppressWarnings("resource")
	    		FileOutputStream ppm = new FileOutputStream(komprimierteAusgabe, true);
	    		ppm.write(aufZeile.getBytes());
	    		ppm.flush();
	    		erfolg = true;
	    	} catch (FileNotFoundException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    		erfolg = false;
	    	}
			}
			if(erfolg) {
	    		System.out.println("Bilddatei erfolgreich komprimiert!");
			}
			else {
	    		System.out.println("Es konnte keine Datei angelegt werden, bitte ueberpruefen Sie den Dateipfad!");

			}
    	}
	
	
    	/////////////////////////////////////////////////////////////////////////
    	
    	
    	//Dekomprimierung der Bilddatei
    	/////////////////////////////////////////////////////////////////////////
    	//In diesem Teil wird die komprimierte Datei übergeben und wieder Zeile für Zeile dekomprimiert
    	//Auch hier werden die ersten vier Zeilen wieder direkt übertragen
    	 Path filePath2 = Paths.get("C:/", "Users/", "Arian Lösing/", "Desktop/", "Schule", "Informatik/", "Kreis2.ppm");
     	
    	 try {
 			text2 = Files.readString(filePath2);
 		} catch (IOException e) {
 			e.printStackTrace();
 		}
 		
     	int j = 0;
    	String zeile2 = "";
    	String aufZeile2 = "";
    	boolean erfolgD = false;
    	try (Scanner fileScanner2 = new Scanner(text2)){
			while(fileScanner2.hasNextLine()) {
			j = j + 1;
			if(j > 4){
				zeile2 = fileScanner2.nextLine();
				aufZeile2 = (dekomprimieren(zeile2) + System.getProperty("line.separator"));
				}
				else{
					aufZeile2 = fileScanner2.nextLine() + System.getProperty("line.separator");
				}
			//Hier wird die neue dekomprimierte Datei erstellt und beschrieben
			try {
	    		@SuppressWarnings("resource")
	    		FileOutputStream ppm2 = new FileOutputStream("C:\\Users\\Arian Lösing\\Desktop\\Schule\\Informatik\\Kreis3.ppm", true);
	    		ppm2.write(aufZeile2.getBytes());
	    		ppm2.flush();
	    		erfolgD = true;
	    	} catch (FileNotFoundException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    		erfolgD = false;
	    	}
			}
			if(erfolgD) {
	    		System.out.println("Die komprimierte Bilddatei wurde erfolgreich dekomprimiert!");
			}
			else {
	    		System.out.println("Es ist ein Fehler aufgetreten, bitte ueberpruefen Sie alle angegebenen Dateipfade!");
			}
    	}
	
    	/////////////////////////////////////////////////////////////////////////
			}


   
    //Komprimieren Methode
    public static String komprimieren(String t) {
    	String textKomprimiert = "";
    	char leerzeichen = ' ';
    	String a = "";
    	String vergleich = "";
    	String vergleich2 = "";
    	int counter = 1;
    	int leerzeichenZaehler = 0;
    
    //for-Schleife für die gesamte Laenge des übergebenen Strings	
    for(int i = 0; i < t.length(); i++) {
    	//falls es sich nicht um ein Leerzeichen handelt und nicht um den letzten Buchstaben, wird dieser dem String a hinzugefügt
    	if(t.charAt(i) != leerzeichen && i !=  t.length() -1 ) {
    		a = a + t.charAt(i);
    	}
    	else {
    		//falls es sich um den letzten Buchstaben handelt wird dieser zu a hinzugefügt und a in einem Vergleichsstring gespeichert
    		if(t.charAt(i) != leerzeichen && i == t.length() - 1) {
    			a = a + t.charAt(i);
    			vergleich2 = a;
    		}
    		//Beim 3. Leerzeichen ist ein Tripel zu Ende und es wird in einem Vergleichs-String gespeichert
    		if(t.charAt(i) == leerzeichen && leerzeichenZaehler == 2) {

    			leerzeichenZaehler = 0;
    	         if(vergleich == "") {
    	        	 vergleich = vergleich + a; 

    	        	 a = "";
    	         }
    	         else {
    	    		vergleich2 = "";
    	    		vergleich2 = a;
    	    		a = "";
    	         }		
    		}
    		//falls es sich um ein Leerzeichen, aber nicht um das 3. handelt, wird das Leerzeichen zu a hinzugefügt und der Leerzeichen-Zaehler um 1 erhöht
    		else {
    			leerzeichenZaehler = leerzeichenZaehler + 1;
    			a = a + t.charAt(i);
        		}
    		
    		//falls die beiden Vergleichstriple identisch und nicht leer sind, wird der Counter um 1 erhöht und vergleich2 zurückgesetzt
    		if(vergleich.equals(vergleich2) && !vergleich2.equals("")) {
       		 counter = counter + 1;
       		 vergleich2 = "";
       	 }
    		//falls sich die Vergleichstriple unterscheiden wird der bisherige vergleich1-Wert in dem komprimierten Text zusammen mit seiner Anzahl gespeichert
    		//Dann wird das neue Triple zum neuen Vergleichswert, der Counter wird zurückgesetzt.
    		 else {
    			if(vergleich != vergleich2 && !vergleich2.equals("")) {
    				textKomprimiert = textKomprimiert + vergleich + " " + counter + " ";
    				vergleich = vergleich2;
    				counter = 0;
    			}
    		}
    		
    	
    	
    }
    }
    //falls sich das letzte Triple vom vorherigen unterscheidet wird der Counter auf 1 gesetzt, weil sonst die Anzahl 0 angegeben werden wuerde
    if(counter != 0) {
    textKomprimiert = textKomprimiert + vergleich +" " + counter;
    }
    else {
    	textKomprimiert = textKomprimiert + vergleich +" " + 1;	
    }
    return textKomprimiert;
    }
    

	
    //Dekomprimieren Methode
    public static String dekomprimieren (String tK) {
    	String dekomprimiert = "";
    	char leerzeichen = ' ';
    	int anzahl = 0;
    	String wert = "";
    	char an = ' ';
    	int leerzeichenZaehler = 0;
    	
    	//for-Schleife fuer die Laenge des uebergebenen komprimierten Textes
        for(int i = 0; i < tK.length(); i++) {
        	//falls es kein Leerzeichen und nicht der letzte Buchstabe ist, wird der char im "wert" gespeichert
        	//wert steht in diesem Fall für das Tripel
        	if(tK.charAt(i) != leerzeichen && i !=  tK.length() -1 ) {
        		wert = wert + tK.charAt(i);
        	}
        	else {
        		//ist das Tripel vollstaendig, wird es n-mal zum dekomprimierten Text hinzugefuegt
        		//n ist bestimmt duch die Zahl, welche nach dem dritten Leerzeichen kommt
        		if(tK.charAt(i) == leerzeichen && leerzeichenZaehler == 2) {

        			leerzeichenZaehler = 0;
        			an = tK.charAt(i + 1);
        	         anzahl = Character.getNumericValue(an);
        	         
        	         for(int j = 0; j < anzahl; j++) {
        	        	 dekomprimiert = dekomprimiert + wert + " ";
        	         }
        	         anzahl = 0;
        	         wert = "";
        	         i = i + 2;

        	        
        		}
        		 else {
    	        	 leerzeichenZaehler = leerzeichenZaehler + 1;
    	        	 wert = wert + tK.charAt(i);
    	         }
        	         
     
    	

    	
    }
        	}
    	return dekomprimiert;
    }
 

    
}