package ucentral.poo.juegoGramatical.mundo;

import java.util.ArrayList;
import junit.framework.TestCase;

/**
 * Se ultiliza para realizar pruebas a metodos en posibles escenarios del juego gramatical.
 * @author lvargasc10
 * @version 1.0 
 * @since Nov 23 2019
 */

public class JuegoGramaticalTest extends TestCase {
	
	//Atributos
	
	/**
	 * Juego gramatical para probar los escenarios.
	 */
	private JuegoGramatical juegoGramaticalUno;
	
	
	//Metodos
	//Escenarios
	
	/**
	 * Se crea un juego gramatical por defecto para el escenario 1.
	 */
	public void setupEscenario_1() {
		this.juegoGramaticalUno = new JuegoGramatical();
	}
	
	/**
	 * Se crea un juego gramatical para el escenario 2 con parametros establecidos.	
	 */
	public void setupEscenario_2() {		
		String[] figuras = {"A","B"};
		this.juegoGramaticalUno = new JuegoGramatical();
		this.juegoGramaticalUno.generarDado("DadoUno",figuras);
	}
	
	//Metodos de prueba
	
	/**
	 * Metodo para probar la funcion de mostrar los dados creados.	
	 */
	public void testDarDados() {
		this.setupEscenario_1();		
		ArrayList<DadoFiguras> dados = this.juegoGramaticalUno.darDados();
		assertNotNull("No existe la lista de dados",dados);
		assertTrue("La lista de dados no esta vacía",dados.isEmpty());
		assertEquals("La lista de dados no esta vacia",0,dados.size());
	}
	
	/**
	 * Metodo para crear un dado por defecto y mostrarlo.	
	 */
	public void testCrearDadoPorDefecto() {
		this.setupEscenario_2();
		assertNotNull("No se creo el dado",this.juegoGramaticalUno.darDado());
	}
	
	/**
	 * Metodo para mostrar el tipo de juego que se eligio.
	 */
	public void testModoJuego_1(){
		this.setupEscenario_2();
		try {
			String modo = this.juegoGramaticalUno.darModo();
			assertNotNull("No existe la lista de dados",juegoGramaticalUno.darDados());
			assertTrue("La lista de dados no esta vacía",juegoGramaticalUno.darDados().isEmpty());
			assertEquals("La lista de dados no esta vacia",0,juegoGramaticalUno.darDados().size());
			
		}catch(Exception exp) {
			fail();
		}		
	}
	
}