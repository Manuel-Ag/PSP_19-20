package ejemplo17;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjetoCompartido objetoCompartido = new ObjetoCompartido();
		
		HiloCadena hiloCadena = new HiloCadena(objetoCompartido, "---------");
		HiloCadena hiloCadena2 = new HiloCadena(objetoCompartido, "|||||||||||");
		HiloCadena hiloCadena3 = new HiloCadena(objetoCompartido, "+++++++++++");
		HiloCadena hiloCadena4 = new HiloCadena(objetoCompartido, "@@@@@@@@@@@");
		
		hiloCadena.start();
		hiloCadena2.start();
		hiloCadena3.start();
		hiloCadena4.start();
		
	}
	
	

}
