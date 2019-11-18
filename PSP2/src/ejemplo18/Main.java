package ejemplo18;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cola cola = new Cola();
		
		Consumidor consumidor = new Consumidor(cola, 1);
		Productor productor = new Productor(cola, 1);
		
		consumidor.start();
		productor.start();
	}

}
