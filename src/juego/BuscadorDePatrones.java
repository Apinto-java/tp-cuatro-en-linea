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
	
	
	
	/**
	 * Valida que la ficha a tirar est� dentro de los l�mites del tablero.
	 * 
	 * post: Devuelve si se cumple o no la condici�n.
	 * 
	 * @param coordenadaColumna : posici�n de la ficha en columna
	 * @param coordenadaFila : posici�n de la ficha en fila
	 * @return True en caso de cumplirse la condici�n dada.
	 */
	private boolean estaDentroDeLosLimitesDelTablero(int coordenadaColumna, int coordenadaFila) {
		
		return (coordenadaColumna < tablero.length && coordenadaColumna >= 0) && 
				(coordenadaFila < tablero[coordenadaColumna].length && coordenadaFila >= 0);
	}
	
	/**
	 * pre : Existe un tablero y existen m�s de 6 fichas en el mismo (3 de cada jugador).
	 * post: Busca fichas compa�eras en direcci�n izquierda.
	 */
	
	private void buscarFichasHaciaLaIzquierda() {
		
		columnaDesplazada = coordenadaColumna;
		filaDesplazada = coordenadaFila;
		
		while(fichasEncontradas < 4 && estaDentroDeLosLimitesDelTablero(columnaDesplazada - 1, filaDesplazada) && 
				tablero[columnaDesplazada - 1][filaDesplazada] == colorCasillero) {
			
			fichasEncontradas++;
			columnaDesplazada--;
		}
	}
	
	/**
	 * pre : Existe un tablero y existen m�s de 6 fichas en el mismo (3 de cada jugador).
	 * post: Busca fichas compa�eras en direcci�n derecha.
	 */
	
	private void buscarFichasHaciaLaDerecha() {
		
		columnaDesplazada = coordenadaColumna;
		filaDesplazada = coordenadaFila;
		
		while(fichasEncontradas < 4 && estaDentroDeLosLimitesDelTablero(columnaDesplazada + 1, filaDesplazada) && 
				tablero[columnaDesplazada + 1][filaDesplazada] == colorCasillero) {
			
			fichasEncontradas++;
			columnaDesplazada++;
		}
	}
	
	/**
	 * pre : Existen m�s de 6 fichas en el tablero.
	 * post: Analiza los laterales de la �ltima ficha lanzada en b�squeda de fichas compa�eras.
	 * @return True en caso de encontrarse 4 fichas compa�eras.
	 */
	private boolean hayPatronHorizontal() {
		
		fichasEncontradas = 1;

		buscarFichasHaciaLaIzquierda();
		
		buscarFichasHaciaLaDerecha();
		
		return fichasEncontradas == 4;
	}
	
	/**
	 * pre : Existe un tablero y existen m�s de 6 fichas en el mismo (3 de cada jugador).
	 * post: Busca fichas compa�eras hacia abajo.
	 */

	private void buscarFichasHaciaAbajo() {
		
		columnaDesplazada = coordenadaColumna;
		filaDesplazada = coordenadaFila;
		
		while(fichasEncontradas < 4 && estaDentroDeLosLimitesDelTablero(columnaDesplazada, filaDesplazada + 1) &&
				tablero[columnaDesplazada][filaDesplazada + 1] == colorCasillero) {
			
			fichasEncontradas++;
			filaDesplazada++;
		}
	}
	
	/**
	 * pre : La cuarta fila tiene al menos una ficha soltada.
	 * post: Busca hacia abajo Fichas compa�eras en la periferia de la �ltima ficha lanzada.
	 * 
	 * @return True en caso de encontrarse 4 fichas compa�eras.
	 */
	private boolean hayPatronVertical() {
		
		fichasEncontradas = 1;
		
		buscarFichasHaciaAbajo();
		
		return fichasEncontradas == 4;
	}

	/**
	 * pre : Existe un tablero y existen m�s de 6 fichas en el mismo (3 de cada jugador).
	 * post: Busca fichas compa�eras hacia arriba a la izquierda (diagonal ascendente).
	 */
	private void buscarFichasHaciaArribaALaIzquierda() {
		
		columnaDesplazada = coordenadaColumna;
		filaDesplazada = coordenadaFila;
		
		while(fichasEncontradas < 4 && estaDentroDeLosLimitesDelTablero(columnaDesplazada - 1, filaDesplazada - 1) && 
				tablero[columnaDesplazada - 1][filaDesplazada - 1] == colorCasillero) {
			
			fichasEncontradas++;
			columnaDesplazada--;
			filaDesplazada--;
		}
	}
	
	/**
	 * post: Busca fichas compa�eras hacia abajo a la derecha (diagonal descendente).
	 */
	private void buscarFichasHaciaAbajoALaDerecha() {
		
		columnaDesplazada = coordenadaColumna;
		filaDesplazada = coordenadaFila;
		
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
	 * pre : En direcciones abajo-derecha o abajo-izquierda hay al menos 3
	 * 		 (4 contando a la �ltima Ficha lanzada) columnas que la separen 
	 *       de los m�rgenes laterales del Tablero.
	 * post: Devuelve valor de verdad en caso de hallarse el patr�n indicado.
	 * 
	 * @return True en caso de encontrarse 4 fichas compa�eras.
	 */
	private boolean hayPatronDiagonalDescendente() {
		
		fichasEncontradas = 1;
		
		buscarFichasHaciaArribaALaIzquierda();
		
		buscarFichasHaciaAbajoALaDerecha();
		
		return fichasEncontradas == 4;
	}

	/**
	 * post: Busca fichas compa�eras hacia arriba a la derecha (diagonal ascendente).
	 */
	private void buscarFichasHaciaArribaALaDerecha() {
		
		columnaDesplazada = coordenadaColumna;
		filaDesplazada = coordenadaFila;
		
		while(fichasEncontradas < 4 && estaDentroDeLosLimitesDelTablero(columnaDesplazada + 1, filaDesplazada - 1) && 
				tablero[columnaDesplazada + 1][filaDesplazada - 1] == colorCasillero) {
			
			fichasEncontradas++;
			columnaDesplazada++;
			filaDesplazada--;
		}
	}
	
	/**
	 * post: Busca fichas compa�eras hacia abajo a la izquierda (diagonal descendente).
	 */
	private void buscarFichasHaciaAbajoALaIzquierda() {
		
		columnaDesplazada = coordenadaColumna;
		filaDesplazada = coordenadaFila;
		
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
	 * pre : En direcciones arriba-derecha o arriba-izquierda hay al menos 3
	 * 		 (4 contando a la �ltima Ficha lanzada) columnas que la separen 
	 *       de los m�rgenes laterales del Tablero.
	 * post: Devuelve valor de verdad en caso de hallarse el patr�n indicado.
	 * 
	 * @return True en caso de encontrarse 4 fichas compa�eras.
	 */
	private boolean hayPatronDiagonalAscendente() {
		
		fichasEncontradas = 1;
		
		buscarFichasHaciaArribaALaDerecha();
		
		buscarFichasHaciaAbajoALaIzquierda();
		
		return fichasEncontradas == 4;
	}
	
	/**
	 * Define fin del juego.

	 * post: Devuelve valor de verdad en caso de hallarse uno de los patrones que indican fin del juego.
	 * 
	 * @param coordenadaUltimaFichaTirada :
	 * @param tablero : 
	 * @return True en caso de encontrarse uno de los 4 patrones determinados.
	 */
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