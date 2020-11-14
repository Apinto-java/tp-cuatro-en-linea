package juego;

public class BuscadorDePatrones {
	
	private int coordenadaFila = 0;
	private int coordenadaColumna = 0;
	
	private Casillero[][] tablero;
	private Casillero colorCasillero;
	
	private int columnaDesplazada = 0;
	private int filaDesplazada = 0;
	
	private int fichasEncontradas = 1;
	
	public BuscadorDePatrones() { }
	
	private boolean estaDentroDeLosLimitesDelTablero(int coordenadaColumna, int coordenadaFila) {
		
		return (coordenadaColumna < tablero.length && coordenadaColumna >= 0) && 
				(coordenadaFila < tablero[coordenadaColumna].length && coordenadaFila >= 0);
	}
	
	private void buscarFichasEnDireccionOeste() {
		
		columnaDesplazada = coordenadaColumna;
		filaDesplazada = coordenadaFila;
		
		while(fichasEncontradas < 4 && estaDentroDeLosLimitesDelTablero(columnaDesplazada - 1, filaDesplazada) && 
				tablero[columnaDesplazada - 1][filaDesplazada] == colorCasillero) {
			
			fichasEncontradas++;
			columnaDesplazada--;
		}
	}
	
	private void buscarFichasEnDireccionEste() {
		
		columnaDesplazada = coordenadaColumna;
		filaDesplazada = coordenadaFila;
		
		while(fichasEncontradas < 4 && estaDentroDeLosLimitesDelTablero(columnaDesplazada + 1, filaDesplazada) && 
				tablero[columnaDesplazada + 1][filaDesplazada] == colorCasillero) {
			
			fichasEncontradas++;
			columnaDesplazada++;
		}
	}
	
	/**
	 * Analiza los laterales de la �ltima ficha lanzada en b�squeda de fichas compa�eras.
	 * @return
	 */
	private boolean hayPatronHorizontal() {
		
		fichasEncontradas = 1;

		buscarFichasEnDireccionOeste();
		
		buscarFichasEnDireccionEste();
		
		return fichasEncontradas == 4;
	}

	private void buscarFichasEnDireccionSur() {
		
		columnaDesplazada = coordenadaColumna;
		filaDesplazada = coordenadaFila;
		
		while(fichasEncontradas < 4 && estaDentroDeLosLimitesDelTablero(columnaDesplazada, filaDesplazada + 1) &&
				tablero[columnaDesplazada][filaDesplazada + 1] == colorCasillero) {
			
			fichasEncontradas++;
			filaDesplazada++;
		}
	}
	
	/**
	 * Busca hacia abajo Fichas compa�eras en la periferia de la �ltima Ficha lanzada.
	 * El m�todo debe ser ejecutado reci�n cuando se alcanza la cuarta fila con al
	 * menos una Ficha soltada.
	 * 
	 * @return
	 */
	private boolean hayPatronVertical() {
		
		fichasEncontradas = 1;
		
		buscarFichasEnDireccionSur();
		
		return fichasEncontradas == 4;
	}

	private void buscarFichasEnDireccionNoroeste() {
		
		columnaDesplazada = coordenadaColumna;
		filaDesplazada = coordenadaFila;
		
		/**
		 * busca Fichas en direcci�n Noroeste.
		 */
		while(fichasEncontradas < 4 && estaDentroDeLosLimitesDelTablero(columnaDesplazada - 1, filaDesplazada - 1) && 
				tablero[columnaDesplazada - 1][filaDesplazada - 1] == colorCasillero) {
			
			fichasEncontradas++;
			columnaDesplazada--;
			filaDesplazada--;
		}
	}
	
	private void buscarFichasEnDireccionSureste() {
		
		columnaDesplazada = coordenadaColumna;
		filaDesplazada = coordenadaFila;
		
		/**
		 * busca Fichas en direcci�n Sureste.
		 */
		while(fichasEncontradas < 4 && estaDentroDeLosLimitesDelTablero(columnaDesplazada + 1, filaDesplazada + 1) && 
				tablero[columnaDesplazada + 1][filaDesplazada + 1] == colorCasillero) {
			
			fichasEncontradas++;
			columnaDesplazada++;
			filaDesplazada++;
		}
	}
	
	/**
	 * Busca en las diagonales descendentes de la periferia de la �ltima Ficha 
	 * lanzada Fichas compa�eras.
	 * 
	 * El m�todo adem�s deber� eximir de la ejecuci�n la b�squeda en direcci�n 
	 * abajo-derecha o abajo-izquierda de Fichas si en respectivas direcciones 
	 * no hay al menos 3 (4 contando a la �ltima Ficha lanzada) columnas que la
	 * separen de los m�rgenes laterales del Tablero.
	 * 
	 * @return
	 */
	private boolean hayPatronDiagonalDescendente() {
		
		fichasEncontradas = 1;
		
		buscarFichasEnDireccionNoroeste();
		
		buscarFichasEnDireccionSureste();
		
		return fichasEncontradas == 4;
	}

	private void buscarFichasEnDireccionNoreste() {
		
		columnaDesplazada = coordenadaColumna;
		filaDesplazada = coordenadaFila;
		
		/**
		 * busca Fichas en direcci�n Noreste.
		 */
		while(fichasEncontradas < 4 && estaDentroDeLosLimitesDelTablero(columnaDesplazada + 1, filaDesplazada - 1) && 
				tablero[columnaDesplazada + 1][filaDesplazada - 1] == colorCasillero) {
			
			fichasEncontradas++;
			columnaDesplazada++;
			filaDesplazada--;
		}
	}
	
	private void buscarFichasEnDireccionSuroeste() {
		
		columnaDesplazada = coordenadaColumna;
		filaDesplazada = coordenadaFila;
		
		/**
		 * busca Fichas en direcci�n Suroeste.
		 */
		while(fichasEncontradas < 4 && estaDentroDeLosLimitesDelTablero(columnaDesplazada - 1, filaDesplazada + 1) && 
				tablero[columnaDesplazada - 1][filaDesplazada + 1] == colorCasillero) {
			
			fichasEncontradas++;
			columnaDesplazada--;
			filaDesplazada++;
		}
	}
	
	/**
	 * Busca en las diagonales ascendentes de la periferia de la �ltima Ficha 
	 * lanzada Fichas compa�eras.
	 * 
	 * El m�todo adem�s deber� eximir de la ejecuci�n la b�squeda en direcci�n 
	 * arriba-derecha o arriba-izquierda de Fichas si en respectivas direcciones 
	 * no hay al menos 3 (4 contando a la �ltima Ficha lanzada) columnas que la
	 * separen de los m�rgenes laterales del Tablero.
	 * 
	 * @return
	 */
	private boolean hayPatronDiagonalAscendente() {
		
		fichasEncontradas = 1;
		
		buscarFichasEnDireccionNoreste();
		
		buscarFichasEnDireccionSuroeste();
		
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