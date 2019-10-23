package ejemplo07;

public class Hilo extends Thread {
	private SolicitaSuspender solicitaSuspender = new SolicitaSuspender();
	
	public void Suspende() {
		solicitaSuspender.setBolean(true);
	}
	
	public void Reanuda() {
		solicitaSuspender.setBolean(false);
	}
	
	public void run() { 
		int contador = 0;
		
		while (true) {
			solicitaSuspender.esperando();
			System.out.println(contador+"");
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			contador++;
			
		}
	}
	
	public class SolicitaSuspender {
		private boolean suspender;
		
		public synchronized void setBolean(boolean b) {
			suspender = b;
			notifyAll();
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
