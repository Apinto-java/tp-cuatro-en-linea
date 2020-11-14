package juego;

public class BuscadorDePatrones {
	
	private int coordenadaFila = 0;
	private int coordenadaColumna = 0;
	private Casillero[][] tablero;
	private Casillero colorCasillero;
	private int fichasEncontradas = 0;
	private int columnaDesplazada = 0;
	
	public BuscadorDePatrones() { }
	
	private boolean estaDentroDeLosLimitesDelTablero(int coordenadaColumna, int coordenadaFila) {
		
		return (coordenadaColumna < tablero.length && coordenadaColumna >= 0) && 
				(coordenadaFila < tablero[coordenadaColumna].length && coordenadaFila >= 0);
	}
	
	private void buscarFichasHaciaLaIzquierda() {
		
		columnaDesplazada = coordenadaColumna;
		
		while(fichasEncontradas < 4 && estaDentroDeLosLimitesDelTablero(columnaDesplazada - 1, coordenadaFila) && 
				tablero[columnaDesplazada - 1][coordenadaFila] == colorCasillero) {
			
			fichasEncontradas++;
			columnaDesplazada--;
		}
	}
	
	private void buscarFichasHaciaLaDerecha() {
		
		columnaDesplazada = coordenadaColumna;
		
		while(fichasEncontradas < 4 && estaDentroDeLosLimitesDelTablero(columnaDesplazada + 1, coordenadaFila) && 
				tablero[columnaDesplazada + 1][coordenadaFila] == colorCasillero) {
			
			fichasEncontradas++;
			columnaDesplazada++;
		}
	}
	
	/**
	 * Analiza los laterales de la última ficha lanzada en búsqueda de fichas compañeras.
	 * @return
	 */
	private boolean hayPatronHorizontal() {
		
		fichasEncontradas = 1;

		buscarFichasHaciaLaIzquierda();
		
		buscarFichasHaciaLaDerecha();
		
		return fichasEncontradas == 4;
	}

	/**
	 * Busca hacia abajo Fichas compañeras en la periferia de la última Ficha lanzada.
	 * El método debe ser ejecutado recién cuando se alcanza la cuarta fila con al
	 * menos una Ficha soltada.
	 * 
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
	 * Busca en las diagonales descendentes de la periferia de la última Ficha 
	 * lanzada Fichas compañeras.
	 * 
	 * El método además deberá eximir de la ejecución la búsqueda en dirección 
	 * abajo-derecha o abajo-izquierda de Fichas si en respectivas direcciones 
	 * no hay al menos 3 (4 contando a la última Ficha lanzada) columnas que la
	 * separen de los márgenes laterales del Tablero.
	 * 
	 * @return
	 */
	private boolean hayPatronDiagonalDescendente() {
		
		int fichasEncontradas = 1;
		int columna = coordenadaColumna;
		int fila = coordenadaFila;
		
		/**
		 * busca Fichas en dirección Noroeste.
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
		 * busca Fichas en dirección Sureste.
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
	 * Busca en las diagonales ascendentes de la periferia de la última Ficha 
	 * lanzada Fichas compañeras.
	 * 
	 * El método además deberá eximir de la ejecución la búsqueda en dirección 
	 * arriba-derecha o arriba-izquierda de Fichas si en respectivas direcciones 
	 * no hay al menos 3 (4 contando a la última Ficha lanzada) columnas que la
	 * separen de los márgenes laterales del Tablero.
	 * 
	 * @return
	 */
	private boolean hayPatronDiagonalAscendente() {
		
		int fichasEncontradas = 1;
		int columna = coordenadaColumna;
		int fila = coordenadaFila;
		
		/**
		 * busca Fichas en dirección Noreste.
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
		 * busca Fichas en dirección Suroeste.
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
		 * Orden de secuencia (busca optimizar la fluidez del juego). Revisar cada método.
		 */
		return hayPatronHorizontal() || hayPatronVertical() || 
				hayPatronDiagonalDescendente() || hayPatronDiagonalAscendente();
	}
}