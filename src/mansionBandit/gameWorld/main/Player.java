package mansionBandit.gameWorld.main;

import java.io.Serializable;

import mansionBandit.gameWorld.areas.MansionArea;
import mansionBandit.gameWorld.areas.Grid;
import mansionBandit.gameWorld.matter.Bandit;
import mansionBandit.gameWorld.matter.Grabable;

/**
 * Player object is different for each client in the game
 * Each client has its own player and this class also takes
 * the pre defined rooms layout
 * @author Liam De Grey
 *
 */
public abstract class Player {
	private MansionArea[][] grid;
	private Bandit bandit;

	public Player(String name, int rooms){
		this.grid = new Grid(rooms).getGrid();
		this.bandit = new Bandit(name, grid, this);
	}

	public Player(String name){
		this.bandit = new Bandit(name, this);
	}

	public Bandit getBandit(){
		return bandit;
	}

	public MansionArea[][] getGrid(){
		return bandit.getGrid();
	}

	public void setGridStart(MansionArea[][] grid){
		this.grid = grid;
		bandit.setGridStart(grid);
	}

	public void setGrid(MansionArea[][] grid) {
		bandit.setGrid(grid);
	}

	public void turnLeft(){
		bandit.turnLeft();
	}

	public void turnRight(){
		bandit.turnRight();
	}

	public boolean moveForward(){
		if(bandit.moveForward()){
			updateRoom();
			return true;
		}
		return false;
	}

	public boolean addItem(Grabable itm, int slot){

		if(bandit.addItem(itm,slot)){
			updateRoom();
			return true;
		}
		return false;
	}

	public boolean addItem(Grabable itm){
		if(bandit.addItem(itm)){
			updateRoom();
			return true;
		}
		return false;
	}

	public boolean removeItem(int slot){
		return bandit.removeItem(slot);
	}

	public boolean removeItem(Grabable itm) {
		return bandit.removeItem(itm);
	}

	public boolean removeItemFromRoom(Grabable itm) {

		if(bandit.getArea().getItems().remove(itm)){
			updateRoom();
			return true;
		}
		return false;
	}

	public boolean dropItem(Grabable itm) {
		if(bandit.getArea().getItems().add(itm)){
			updateRoom();
			return true;
		}
		return false;
	}

	public Grabable getItem(int slot){
		return bandit.getItem(slot);
	}

	public int getInventorySize(){
		return 7;
	}

	protected abstract void updateGrid();

	protected abstract void updateRoom();
}

