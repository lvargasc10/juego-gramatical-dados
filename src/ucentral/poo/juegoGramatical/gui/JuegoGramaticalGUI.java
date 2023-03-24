package ucentral.poo.juegoGramatical.gui;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import ucentral.poo.juegoGramatical.mundo.DadoNoExisteException;
import ucentral.poo.juegoGramatical.mundo.IModoJuego;
import ucentral.poo.juegoGramatical.mundo.JuegoGramatical;
import ucentral.poo.juegoGramatical.mundo.ModoDificil;
import ucentral.poo.juegoGramatical.mundo.ModoFacil;

/**
 * Clase principal para la interfaz de usuario o GUI.
 * @author lvargasc10
 * @version 1.0 
 * @since Nov 23 2019
 */

public class JuegoGramaticalGUI extends JFrame {
	
	// ATRIBUTOS	
	
	/**
	 * Panel que muestra la imagen
	 */
	JuegoGramatical miJuegoGramatical = new JuegoGramatical();
	
	/**
	 * Muestra la imagen en el Panel.
	 */	
	private PanelDado pnlDado;
	
	/**
	 * Panel con los elementos de interaccion con el juego gramatical.
	 */	
	private PanelInteraccion pnlInteraccion;
	
	/**
	 * Barra de menu de la aplicacion.	
	 */
	private JuegoGramaticalMenu menuEditor;
	
	//METODOS
	//:= constructores
	
	/**
	 * Crea una Ventana del editor de Imagen segun el valor de los parametros 
	 * @param alto del juego gramatical
	 * @param ancho del juego gramatical
	 * @param titulo del juego gramatical
	 */	
	public JuegoGramaticalGUI(int alto, int ancho, String titulo) {
		super(titulo);		
		this.miJuegoGramatical = new JuegoGramatical();
		this.inicializarGUI(alto,ancho,titulo);
		BorderLayout borde = new BorderLayout();
	}	
	
	/**
	 * Inicializa los elementos de la GUI
	 * @param alto de la GUI
	 * @param ancho de la GUI
	 * @param titulo de la GUI
	 */
	private void inicializarGUI(int alto, int ancho,String titulo) {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		BorderLayout borde = new BorderLayout();	
				
		this.setLayout(borde);
				
		try {
			Properties misPropiedades = new Properties();
			FileInputStream in = new FileInputStream("./data/propiedades/juegoGramaticalGUI.properties");
			misPropiedades.load(in);
					
			String elTitulo = misPropiedades.getProperty("juegoGramatical.titulo");
			this.setTitle(elTitulo);
			
			String strAlto = misPropiedades.getProperty("juegoGramatical.alto");
			String strAncho = misPropiedades.getProperty("juegoGramatical.ancho");
			int elAlto = Integer.parseInt(strAlto.trim());
			int elAncho = Integer.parseInt(strAncho.trim());
					
			this.setSize(elAlto,elAncho);
					
					
		}catch(FileNotFoundException fnfe) {
			this.setSize(ancho, alto);
			this.setTitle(titulo);
			fnfe.printStackTrace();			
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}
				
		//creacion de elementos 
		this.pnlDado = new PanelDado();
		this.pnlInteraccion = new PanelInteraccion(this);
				
								
		//Agregar elementos.
		this.add(this.pnlInteraccion,BorderLayout.SOUTH);
		this.add(this.pnlDado,BorderLayout.NORTH);
				
		this.menuEditor = new JuegoGramaticalMenu(this);
		this.setJMenuBar(this.menuEditor);	
		}
	
	
	/**
	 * Metodo para la creacion del dado o dados.
	 */
	public void crearDado() {						
		//Dentro del try coloco el codigo del cual si se genera el error este lo capturara.
		try {
			//Se crean los dados segun la cantidad indicada.
			int numeroDados = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de dados"));
			
			for (int i = 0  ; i < numeroDados; i ++){
				JOptionPane.showMessageDialog(this,"Ingrese los datos del dado numero "+(i+1));				
				
				String nombreDado = JOptionPane.showInputDialog("\nIngrese el nombre del Dado "+(i+1)+":" );
				int cantidadCaras = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de caras del dado "+nombreDado));	
				
				JOptionPane.showMessageDialog(null,"Ingrese los datos del dado numero "+(i+1));				
				JOptionPane.showMessageDialog(null,"Ingrese las figuras, una por una [Presione ACEPTAR]");
				
				String[] listaFiguras = new String[cantidadCaras];					
			
				for(int j = 0  ; j < cantidadCaras; j ++){					
					listaFiguras[j]=JOptionPane.showInputDialog("Ingrese la figura numero "+(j+1));		
				}																						
			//Invoco el metodo genera dado de la instancia de tipo JuegoGramatical.
			this.miJuegoGramatical.generarDado(nombreDado,listaFiguras);		
			//Se agrega cada Dado creado a la lista de dados.		
			this.miJuegoGramatical.listaDados.add(miJuegoGramatical.darDado());
			JOptionPane.showMessageDialog(this,"Cantidad de dados actual: "+miJuegoGramatical.listaDados.size());
				}
			//Con el catch decidimos que hacer en caso de que se genere un error en el bloque del try.	
			}
		catch(Exception e) {JOptionPane.showMessageDialog(null,"El valor ingresado no es un numero. Intente de nuevo.");
		}
	}
	
