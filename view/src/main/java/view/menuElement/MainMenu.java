package view.menuElement;

import contract.Menu;

/* @author Maiva
* @author Chabain
*  @author Vladimir
*
*/
public class MainMenu extends MenuElement {
	
	/**
     * The constructor MainMenu.
     * @param  content means the content of the mainMenu.
     *  @param size  the size of the board mainmenu.
     *   @param  alpha  the action that the mainmenu are suppose to do .
     */
	public MainMenu(String content, int size, int alpha) {
		super(content, size, alpha);
	}
	
	@Override
	public Menu MenuRequest() {
		if(this.isSelected()) {
			return Menu.Mainmenu;
		}
		return Menu.Else;
	}

}
