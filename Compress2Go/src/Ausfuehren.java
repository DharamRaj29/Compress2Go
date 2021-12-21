import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ausfuehren {
	static String text =  "";
    public static void main(String[] args) {
        
		String gesamt = "";
		
		/*
        String uncomdpressedFile ->Bildpfad
        Compress Methode

        String compressedFile ->Bildpfad
        Decompress Methode

		

        */
		// Windows:
        //Path filePath = Paths.get("H:/", "Desktop", "Informatik", "Kreis.ppm");
		
		// Mac:
		Path filePath = Paths.get("/Users/", "dharamraj/", "Documents/", "Schule/", "Informatik/", "Kreis.ppm");
		
    	try {
			text = Files.readString(filePath);
			//System.out.println(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	//String text2= "255 255 255 255 255 255 255 255 255 255 255 255 255 255 255";
 
    	String zeile = "";
    	System.out.println("/////////////////////////////////////////////////////////////////////////");
    	for(int i = 0; i < 5000000; i++) {
    	try (Scanner fileScanner = new Scanner(text)){
    		zeile = fileScanner.nextLine();
    	}
    	gesamt = gesamt + zeile;
    	

    	}

		System.out.println(zeilen(text));
   		//System.out.println(aufteilen(gesamt));

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
    		//System.out.println(a);
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
    	        	// System.out.println("Vergleich 1 " + vergleich);
    	        	 a = "";
    	         }
    	         else {
    	    		vergleich2 = "";
    	    		vergleich2 = a;
    	    		a = "";
    	    		//System.out.println("vergleich2 " + vergleich2);
    	         }		
    		}
    		else {
    			leerzeichenZaehler = leerzeichenZaehler + 1;
    			a = a + t.charAt(i);
        		}
    		
    		if(vergleich.equals(vergleich2) && !vergleich2.equals("")) {
       		 counter = counter + 1;
       		 vergleich2 = "";
       		// System.out.println("counter: " + counter);
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
    
	public static String zeilen(String t) {
		String zeile1 = "";
		String zeile2 = "";
		String zeile3 = "";
		String zeile4 = "";
		
		try (Scanner fileScanner = new Scanner(t)) {
			zeile1 = fileScanner.nextLine();
			zeile2 = fileScanner.nextLine();
			zeile3 = fileScanner.nextLine();
			zeile4 = fileScanner.nextLine();
		}
		String geformt = "";

		
		return zeile1 + zeile2 + zeile3;
	}

	public static String umformen (String t){
		String geformt = "";
		
		return geformt;

	}
        
    }