	/**
	 * guarda los dados creados en un archivo de texto
	 */
	public void guardarDados() {
		
		//seleccionar el archivo
		JFileChooser selector = new JFileChooser();
		int valorRetorno = selector.showSaveDialog(this);
		if(valorRetorno == JFileChooser.APPROVE_OPTION) {
			File archivoDados = selector.getSelectedFile();
			//guardar en el archivo
			try {
				this.miJuegoGramatical.guardarDados(archivoDados);
			}catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(this, "Archivo no encontrado","guardar dados",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();	
			}catch(Exception e) {
				JOptionPane.showMessageDialog(this, e.getMessage(),"guardar dados",JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}		
	}
	
	/**
	 * Carga los carga un archivo con dados guardados.
	 */
	public void cargarDados() {
		
		//Mostrar el dialogo de seleccion del archivo.		
		JFileChooser selector = new JFileChooser();
		int valorRetorno = selector.showOpenDialog(this);
		if(valorRetorno == JFileChooser.APPROVE_OPTION) {
			File archivoDados = selector.getSelectedFile();
			try {
				//Cargue los dados.
				this.miJuegoGramatical.cargarDadosDesdeArchivo(archivoDados);				
				
			}catch(DadoNoExisteException exp) {
				JOptionPane.showMessageDialog(this, exp.getMessage(),"Cargar Dados",JOptionPane.ERROR_MESSAGE);
			
			}catch(FileNotFoundException exp) {
				JOptionPane.showMessageDialog(this, exp.getMessage(),"No se encuentra el archivo ",JOptionPane.ERROR_MESSAGE);			
			
			}catch(IOException exp) {
				JOptionPane.showMessageDialog(this, exp.getMessage(),"Cargar Dados",JOptionPane.ERROR_MESSAGE);
			}		
		}
	}
	
	/**
	 * Metodo para consultar el dado o los dados creados.
	 */	
	public void consultarDado() {
		
		if(miJuegoGramatical.listaDados == null)
			JOptionPane.showMessageDialog(null, "No han sido creado dados.");
		
		JOptionPane.showMessageDialog(this,"Consultando dados...");				
		//Si ya se han creado dados entonces mostrara la informacion de cada uno de ellos.
		
		//Se recorre el arreglo.
		for(int i = 0  ; i < miJuegoGramatical.listaDados.size(); i ++){
			//Se imprimen los atributos de cada dado, usando la funcion correspondiente a su visibilidad.
			JOptionPane.showMessageDialog(this,"\nNombre del Dado: "+miJuegoGramatical.listaDados.get(i).darNombreDado()
								+"\nNumero de caras: "+miJuegoGramatical.listaDados.get(i).darListaFiguras().length
								+"\nFiguras: "+( miJuegoGramatical.listaDados.get(i)).mostrarFiguras());			
		}
	}	
	
	/**
	 * Metodo para lanzar los dados.
	 */
	public void lanzarDado() {	
		if(miJuegoGramatical.listaDados == null)
			JOptionPane.showMessageDialog(null, "No han sido creado dados.");
		
		//Si ya se han creado dados, entonces se invocara el metodo lanzar dado.		
		miJuegoGramatical.figurasObtenidas.clear();
		ImageIcon dadoImagen = new ImageIcon("./data/gifDado.gif");
		JOptionPane.showMessageDialog(this,"","Espere... ¡Lanzando Dados!", JOptionPane.INFORMATION_MESSAGE, dadoImagen);
			
		for(int i = 0  ; i < miJuegoGramatical.listaDados.size(); i ++){	
			miJuegoGramatical.figurasObtenidas.add(miJuegoGramatical.darDado().lanzarDado(miJuegoGramatical.listaDados.get(i).darListaFiguras()));
			JOptionPane.showMessageDialog(this,"\n"+"Dado "+miJuegoGramatical.listaDados.get(i).darNombreDado()+ " lanzado, su resultados es: "+
									"\n"+miJuegoGramatical.figurasObtenidas.get(i));							
		}	
	}
	
	/**
	 * Metodo para salir de la aplicacion por medio del menu Archivo.
	 */
	public void salirAplicacion() {
		this.dispose();		
	}
	
	/**
	 * Metodo para mostrar a LA creadora del juego.
	 */
	public void mostrarCreditos() {
		ImageIcon logoEquipo = new ImageIcon("./data/DarkSide.png");
		JOptionPane.showMessageDialog(this,"","\nJuego Gramatical v1.0.0", JOptionPane.INFORMATION_MESSAGE, logoEquipo);
	}
	
	/**
	 * Metodo para escoger el nivel del juego por medio de la barra de menu.
	 */
	public void nivelDeJuego() {
		int seleccion = JOptionPane.showOptionDialog(this,"Seleccione un nivel", "Niveles del juego gramatical",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,    // null para icono por defecto.
				   new Object[] { "Facil", "Dificil"},   // null para YES, NO y CANCEL
				   "opcion 1");		
			if (JOptionPane.YES_NO_OPTION == seleccion) {
				nivelFacil();	
			}else {				
				nivelDificil();				
				}
			
			}
		
	/**
	 * Metodo para jugar en modo facil.	
	 */
	public void nivelFacil() {
		if(miJuegoGramatical.figurasObtenidas == null)
			JOptionPane.showMessageDialog(null, "No ha lanzado los dados.");
		
		miJuegoGramatical.modo("Facil");
		JOptionPane.showMessageDialog(this,"Nivel: "+ miJuegoGramatical.darModo()+" seleccionado.");				
		for(int i = 0  ; i < miJuegoGramatical.figurasObtenidas.size(); i ++){
			String frase = JOptionPane.showInputDialog(this,"Ingrese la frase numero "+(i+1)+" con la figura: "+"\n"+miJuegoGramatical.figurasObtenidas.get(i));
			miJuegoGramatical.frases.add(frase);
		
		IModoJuego facil = new ModoFacil(miJuegoGramatical.frases);
		JOptionPane.showMessageDialog(this,"Las frases ingresadas fueron: "+miJuegoGramatical.frases);
		if (facil.verificar(miJuegoGramatical.figurasObtenidas) != true) {								
			JOptionPane.showMessageDialog(this,"¡PERDIÓ! Intente de nuevo.");					
			JOptionPane.showMessageDialog(this,"La palabra/as "+miJuegoGramatical.figurasObtenidas.get(i)+" no se encuentra en la frase o esta mal escrita.");	
			miJuegoGramatical.frases.clear();
			}				
			else{
				JOptionPane.showMessageDialog(this,"¡Ganó! Su frase esta bien escrita.GG IZI WP");						
				miJuegoGramatical.frases.clear();
			}	
		}		
	}
	
	/**
	 * Metodo para jugar en modo dificil.
	 */
	public void nivelDificil() {
		if(miJuegoGramatical.figurasObtenidas == null)
			JOptionPane.showMessageDialog(null, "No ha lanzado los dados.");
		
		miJuegoGramatical.modo("Dificil");
		JOptionPane.showMessageDialog(this,"Nivel: "+ miJuegoGramatical.darModo()+" seleccionado.");			   
		String frase =JOptionPane.showInputDialog(this,"Ingrese la frase con las figuras: "+"\n"+miJuegoGramatical.figurasObtenidas);
		IModoJuego dificil = new ModoDificil(frase);
		JOptionPane.showMessageDialog(this,"La frase ingresada fue: "+frase);
		if (dificil.verificar(miJuegoGramatical.figurasObtenidas) != true) {
			JOptionPane.showMessageDialog(this,"¡PERDIÓ! Intente de nuevo.");					
		    JOptionPane.showMessageDialog(this,"La palabra/as "+miJuegoGramatical.figurasObtenidas+" no se encuentran en la frase o esta mal escrita.");									
			 }				
			 else{
				 JOptionPane.showMessageDialog(this,"¡Ganó! Su frase esta bien escrita. GG IZI WP");						
			}
		}		
	
	/**
	 * Se inicializa la ventana con sus respectivas medidas.
	 * @param args que ingresan
	 */
	public static void main(String[] args) {		
		JuegoGramaticalGUI ventanaEditor = new JuegoGramaticalGUI(0,0,"");//Las propiedades por defecto se cargan desde el archivo de texto.
		ventanaEditor.setVisible(true);
	}
}

