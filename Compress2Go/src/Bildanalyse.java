
public class Bildanalyse {
	
	static String ppm = "255 255 255 255 255 255 255 255 255 255 255 255 255 255 255";

	public static void main(String[] args) {
		String umg_bin = umwandlung(ppm);
		System.out.println(umg_bin);
	}

	public static String umwandlung(String p ) {
		String umgew = "Test";

		for(int i=0; i<3; i= i+3){
			String akt_zahl_string = new String();
			akt_zahl_string = akt_zahl_string + p.charAt(i) + p.charAt(i+1) + p.charAt(i+2) ; 
			System.out.println(akt_zahl_string);

			int akt_zahl_int = Integer.parseInt(akt_zahl_string);
			System.out.println(akt_zahl_int);
			
			String bin = Integer.toBinaryString(akt_zahl_int);
			System.out.println(bin);
			
		}
		return umgew;
	}

}
