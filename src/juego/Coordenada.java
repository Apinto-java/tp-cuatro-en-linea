package juego;

public class Coordenada {
	
	private int columna;
	private int fila;
	
	public Coordenada(int columna, int fila) {
		
		this.columna = columna;
		this.fila = fila;
	}
	
	public int obtenerFila() {
		 return fila;
	}
	
	public int obtenerColumna() {
		return columna;
	}
	
	public void cambiarFila(int fila) {
		this.fila = fila;
	}
	
	public void cambiarColumna (int columna) {
		this.columna = columna;
	}
	
	public void cambiarCoordenada(int columna, int fila) {
		this.columna = columna;
		this.fila = fila;
	}
	
}
