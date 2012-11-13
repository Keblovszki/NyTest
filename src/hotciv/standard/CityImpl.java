package hotciv.standard;

import hotciv.framework.*;

public class CityImpl implements City {
	private Player owner;
	private int production;
	private Position position;
	
	//Constructor
	public CityImpl(Player p, Position po){
		owner = p;
		production = 0;
		position = po;
	}
	
	@Override
	public Player getOwner() {
		return owner;
	}

	@Override
	public int getSize() {
		return 1;
	}

	@Override
	public String getProduction() {
		return null;
	}
	
	@Override
	public String getWorkforceFocus() {
		return null;
	}
	
	@Override
	public void doProductionSum(){
		production += 6;
	}
	
	@Override
	public int getProductionSum(){
		return production;
	}
	
	
}
