package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import contract.IModel;
import elements.Avatar;
import entity.Entity;
import entity.Game;
import entity.Sprite;

/**
 * The Class ViewPanel.
 * @author Maiva
 * @author Chabain
 *  @author Vladimir
 *
 */
class ViewPanel extends JPanel implements Observer {

	/** The view frame. */
	private ViewFrame viewFrame;
	/** The Background image */
	
	
	
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -998294702363713521L ;
	/** The counter until the end of the game */
	private static int timer = 150;
	/** The boolean to refresh some information only once */
	private boolean modification = false;
	/** The boolean to start properly the timer */
	private boolean isTimerStart = false;

	public ViewPanel() {
		
	}

	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
		viewFrame.getModel().getGame();

	}

	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */
	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame the new view frame
	 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	/**
	 * Repaint the view.
	 */
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */

	/**
	 * Display information on screen. Method called each time the view is "painted".
	 */
	@Override
	protected void paintComponent(final Graphics graphics) {

		final double scale = 3.0;
		final int imageSize = 16;
		final int width = this.getWidth();
		final int height = this.getHeight();
		final int timerResetValue = 200;
		Game game = this.viewFrame.getModel().getGame();
		Entity[][] loadGame = null;
		Avatar avatar = null;
//		a = getWidth();
//		b = getHeight();
		if (game.getAvatar() != null) {

			loadGame = game.getArrayGame();
			avatar = this.viewFrame.getModel().getGame().getAvatar();
			int playerPosX = this.viewFrame.getModel().getGame().getAvatar().getPositionX();
			int playerPosY = this.viewFrame.getModel().getGame().getAvatar().getPositionY();
			Font font = new Font("Arial", Font.BOLD, 20);
			graphics.setFont(font);
			if (timer != 0 && timer != -100) {

				this.focusGameOnAvatar(graphics, width, height, playerPosX, playerPosY, scale, imageSize);

				this.displayGame(graphics, width, height);
				
				if (isTimerStart == false) {
					ViewPanel.startTimer();
					this.isTimerStart = true;
				}

				this.reverseFocusOnScreenAndStats(graphics, scale, width, height, playerPosX, playerPosY, avatar,game, imageSize);

			} else {
				
				graphics.clearRect(0, 0, width, height);
				graphics.drawString("you lost because of the over time !", width / 2 - 75, height / 2);
				timer = -100;
				/*
				 * NOW WE HAVE TO PERFORM AN ACTION WHEN THE PLAYER LOOSES (+ RESTART THE TIMER
				 * = set it two 200 when the player switch between the maps)
				 */
			}
			

		} else {
			//graphics.clearRect(0, 0, width, height);
			Sprite sprite = new Sprite('0', "fond.jpg");
			sprite.loadImage();
			  graphics.drawImage(sprite.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
			  
		}
		//switch(this.getViewFrame().getModel().getState()) {
		/** Pauses the view g.*/
		//case Pause:
			//this.pauseView(graphics);
			//break;
		/** Plays the view g.*/
		//case Playing:
			//this.displayGame( graphics, width, height);
			//break;
		/** Ends the view g.*/
		//case End:
			///this.displayGame( graphics, width, height);
			//break;
		/** Shows menu on the view g.*/
		//case Menu:
			//this.menuView(graphics);
			//break;
		}	
	///}

	/**
	 * The startTimer method.
	 * Launch a specific timer, calculated by seconds.
	 * 
	 */
	public static void startTimer() { // This is a timer
		//ViewPanel drawTimer = new ViewPanel();
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				if (timer != -100 && timer > 0) {
					timer--;// increments the counter
				}
			}
		};
		Timer timer = new Timer("MyTimer"); 
		timer.scheduleAtFixedRate(timerTask, 1000, 1000); 
	}

	/**
	 * The displayMap method.
	 * Allows the paintComponent method to display the map and its entities.
	 * @param graphics the Graphics
	 * @param width the width of the view
	 * @param height the height of the view
	 */
	public void displayGame(Graphics graphics, int width, int height) {

		final int imageSize = 16;
		final int numberOfLevels = 5;
		Game game = this.viewFrame.getModel().getGame();
		IModel getModel = this.viewFrame.getModel();
		Entity[][] loadGame = game.getArrayGame();
		Avatar avatar = this.viewFrame.getModel().getGame().getAvatar();
		final int timerResetValue = 200;
		for (int x = 0; x < game.getWidthGame(); x++) {
			for (int y = 0; y < game.getHeightGame(); y++) {
				graphics.drawImage(loadGame[x][y].getSprite().getImage(), x * imageSize, y * imageSize, this);
			}
		}
	
		if (!avatar.getlive()&& modification == false) {

			modification = true;
			graphics.clearRect(0, 0, width, height);
			this.viewFrame.printMessage("You died ! Try again...");
			getModel.loadGame(game.getId());
			modification = false;
		}

		if (avatar.getIsWin() && modification == false) {
			if (game.getId() < numberOfLevels) {
				getModel.loadGame(game.getId() + 1);
				timer = timerResetValue;
			} else {
				modification = true;
				avatar.setlive(false);
				graphics.clearRect(0, 0, width, height);
				this.viewFrame.printMessage("You won ! Congrats !");
				System.exit(0);
			}
		}
	}

	/**
	 * The focusMapOnPlayer method.
	 * Zoom and center the attention on the player.
	 * @param graphics the Graphics
	 * @param width the width of the view
	 * @param height the height of the view
	 * @param playerPosX the x coord of the player
	 * @param playerPosY the y coord of the player
	 * @param scale the zoom used to focus on player
	 * @param imageSize the sprite size
	 */
	public void focusGameOnAvatar(Graphics graphics, int width, int height, int playerPosX, int playerPosY, double scale, int imageSize) {

		graphics.clearRect(0, 0, width, height);
			graphics.translate(0,
					(int) (-playerPosY * imageSize + 10));
			((Graphics2D) graphics).scale(2, 2);
	}
	

	/**
	 * The reverseFocusOnScreenAndStats method.
	 * Displays statistics on the right upper corner of the view.
	 * @param graphics the Graphics
	 * @param scale the zoom used to focus on the player
	 * @param width the width of the view
	 * @param height the height of the view
	 * @param playerPosX the x coord of the player
	 * @param playerPosY the y coord of the player
	 * @param player the player
	 * @param map the map
	 * @param imageSize the sprite size
	 */
	public void reverseFocusOnScreenAndStats(Graphics graphics, double scale, int width, int height, int playerPosX,
			int playerPosY, Avatar avatar, Game game, int imageSize) {

		/*final int xStartStatsValues = width + 30;
		final int yStartStatsValues = 0;
		final int xEndStatsValues = 240;
		final int yEndStatsValues = 65;
		final int xStartStatsDisplay = width + 30;*/
		graphics.setColor(Color.white);
		graphics.fillRect(588, 290,120, 50);
		 Font font = new Font("Courier", Font.BOLD, 8);
		 graphics.setFont(font);
		graphics.setColor(Color.BLACK);
		graphics.drawString("TIMER : " + timer, 180, 220);
		//graphics.drawString(String.valueOf("Diamond Counter : " + player.getDiamondsCounter()), 590, 350);
		graphics.setColor(Color.RED);
		graphics.drawString(String.valueOf("Number needed : " + game.getNbrDiamonds()), 590,
				330);

		if (avatar.getDiamondstimer() >= game.getNbrDiamonds()) {
			graphics.setColor(Color.white);
			graphics.fillRect(588, 290,120, 50);
			graphics.setColor(Color.BLACK);
			graphics.drawString("TIMER : " + timer, 180, 220);
			graphics.setColor(Color.RED);
			//graphics.drawString(String.valueOf("Number needed : " + map.getNumberOfDiamondsNeeded()), 590,
					//330);
			//graphics.clearRect(650, 0,120, 100);
			//graphics.setColor(Color.BLACK);
			//graphics.drawString("Remaining time : " + counter, 590, 310);
			graphics.setColor(Color.GREEN);
			graphics.drawString(String.valueOf("Diamond Counter : " + avatar.getDiamondstimer()), 590, 300);
			//graphics.setColor(Color.BLUE);
			graphics.drawString("GO TO EXIT DOOR !", 590, 330);
		}
		else {
			graphics.setColor(Color.BLUE);
			graphics.drawString(String.valueOf("Diamond Counter : " + avatar.getDiamondstimer()), 590, 300);
		}

	}
	
	
	 
    /**
     * The getTimer method.
     * @return the counter
     */
    public int getTimer() {
      return timer;
    }

    
    /**
     * The setTimer method.
     * @param newtimer the new timer
     * @throws IndexOutOfBoundsException in case of an exception
     */
    public void setTimer(int newtimer) throws IndexOutOfBoundsException{
      if (newtimer > 0 && newtimer < 10000) {
          ViewPanel.timer = newtimer;
      }else {
          throw new IndexOutOfBoundsException("Wrong parameters");
      }
    }
}
