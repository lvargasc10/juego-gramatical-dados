package ucentral.poo.juegoGramatical.mundo;

import java.util.ArrayList;

/**  
 * Representa el modo de juego facil de manera concreta.
 * @author lvargasc10
 * @version 1.0 
 * @since Nov 23 2019
 */

public class ModoFacil implements IModoJuego {
	
	//Atributos.
	
	/**
	 * Lista que contiene las frases ingresadas por el usuario.
	 */
	protected ArrayList<String> listaFrases;
	
	//Metodos
	/**
	 * Crea el modo facil concreto con la lista de frases ingresadas.
	 * @param listaFrases para crear el modo.
	 */
	public ModoFacil(ArrayList<String> listaFrases) {
	       this.listaFrases = listaFrases;		        
	   }
	
	/**
	 * Metodo para verificar que se contengan las figuras en la frase.
	 * @return Falso o Verdadero segun sea el caso.
	 */
	public boolean verificar(ArrayList<String> listaCaras) {		
		boolean resultado = false;		
		for(int i=0;i<listaCaras.size();i++) {
			if(listaFrases.contains(listaCaras.get(i))) {
				resultado=true;				
			}else {
				resultado=false;
			}		
		}
		return resultado;		
	}	
	
}
