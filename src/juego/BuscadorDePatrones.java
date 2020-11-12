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
		/**
		 * Busca a la izquierda de la Coordenada de la última Ficha tirada.
		 */
		/*
		while (fichasEncontradas < 4 && coordenadaColumna + numeroDeColumna < tablero.length) {
			if (tablero[coordenadaColumna - columnaDeLaOuija][coordenadaFila] != colorCasillero) {
				
				columnaDeLaOuija--;
				
			} else {
				
				fichasEncontradas++;
			}
		}
		
		columnaDeLaOuija = 0;
		*/
		return fichasEncontradas == 4;
	}

	private boolean hayPatronVertical() {
		
		return false;
	}

	private boolean hayPatronDiagonalDescendente() {

		return false;
	}

	private boolean hayPatronDiagonalAscendente() {

		return false;
	}
	
	public boolean hay4EnLinea(Coordenada coordenadaUltimaFichaTirada, 
							   Casillero[][] tablero) {
		
		this.tablero = tablero;
		coordenadaFila = coordenadaUltimaFichaTirada.obtenerFila();
		coordenadaColumna = coordenadaUltimaFichaTirada.obtenerColumna();
		colorCasillero = tablero[coordenadaColumna][coordenadaFila];
		
		return hayPatronHorizontal() || hayPatronVertical() || 
				hayPatronDiagonalDescendente() || hayPatronDiagonalAscendente();
	}
}
