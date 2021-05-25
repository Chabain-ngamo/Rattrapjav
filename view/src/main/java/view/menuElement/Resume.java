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
public class Resume extends MenuElement {

	public Resume(String content, int size, int alpha) {
		super(content, size, alpha);
	}
	
	@Override
	public Menu MenuRequest() {
		if(this.isSelected()) {
			return Menu.Resume;
		}
		return Menu.Else;
	}

}
