package test;

import static org.junit.Assert.*;
import juego.CuatroEnLinea;

import org.junit.Test;

public class PruebasDimesionesCuatroEnLinea {
	
	private CuatroEnLinea juego;
	
	//TESTS DE FILAS MENOR A 4
	@Test (expected = Error.class)
	public void crearConMenos3FilasPor5ColumnasLanzaExcepcionPorqueFilasEsMenorA4() {
		juego = new CuatroEnLinea(-3, 5, "Adrián", "Ramiro");
	}
	
	@Test (expected = Error.class)
	public void crearConMenos10FilasPor8ColumnasLanzaExcepcionPorqueFilasEsMenorA4(){
		juego = new CuatroEnLinea(-10, 5, "Adrián", "Hernán");
	}
	//------------------------
	
	//TESTS DE COLUMNAS MENOR A 4
	@Test (expected = Error.class)
	public void crearCon5FilasPorMenos8ColumnasLanzaExcepcionPorqueColumnasEsMenorA4(){
		juego = new CuatroEnLinea(5, -8, "Ramiro", "Hernán");
	}
	
	@Test (expected = Error.class)
	public void crearCon6FilasPorMenos3ColumnasLanzaExcepcionPorqueColumnasEsMenorA4(){
		juego = new CuatroEnLinea(6, -3, "Ramiro", "Martín");
	}
	//---------------------------
	
	//TESTS DE FILAS Y COLUMNAS MENOR A 4
	@Test (expected = Error.class)
	public void crearConMenos7FilasPorMenos10ColumnasLanzaExcepcionPorqueColumnasYFilasSonMenoresA4(){
		juego = new CuatroEnLinea(-7, -10, "Leandro", "Roberto");
	}
	
	@Test (expected = Error.class)
	public void crearConMenos5FilasPorMenos5ColumnasLanzaExcepcionPorqueColumnasYFilasSonMenoresA4(){
		juego = new CuatroEnLinea(-5, -5, "Alberto", "Fabián");
	}
	
	@Test (expected = Error.class)
	public void crearConMenos4FilasPorMenos4ColumnasLanzaExcepcionPorqueColumnasYFilasSonMenoresA4(){
		juego = new CuatroEnLinea(-4, -4, "Agustín", "Francisco");
	}
	//-----------------------------------
	
	//TESTS ALTERNANDO EL VALOR -4 EN FILAS Y COLUMNAS 
	@Test (expected = Error.class)
	public void crearCon4FilasPorMenos4ColumnasLanzaExcepcionPorqueColumnasEsMenorA4(){
		juego = new CuatroEnLinea(4, -4, "Fernando", "Mariano");
	}
	
	@Test (expected = Error.class)
	public void crearConMenos4FilasPor4ColumnasLanzaExcepcionPorqueFilasEsMenorA4(){
		juego = new CuatroEnLinea(-4, 4, "Mariana", "Florencia");
	}
	//------------------------------------------------
	
	//TESTS USANDO EL VALOR CERO EN FILAS Y COLUMNAS
	@Test (expected = Error.class)
	public void crearCon0FilasY4ColumasLanzaExcepcionPorqueFilasEsMenorA4(){
		juego = new CuatroEnLinea(0, 4, "Julián", "Gabriela");
	}
	
	@Test (expected = Error.class)
	public void crearCon4FilasY0ColumnasLanzaExcepcionPorqueColumnasEsMenorA4(){
		juego = new CuatroEnLinea(4, 0, "Gabriel", "Rosa");
	}
	
	//----------------------------------------------
}
