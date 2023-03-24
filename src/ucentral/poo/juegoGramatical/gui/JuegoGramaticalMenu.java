package ucentral.poo.juegoGramatical.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import ucentral.poo.juegoGramatical.mundo.DadoFiguras;
import ucentral.poo.juegoGramatical.mundo.DadoNoExisteException;

/**
 * Clase para el manejo de las acciones sobre el menu de juego gramtical.
 * @author lvargasc10
 * @version 1.0 
 * @since Nov 23 2019
 */

public class JuegoGramaticalMenu extends JMenuBar implements ActionListener {	
			
	//ATRIBUTOS		
	
	/**
	 * Atributo juego gramatical
	 */
	private JuegoGramaticalGUI principal;
	
	/**
	 * Menus con los elementos de archivo del juego gramatical.
	 */
	private JMenu mnArchivo;
	
	/**
	 * Menu con los creditos del juego gramatical.
	 */	
	private JMenu mnAcercaDe;	
	
	/**
	 * Menu con las opciones para empezar a jugar.
	 */
	private JMenu mnJugar;	
	
	/**
	 * Opcion del menu para crear el dado.
	 */	
	private JMenuItem mnitCrearDado;
	
	/**
	 * Opcion del menu para consultar el dado.
	 */
	private JMenuItem mnitConsultarDado;
	
	/**
	 * Opcion del menu para lanzar el dado.
	 */
	private JMenuItem mnitLanzarDado;
	
	/**
	 * Opcion del menu para salir.
	 */
	private JMenuItem mnitSalir;
	
	/**
	 * Opcion del menu para los creditos.
	 */
	private JMenuItem mnitCreditos;
	
	/**
	 * Opcion del menu para escoger el nivel.	
	 */
	private JMenuItem mnitNivel;
	
	/**
	 * Opcion para guardar los dados del juego gramatical.	
	 */
	private JMenuItem mnitGuardarDados;
	
	/**
	 * Opcion para cargar los dados del juego gramatical.	
	 */
	private JMenuItem mnitCargarDados;	
	
	//METODOS
	//:= Constructores
	
	
	/**
	 * Se crea el menu del juego gramatical.
	 * @param ventana del juego gramatical
	 */
	public JuegoGramaticalMenu(JuegoGramaticalGUI ventana) {
		
		this.principal=ventana;		
		this.mnArchivo = new JMenu("Archivo");		
		this.mnAcercaDe = new JMenu("Acerca De...");
		this.mnJugar = new JMenu("Jugar");
		
		this.inicializarMenu ();	
		
		this.add(mnArchivo);
		this.add(mnJugar);
		this.add(mnAcercaDe);		
	}
	
	/**
	 * Funcion para inicializar los elementos del menu y anadirlos.
	 */
	private void inicializarMenu() {
		
		this.mnitCrearDado = new JMenuItem("Crear Dado");
		this.mnitCrearDado.addActionListener(this);
		this.mnitCrearDado.setActionCommand(DCMJuegoGramaticalGUI.ACCION_CREAR_DADO);
		
		this.mnitConsultarDado = new JMenuItem("Consultar Dado");
		this.mnitConsultarDado.addActionListener(this);
		this.mnitConsultarDado.setActionCommand(DCMJuegoGramaticalGUI.ACCION_CONSULTAR_DADO);
		
		this.mnitLanzarDado = new JMenuItem("Lanzar Dado");		
		this.mnitLanzarDado.addActionListener(this);
		this.mnitLanzarDado.setActionCommand(DCMJuegoGramaticalGUI.ACCION_LANZAR_DADO);
		
		
		this.mnitSalir = new JMenuItem("Salir");		
		this.mnitSalir.addActionListener(this);
		this.mnitSalir.setActionCommand(DCMJuegoGramaticalGUI.ACCION_SALIR);
		
		this.mnitGuardarDados = new JMenuItem("Guardar Dados");
		this.mnitGuardarDados.addActionListener(this);
		this.mnitGuardarDados.setActionCommand(DCMJuegoGramaticalGUI.ACCION_GUARDAR_DADOS);
		
		this.mnitCargarDados = new JMenuItem("Cargar Dados");
		this.mnitCargarDados.addActionListener(this);
		this.mnitCargarDados.setActionCommand(DCMJuegoGramaticalGUI.ACCION_CARGAR_DADOS);
		
		
		this.mnArchivo.add(mnitCrearDado);
		this.mnArchivo.add(mnitConsultarDado);
		this.mnArchivo.add(mnitLanzarDado);
		this.mnArchivo.add(mnitGuardarDados);
		this.mnArchivo.add(mnitCargarDados);
		this.mnArchivo.addSeparator();
		this.mnArchivo.add(mnitSalir);
		
		this.mnitCreditos = new JMenuItem("Creditos");
		this.mnitCreditos.addActionListener(this);
		this.mnitCreditos.setActionCommand(DCMJuegoGramaticalGUI.ACCION_VER_CREDITOS);
		
		this.mnAcercaDe.add(mnitCreditos);
		
		this.mnitNivel = new JMenuItem("Escoger Nivel");
		this.mnitNivel.addActionListener(this);
		this.mnitNivel.setActionCommand(DCMJuegoGramaticalGUI.ACCION_NIVEL);		
		this.mnJugar.add(mnitNivel);
		
		//Activar o desactivar en nivel.
		this.mnitNivel.setEnabled(true);		
	}	

	/**
	 * Metodo para activar las acciones segun la opcion del menu que se escoja.
	 */
	@Override
	public void actionPerformed(ActionEvent event) {		
		String comando = event.getActionCommand();
		if (comando.equals(DCMJuegoGramaticalGUI.ACCION_CREAR_DADO) ) {						
			this.principal.crearDado();
		} 
		else if (comando.equals(DCMJuegoGramaticalGUI.ACCION_CONSULTAR_DADO)){
			this.principal.consultarDado();
		}
		else if (comando.equals(DCMJuegoGramaticalGUI.ACCION_LANZAR_DADO)){			
				this.principal.lanzarDado();		
		}		
		else if (comando.equals(DCMJuegoGramaticalGUI.ACCION_SALIR)){	
			this.principal.salirAplicacion();
		} 	
		else if (comando.equals(DCMJuegoGramaticalGUI.ACCION_VER_CREDITOS)){
			this.principal.mostrarCreditos();
		}
		else if (comando.equals(DCMJuegoGramaticalGUI.ACCION_CARGAR_DADOS)){	
			this.principal.cargarDados();
		} 	
		else if (comando.equals(DCMJuegoGramaticalGUI.ACCION_GUARDAR_DADOS)){
			this.principal.guardarDados();
		}else if (comando.equals(DCMJuegoGramaticalGUI.ACCION_NIVEL)){
			this.principal.nivelDeJuego();
		}

	}
}
