package ejemplo02;

public class Hilo extends Thread {
	
	private String nombre;
		
	public Hilo(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	// Código a ejecutar
	public void run() {
		//Asignamos un nombre
		System.out.println("Nombre del hilo:" + nombre);
		//Prioridad por defecto del hilo 
		System.out.println("Prioridad por defecto: " + NORM_PRIORITY);
		
		//Podemos cambiar el nombre del hilo
		//Thread.currentThread().setName("nombre");
		//Y también la prioridad del hilo
		Thread.currentThread().setPriority(MIN_PRIORITY);
		System.out.println("getName(): " + Thread.currentThread().getName());
		System.out.println("getPriority(): " + Thread.currentThread().getPriority());
		System.out.println("getId(): " + Thread.currentThread().getId());
		System.out.println("activeCount(): " + Thread.currentThread().activeCount());
		
		
	}
}
