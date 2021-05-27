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
	
	
	/**
     * The constructor play.
     * @param  content means the content of the mainMenu.
     *  @param size  the size of the board play.
     *   @param  alpha  the action that the play are suppose to do .
     */
	
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
