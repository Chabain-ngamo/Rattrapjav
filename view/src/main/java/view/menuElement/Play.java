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
public class Play extends MenuElement {
	
	public Play(String content, int size, int alpha) {
		super(content, size, alpha);
	}
	
	@Override
	public Menu MenuRequest() {
		if(this.isSelected()) {
			return Menu.Play;
		}
		return Menu.Else;
	}
	

}
