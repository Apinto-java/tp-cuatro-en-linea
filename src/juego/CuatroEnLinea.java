package juego;

/**
 * Juego Cuatro en L�nea
 * 
 * Reglas:
 * 
 * 		...
 *
 */
public class CuatroEnLinea {
	
	private Casillero[][] tablero;
	private int contadorDeVecesTiradas = 0;
	private String jugadorRojo;
	private String jugadorAmarillo;
	private Coordenada posicionUltimaFichaLanzada;
	private BuscadorDePatrones buscadorDePatrones;
	private boolean hayGanador = false;
	private boolean terminoElJuego = false;
	
	
	/**
	 * pre : 'filas' y 'columnas' son mayores o iguales a 4.
	 * post: empieza el juego entre el jugador que tiene fichas rojas, identificado como 
	 * 		 'jugadorRojo' y el jugador que tiene fichas amarillas, identificado como
	 * 		 'jugadorAmarillo'. 
	 * 		 Todo el tablero est� vac�o.
	 * 
	 * @param filas : cantidad de filas que tiene el tablero.
	 * @param columnas : cantidad de columnas que tiene el tablero.
	 * @param jugadorRojo : nombre del jugador con fichas rojas.
	 * @param jugadorAmarillo : nombre del jugador con fichas amarillas.
	 */
	public CuatroEnLinea(int filas, int columnas, String jugadorRojo, String jugadorAmarillo) {
		
		if (!esFilaYColumnaMinimasParaCrearTablero(filas, columnas)) {
			
			throw new Error("El tablero debe ser m�nimamente de 4 por 4, sino no habr�a lugar "
					+ "para ganarle a su compa�ero. :D");
		}
		
		tablero = new Casillero[columnas][filas];
		
		this.jugadorRojo = jugadorRojo;
		this.jugadorAmarillo = jugadorAmarillo;
		
		rellenarTableroCon(Casillero.VACIO);
		
		posicionUltimaFichaLanzada = new Coordenada();
		
		buscadorDePatrones = new BuscadorDePatrones();
	}
	
	/**
	 * post : rellena el tablero completo con el tipo de Casillero indicado.
	 * @param tipo : tipo de casillero.
	 */
	private void rellenarTableroCon(Casillero tipo) {
		
		int longitudTablero = tablero.length;
		int alturaTablero = 0;
		
		for (int indiceColumna = 0; indiceColumna < longitudTablero; indiceColumna++) {
			
			alturaTablero = tablero[indiceColumna].length;
			
			for (int indiceFila = 0; indiceFila < alturaTablero; indiceFila++) {
				
				tablero[indiceColumna][indiceFila] = Casillero.VACIO;
			}
		}
	}
	
	/**
	 * post : devuelve la cantidad m�xima de fichas que se pueden apilar en el tablero.
	 */
	public int contarFilas() {
		
		return tablero[0].length;
	}

	/**
	 * post : devuelve la cantidad m�xima de fichas que se pueden alinear en el tablero.
	 */
	public int contarColumnas() {
		
		return tablero.length;
	}

	/**
	 * pre : fila est� en el intervalo [1, contarFilas()],
	 * 		 columnas est� en el intervalo [1, contarColumnas()].
	 * post: indica qu� ocupa el casillero en la posici�n dada por fila y columna.
	 * 
	 * @param fila
	 * @param columna
	 */
	public Casillero obtenerCasillero(int fila, int columna) {
		
		int indiceFila = obtenerIndice(fila);
		int indiceColumna = obtenerIndice(columna);
		
		if(!esColumnaValida(indiceColumna) || !esFilaValida(indiceFila)) {
			
			throw new Error("El casillero est� fuera de los l�mites del Tablero.");
		}
		
		return tablero[indiceColumna][indiceFila];
	}
	
	/**
	 * pre : el juego no termin�, columna est� en el intervalo [1, contarColumnas()]
	 * 		 y a�n queda un Casillero.VACIO en la columna indicada. 
	 * post: deja caer una ficha en la columna indicada.
	 * 
	 * @param columna : n�mero de columna en que soltar la ficha.
	 */
	public void soltarFichaEnColumna(int columna) {
		
		int indiceColumna = obtenerIndice(columna);
		
		if (esColumnaValida(indiceColumna) && hayFilasVacias(indiceColumna) && !terminoElJuego) {
			
			int fila = obtenerFilaVacia(indiceColumna);
			
			tablero[indiceColumna][fila] = obtenerProximaFichaALanzar(obtenerQuienLanzoUltimo());
			
			posicionUltimaFichaLanzada.cambiarCoordenada(indiceColumna, fila);
			contadorDeVecesTiradas++;
		} 
	}
	
