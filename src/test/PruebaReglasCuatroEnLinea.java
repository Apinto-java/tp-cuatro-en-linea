package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import juego.CuatroEnLinea;

public class PruebaReglasCuatroEnLinea {

	private CuatroEnLinea juego;
	
	/**
	 * Se modifica el nombre anterior del método, que era "noGananLasRojasConFila6Desde1Hasta4PorqueBloqueronLasAmarillas"
	 * agregándole "Columna"
	 */
	@Test
	public void noGananLasRojasConFila6DesdeColumna1HastaColumna4PorqueBloqueronLasAmarillas() {
		
		juego = new CuatroEnLinea(6, 5, "Fabi", "Lucas");
		juego.soltarFichaEnColumna(1);
		juego.soltarFichaEnColumna(1);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(3);
		juego.soltarFichaEnColumna(4);

		juego.soltarFichaEnColumna(4);

		asertarQueNoHayGanadorAun();
	}
	/**
	 * Se modifica el nombre anterior del método, que era "gananRojasConFila6Desde1Hasta4"
	 * agregándole la palabra "Columna"
	 */
	@Test
	public void gananRojasConFila6DesdeColumna1HastaColumna4() {
		
		juego = new CuatroEnLinea(6, 5, "Fabi", "Lucas");
		juego.soltarFichaEnColumna(1);
		juego.soltarFichaEnColumna(1);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(3);
		juego.soltarFichaEnColumna(3);

		juego.soltarFichaEnColumna(4);

		asertarQueElGanadorEs("Fabi");
	}
	
	/**
	 * Se modifica nombre anterior del método que era "gananAmarillasConFila5Desde2Hasta3"
	 * agregándole "Columna" y modificando 2 por 5 y 3 por 2
	 */
	@Test
	public void gananAmarillasConFila5DesdeColumna5HastaColumna2() {
		
		juego = new CuatroEnLinea(6, 5, "Fabi", "Lucas");
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(3);
		juego.soltarFichaEnColumna(3);
		juego.soltarFichaEnColumna(4);
		juego.soltarFichaEnColumna(4);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(5);
		juego.soltarFichaEnColumna(2);
		
		juego.soltarFichaEnColumna(5);

		asertarQueElGanadorEs("Lucas");
	}
	//Pasó doble verificación
	@Test
	public void noGananLasRojasConColumna5PorqueBloqueronLasAmarillas() {
		
		juego = new CuatroEnLinea(6, 10, "Leo", "Lucas");
		juego.soltarFichaEnColumna(5);
		juego.soltarFichaEnColumna(7);
		juego.soltarFichaEnColumna(5);
		juego.soltarFichaEnColumna(7);
		juego.soltarFichaEnColumna(5);
		juego.soltarFichaEnColumna(5);

		juego.soltarFichaEnColumna(5);

		asertarQueNoHayGanadorAun();
	}
	/**
	 * Se modifica nombre del método que anteriormente era "gananRojasConColumna3Desde1Hasta4"
	 * agregándole "Fila" y modificando 1 por 7
	 */
	@Test
	public void gananRojasConColumna3DesdeFila7HastaFila4() {
		
		juego = new CuatroEnLinea(7, 9, "Agus", "Fabi");
		juego.soltarFichaEnColumna(3);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(3);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(3);
		juego.soltarFichaEnColumna(2);

		juego.soltarFichaEnColumna(3);

		asertarQueElGanadorEs("Agus");
	}
	
	/**
	 * Se modifica nombre del método que anteriormente era "gananAmarillasConColumna2Desde2Hasta5"
	 * agregándole "Fila" y modificando 2 por 7 y 5 por 4. 
	 */
	@Test
	public void gananAmarillasConColumna2DesdeFila7HastaFila4() {
		
		juego = new CuatroEnLinea(7, 9, "Vero", "Fabi");
		juego.soltarFichaEnColumna(3);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(4);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(5);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(3);

		juego.soltarFichaEnColumna(2);

		asertarQueElGanadorEs("Fabi");
	}
	
	/**
	 * Se cambia el nombre del método que anteriormente era "gananRojasConDiagonalDesdeFila1HastaFila4"
	 * agregándole el número de columna y cambiando número de fila 1 por 4 y 4 por 1.
	 */
	@Test
	public void gananRojasConDiagonalDesdeColumna1Fila4HastaColumna4Fila1() {
		
		juego = new CuatroEnLinea(5, 5, "Gabi", "Lucas");
		juego.soltarFichaEnColumna(1);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(3);
		juego.soltarFichaEnColumna(4);
		juego.soltarFichaEnColumna(5);
		juego.soltarFichaEnColumna(1);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(3);
		juego.soltarFichaEnColumna(4);
		juego.soltarFichaEnColumna(5);
		
		juego.soltarFichaEnColumna(3);
		juego.soltarFichaEnColumna(4);

		juego.soltarFichaEnColumna(4);

		asertarQueElGanadorEs("Gabi");
	}
	
