package ejemplo05;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {

	public static void main(String[] args) throws IOException {
		// Pasar cadena al programa
		Process p = new ProcessBuilder("CMD", "/C", "DATE").start();
		OutputStream os = p.getOutputStream();
		os.write("11-11-11".getBytes());
		os.flush();
		
		os.close();
		
		InputStream is = p.getInputStream();
		int c;
		while ((c = is.read()) != -1) {
			System.out.print((char) c );
		}
		
		InputStream er = p.getErrorStream();
		int c2;
		while ((c2 = er.read()) != -1) {
			System.out.print((char) c2);
		}
		
		is.close();
		
	}

}
