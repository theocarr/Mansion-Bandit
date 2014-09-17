package mansionBandit.gameWorld.main;

import mansionBandit.gameWorld.rooms.RoomsLayout;

/**
 * This class starts off the game
 * creates the panels and frames
 * and initialises the rooms and items
 * @author Liam De Grey
 *
 */
public class Main {
	
	public Main(){
		//System.out.println("Make the JFrame");
		new RoomsLayout(20);
	}
	
	public static void main(String[] args){
		new Main();
	}
}
