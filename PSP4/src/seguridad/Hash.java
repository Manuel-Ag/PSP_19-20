package seguridad;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		MessageDigest md;
		
		md = MessageDigest.getInstance("MD5");
		String mensaje = "mensaje blah blah";
		//Byte[] fileContent = Files.readAllBytes("prueba.txt");
		byte[] dataBytes = Files.readAllBytes(Paths.get("prueba.txt"));
		//byte dataBytes[] = mensaje.getBytes();
		md.update(dataBytes);
		byte resumen[] = md.digest();
		
		System.out.println("Mensaje resumen :" + new String(resumen));
		System.out.println("Código hash:" + convertirHex(resumen));
		
	}
	
	static String convertirHex(byte[] resumen) {
		String hex = "";
		for (int i = 0; i < resumen.length; i++) {
			String h = Integer.toHexString(resumen[i] & 0xFF);
			hex += h;
		}
		return hex;
	}

}