	/**
	 * post : indica si el juego termin� porque uno de los jugadores
	 * 		  gan� o no existen casilleros vac�os.
	 */
	public boolean termino() {
		
		terminoElJuego = hayGanador() || hayEmpate();
		
		return terminoElJuego;
	}

	private boolean hayEmpate() {
		
		int columna = 0;
		
		/**
		 * Recorrer columnas
		 */
		while ((columna < contarColumnas()) && (!hayFilasVacias(columna)) ) {
			
			columna++;
		}
		
		return columna == contarColumnas();
	}

	/**
	 * post : indica si el juego termin� y si tiene un ganador.
	 */
	public boolean hayGanador() {
		
		/**
		 * 'contadorDeVecesTiradas > 6' condici�n que evita que el juego analice la partida
		 *                              en b�squeda de un ganador con menos de 7 fichas tiradas.
		 */
		if (!hayGanador && contadorDeVecesTiradas > 6) {
			
			/**
			 * Se debe proteger el m�todo hay4EnLinea(..) ya que hayGanador(..) es
			 * llamado en dos oportunidades.
			 */
			hayGanador = buscadorDePatrones.hayCuatroEnLinea(posicionUltimaFichaLanzada, tablero);
		}

		return hayGanador;
	}

	public String obtenerNombreJugadorRojo() {
		
		return jugadorRojo;
	}
	
	public String obtenerNombreJugadorAmarillo() {
		
		return jugadorAmarillo;
	}
	
	/**
	 * pre : el juego termin�.
	 * post: devuelve el nombre del jugador que gan� el juego.
	 */
	public String obtenerGanador() {
		
		String jugadorGanador = null;
		
		if (hayGanador) {
			
			jugadorGanador = obtenerQuienLanzoUltimo();
		}
		
		return jugadorGanador;
	}
	
	/**
	 * post : devuelve si el n�mero de fila y columna es v�lido.
	 * 
	 * @param filas : cantidad de filas con las que se desea inicializar el tablero.
	 * @param columnas : cantidad de columnas con las que se desea inicializar el tablero.
	 */
	private boolean esFilaYColumnaMinimasParaCrearTablero(int fila, int columna) {
		
		return (fila >= 4) && (columna >= 4);
	}
	
	/**
	 * post: Devuelve el n�mero de fila vacia
	 */
	private int obtenerFilaVacia(int columna) {
		
		int ultimaFila = obtenerIndice(contarFilas());
		while (tablero[columna][ultimaFila] != Casillero.VACIO && ultimaFila > 0) {
			
			ultimaFila--;
		}
		
		return ultimaFila;
	}
	
	/**
	 * post: Devuelve si la hay filas vacias en la columna indicada.
	 * 
	 * @param columna: Columna a verificar
	 */
	private boolean hayFilasVacias(int columna) {
		
		return (tablero[columna][0] == Casillero.VACIO);
	}
	
	/**
	 * post: Devuelve si la columna indicada existe.
	 */
	private boolean esColumnaValida(int columna) {
		

		return columna >= 0 && columna < contarColumnas();
	}
	
	/**
	 * post: Devuelve si la fila indicada es v�lida
	 */
	private boolean esFilaValida(int fila) {
		
		return fila >= 0 && fila < contarFilas();
	}
	
	private int obtenerIndice(int posicion) {
		
		return posicion - 1;
	}
	
	private String obtenerQuienLanzoUltimo() {
		
		String jugadorLanzador = jugadorRojo;
		if(contadorDeVecesTiradas % 2 == 0) {
			
			jugadorLanzador = jugadorAmarillo;
		}
		
		return jugadorLanzador;
	}
	
	private Casillero obtenerProximaFichaALanzar(String ultimoJugadorEnLanzar) {
		
		Casillero ficha = Casillero.ROJO;
		
		if (ultimoJugadorEnLanzar == jugadorRojo) {
			
			ficha =  Casillero.AMARILLO;
		}
		
		return ficha;
	}
}