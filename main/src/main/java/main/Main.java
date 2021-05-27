
package main;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import contract.ControllerOrder;
import controller.Controller;
import model.Model;
import view.View;

/**
 * The Class Main.
 * @author Maiva
 * @author Chabain
 *  @author Vladimir
 *
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     * @throws LineUnavailableException 
     * A LineUnavailableException is an exception indicating that aline cannot be opened because it is unavailable. This situationarises most commonly when a requested line is already in useby another 
     * @throws IOException 
     * Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed orinterrupted I/O operations
     * @throws UnsupportedAudioFileException 
     * means An UnsupportedAudioFileException is an exception indicating that an operation failed because a file did not contain valid data of a recognized filetype and format.
     */
    public static void main(final String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
    	final Model model = new Model();   
        final View view = new View(model);
       // final AudioLoad audioLoad=new AudioLoad();
        final Controller controller = new Controller(view, model);
        view.setController(controller);
		
        controller.control();
        controller.orderPerform(ControllerOrder.Game1); 

        controller.start();
        
    }
}
