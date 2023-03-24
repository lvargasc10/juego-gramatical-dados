package ucentral.poo.juegoGramatical.mundo;

import java.util.Arrays;

/**  
 * Representa un dado que contiene figuras en sus caras.
 * @author lvargasc10
 * @version 1.0 
 * @since Nov 23 2019
 */

public class DadoFiguras extends Dado {
	
	//Metodos

	/**
	 * Metodo para crear el dado con figuras.
	 */
	public DadoFiguras() {
		super();
	}
	
	/**
	 * Crea un dado cde figuras con las caracteristicas indicadas por los parametros.
	 * @param nombreDado identificador del dado.	 
	 * @param listaFiguras lista de palabras asignadas al dado.
	 */
	public DadoFiguras(String nombreDado,String[] listaFiguras) {
		super(nombreDado, listaFiguras);		
	}
	
	/**
	 * Devuelve la lista de figuras que contienen las caras del dado.<br>
	 * <b>pre: </b> La lista contiene figuras <br>
	 * <b>pos: </b> Figuras mostradas	 	 
	 * @return la lista de palabras referentes a figuras.
	 */
	public String mostrarFiguras(){
		//Clase Arrays con metodos para manipular mejor los arreglos.
		//Metodo toString para mostrar el contenido de dicho arreglo.
        return Arrays.toString(this.darListaFiguras());
    } 
}