	/**
	 * Se modifica nombre del método que anteriormente era "aunNoGananRojasConDiagonalDesdeFila4HastaFila2"
	 * cambiando 4 por 5 y 2 por 3. Se agrega también el número de columna para mantener
	 * la consistencia con los métodos que siguen
	 */
	@Test
	public void aunNoGananRojasConDiagonalDesdeColumna5Fila5HastaColumna3Fila3() {
		
		juego = new CuatroEnLinea(5, 5, "Fer", "Nico");
		juego.soltarFichaEnColumna(1);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(3);
		juego.soltarFichaEnColumna(4);
		juego.soltarFichaEnColumna(5);
		juego.soltarFichaEnColumna(5);
		juego.soltarFichaEnColumna(4);
		juego.soltarFichaEnColumna(3);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(1);
		juego.soltarFichaEnColumna(3);

		juego.soltarFichaEnColumna(2);

		asertarQueNoHayGanadorAun();
	}
	
	/**
	 * Se modifica nombre del método que anteriormente era "gananRojasConDiagonalDesdeFila4HastaFila1"
	 * cambiando 4 por 5 y 1 por 2. Se agrega también la columna para mantener la consistencia
	 * con los métodos que siguen
	 */ 
	@Test
	public void gananRojasConDiagonalDesdeColumna5Fila5HastaColumna2Fila2() {
		
		juego = new CuatroEnLinea(5, 5, "Fer", "Nico");
		juego.soltarFichaEnColumna(1);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(3);
		juego.soltarFichaEnColumna(4);
		juego.soltarFichaEnColumna(5);
		juego.soltarFichaEnColumna(5);
		juego.soltarFichaEnColumna(4);
		juego.soltarFichaEnColumna(3);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(1);
		juego.soltarFichaEnColumna(3);
		juego.soltarFichaEnColumna(2);

		juego.soltarFichaEnColumna(2);

		asertarQueElGanadorEs("Fer");
	}
	
	//Pasó doble verificación
	@Test
	public void gananRojasConDiagonalDesdeColumna6Fila6HastaColumna3Fila3() {
		
		juego = new CuatroEnLinea(7, 7, "Jime", "Nico");
		fueronSoltadasFichasEnColumnas(2,4,5,3,5,6,6,3,3,4,5,4,2,2,3,5,4,5,6,6,5,4);

		juego.soltarFichaEnColumna(3);
		
		asertarQueElGanadorEs("Jime");
	}
	
	//Pasó doble verificación
	@Test
	public void gananRojasConDiagonalDesdeColumna4Fila7HastaColumna7Fila4() {
		
		juego = new CuatroEnLinea(7, 9, "Marce", "Nati");
		fueronSoltadasFichasEnColumnas(3,7,4,5,2,1,5,4,3,4,2,6,8,6,3,3,2,2,4,5,6,7,8,7);

		juego.soltarFichaEnColumna(7);
		
		asertarQueElGanadorEs("Marce");
	}
	//Pasó doble verificación
	@Test
	public void empatanEnTableroDe5Por6() {
		
		juego = new CuatroEnLinea(5, 6, "Jime", "Nico");
		fueronSoltadasFichasEnColumnas(1,2,3,4,5,6, 6,5,4,3,2,1, 6,5,4,3,2,1, 1,2,3,4,5,6, 1,2,3,4,5);
		
		juego.soltarFichaEnColumna(6);
		
		asertarQueEmpataron();
	}
	//Pasó doble verificación
	@Test
	public void empatanEnTableroDe4Por4() {
		
		juego = new CuatroEnLinea(4, 4, "Nati", "Fabi");
		fueronSoltadasFichasEnColumnas(1,2,3,4, 4,3,2,1, 4,3,2,1, 4,3,2);
		
		juego.soltarFichaEnColumna(1);
		
		asertarQueEmpataron();
	}
	
	private void asertarQueEmpataron() {
		
		assertTrue("terminó", juego.termino());
		assertFalse("no hay ganador", juego.hayGanador());
		assertNull("ganador", juego.obtenerGanador());
	}
	
	private void asertarQueElGanadorEs(String ganadorEsperado) {
		
		assertTrue("terminó", juego.termino());
		assertTrue("hay ganador", juego.hayGanador());
		assertEquals("ganador", ganadorEsperado, juego.obtenerGanador());
	}
	
	private void asertarQueNoHayGanadorAun() {
		
		assertFalse("terminó", juego.termino());
		assertFalse("no hay ganador", juego.hayGanador());
		assertNull("ganador", juego.obtenerGanador());
	}
	
    private void fueronSoltadasFichasEnColumnas(int... columnas) {

    	for (int columna : columnas) {
    		juego.soltarFichaEnColumna(columna);
    	}
    }

}
