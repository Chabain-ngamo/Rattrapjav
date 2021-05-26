package controller;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;
import contract.Menu;
import contract.State;


/**
 * The Class Controller.
 * @author Maiva
 * @author Chabain
 *  @author Vladimir
 *
 */
public final class Controller implements IController {

	/** The view. */
	private IView		view;

	/** The model. */
	private IModel	model;
	
	 private boolean firstClickOnPause;
	

	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
		//this.getAudioLoad().startMusic("game");
	}

	

	public Controller() {
		// TODO Auto-generated constructor stub
	}



	/**
     * Control.
     */
	public void control() {
		this.view.printMessage(this.getMessageToShow());
	}
	
	public String getMessageToShow() {
		return "enter 1, 2, 3, 4 or 5 to choose the level of your game.";
	}
	
	/**
	 * Start method.
	 * Launch the model loop. Refresh each 100 milliseconds.
	 * @throws LineUnavailableException 
	 * @throws IOException 
	 * @throws UnsupportedAudioFileException 
	 */
	
	public void start() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		while(true) {
			this.model.loop();
			try {
				Thread.sleep(100);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
     * Sets the view.
     *
     * @param pview
     *            the new view
     */
	private void setView(final IView pview) {
		this.view = pview;
	}
	
	public IView getView() {
		return this.view;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}
	
	public IModel getModel() {
		return this.model;
	}

	/**
     * Order perform.
     *
     * @param controllerOrder
     *            the controller order
	 * @throws LineUnavailableException 
	 * @throws IOException 
	 * @throws UnsupportedAudioFileException 
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public void orderPerform(final ControllerOrder controllerOrder) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		switch (controllerOrder) {
		case Game1:
			this.model.loadGame(1);
			break;
		case Game2:
			this.model.loadGame(2);
			break;
		case Game3:
			this.model.loadGame(3);
			break;
		case Game4:
			this.model.loadGame(4);
			break;
		case Game5:
			this.model.loadGame(5);
			break;
		case Up:
			this.model.getGame().getAvatar().movePlayer('Z');
			//this.model.modelNotify();
			break;
		case Left:
			this.model.getGame().getAvatar().movePlayer('Q');
			//this.model.modelNotify();
			break;
		case Down:
			this.model.getGame().getAvatar().movePlayer('S');
			//this.model.modelNotify();
			break;
		case Right:
			this.model.getGame().getAvatar().movePlayer('D');
			//this.model.modelNotify();
			break;
			
		}
	}

	@Override
	public void performMenuRequest(Menu menu) {
		// TODO Auto-generated method stub
		
	}

	
	

}
