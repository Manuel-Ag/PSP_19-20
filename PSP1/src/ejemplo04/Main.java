package ejemplo04;

import java.io.IOException;
import java.io.InputStream;

public class Main {

	public static void main(String[] args) throws IOException {
		//Redirigir stream a error
		Process p = new ProcessBuilder("CMD", "/C", "ipcondsffig").start();

		InputStream is = p.getInputStream();
		int c;
		while ((c = is.read()) != -1) {
			System.out.print((char) c);
		}
		
		InputStream er = p.getErrorStream();
		int c2;
		while ((c2 = er.read()) != -1) {
			System.out.print((char) c2);
		}
		
		is.close();
		er.close();
		
		System.exit(-1);
	}

}
