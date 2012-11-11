package hotciv.standard;

import hotciv.framework.*;

public class CityImpl implements City {
	
	//Constructor
	public CityImpl(){
		
	}
	
	@Override
	public Player getOwner() {
		return Player.RED;
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
