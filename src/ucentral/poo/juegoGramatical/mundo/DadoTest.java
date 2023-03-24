package ucentral.poo.juegoGramatical.mundo;

import junit.framework.TestCase;

/**  
 * Se utiliza para realizar pruebas en posibles escenarios.
 * @author lvargasc10
 * @version 1.0 
 * @since Nov 23 2019
 */

public class DadoTest extends TestCase {
	
	//Atributos
	
	/**
	 * Dado para realizar las pruebas.	
	 */
	private DadoFiguras dadoUno;
	
	//Metodos
	
	/**
	 * Se crea un dado para el escenario 1 por defecto.	
	 */
	public void setupEscenario_1() {
		this.dadoUno = new DadoFiguras();
	}
	
	/**
	 * Se crea un dado para el escenario 2 pero estableciendole parametros.
	 */
	public void setupEscenario_2() {
		String[] listaFiguras = new String[2];
		String nombre = "DadoPrueba";
		listaFiguras[0]="A";
		listaFiguras[1]="B";
		this.dadoUno = new DadoFiguras(nombre,listaFiguras);		
	}
	
	/**
	 * Metodo para probar la funcion que retorna el nombre del dado.	
	 */
	public void testDarNombre() {
		this.setupEscenario_2();
		assertEquals("El nombre no corresponde","DadoPrueba",this.dadoUno.darNombreDado());
	}
	
	/**
	 * Metodo para probar la funciones de acceso a las figuras que contiene el dado.
	 */
	public void testDarFiguras() {
		this.setupEscenario_2();	
		String[] listaFiguras = this.dadoUno.darListaFiguras();
		assertEquals("El alto no corresponde","A",listaFiguras[0]);
		assertEquals("El ancho no corresponde","B",listaFiguras[1]);		
	}	
}


