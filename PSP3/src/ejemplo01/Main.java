package ejemplo01;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * Ejemplos con InetAddress y URL
 *
 */

public class Main {

	public static void main(String[] args) {
		// Ejemplos InetAddress
		ejemploInetAddress("localhost");
		System.out.println("------------------------------------------------");
		ejemploInetAddress("www.duckduckgo.com");
		System.out.println("------------------------------------------------");

		// Ejemplos URL
		ejemploURL("http://www.duckduckgo.com");
		System.out.println("------------------------------------------------");
		ejemploURL("https://duckduckgo.com/?q=java&t=h_&ia=web");
		System.out.println("------------------------------------------------");
		
	}
	
	private static void ejemploInetAddress(String s) {
		try {
			InetAddress inetAddress = InetAddress.getByName(s);
			System.out.println("Método getLocalHost(): " + inetAddress.getLocalHost());
			System.out.println("Método getHostName(): " + inetAddress.getHostName());
			System.out.println("Método getHostAddresrs(): " + inetAddress.getHostAddress());
			System.out.println("Método toString(): " + inetAddress.toString());
			System.out.println("Método getCanonicalHostName(): " + inetAddress.getCanonicalHostName());
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void ejemploURL(String s) {
		try {
			URL url = new URL(s);
			System.out.println("Método toString(): " + url.toString());
			System.out.println("Método getProtocol(): " + url.getProtocol());
			System.out.println("Método getHost(): " + url.getHost());
			System.out.println("Método getPort(): " + url.getPort());  // especificar puerto en constructor URL para mostrar
			System.out.println("Método getFile(): " + url.getFile());
			System.out.println("Método getUserInfo(): " + url.getUserInfo());
			System.out.println("Método getPath(): " + url.getPath());
			System.out.println("Método getAuthority(): " + url.getAuthority());
			System.out.println("Método getQuery(): " + url.getQuery());
			System.out.println("Método getDefaultPort(): " + url.getDefaultPort());
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
