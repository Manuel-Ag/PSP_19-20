package ejemplo06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class EjemploLectura {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*Scanner sc = new Scanner(System.in);
		sc.nextLine();*/
		
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		
		System.out.println("Escribe algo");
		String texto = br.readLine();
		
		System.out.println(texto);
		br.close();
		in.close();
		
		System.exit(0);
	}

}
