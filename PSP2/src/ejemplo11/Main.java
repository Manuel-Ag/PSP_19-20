package ejemplo11;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		ThreadGroup group = new ThreadGroup("grupo_hilos");
		
		// TODO Auto-generated method stub
		Hilo hilo = new Hilo(group, "hilo1");
		Hilo hilo2 = new Hilo(group, "hilo2");
		Hilo hilo3 = new Hilo(group, "hilo3");
		Hilo hilo4 = new Hilo(group, "hilo4");
		Hilo hilo5 = new Hilo(group, "hilo5");
		Hilo hilo6 = new Hilo(group, "hilo6");
		Hilo hilo7 = new Hilo(group, "hilo7");
		Hilo hilo8 = new Hilo(group, "hilo8");
		Hilo hilo9 = new Hilo(group, "hilo9");
		Hilo hilo10 = new Hilo(group, "hilo10");
		
		hilo.start();
		hilo2.start();
		hilo3.start();
		hilo4.start();
		hilo5.start();
		hilo6.start();
		hilo7.start();
		hilo8.start();
		hilo9.start();
		hilo10.start();

		Thread.sleep(3000);
		
		System.out.println("-------------------" + group.activeCount());
		group.suspend();
		
		/*hilo.Suspende();
		hilo2.Suspende();
		hilo3.Suspende();
		hilo4.Suspende();
		hilo5.Suspende();
		hilo6.Suspende();
		hilo7.Suspende();
		hilo8.Suspende();
		hilo9.Suspende();
		hilo10.Suspende();*/
		
	}

}
