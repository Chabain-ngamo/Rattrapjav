/**
 * 
 */
package view.menuElement;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import contract.Menu;

/* @author Maiva
 * @author Chabain
 *  @author Vladimir
 *
 */
public class Resume extends MenuElement {
	
	
	/**
     * The constructor Resume.
     * @param  content means the content of Resume.
     *  @param size means the size of the board resume.
     *   @param int alpha means the the element on the frame.
     */

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
