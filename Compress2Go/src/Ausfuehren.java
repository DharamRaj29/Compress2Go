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
    public static void main(String[] args) throws IOException {
     
    
    	
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
		}
    	
		int i = 0;
    	String zeile = "";
    	String aufZeile = "";
    	try (Scanner fileScanner = new Scanner(text)){
			while(fileScanner.hasNextLine()) {
			i = i + 1;
			if(i > 4){
				zeile = fileScanner.nextLine();
				aufZeile = (aufteilen(zeile) + System.getProperty("line.separator"));
				}
				else{
					aufZeile = fileScanner.nextLine() + System.getProperty("line.separator");
				//System.out.println(fileScanner.nextLine());
				}
			try {
	    		@SuppressWarnings("resource")
	    		FileOutputStream ppm = new FileOutputStream("C:\\Users\\Arian Lösing\\Desktop\\Schule\\Informatik\\Kreis3.ppm", true);
	    		ppm.write(aufZeile.getBytes());
	    		ppm.flush();
	    	} catch (FileNotFoundException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	}
			}
    	}
	
	
    	 Path filePath2 = Paths.get("C:/", "Users/", "Arian Lösing/", "Desktop/", "Schule", "Informatik/", "Kreis3.ppm");
     	try {
 			text2 = Files.readString(filePath2);
 			System.out.println(text2);
 		} catch (IOException e) {
 			e.printStackTrace();
 		}
	
	
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
    

	
}