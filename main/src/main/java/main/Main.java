
package main;

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
     */
    public static void main(final String[] args) {
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
