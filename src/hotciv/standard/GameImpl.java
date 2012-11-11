package hotciv.standard;

import hotciv.framework.*;

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
	
	public Tile getTileAt(Position p) {
		return null;
	}

	public Unit getUnitAt(Position p) {
		return null;
	}

	public City getCityAt(Position p) {
		if (p.equals(new Position(1, 1))) {
			return new CityImpl();
		} 
		if (p.equals(new Position(4, 1))) {
			return new CityImpl();
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
		if(playerInTurn == Player.RED){
			playerInTurn = Player.BLUE;
		}
		else{
			age += 100;
			playerInTurn = Player.RED;
		}
		
	}

	public void changeWorkForceFocusInCityAt(Position p, String balance) {
	}

	public void changeProductionInCityAt(Position p, String unitType) {
	}

	public void performUnitActionAt(Position p) {
	}
}
