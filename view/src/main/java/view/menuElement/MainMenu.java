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
