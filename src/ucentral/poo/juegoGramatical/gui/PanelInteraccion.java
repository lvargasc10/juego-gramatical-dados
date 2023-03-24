package ucentral.poo.juegoGramatical.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Representa el panel que contiene los botones para la interaccion con la logica del programa.
 * @author lvargasc10
 * @version 1.0 
 * @since Nov 23 2019
 */

public class PanelInteraccion extends JPanel implements ActionListener{	
	
	//ATRIBUTOS
	
	/**
	 * Boton para crear un dado.
	 */
	private JButton btnCrearDado;
	
	/**
	 * Boton para lanzar un dado.
	 */
	private JButton btnLanzarDado;
	
	/**
	 * Boton para consultar un dado.
	 */
	private JButton btnConsultarDado;
	
	/**
	 * Boton para seleccionar el modo de juego facil.
	 */
	private JButton btnModoFacil;
	
	/**
	 * Boton para seleccionar el modo de juego dificil.
	 */
	private JButton btnModoDificil;	
	
	/**
	 * Boton para mostrar a LA creadora del juego gramatical.
	 */
	private JButton btnCreditos;
	
	//METODOS
	// :=Constructores
	
	/**
	 * Relacion ventana principal
	 */
	private JuegoGramaticalGUI principal;
	
	/**
	 * Se crea el panel de interaccion con la ventana como parametro.
	 * @param ventana del juego gramatical
	 */
	public PanelInteraccion(JuegoGramaticalGUI ventana){
		this.principal = ventana;
		this.inicializarPanel();		
	}
	
	/**
	 * Metodo para inicializar el panel de interaccion
	 */
	private void inicializarPanel() {
		
		GridLayout borde = new GridLayout(3,2);
		this.setLayout(borde);
		
		//Crear los elementos de la interaccion		
		this.btnCreditos = new JButton("Creditos");
		this.btnCreditos.addActionListener(this);
		this.btnCreditos.setActionCommand(DCMJuegoGramaticalGUI.ACCION_VER_CREDITOS);		
		
		
		this.btnCrearDado = new JButton ("Crear Dado");
		this.btnCrearDado.addActionListener(this);
		this.btnCrearDado.setActionCommand(DCMJuegoGramaticalGUI.BOTON_CREAR_DADO);
		
		this.btnLanzarDado = new JButton("¡Lanzar Dado!");
		this.btnLanzarDado.addActionListener(this);
		this.btnLanzarDado.setActionCommand(DCMJuegoGramaticalGUI.BOTON_LANZAR_DADO);
		
		this.btnConsultarDado = new JButton("Consultar Dados Creados");
		this.btnConsultarDado.addActionListener(this);
		this.btnConsultarDado.setActionCommand(DCMJuegoGramaticalGUI.BOTON_CONSULTAR_DADO);
		
		this.btnModoFacil= new JButton("Modo de Juego Facil");
		this.btnModoFacil.addActionListener(this);
		this.btnModoFacil.setActionCommand(DCMJuegoGramaticalGUI.BOTON_MODO_FACIL);
		
		this.btnModoDificil = new JButton("Modo de Juego Dificil");
		this.btnModoDificil.addActionListener(this);
		this.btnModoDificil.setActionCommand(DCMJuegoGramaticalGUI.BOTON_MODO_DIFICIL);		
		
		//Agregar elementos					
		this.add(this.btnCrearDado);
		this.add(this.btnConsultarDado);
		this.add(this.btnLanzarDado);		
		this.add(this.btnModoFacil);
		this.add(this.btnModoDificil);
		this.add(this.btnCreditos);	
		
		//Habilito o deshabilito los botones en caso de ser necesario.
		this.btnCrearDado.setEnabled(true);
		this.btnConsultarDado.setEnabled(true);
		this.btnLanzarDado.setEnabled(true);
		this.btnModoFacil.setEnabled(true);
		this.btnModoDificil.setEnabled(true);		
	}	
	
	/**
	 * Metodo para las acciones al clickear un boton.
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		/**
		 * Variable para la opcion seleccionada.
		 */
		String comando = event.getActionCommand();
		
		if(comando.equals(DCMJuegoGramaticalGUI.BOTON_CREAR_DADO)) {
			this.principal.crearDado();
			
		}else if (comando.equals(DCMJuegoGramaticalGUI.BOTON_LANZAR_DADO)) {
			this.principal.lanzarDado();
			
		}else if (comando.equals(DCMJuegoGramaticalGUI.BOTON_CONSULTAR_DADO)) {
			this.principal.consultarDado();
			
		}else if (comando.equals(DCMJuegoGramaticalGUI.BOTON_MODO_FACIL)) {
			this.principal.nivelFacil();
			
		}else if (comando.equals(DCMJuegoGramaticalGUI.BOTON_MODO_DIFICIL)) {
			this.principal.nivelDificil();
			
		}else if (comando.equals(DCMJuegoGramaticalGUI.ACCION_VER_CREDITOS)) {
			this.principal.mostrarCreditos();			
		}					
	}
}
