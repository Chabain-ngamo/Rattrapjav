/**
 * 
 */
package view.menuElement;

import contract.Menu;

/**
 * @author media
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
		return Menu.Nop;
	}

}
