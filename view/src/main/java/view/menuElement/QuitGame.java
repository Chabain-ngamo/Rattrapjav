/**
 * 
 */
package view.menuElement;

import contract.Menu;

/* @author Maiva
* @author Chabain
*  @author Vladimir
*
*/
public class QuitGame extends MenuElement {

	public QuitGame(String content, int size, int alpha) {
		super(content, size, alpha);
	}
	
	@Override
	public Menu MenuRequest() {
		if(this.isSelected()) {
			return Menu.Quitgame;
		}
		return Menu.Else;
	}

}
