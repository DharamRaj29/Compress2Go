public class Ausfuehren {
    public static void main(String[] args) {
        /*

        String uncomdpressedFile ->Bildpfad
        Compress Methode

        String compressedFile ->Bildpfad
        Decompress Methode


        */
        

    }

   

    public static String compress() {
        
        String comp = new String();

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
        
    }
}
