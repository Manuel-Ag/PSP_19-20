package ejemplo06;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ejemplo06 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// Llamamos al programa ejemplo2
		File directorio = new File(".\\bin");

		ProcessBuilder pb = new ProcessBuilder("java", "ejemplo06.EjemploLectura");
		pb.directory(directorio);

		Process p = pb.start();
		
		OutputStream os = p.getOutputStream();
		os.write("prueba prueba".getBytes());
		os.flush();
		
		os.close();
		
		
		InputStream is = p.getInputStream();
		int c;
		while ((c = is.read()) != -1) {
			System.out.print((char) c);
		}

		// comprobamos si ha finalizado correctamente ejemplo02.java
		//System.out.println(p.waitFor() + "");

	}
}
