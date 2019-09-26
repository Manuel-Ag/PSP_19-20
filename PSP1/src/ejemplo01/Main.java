package ejemplo01;

import java.io.IOException;

public class Main {
	//Ejemplo 1: Abrir un proceso
	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		Process pb = new ProcessBuilder("NOTEPAD").start();
	}
}
