package ucentral.poo.juegoGramatical.mundo;


/**  
 * Excepcion personalizada para cuando no exista un dado.
 * @author lvargasc10
 * @version 1.0 
 * @since Nov 23 2019
 */

public class DadoNoExisteException extends Exception {
	
	//Metodos
	// := Constructores
	
	/**
	 * Crea una excepcion con un mensaje por defecto
	 */
	public DadoNoExisteException () {
		super("¡No se ha creado ningun dado!");
	}
	
	/**
	 * Crea una excepcion con un mensaje por parametro
	 * @param mensaje el mensaje de la excepcion
	 */
	public DadoNoExisteException (String mensaje) {
		super(mensaje);
	}
	
}
