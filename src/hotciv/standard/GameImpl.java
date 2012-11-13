package hotciv.standard;

import hotciv.framework.City;
import hotciv.framework.Game;
import hotciv.framework.GameConstants;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.framework.Tile;
import hotciv.framework.Unit;

import java.util.*;

/**
 * Skeleton implementation of HotCiv.
 * 
 * This source code is from the book "Flexible, Reliable Software: Using
 * Patterns and Agile Development" published 2010 by CRC Press. Author: Henrik B
 * Christensen Computer Science Department Aarhus University
 * 
 * This source code is provided WITHOUT ANY WARRANTY either expressed or
 * implied. You may study, use, modify, and distribute it for non-commercial
 * purposes. For any commercial use, see http://www.baerbak.com/
 */

public class GameImpl implements Game {
	private Player playerInTurn = Player.RED;
	private int age = -4000;
	HashMap<Position, CityImpl> mapCity = new HashMap<Position, CityImpl>();
	
	//Constructor
	public GameImpl(){
		mapCity.put(new Position(1, 1), new CityImpl(Player.RED));
		mapCity.put(new Position(4, 1), new CityImpl(Player.BLUE));	
	}
	
	public Tile getTileAt(Position p) {
		if(p.equals(new Position(1, 0))){
			return new TileImpl(new Position (1, 0), GameConstants.OCEANS);
		}
		if(p.equals(new Position(0, 1))){
			return new TileImpl(new Position (0, 1), GameConstants.HILLS);
		}
		if(p.equals(new Position(2, 2))){
			return new TileImpl(new Position (2, 2), GameConstants.MOUNTAINS);
		}
		else{
			return new TileImpl(p , GameConstants.PLAINS);
		}
	}

	public Unit getUnitAt(Position p) {
		if(p.equals(new Position(2, 0))){
			return new UnitImpl(Player.RED, GameConstants.ARCHER, new Position(2, 0));
		}
		if(p.equals(new Position(3, 2))){
			return new UnitImpl(Player.BLUE, GameConstants.LEGION, new Position(3, 2));
		}
		if(p.equals(new Position(4, 3))){
			return new UnitImpl(Player.RED, GameConstants.SETTLER, new Position(4, 3));
		}
		return null;
	}

	public City getCityAt(Position p) {
		if (p.equals(new Position(1, 1))) {
			return mapCity.get(p);
		} 
		if (p.equals(new Position(4, 1))) {
			return mapCity.get(p);
		} 
		else {
			return null;
		}
	}

	public Player getPlayerInTurn() {
		return playerInTurn;
	}

	public Player getWinner() {
		return Player.RED;
	}

	public int getAge() {
		return age;
	}

	public boolean moveUnit(Position from, Position to) {
		return false;
	}

	public void endOfTurn() {
		// City c = new CityImpl(Player.RED, new Position(1, 1));
		if(playerInTurn == Player.RED){
			playerInTurn = Player.BLUE;
		}
		else{
			age += 100;
			playerInTurn = Player.RED;
			//c.doProductionSum();	
		}
	}	

	public void changeWorkForceFocusInCityAt(Position p, String balance) {
		
	}

	public void changeProductionInCityAt(Position p, String unitType) {
		
	}

	public void performUnitActionAt(Position p) {
		
	}
}
