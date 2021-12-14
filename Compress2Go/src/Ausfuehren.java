import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ausfuehren {
	static String text =  "";
    public static void main(String[] args) {
        /*

        String uncomdpressedFile ->Bildpfad
        Compress Methode

        String compressedFile ->Bildpfad
        Decompress Methode


        */
        Path filePath = Paths.get("H:/", "Desktop", "Informatik", "Kreis.ppm");
    	try {
			text = Files.readString(filePath);
			System.out.println(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	String text2= "237 28 36 237 28 36 237 28 36 237 28 36 237 28 36 237 28 36 255 255 255";
 
    	
    	System.out.println("/////////////////////////////////////////////////////////////////////////");
        System.out.println(aufteilen(text2));
    }

   
    
    public static String aufteilen(String t) {
    	String textKomprimiert = "";
    	char leerzeichen = ' ';
    	String a = "";
    	String vergleich = "";
    	String vergleich2 = "";
    	int counter = 1;
    	int leerzeichenZaehler = 0;
    	boolean vollstaendig = false;
    	String zw = "";
    for(int i = 0; i < t.length(); i++) {
    	if(t.charAt(i) != leerzeichen) {
    		a = a + t.charAt(i);
    	}
    	else {
    		if(t.charAt(i) == leerzeichen && leerzeichenZaehler == 2) {

    			leerzeichenZaehler = 0;
    	         if(vergleich == "") {
    	        	 vergleich = vergleich + a; 
    	        	 System.out.println("Vergleich 1 " + vergleich);
    	        	 a = "";
    	        	 System.out.println("aaaaa: " + a);
    	        	 i = i + 1;
    	         }
    	         else {
    	    		vollstaendig = true;
    	    		
    	    		vergleich2 = "";
    	    		vergleich2 = a;
    	    		System.out.println("a2 " + a);
    	    		System.out.println("vergleich2 " + vergleich2);
    	    		System.out.println("a " + a);
    	         }		
    		}
    		else {
    			vollstaendig = false;
    			leerzeichenZaehler = leerzeichenZaehler + 1;
    			a = a + t.charAt(i);
        		}
    		
    		if(vergleich.equals(vergleich2)) {
       		 counter = counter + 1;
       	 }
    		/* else {
    			if(vergleich != vergleich2 && vollstaendig == true) {
    				textKomprimiert = textKomprimiert + vergleich + counter + "   ";
    				System.out.println(zw);
    				vergleich = "";
    				counter = 0;
    			}
    		}
    		*/
    	
    	
    }
    }
    
    textKomprimiert = vergleich +" Anzahl: " + counter;
    
    return textKomprimiert;
    }
    
	public static String zeilen(String t) {
		String zeile1 = "";
		String zeile2 = "";
		String zeile3 = "";
		String zeile4 = "";
		
		
		
		
		
		Scanner fileScanner = new Scanner(t);
		
		zeile1 = fileScanner.nextLine();
		
		System.out.println("Zeile 1 ist: " + zeile1);

		String geformt = "";


		
		return geformt;
	}
        
    }