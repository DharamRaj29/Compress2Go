import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ausfuehren {
	
	static String text = "";
	
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	aufteilen(text);
    }

   

    public static String aufteilen(String t) {
        
        String comp = new String();
        
        char leerzeichen = ' ';
        
        int leerzeichenZaehler = 0;

        for(int i=0; i < t.length(); i++){
            String tripel1 = new String();

            String tripel2 = new String();

            tripel1 = tripel1 + t.charAt(i);
            
          
             
            if(t.charAt(i)== leerzeichen){
                leerzeichenZaehler = leerzeichenZaehler + 1;
                if(leerzeichenZaehler < 3){
                    tripel1 = tripel1 + t.charAt(i) ;
                }
            }
            else if(leerzeichenZaehler == 3){
                
                leerzeichenZaehler = 0;

                if(t.charAt(i)== leerzeichen){
                    leerzeichenZaehler = leerzeichenZaehler + 1;
                    if(leerzeichenZaehler < 3){
                        tripel2 = tripel2 + t.charAt(i) ;
                    }
                }

            }
            else{
                if(leerzeichenZaehler < 3)
                tripel1 = tripel1 + t.charAt(i);
            }
            


        }

        
        return comp;
        
    }
}

