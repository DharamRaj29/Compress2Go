
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Ausfuehren {
    public static void main(String[] args) {
        /*
        String decomdpressedFile ->Bildpfad
        Compress Methode
        */
    	Path filePath = Paths.get("H:/", "Desktop", "Informatik", "Kreis.ppm");
    	try {
			String text = Files.readString(filePath);
			System.out.println(text);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        /*
        String compressedFile ->Bildpfad
        Decompress Methode

        */
    }
}
