package ejemplo17;

public class HiloCadena extends Thread {
	private ObjetoCompartido objeto;
	String cad;
	
	public HiloCadena(ObjetoCompartido objeto, String cadena) {
		this.objeto = objeto;
		this.cad = cadena;
	}
	
	public void run() {
		synchronized (objeto) {
			for (int i = 0; i < 50; i++) {
				objeto.PintaCadena(cad);
				objeto.notify();
				try {
					objeto.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
			objeto.notifyAll();
		}
		
		System.out.println("Finaliza hilo " + getName());
		
	}
}
