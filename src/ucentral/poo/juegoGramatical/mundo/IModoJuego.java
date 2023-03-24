package ucentral.poo.juegoGramatical.mundo;

import java.util.ArrayList;

/**  
 * Interface del modo juego para crear tipos de juego concretos.
 * @author lvargasc10
 * @version 1.0 
 * @since Nov 23 2019
 */

public interface IModoJuego {
	
	/**
	 * Metodo para verificar que las figuras esten contenidas en la frase.
	 * @param lista con las frases
	 * @return booleano falso o verdadero
	 */
	public boolean verificar(ArrayList<String> lista);

}
