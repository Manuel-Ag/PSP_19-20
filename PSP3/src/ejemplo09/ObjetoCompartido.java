package ejemplo09;

public class ObjetoCompartido {
	private int numero;
	private boolean acabo;
	private int ganador;
	
	public ObjetoCompartido(int numero) {
		this.numero = numero;
		this.acabo = false;
	}

	public boolean isAcabo() {
		return acabo;
	}

	public int getGanador() {
		return ganador;
	}
	
	public synchronized String nuevaJugada(int jugador, int suNumero) {
		String cadena = "";
		
		if (!isAcabo()) {
			if (suNumero > numero)
				cadena = "N�mero demasiado algo";
			if (suNumero < numero)
				cadena = "N�mero demasiado bajo";
			if (suNumero == numero) {
				cadena = "Jugador " + jugador + " gana la partida, n�mero adivinado:" + numero;
				this.acabo = true;
				this.ganador = jugador;
			}
		} else
			cadena = "El juego ha finalizado ya";
		
		return cadena;
	}
}
