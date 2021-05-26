package view;

import java.awt.Container;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import contract.IController;
import contract.IModel;
import view.menuElement.MainMenu;
import view.menuElement.MenuElement;
import view.menuElement.Play;
import view.menuElement.QuitGame;
import view.menuElement.Resume;

/**
 * The Class ViewFrame.
 * @author Maiva
 * @author Chabain
 *  @author Vladimir
 *
 */
class ViewFrame extends JFrame implements KeyListener {

	/** The model. */
	private IModel model;
	/** The controller. */
	private IController controller;
	/** the window length. */
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -697358409737458175L;
	/** Sets "resume" as a new Resume(). */
	
	/**
	 * Instantiates a new view frame.
	 *
	 * @param model the model
	 * @throws HeadlessException the headless exception
	 */
	public ViewFrame(final IModel model) throws HeadlessException {
		this.buildViewFrame(model);
		
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model the model
	 * @param gc    the gc
	 */
	public ViewFrame(final IModel model, final GraphicsConfiguration gc) {
		super(gc);
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model the model
	 * @param title the title
	 * @throws HeadlessException the headless exception
	 */
	public ViewFrame(final IModel model, final String title) throws HeadlessException {
		super(title);
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model the model
	 * @param title the title/
	 * @param gc    the gc
	 */
	public ViewFrame(final IModel model, final String title, final GraphicsConfiguration gc) {
		super(title, gc);
		this.buildViewFrame(model);
	}
	/**
	 * Instantiates a new view frame.
	 *
	 */


	
	/**
	 * Gets the controller.
	 *
	 * @return the controller
	 */
	private IController getController() {
		return this.controller;
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller the new controller
	 */
	protected void setController(final IController controller) {
		this.controller = controller;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	protected IModel getModel() {
		return this.model;
	}

	/**
	 * Sets the model.
	 *
	 * @param model the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/**
	 * Builds the view frame.
	 *
	 * @param model the model
	 */
	private void buildViewFrame(final IModel model) {
		this.setModel(model);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.addKeyListener(this);
		ViewPanel vp = new ViewPanel(this);
		this.setTitle("   Bienvenue Sur BOULDER DASH   ");
		this.setContentPane(vp);
		
		this.setSize(810,460);
		this.setLocationRelativeTo(null);
		
	}

	

	/**
	 * Prints the message.
	 *
	 * @param message the message
	 */
	public void printMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}
 
	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	public void keyTyped(final KeyEvent e) {

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(final KeyEvent e) {
		
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	public void keyReleased(final KeyEvent e) {
		try {
			this.getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
	}
}