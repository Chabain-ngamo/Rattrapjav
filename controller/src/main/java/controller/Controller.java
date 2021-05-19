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
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#control()
	 */
	public void control() {
		this.view.printMessage("Appuyer sur les touches 'E', 'F', 'D' ou 'I', pour afficher Hello world dans la langue d votre choix.");
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
			case Up:
				this.model.loadHelloWorld("GB");
				break;
			case Down:
				this.model.loadHelloWorld("FR");
				break;
			case Right:
				this.model.loadHelloWorld("DE");
				break;
			case Left:
				this.model.loadHelloWorld("ID");
				break;
			case Enter:
				
				switch(this.getModel().getState()) {
				case Pause:
				case Menu:
					this.model.loadHelloWorld("ID");
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
			this.model.loadHelloWorld("ID");
			System.exit(0);
			break;
		default:
			break;
	}
		
		
	}
	
	

}
