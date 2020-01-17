package ejemplo09;

import java.io.Serializable;

public class Datos implements Serializable {
	String cadena;
	int intentos;
	int identificador;
	boolean gana;
	boolean juega;
	
	public Datos(String cadena, int intentos, int identificador) {
		this.cadena = cadena;
		this.intentos = intentos;
		this.identificador = identificador;
		this.gana = false;
		this.juega = true;
	}
	public Datos(String cadena) {
		this.cadena = cadena;
	}
	public String getCadena() {
		return cadena;
	}
	public void setCadena(String cadena) {
		this.cadena = cadena;
	}
	public int getIntentos() {
		return intentos;
	}
	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}
	public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	public boolean isGana() {
		return gana;
	}
	public void setGana(boolean gana) {
		this.gana = gana;
	}
	public boolean isJuega() {
		return juega;
	}
	public void setJuega(boolean juega) {
		this.juega = juega;
	}
	
	

}
