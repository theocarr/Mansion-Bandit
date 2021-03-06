package mansionBandit.gameWorld.areas;

import java.util.ArrayList;
import java.util.List;

import mansionBandit.factory.RoomFactory;
import mansionBandit.gameWorld.matter.GameMatter;

/**
 * This class makes the rooms and fits them together depending on the amount of rooms wanted
 * by the user
 * @author Liam De Grey
 *
 */
public class Grid {
	private int roomName = 1;
	private List<Room> rooms = new ArrayList<Room>();
	private List<GameMatter> allItems = new ArrayList<GameMatter>();
	private MansionArea[][] grid;
	private RoomFactory factory;
	private boolean hallwayES = true;//true if the hallway should go south at the eastern wall
	private boolean hallwayWS = false;//true if the hallway should go south at the western wall

	public Grid(int numRooms){
		factory = new RoomFactory();
		makeRooms(numRooms);
		setLinks();
	}

	public void makeRooms(int numRooms){
		for(int i=0; i<numRooms; i++){
			rooms.add(new Room(roomName+""));
			roomName++;
		}
	}


	/**
	 * Sets the layout of the rooms and adds links to the hallways and
	 * the rooms
	 */
	public void setLinks(){
		int rand, range=2, extra=1;

		for(int i=1; i<rooms.size(); i+=20){
			extra++;
		}

		/*if(rooms.size()<=20)
			extra = 2;
		else if(rooms.size()<=40)
			extra = 3;
		else if(rooms.size()<=60)
			extra = 6;
		else if(rooms.size()<=80)
			extra = 8;
		else
			extra = 9;*/

		int rows = (int)Math.sqrt(rooms.size())+extra;//(rooms.size()/10);
		int cols = rows;

		grid = new MansionArea[rows][cols];//A grid showing [rows][columns] of all the rooms

		int extraSpace = (rows * cols) - rooms.size();//find out how many free spaces there are in the grid


		for(int i=1; extraSpace>i; i+=60){
			range += 1;
		}


		/*if(extraSpace<20){
			range = 4;
		}else if(extraSpace<80){
			range = 6;
		}else if(extraSpace<140){
			range = 8;
		}*/

		int roomNum = 0;
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[0].length; j++){

				if(extraSpace>0) {
					rand = (int)(Math.random() * range)+1;
					if((rand==2||rand==3)&&roomNum<rooms.size()) {
						grid[i][j] = rooms.get(roomNum);//put room in grid
						roomNum++;
					}else {
						grid[i][j] = new Hallway(roomName+"");
						roomName++;
						extraSpace--;
					}
				}else {
					grid[i][j] = rooms.get(roomNum);
					roomNum++;
				}
			}
		}

		for(int i=0; i<grid.length; i++){//These loops go through each grid space and set links,
			for(int j=0; j<grid[0].length; j++){ //Hallways go horizontal across the mansion
				MansionArea current = grid[i][j]; //Rooms have 4 doors if not next to a wall
				MansionArea n = null, e = null, s = null, w = null;
				if(current instanceof Room) {
					if(i!=0)
						n = grid[i-1][j];
					if(i!=grid.length-1)
						s = grid[i+1][j];
				}else {
					if(i>0&&grid[i-1][j] instanceof Room)
						n = grid[i-1][j];
					if(i<(grid.length-1)&&grid[i+1][j] instanceof Room)
						s = grid[i+1][j];
					if(j==(grid[0].length-1)) {//If current is against the far east wall
						if(hallwayES) {//If the current needs to snake down
							if(i<(grid.length-1)&&s==null)
								s = grid[i+1][j];
						}else if(n==null)
							n = grid[i-1][j];
						hallwayES = (hallwayES)? false:true;
					}else if(j==0) {//If current is against the most western wall
						if(hallwayWS) {//If current needs to snake down
							if(i<(grid.length-1)&&s==null)
								s = grid[i+1][j];
						}else if(i>0&&n==null)
							n = grid[i-1][j];
						hallwayWS = (hallwayWS)? false:true;
					}


				}
				if(j!=0)
					w = grid[i][j-1];
				if(j!=grid[0].length-1)
					e = grid[i][j+1];
				current.setLinks(n, e, s, w);
				factory.populateRoom(current);
			}
		}
	}

	public MansionArea[][] getGrid(){
		return grid;
	}

}
