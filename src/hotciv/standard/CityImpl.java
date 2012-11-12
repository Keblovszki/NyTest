package hotciv.standard;

import hotciv.framework.*;

public class CityImpl implements City {
	private Player owner;
	
	//Constructor
	public CityImpl(Player p){
		owner = p;
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
}
