package juego;

/**
 * 
 * Permite almacenar un único par ordenado. En el contexto del juego, la coordenada X es la columna
 * y la coordenada Y es la fila
 */
public class Coordenada {
	
	private int columna;
	private int fila;
	
	/**
	 * Constructor de Coordenada
	 * @param columna: Columna de la Coordenada
	 * @param fila: Fila de la Coordenada
	 */
	public Coordenada(int columna, int fila) {
		
		this.columna = columna;
		this.fila = fila;
	}
	
	/**
	 * post: Devuelve la fila de la Coordenada
	 * @return Entero equivalente al número que corresponde a la fila.
	 */
	public int obtenerFila() {
		 return fila;
	}
	
	/**
	 * post: Devuelve la columna de la Coordenada
	 * @return Entero equivalente al número que corresponde a la columna.
	 */
	public int obtenerColumna() {
		return columna;
	}
	
	/**
	 * @param fila: Nueva fila de la Coordenada
	 * post: Cambia la fila de la Coordenada
	 */
	public void cambiarFila(int fila) {
		this.fila = fila;
	}
	
	/**
	 * @param columna: Nueva columna de la Coordenada
	 * post: Cambia la columna de la coordenada
	 */
	public void cambiarColumna (int columna) {
		this.columna = columna;
	}
	
	/**
	 * 
	 * @param columna: Nueva columna de la Coordenada
	 * @param fila: Nueva fila de la Coordenada
	 * post: Cambia tanto la fila como la columna de la Coordenada
	 */
	public void cambiarCoordenada(int columna, int fila) {
		this.columna = columna;
		this.fila = fila;
	}
	
}
