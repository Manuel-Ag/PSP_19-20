package ejemplo15;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cuenta c = new Cuenta(1000);
		
		SacarDinero sd;
		for (int i = 0; i < 50; i++) {
			sd = new SacarDinero("Persona"+i, c);
			sd.start();
			
		}
	}

}
