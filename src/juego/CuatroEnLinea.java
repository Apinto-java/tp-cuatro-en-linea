package juego;

/**
 * Juego Cuatro en Lí­nea
 * 
 * Reglas:
 * 
 * 		...
 *
 */
public class CuatroEnLinea {
	
	private Casillero[][] tablero;
	private int contador = 0;
	
	/**
	 * pre : 'filas' y 'columnas' son mayores o iguales a 4.
	 * post: empieza el juego entre el jugador que tiene fichas rojas, identificado como 
	 * 		 'jugadorRojo' y el jugador que tiene fichas amarillas, identificado como
	 * 		 'jugadorAmarillo'. 
	 * 		 Todo el tablero está vacío.
	 * 
	 * @param filas : cantidad de filas que tiene el tablero.
	 * @param columnas : cantidad de columnas que tiene el tablero.
	 * @param jugadorRojo : nombre del jugador con fichas rojas.
	 * @param jugadorAmarillo : nombre del jugador con fichas amarillas.
	 */
	public CuatroEnLinea(int filas, int columnas, String jugadorRojo, String jugadorAmarillo) {
		
		if(esUnNumeroDeFilaYColumnaValido(filas, columnas)) {
			
			tablero = new Casillero[columnas][filas];
			rellenarTableroCon(Casillero.VACIO);
			
		} else {
			
			throw new Error("El tablero debe ser mínimamente de 4 por 4, sino no habría lugar "
					+ "para ganarle a su compañero. :D");
		}
	}
	
	/**
	 * post : rellena el tablero completo con el tipo de Casillero indicado.
	 * @param tipo : tipo de casillero.
	 */
	private void rellenarTableroCon(Casillero tipo) {
		
		for (int indiceColumna = 0; indiceColumna < tablero.length; indiceColumna++) {
			
			for (int indiceFila = 0; indiceFila < tablero[indiceColumna].length; indiceFila++) {
				
				tablero[indiceColumna][indiceFila] = Casillero.VACIO;
			}
		}
	}
	
	/**
	 * post : devuelve la cantidad máxima de fichas que se pueden apilar en el tablero.
	 */
	public int contarFilas() {
		
		return tablero[0].length;
	}

	/**
	 * post : devuelve la cantidad máxima de fichas que se pueden alinear en el tablero.
	 */
	public int contarColumnas() {
		
		return tablero.length;
	}

	/**
	 * pre : fila está en el intervalo [1, contarFilas()],
	 * 		 columnas está en el intervalo [1, contarColumnas()].
	 * post: indica qué ocupa el casillero en la posición dada por fila y columna.
	 * 
	 * @param fila
	 * @param columna
	 */
	public Casillero obtenerCasillero(int fila, int columna) {
		
		return tablero[fila-1][columna-1];
	}
	
	/**
	 * pre : el juego no terminó, columna está en el intervalo [1, contarColumnas()]
	 * 		 y aún queda un Casillero.VACIO en la columna indicada. 
	 * post: deja caer una ficha en la columna indicada.
	 * 
	 * @param columna : número de columna en que soltar la ficha.
	 */
	public void soltarFichaEnColumna(int columna) {
		
		/**
		 * Implementación parcial.
		 */
		int i = tablero.length - 1;
		while (tablero[i][columna - 1] != Casillero.VACIO && i > 0) {
			
			i--;
				
		}
		
		if (contador % 2 == 0 ) {
			tablero[i][columna - 1] = Casillero.ROJO;
		} else {
			tablero[i][columna - 1] = Casillero.AMARILLO;
		}
		contador++;
		
	}
	
	/**
	 * post : indica si el juego terminó porque uno de los jugadores
	 * 		 ganó o no existen casilleros vacíos.
	 */
	public boolean termino() {
		return false;
	}

	/**
	 * post : indica si el juego terminó y si tiene un ganador.
	 */
	public boolean hayGanador() {
		
		return false;
	}

	/**
	 * pre : el juego terminó.
	 * post: devuelve el nombre del jugador que ganó el juego.
	 */
	public String obtenerGanador() {
		
		return null;
	}
	
	/**
	 * post : devuelve si el número de fila y columna es válido.
	 * 
	 * @param filas : cantidad de filas con las que se desea inicializar el tablero.
	 * @param columnas : cantidad de columnas con las que se desea inicializar el tablero.
	 */
	private boolean esUnNumeroDeFilaYColumnaValido(int fila, int columna) {
		
		return (fila >= 4) && (columna >= 4);
	}
}
