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
		
		
    	try {
			text = Files.readString(filePath);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Bitte geben Sie einen korrekten Bildpfad an!");
		}
    	
		int i = 0;
    	String zeile = "";
    	String aufZeile = "";
    	boolean erfolg = false;
    	try (Scanner fileScanner = new Scanner(text)){
			while(fileScanner.hasNextLine()) {
			i = i + 1;
			if(i > 4){
				zeile = fileScanner.nextLine();
				aufZeile = (aufteilen(zeile) + System.getProperty("line.separator"));
				}
				else{
					aufZeile = fileScanner.nextLine() + System.getProperty("line.separator");
				}
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
				aufZeile2 = (dekomprimiert(zeile2) + System.getProperty("line.separator"));
				}
				else{
					aufZeile2 = fileScanner2.nextLine() + System.getProperty("line.separator");
				}
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


   
    
    public static String aufteilen(String t) {
    	String textKomprimiert = "";
    	char leerzeichen = ' ';
    	String a = "";
    	String vergleich = "";
    	String vergleich2 = "";
    	int counter = 1;
    	int leerzeichenZaehler = 0;
    	
    for(int i = 0; i < t.length(); i++) {
    	if(t.charAt(i) != leerzeichen && i !=  t.length() -1 ) {
    		a = a + t.charAt(i);
    	}
    	else {
    		if(t.charAt(i) != leerzeichen && i == t.length() - 1) {
    			a = a + t.charAt(i);
    			vergleich2 = a;
    		}
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
    		else {
    			leerzeichenZaehler = leerzeichenZaehler + 1;
    			a = a + t.charAt(i);
        		}
    		
    		if(vergleich.equals(vergleich2) && !vergleich2.equals("")) {
       		 counter = counter + 1;
       		 vergleich2 = "";
       	 }
    		 else {
    			if(vergleich != vergleich2 && !vergleich2.equals("")) {
    				textKomprimiert = textKomprimiert + vergleich + " " + counter + " ";
    				vergleich = vergleich2;
    				counter = 0;
    			}
    		}
    		
    	
    	
    }
    }
    if(counter != 0) {
    textKomprimiert = textKomprimiert + vergleich +" " + counter;
    }
    else {
    	textKomprimiert = textKomprimiert + vergleich +" " + 1;	
    }
    return textKomprimiert;
    }
    

	
    
    public static String dekomprimiert (String tK) {
    	String dekomprimiert = "";
    	char leerzeichen = ' ';
    	int anzahl = 0;
    	String wert = "";
    	char an = ' ';
    	int leerzeichenZaehler = 0;
    	
        for(int i = 0; i < tK.length(); i++) {
        	if(tK.charAt(i) != leerzeichen && i !=  tK.length() -1 ) {
        		wert = wert + tK.charAt(i);
        	}
        	else {
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