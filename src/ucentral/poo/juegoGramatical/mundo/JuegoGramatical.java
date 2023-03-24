package ucentral.poo.juegoGramatical.mundo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/** 
  Juego gramatical: Permite crear un dado de imagenes,muestra dichas imagenes, lanza el dado y muestra un resultado al azar.
 * @author lvargasc10
 * @version 1.0
 * @since Nov 23 2019
 */

public class JuegoGramatical {	
	
	//Atributos.
	
	/**
	 * El dado a lanzar.
	 */
	private DadoFiguras dado;
	
	/**
	 * Tipo de juego seleccionado, sea dificil o facil.
	 */
	private String modo;
	
	/**
	 * Modo de juego Interface
	 */
	private IModoJuego modoJuego;
	
	//Metodos
	//Constructores	
	
	
	/**
	 * Arreglo que contiene los dados de figuras creados, de una vez inicializado.
	 */
	public ArrayList<DadoFiguras> listaDados = new ArrayList<DadoFiguras>();
	
	/**
	 * Arreglo que contiene los resultados de haber lanzado los dados, de una vez inicializado.
	 */
	public ArrayList<String> figurasObtenidas = new ArrayList<String>();
	
	/**
	 * Arreglo que contiene las frases ingresadas por el usuario, de una vez inicializado.
	 */
	public ArrayList<String> frases = new ArrayList<String>();	
	
	
	/**
	 * Metodo para mostrar el modo de juego como String
	 * @return el modo de juego.
	 */
	public String darModo() {
		return this.modo;
	}
	
	/**
	 * Retorna el modo de juego
	 * @param modo de juego
	 */
	public void modo(String modo) {
        this.modo = modo;
    }		
	
	/**
	 * Se inicializa el arreglo que contendra dados.
	 * @param dado creado
	 */
	public void generarDados(DadoFiguras dado) {
		this.listaDados = new ArrayList<DadoFiguras>();
	}
	
	/**
	 * Metodo para mostrar la lista con los dados.
	 * @return lista con los dados creados
	 */
	public ArrayList<DadoFiguras> darDados(){
		return this.listaDados;
	}
	
	/**
	 * Retorna el dado del juego gramatical.
	 * @return el dado.
	 */
	public DadoFiguras darDado() {
		return this.dado;		
	}	
	
	/**
	 * Crear un dado indicando su contenido.
	 * @param nombreDado identificador del dado.	 
	 * @param listaFiguras la lista con las palabras que contienen las caras del dado.
	 */
	public void generarDado(String nombreDado,String[]listaFiguras) {
		this.dado = new DadoFiguras (nombreDado,listaFiguras);
	}
	
	/**
	 * Metodo para guardar los dados creados en un archivo de texto
	 * @param archivo que contrendra los dados
	 * @throws FileNotFoundException si no se encuentra el archivo
	 * @throws Exception en caso de un error inesperado
	 */
	public void guardarDados(File archivo) throws FileNotFoundException,Exception {
		if(this.listaDados.isEmpty()) {
			throw new Exception("¡No hay dados en el arreglo!");
		}
		else {
			PrintWriter escritor = new PrintWriter(archivo);
			for(int i=0;i<this.listaDados.size();i++){
				DadoFiguras dado = this.listaDados.get(i);
				String nombreFiltro = dado.darNombreDado();
				String separador = ":";
				String figuras = dado.mostrarFiguras();								
				escritor.println(nombreFiltro+separador+figuras);
			}
			escritor.close();
		}
	}
	
	/**
	 * Metodo para cargar los dados que se encuentran en el archivo.
	 * @param archivo que contiene los dados
	 * @throws DadoNoExisteException no existe un dado
	 * @throws IOException error de entrada
	 * @throws FileNotFoundException si no se encuentra el archivo
	 */
	public void cargarDadosDesdeArchivo( File archivo )	throws DadoNoExisteException, IOException, FileNotFoundException {	
		
		FileReader lectorArchivo = new FileReader(archivo);
		BufferedReader lector = new BufferedReader(lectorArchivo);		
		String linea = lector.readLine();
		
		while (linea != null) {			
			
			String[] valoresDado = linea.split(":");	
			//nombre dado primera posicion
 			String nombreDado = valoresDado[0];			
			//Longitud String segunda posicion
			int cantidadCaras = valoresDado[1].length();
			//cadena segunda posicion
			String cadena = valoresDado[1];	
			//Elimino los corchetes cuadrados de la cadena, inicio y final.(El string entre 0 y la longitud de la cadena menos 1).
			cadena = cadena.substring(1,cantidadCaras-1);
			String[] listaFiguras = cadena.split(",");	
																									
		//Invoco el metodo genera dado de la instancia de tipo JuegoGramatical.
		this.generarDado(nombreDado,listaFiguras);		
		//Se agrega cada Dado creado a la lista de dados.		
		this.listaDados.add(dado);
		linea = lector.readLine();		
		}	
		JOptionPane.showMessageDialog(null, "¡Dados cargados con exito!");
		lector.close();
	}
}
	
	



