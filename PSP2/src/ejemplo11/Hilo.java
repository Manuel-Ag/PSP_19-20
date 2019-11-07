package ejemplo11;

public class Hilo extends Thread {
	private SolicitaSuspender solicitaSuspender = new SolicitaSuspender();
	
	public Hilo(String s) {
		super(s);
	}
	
	public Hilo(ThreadGroup group, String name) {
		super(group, name);
	}

	public void Suspende() {
		solicitaSuspender.setBolean(true);
	}
	
	public void Reanuda() {
		solicitaSuspender.setBolean(false);
	}
	
	public void run() { 
		int contador = 0;
		
		while (true) {
			if (solicitaSuspender.getBolean())
				System.out.println("He han suspendido: " + getName());
			solicitaSuspender.esperando();
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Hola soy " + getName() + " contador: " + contador);
			contador++;
			
		}
	}
	
	public class SolicitaSuspender {
		private boolean suspender;
		
		public synchronized void setBolean(boolean b) {
			suspender = b;
			notify();
		}
		
		public boolean getBolean() {
			return suspender;
		}
		
		public synchronized void esperando() {
			while (suspender)
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
}
