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
	HashMap<Position, UnitImpl> mapUnit = new HashMap<Position, UnitImpl>();
	
	//Constructor
	public GameImpl(){
		mapCity.put(new Position(1, 1), new CityImpl(Player.RED));
		mapCity.put(new Position(4, 1), new CityImpl(Player.BLUE));	
		
		mapUnit.put(new Position(2, 0), new UnitImpl(Player.RED, GameConstants.ARCHER) );
		mapUnit.put(new Position(3, 2), new UnitImpl(Player.BLUE, GameConstants.LEGION) );
		mapUnit.put(new Position(4, 3), new UnitImpl(Player.RED, GameConstants.SETTLER) );
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
		return mapUnit.get(p);
	}

	public City getCityAt(Position p) {
		/*
		if (p.equals(new Position(1, 1))) {
			return mapCity.get(p);
		} 
		if (p.equals(new Position(4, 1))) {
			return mapCity.get(p);
		} 
		*/
		return mapCity.get(p);
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
		if(mapUnit.get(to) == null ){
			mapUnit.put(to, mapUnit.get(from) );
			mapUnit.remove(from);
			return true;
		}
		
		if(mapUnit.get(to) != null){
			mapUnit.remove(to);
			mapUnit.put(to, mapUnit.get(from) );
			mapUnit.remove(from);
			return true;
		}
		else {
			return false;
		}
	}

	public void endOfTurn() {
		if(playerInTurn == Player.RED){
			playerInTurn = Player.BLUE;
		}
		else{
			age += 100;
			playerInTurn = Player.RED;
			for(CityImpl c : mapCity.values()){
				c.doProductionSum();
			}
		}
	}	

	public void changeWorkForceFocusInCityAt(Position p, String balance) {
		
	}

	public void changeProductionInCityAt(Position p, String unitType) {
		mapCity.get(p).setProduction(unitType);
		
	}

	public void performUnitActionAt(Position p) {
		
	}
	
	public void createProductionInCityAt(Position p){
		final Position south = p.getSouth(p);
		final Position north = p.getNorth(p);
		final Position east = p.getEast(p);
		final Position west = p.getWest(p);
		final Position southWest = p.getSouthWest(p);
		final Position southEast = p.getSouthEast(p);
		final Position northWest = p.getNorthWest(p);
		final Position northEast = p.getNorthEast(p);
		final ArrayList<Position> aroundTheCity = new ArrayList<Position>();
		
		aroundTheCity.add(p);
		aroundTheCity.add(north);
		aroundTheCity.add(northEast);
		aroundTheCity.add(east);
		aroundTheCity.add(southEast);
		aroundTheCity.add(south);
		aroundTheCity.add(southWest);
		aroundTheCity.add(west);
		aroundTheCity.add(northWest);
		//Archer koster 10
		//Legions koster 15
		if(mapCity.get(p) != null){
			CityImpl c = mapCity.get(p);
			if(c.getProduction() == GameConstants.SETTLER ){
				if(c.getProductionSum() >= 30){
					for(Position currentPosition : aroundTheCity){
						if(mapUnit.get(currentPosition) == null){
							mapUnit.put(currentPosition, new UnitImpl(c.getOwner(), GameConstants.SETTLER));
							break;
						}
					}
					c.setProductionSum(-30);
				}
			}
			if(c.getProduction() == GameConstants.LEGION){
				if(c.getProductionSum() >= 15){
					for(Position currentPosition : aroundTheCity){
						if(mapUnit.get(currentPosition) == null){
							mapUnit.put(currentPosition, new UnitImpl(c.getOwner(), GameConstants.LEGION));
							break;
						}
					}
					c.setProductionSum(-15);
				}
			}
			if(c.getProduction() == GameConstants.ARCHER ){
				if(c.getProductionSum() >= 10){
					for(Position currentPosition : aroundTheCity){
						if(mapUnit.get(currentPosition) == null){
							mapUnit.put(currentPosition, new UnitImpl(c.getOwner(), GameConstants.ARCHER));
							break;
						}
					}
					c.setProductionSum(-10);
				}
			}
		}
	}
}
