package ejemplo03;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Main {

	public static void main(String[] args) throws IOException {
		// Llamamos al programa ejemplo2
		File directorio = new File(".\\bin");
		
		ProcessBuilder pb = new ProcessBuilder("java", "ejemplo02.Main");
		pb.directory(directorio);
		
		System.out.println(pb.directory()+"");
		
		Process p;
		
		p = pb.start();
		InputStream is = p.getInputStream();
		int c;
		while ((c = is.read()) != -1) {
			System.out.print((char) c);
		}
	} 

}
