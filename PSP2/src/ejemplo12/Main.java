package ejemplo12;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contador contador = new Contador();
		
		HiloA a = new HiloA("HiloA", contador);
		HiloB b = new HiloB("HiloB", contador);
		a.start();
		b.start();
	}

}
