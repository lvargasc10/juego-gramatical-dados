package ucentral.poo.juegoGramatical.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Panel donde se muestra la imagen del juego gramatical.
 * @author lvargasc10
 * @version 1.0 
 * @since Nov 23 2019
 */

public class PanelDado extends JPanel {
	
	// ATRIBUTOS
	
	/**
	 * Imagen que contiene el panel como decoracion.
	 */
	private BufferedImage imagenPortada;
		
	// METODOS
	// := Constructor
	
	/**
	 * Crea un nuevo panel imagen
	*/
	public PanelDado() {
		// Carga una imagen por defecto
		try {
			File archivoImagen = new File("./data/portada.jpg");
			this.imagenPortada = ImageIO.read( archivoImagen );
		} catch (IOException ioexp) {
				
		}if (this.imagenPortada != null ) {
			this.setPreferredSize( new Dimension (this.imagenPortada.getWidth(), this.imagenPortada.getHeight() ) );
		}
	}	
		
	/**
	 * Muestra la imagen.
	 * @param pGraphics graficas del panel.
	 */
	public void paint( Graphics pGraphics ) {
		super.paint( pGraphics );
	    if (this.imagenPortada != null ) {
	    	pGraphics.drawImage(this.imagenPortada, 0, 0, null, null);
	    	}
	 }	
}

	


