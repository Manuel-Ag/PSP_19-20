package ejemplo02;

import java.io.IOException;
import java.io.InputStream;

public class Main {

	//Ejemplo 2: cambiar inputStream
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Process p = new ProcessBuilder("CMD", "/C", "ipconfig").start();
	
		InputStream is = p.getInputStream();
		int c;
		while ((c = is.read()) != -1) {
			System.out.print((char) c);
		}
		
		//finalizo correctamente
		System.exit(0);
		
	}

}
