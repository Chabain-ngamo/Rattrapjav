package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;
import contract.Menu;
import contract.State;

/**
 * The Class Controller.
 */
public final class Controller implements IController {

	/** The view. */
	private IView		view;

	/** The model. */
	private IModel	model;

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
	}

	/**
     * Control.
     */
	public void control() {
		this.view.printMessage(this.getMessageToShow());
	}
	
	public String getMessageToShow() {
		return "Welcome to BoulderBash ! Press any key to start the game.Press\n- 1 for Level 1 \n - 2 for Level 2 \n - 3 for Level 3\n - 4 for Level 4\n - 5 for Level 5\n - 6 for Level 6\n - 7 for Level 7\n  Use Z/Q/S/D to move the character.";
	}
	
	/**
	 * Start method.
	 * Launch the model loop. Refresh each 100 milliseconds.
	 */
	
	public void start() {
		
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
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public void orderPerform(final ControllerOrder controllerOrder) {
		switch (controllerOrder) {
		case Map1:
			this.model.loadGame(1);
			break;
		case Map2:
			this.model.loadGame(2);
			break;
		case Map3:
			this.model.loadGame(3);
			break;
		case Map4:
			this.model.loadGame(4);
			break;
		case Map5:
			this.model.loadGame(5);
			break;
		case Map6:
			this.model.loadGame(6);
			break;
		case Map7:
			this.model.loadGame(7);
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
			case Enter:
				
				switch(this.getModel().getState()) {
				case Pause:
				case Menu:
					
					break;
				default:
					break;
				}
				break;
			case Escape:
				
				switch(this.getModel().getState()) {
				case Playing:
					this.getModel().setState(State.Pause);
					break;
				case End:
					this.getModel().setState(State.Menu);
					break;
				case Pause:
					this.getModel().setState(State.Playing);
					break;
				default:
					break;
				}
				break;
			default:
				break;
		}
	}

	@Override
	public void performMenuRequest(Menu menu) {
		// TODO Auto-generated method stub
		switch (menu) {
		case Play:
			this.getModel().setState(State.Playing);
			break;
		case Resume:
			this.getModel().setState(State.Playing);
			break;
		case Pausemenu:
			this.getModel().setState(State.Menu);
			break;
		case Quitgame:
			this.getModel().getGame().getAvatar().getSpriteDeath();
			System.exit(0);
			break;
		default:
			break;
	}
		
		
	}
	
	

}
