import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ausfuehren {
    public static void main(String[] args) {
        /*

        String uncomdpressedFile ->Bildpfad
        Compress Methode

        String compressedFile ->Bildpfad
        Decompress Methode


        */
        Path filePath = Paths.get("H:/", "Desktop", "Informatik", "Kreis.ppm");
    	try {
			String text = Files.readString(filePath);
			System.out.println(text);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

   

    public static String aufteilen() {
        
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

            } 
            else{
                if(leerzeichenZaehler < 3){
                    
                    tripel = tripel + pixMap.charAt(i);
                    
                }
                else{
                    tripe
                    leerzeichenZaehler = 0;

                    
                }
                

            }
        }
        
        
        
        
        
        
        
        return aufgeteilt;





        /*String comp = new String();

        String uncomp = new String();
        uncomp = "237 28 36 237 28 36 237 28 36 237 28 36 237 28 36";

        for(int i=0; i < uncomp.length(); i++){
            String tripel = new String();

            String tripel2 = new String();

            //tripel = tripel + uncomp.charAt(i);
            
            char leerzeichen = ' ';
            
            int leerzeichenZähler = 0;
             
            if(uncomp.charAt(i)== leerzeichen){
                leerzeichenZähler = leerzeichenZähler + 1;
                if(leerzeichenZähler < 3){
                    tripel = tripel + uncomp.charAt(i) ;
                }
            }
            else if(leerzeichenZähler == 3){
                
                leerzeichenZähler = 0;

                if(uncomp.charAt(i)== leerzeichen){
                    leerzeichenZähler = leerzeichenZähler + 1;
                    if(leerzeichenZähler < 3){
                        tripel2 = tripel2 + uncomp.charAt(i) ;
                    }
                }

            }
            else{
                if(leerzeichenZähler < 3)
                tripel = tripel + uncomp.charAt(i);
            }
            


        }

        
        return comp;
        */
    }
}
