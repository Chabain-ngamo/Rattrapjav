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

	
	/**
     * The constructor QuitGame.
     * @param  content means the content of the quitgame.
     *  @param size  the size of the board quitgame.
     *   @param  alpha  the action that the quitgame are suppose to do .
     */
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
