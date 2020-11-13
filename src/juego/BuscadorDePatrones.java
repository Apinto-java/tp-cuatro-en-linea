package juego;

public class BuscadorDePatrones {
	
	private int coordenadaFila = 0;
	private int coordenadaColumna = 0;
	private Casillero[][] tablero;
	private Casillero colorCasillero;
	
	public BuscadorDePatrones() { }
	
	private boolean estaDentroDeLosLimitesDelTablero(int coordenadaColumna, int coordenadaFila) {
		
		return (coordenadaColumna < tablero.length && coordenadaColumna >= 0) && 
				(coordenadaFila < tablero[coordenadaColumna].length && coordenadaFila >= 0);
	}
	
	/**
	 * Analiza los laterales de la �ltima ficha lanzada en b�squeda de fichas compa�eras.
	 * @return
	 */
	private boolean hayPatronHorizontal() {
		
		int fichasEncontradas = 1;
		int columna = coordenadaColumna;
		
		while(fichasEncontradas < 4 && estaDentroDeLosLimitesDelTablero(columna - 1, coordenadaFila) && 
				tablero[columna - 1][coordenadaFila] == colorCasillero) {
			
			fichasEncontradas++;
			columna--;
		}
		
		columna = coordenadaColumna;
		while(fichasEncontradas < 4 && estaDentroDeLosLimitesDelTablero(columna + 1, coordenadaFila) && 
				tablero[columna + 1][coordenadaFila] == colorCasillero) {
			
			fichasEncontradas++;
			columna++;
		}

		return fichasEncontradas == 4;
	}

	/**
	 * Busca hacia abajo Fichas compa�eras en la periferia de la �ltima Ficha lanzada.
	 * El m�todo debe ser ejecutado reci�n cuando se alcanza la cuarta fila con al
	 * menos una Ficha soltada.
	 * @return
	 */
	private boolean hayPatronVertical() {
		
		int fichasEncontradas = 1;
		int fila = coordenadaFila;
				
		while(fichasEncontradas < 4 && estaDentroDeLosLimitesDelTablero(coordenadaColumna, fila + 1) &&
				tablero[coordenadaColumna][fila + 1] == colorCasillero) {
			
			fichasEncontradas++;
			fila++;
		}
		
		return fichasEncontradas == 4;
	}

	/**
	 * Busca en las diagonales descendentes de la periferia de la �ltima Ficha 
	 * lanzada Fichas compa�eras.
	 * 
	 * El m�todo adem�s deber� eximir de la ejecuci�n la b�squeda en direcci�n 
	 * abajo-derecha o abajo-izquierda de Fichas si en respectivas direcciones 
	 * no hay al menos 3 (4 contando a la �ltima Ficha lanzada) columnas que la
	 * separen de los m�rgenes laterales del Tablero.
	 * @return
	 */
	private boolean hayPatronDiagonalDescendente() {
		
		int fichasEncontradas = 1;
		int columna = coordenadaColumna;
		int fila = coordenadaFila;
		
		/**
		 * busca Fichas en direcci�n Noroeste.
		 */
		while(fichasEncontradas < 4 && estaDentroDeLosLimitesDelTablero(columna - 1, fila - 1) && 
				tablero[columna - 1][fila - 1] == colorCasillero) {
			
			fichasEncontradas++;
			columna--;
			fila--;
		}
		
		columna = coordenadaColumna;
		fila = coordenadaFila;
		
		/**
		 * busca Fichas en direcci�n Sureste.
		 */
		while(fichasEncontradas < 4 && estaDentroDeLosLimitesDelTablero(columna + 1, fila + 1) && 
				tablero[columna + 1][fila + 1] == colorCasillero) {
			
			fichasEncontradas++;
			columna++;
			fila++;
		}
		
		return fichasEncontradas == 4;
	}

	/**
	 * Busca en las diagonales ascendentes de la periferia de la �ltima Ficha 
	 * lanzada Fichas compa�eras.
	 * 
	 * El m�todo adem�s deber� eximir de la ejecuci�n la b�squeda en direcci�n 
	 * arriba-derecha o arriba-izquierda de Fichas si en respectivas direcciones 
	 * no hay al menos 3 (4 contando a la �ltima Ficha lanzada) columnas que la
	 * separen de los m�rgenes laterales del Tablero.
	 * @return
	 */
	private boolean hayPatronDiagonalAscendente() {
		
		int fichasEncontradas = 1;
		int columna = coordenadaColumna;
		int fila = coordenadaFila;
		
		/**
		 * busca Fichas en direcci�n Noreste.
		 */
		while(fichasEncontradas < 4 && estaDentroDeLosLimitesDelTablero(columna + 1, fila - 1) && 
				tablero[columna + 1][fila - 1] == colorCasillero) {
			
			fichasEncontradas++;
			columna++;
			fila--;
		}
		
		columna = coordenadaColumna;
		fila = coordenadaFila;
		
		/**
		 * busca Fichas en direcci�n Suroeste.
		 */
		while(fichasEncontradas < 4 && estaDentroDeLosLimitesDelTablero(columna - 1, fila + 1) && 
				tablero[columna - 1][fila + 1] == colorCasillero) {
			
			fichasEncontradas++;
			columna--;
			fila++;
		}
		
		return fichasEncontradas == 4;
	}
	
	public boolean hay4EnLinea(Coordenada coordenadaUltimaFichaTirada, 
							   Casillero[][] tablero) {
		
		this.tablero = tablero;
		coordenadaFila = coordenadaUltimaFichaTirada.obtenerFila();
		coordenadaColumna = coordenadaUltimaFichaTirada.obtenerColumna();
		colorCasillero = tablero[coordenadaColumna][coordenadaFila];
		
		/**
		 * Orden de secuencia (busca optimizar la fluidez del juego). Revisar cada m�todo.
		 */
		return hayPatronHorizontal() || hayPatronVertical() || 
				hayPatronDiagonalDescendente() || hayPatronDiagonalAscendente();
	}
}