package ejemplo07;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "ipconfig");	
		
		File fileOutput = new File("salida.txt");
		File fileError = new File("error.txt");
		
		//redirect
		pb.redirectOutput(fileOutput);
		pb.redirectError(fileError);
		
		pb.start();
	}

}
