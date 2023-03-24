package ucentral.poo.juegoGramatical.mundo;

import java.util.Random;

/**
 * Representa el dado que se usara en el jeugo gramatical.
 * @author lvargasc10
 * @version 1.0 
 * @since Nov 23 2019
 */

public abstract class Dado {
	
	//Atributos.	
	
	/**
	 * El nombre identificador del dado creado.
	 */
	private String nombreDado;
	
	/**
	 * Lista de palabras de las figuras que contienen las caras del dado.
	 */
	private String[] listaFiguras;
	
	//Metodos.
	
	/**
	 * Metodo para crear el dado.
	 */
	public Dado() {	
		
	}
	
	/**
	 * Crea un dado con las caracteristicas indicadas por los parametros.
	 * @param nombreDado identificador del dado.	 
	 * @param listaFiguras lista de palabras asignadas al dado.
	 */
	public Dado(String nombreDado,String[] listaFiguras) {
		this.nombreDado = nombreDado;		
		this.listaFiguras = listaFiguras;		
	}
	
	/**
	 * Devuelve el nombre con el que se identifica el dado.
	 * <b>pre: </b> Existe un dado con un nombre <br>
	 * <b>pos: </b> Nombre mostrado	
	 * @return el nombre del dado.
	 */
	public String darNombreDado() {
		return this.nombreDado;
	}	
	
	/**
	 * Devuelve la lista de palabras que contienen las caras del dado.<br>
	 * <b>pre: </b> La lista contiene figuras <br>
	 * <b>pos: </b> Figuras mostradas	 	 
	 * @return la lista de palabras referentes a figuras.
	 */
	public String[] darListaFiguras() {
		return this.listaFiguras;
	}
	
	/**
	 * Metodo que genera al azar una palabra del arreglo de figuras.
	 * <b>pre: </b> Existe un dado <br>
	 * <b>pos: </b> Dado lanzado	
	 * @param listaFiguras la lista de figuras que contiene el dado.
	 * @return la figura seleccionada por el random.
	 */	
	public String lanzarDado(String[] listaFiguras) {
		//Creo una variable de la clase random para generar un indice al azar.
		Random aleatorio = new Random();
		int longitud = listaFiguras.length;
		int random = aleatorio.nextInt(longitud);
		//Creo la variable figura, que sera la palabra escogida por el random.
		//Con el random se devuelve un aleatorio de tipo int entre 0 y la longitud de la lista.(Un indice aleatorio).	    
	    return listaFiguras[random];
	}
}
