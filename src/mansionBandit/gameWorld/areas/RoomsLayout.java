package mansionBandit.gameWorld.areas;

import java.util.ArrayList;
import java.util.List;

import mansionBandit.gameWorld.items.CreateItems;
import mansionBandit.gameWorld.items.Item;

/**
 * This class makes the rooms and fits them together depending on the amount of rooms wanted
 * by the user
 * @author Liam De Grey
 *
 */
public class RoomsLayout {
	private List<Room> rooms = new ArrayList<Room>();
	private List<Item> allItems = new ArrayList<Item>();
	private MansionArea[][] grid;

	public RoomsLayout(int numRooms){
		int rand = (int) (Math.random()*20)+1;
		CreateItems gameItems = new CreateItems(rand);
		allItems = gameItems.getItems();
		makeRooms(numRooms);
		setLinks();
		giveItems();
		drawMap();
	}

	public void makeRooms(int numRooms){
		for(int i=0; i<numRooms; i++){
			rooms.add(new Room());
		}
	}

	/*
	 * this method puts items in the rooms randomly, some rooms wont have items
	 * and some rooms will have multiple items
	 */
	public void giveItems(){
		int itemNum = 0;
		int rand;
		while(itemNum<allItems.size()) {
			for(int i=0; i<grid.length; i++) {
				for(int j=0; j<grid[0].length; j++) {
					
					if(grid[i][j] instanceof Room) {
						rand = (int)(Math.random() * 2 + 1);//either 1 or 2
						if(rand==1&&itemNum<allItems.size()) {
							((Room)grid[i][j]).addItem(allItems.get(itemNum));//Add item to room
							itemNum++;
						}
					}
					if(itemNum==allItems.size())
						return;
				}
			}
		}
	}


	/*
	 * Sets the layout of the rooms
	 */
	public void setLinks(){
		int rows = (int)Math.sqrt(rooms.size())+4;
		int cols = rows;

		grid = new MansionArea[rows][cols];//A grid showing [rows][columns] of all the rooms

		int extraSpace = (rows * cols) - rooms.size();//find out how many free spaces there are in the grid

		int rand;

		int roomNum = 0;
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[0].length; j++){
				
				if(extraSpace>0) {
					rand = (int)(Math.random() * 3 + 1);//either 1 , 2 or 3
					if(rand==1&&roomNum<rooms.size()) {
						grid[i][j] = rooms.get(roomNum);//put room in grid
						roomNum++;
					}else {
						grid[i][j] = new Hallway();
						extraSpace--;
					}
				}else {
					grid[i][j] = rooms.get(roomNum);
					roomNum++;
				}
			}
		}

		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[0].length; j++){
				MansionArea current = grid[i][j];
				MansionArea n = null, e = null, s = null, w = null;

				if(i!=0)
					n = grid[i-1][j];
				if(i!=grid.length-1)
					s = grid[i+1][j];
				if(j!=0)
					w = grid[i][j-1];
				if(j!=grid[0].length-1)
					e = grid[i][j+1];
				current.setLinks(n, e, s, w);
			}
		}
		setHallways(rows, cols);
	}
	
	/*
	 * This method takes all the null spaces and puts in a hallway
	 * where there should be one
	 * TODO make this recursive
	 */
	public void setHallways(int rows, int cols) {
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				
			}
		}
	}


	/*
	 * Draws a textual map in the console to show
	 * the layout of the rooms
	 */
	public void drawMap(){
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[0].length; j++){
				if(grid[i][j] instanceof Room){
					if(((Room)grid[i][j]).getItems().size()>0)
						System.out.print("  I  ");
					else
						System.out.print("  R  ");
				}else{
					System.out.print("     ");
				}
			}
			System.out.println();
		}

		System.out.println("rows = "+grid.length+" cols = "+grid[0].length);
		System.out.println("I = Room has Item, R = Room has no Item, ' ' = Is a Hallway");


		/*if(room.getNorth()!=null&&!drawn.contains(room.getNorth())){
			drawMap(room.getNorth());
		}
		if(room.getWest()!=null&&!drawn.contains(room.getWest())){
			drawMap(room.getWest());
		}

		if(!drawn.contains(room)){
			if(drawn.size()%2==0)
				System.out.println();
			if(room.getItems().size()>0)
				System.out.print("  I  ");//Show if the room has an Item
			else
				System.out.print("  R  ");
			drawn.add(room);
		}

		if(room.getEast()!=null&&!drawn.contains(room.getEast())){
			drawMap(room.getEast());
		}
		if(room.getSouth()!=null&&!drawn.contains(room.getSouth())){
			drawMap(room.getSouth());
		}*/
	}

}
