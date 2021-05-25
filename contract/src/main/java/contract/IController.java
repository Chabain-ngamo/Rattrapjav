package contract;

/**
 * The Interface IController.
 * @author Maiva
 * @author Chabain
 *  @author Vladimir
 *
 */
public interface IController {

	/**
	 * Control.
	 */
	public void control();

	/**
	 * Order perform.
	 *
	 * @param controllerOrder
	 *          the controller order
	 */
	public void orderPerform(ControllerOrder controllerOrder);
	
	public void performMenuRequest(Menu menu);
}
