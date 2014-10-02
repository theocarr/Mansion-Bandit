package mansionBandit.ApplicationWindow;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import mansionBandit.gameWorld.main.Player;


/**
 * The JPanel responsible for drawing GUI elements such as the inventory
 * It is given the applicationFrame using it and from that it can identify the player it is used for.
 * It draw inventory items and other GUI elements automatically as it simply looks to the player object.
 * @author Theo
 *
 */

public class GUICanvas extends JPanel{
	private GameFrame frame;

	//TODO change to player
	private Player player;

	//the image of the inventory bar
	BufferedImage inventoryBarImage;


	public GUICanvas(GameFrame gFrame){
	frame = gFrame;
	player = gFrame.getPlayer();

	try {
		inventoryBarImage = ImageIO.read(this.getClass().getResource("/GUIgraphics/inventorybar.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}


	 public void paintComponent(Graphics g){
	        super.paintComponent(g);

	        //draws the inventory slot bar

	        g.drawImage(inventoryBarImage, frame.getInventoryBarPos().x, frame.getInventoryBarPos().y, null);

	        //draws each of the items in a players inventory

	        //for each item in player inventory
	        //draw image in players inventory [i] at (increment *i)

	        for(int i =0;i<player.getInventorySize();i++){

	        	//if player has an item in this slot
	        	if(player.getItem(i)!=null){

	        		//set the x and y position of the image
	        		int itemImageX = frame.getInventoryBarPos().x + (i*frame.getInventorySlotSize());
	        		int itemImageY = frame.getInventoryBarPos().y;

	        		//draw the item at slot i in player inventory
	        		g.drawImage(player.getItem(i).getImage(), itemImageX, itemImageY,null);
	        	}
	        }

	        //draw map



	    }

}