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
			System.out.println("M�todo getLocalHost(): " + inetAddress.getLocalHost());
			System.out.println("M�todo getHostName(): " + inetAddress.getHostName());
			System.out.println("M�todo getHostAddresrs(): " + inetAddress.getHostAddress());
			System.out.println("M�todo toString(): " + inetAddress.toString());
			System.out.println("M�todo getCanonicalHostName(): " + inetAddress.getCanonicalHostName());
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void ejemploURL(String s) {
		try {
			URL url = new URL(s);
			System.out.println("M�todo toString(): " + url.toString());
			System.out.println("M�todo getProtocol(): " + url.getProtocol());
			System.out.println("M�todo getHost(): " + url.getHost());
			System.out.println("M�todo getPort(): " + url.getPort());  // especificar puerto en constructor URL para mostrar
			System.out.println("M�todo getFile(): " + url.getFile());
			System.out.println("M�todo getUserInfo(): " + url.getUserInfo());
			System.out.println("M�todo getPath(): " + url.getPath());
			System.out.println("M�todo getAuthority(): " + url.getAuthority());
			System.out.println("M�todo getQuery(): " + url.getQuery());
			System.out.println("M�todo getDefaultPort(): " + url.getDefaultPort());
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
