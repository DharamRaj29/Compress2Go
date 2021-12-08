import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
    	String textAufgeteilt = "";
    	char leerzeichen = ' ';
    	String a = "";
    	String vergleich = "";
    	String vergleich2 = "";
    	int counter = 1;
    	int leerzeichenZaehler = 0;
    for(int i = 0; i < t.length(); i++) {
    	if(t.charAt(i) != leerzeichen) {
    		a = a + t.charAt(i);
    	}
    	else {
    		if(t.charAt(i) == leerzeichen && leerzeichenZaehler == 2) {
    			leerzeichenZaehler = 0;
    	         if(vergleich == "") {
    	        	 vergleich = vergleich + a; 
    	        	 a = "";
    	        	 System.out.println(vergleich);
    	         }
    	         else {
    	        	 vergleich2 = a;
    	         }		
    		}
    		else {
    			//if(leerzeichenZaehler != 0) {
    			leerzeichenZaehler = leerzeichenZaehler + 1;
    			a = a + t.charAt(i);
    			//}
        		}
    		
    		if(vergleich.equals(vergleich2)) {
       		 counter = counter + 1;
       	 }
    	
    	
    }
    }
    
    textAufgeteilt = vergleich + " " + counter;
    
    return textAufgeteilt;
    }
    

   /*  public static String aufteilen() {
        
        String pixMap = "237 28 36 237 28 36 237 28 36 237 28 36 237 28 36";
        
        String aufgeteilt = "";

        char leerzeichen = ' ';

        int leerzeichenZaehler = 0;

        String tripel = new String();
        String vergleichsTripel = new String();
        
        for(int i = 0; i < pixMap.length(); i++){
            if(pixMap.charAt(i) == leerzeichen){
                leerzeichenZaehler = leerzeichenZaehler+1;
                
                if(leerzeichenZaehler < 3){
                    tripel = tripel + pixMap.charAt(i); 
                }
                else{
                    tripel = tripel + pixMap.charAt(i);
                }

            } 
            else{
                if(leerzeichenZaehler < 3){
                    
                    tripel = tripel + pixMap.charAt(i);
                    
                }
                else{
                    vergleichsTripel = tripel;
                    
                    tripel = tripel + pixMap.charAt(i);
                    leerzeichenZaehler = 0;

                    
                }
                

            }
        }
        
        System.out.println(tripel);
        System.out.println("Vergleichstripel:" + vergleichsTripel);

        
        
        
        
        return aufgeteilt;

	*/



        /*String comp = new String();

        String uncomp = new String();
        uncomp = "237 28 36 237 28 36 237 28 36 237 28 36 237 28 36";

        for(int i=0; i < uncomp.length(); i++){
            String tripel = new String();

            String tripel2 = new String();

            //tripel = tripel + uncomp.charAt(i);
            
            char leerzeichen = ' ';
            
            int leerzeichenZÃ¤hler = 0;
             
            if(uncomp.charAt(i)== leerzeichen){
                leerzeichenZÃ¤hler = leerzeichenZÃ¤hler + 1;
                if(leerzeichenZÃ¤hler < 3){
                    tripel = tripel + uncomp.charAt(i) ;
                }
            }
            else if(leerzeichenZÃ¤hler == 3){
                
                leerzeichenZÃ¤hler = 0;

                if(uncomp.charAt(i)== leerzeichen){
                    leerzeichenZÃ¤hler = leerzeichenZÃ¤hler + 1;
                    if(leerzeichenZÃ¤hler < 3){
                        tripel2 = tripel2 + uncomp.charAt(i) ;
                    }
                }

            }
            else{
                if(leerzeichenZÃ¤hler < 3)
                tripel = tripel + uncomp.charAt(i);
            }
            


        }

        
        return comp;
        */

        
    }
