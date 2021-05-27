package view;

import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;
import entity.Sound;

/**
 * The Class View.
 * @author Maiva
 * @author Chabain
 *  @author Vladimir
 *
 */
public final class View implements IView, Runnable {

	/** The frame. */
	private final ViewFrame viewFrame;
	
	/** The model. */
	private IModel model;

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 * @throws LineUnavailableException 
     * A LineUnavailableException is an exception indicating that aline cannot be opened because it is unavailable. This situationarises most commonly when a requested line is already in useby another 
     * @throws IOException 
     * Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed orinterrupted I/O operations
     * @throws UnsupportedAudioFileException 
     * means An UnsupportedAudioFileException is an exception indicating that an operation failed because a file did not contain valid data of a recognized filetype and format.
	 */
	public View(final IModel model) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		String filePath="sons/audio/music/game.wav";
		this.viewFrame = new ViewFrame(model);
		this.setModel(model);
		Sound sound = new Sound();
		sound.playSound(filePath);
		SwingUtilities.invokeLater(this);
	}
	

	private void setModel(IModel model) {
		this.model=model;
		
	}


	/**
	 * Key code to controller order.
	 *
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 */
	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_UP:
			return ControllerOrder.Up;
		case KeyEvent.VK_DOWN:
			return ControllerOrder.Down;
		case KeyEvent.VK_RIGHT:
			return ControllerOrder.Right;
		case KeyEvent.VK_LEFT:
			return ControllerOrder.Left;
		case KeyEvent.VK_ESCAPE:
			return ControllerOrder.Escape;
		case KeyEvent.VK_ENTER:
			return ControllerOrder.Enter;
		case KeyEvent.VK_1:
			return ControllerOrder.Game1;
		case KeyEvent.VK_2:
			return ControllerOrder.Game2;
		case KeyEvent.VK_3:
			return ControllerOrder.Game3;
		case KeyEvent.VK_4:
			return ControllerOrder.Game4;
		case KeyEvent.VK_5:
			return ControllerOrder.Game5;
		default:
			return ControllerOrder.Else;
		}
	}

	/*
	 * (non-Javadoc)
	 */
	public void printMessage(final String message) {
		
		this.viewFrame.printMessage(message);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
			this.viewFrame.setVisible(true);
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}


}
