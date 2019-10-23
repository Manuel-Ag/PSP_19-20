package ejemplo08;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// No es necesario especificar los comandos, los definiremos después
		ProcessBuilder pb = new ProcessBuilder("CMD");
		
		File script = new File("comandos.txt");
		File fileOutput = new File("salida.txt");
		File fileError = new File("error.txt");
		
		//redirect
		pb.redirectInput(script);
		pb.redirectOutput(fileOutput);
		pb.redirectError(fileError);
		
		pb.start();
		
	}

}
