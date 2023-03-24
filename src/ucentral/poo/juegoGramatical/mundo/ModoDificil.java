package ucentral.poo.juegoGramatical.mundo;

import java.util.ArrayList;

/**  
 * Representa el modo de juego dificil de manera concreta.
 * @author lvargasc10
 * @version 1.0 
 * @since Nov 23 2019
 */

public class ModoDificil implements IModoJuego {
	
	//Atributos
	
	/**
	 * Frase ingresada por el usuario para ser evaluada.
	 */
	protected String frase;
	
	//Metodos
	
	/**
	 * Se crea el modo de juego dificil ingresando la frase como parametro.
	 * @param frase ingresada por el usuario
	 */
	public ModoDificil(String frase) {
	       this.frase = frase;		        
	   }
	
	/**
	 * Metodo que verifica que la frase contenta la figura.
	 * @return Falso o Verdadero segun sea el caso.
	 */
	public boolean verificar(ArrayList<String> listaCaras) {
		boolean resultado = false;
		for(int i=0;i<listaCaras.size();i++) {
			if(this.frase.contains(listaCaras.get(i))) {
				resultado=true;				
			}else {
				resultado=false;
			}
		}
		return resultado;		
	}
	
}
