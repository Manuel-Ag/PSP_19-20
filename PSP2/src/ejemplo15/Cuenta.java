package ejemplo15;

public class Cuenta {
	private int saldo;
	
	public Cuenta(int n) {
		saldo = n;
	}
	
	public int getSaldo() {
		return saldo;
	}
	
	public void restar(int cantidad) {
		saldo = saldo - cantidad;
	}
	
	public synchronized void retirarDinero(int cantidad, String nom) {
		if (getSaldo() >= cantidad) {
			System.out.println(nom + " SE RETIRA SALDO (ACTUAL ES "+ getSaldo()+")");
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			restar(cantidad);
			System.out.println(nom + "HA RETIRADO " + cantidad + " y el saldo es " + getSaldo());
		} else {
			System.out.println(nom + " NO SE PUDE SACAR DINERO, SALDO " + getSaldo());
		}
		if (getSaldo() < 0) 
			System.out.println(nom + "EL SALDO ES NEGATIVO " + getSaldo());
	}
	
}
