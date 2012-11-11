package hotciv.standard;

import hotciv.framework.GameConstants;
import hotciv.framework.Position;
import hotciv.framework.Tile;

public class TileImpl implements Tile {
	
	//Constructor
	public TileImpl(){
		
	}
	
	@Override
	public Position getPosition() {
		
		/*
		if(getTypeString() == GameConstants.OCEANS){
			return new Position(1, 0);
		} 
		if(getTypeString() == GameConstants.HILLS){
			return new Position(0, 1);
		}
		if(getTypeString() == GameConstants.MOUNTAINS){
			return new Position(0, 1);
		}
		else{
			return null;
		}
		*/
		return null;
		
	}

	@Override
	public String getTypeString() {		
		/*
		if(getPosition().equals(new Position(1, 0))){
			return GameConstants.OCEANS;
		}
		if(getPosition().equals(new Position(0, 1))){
			return GameConstants.HILLS;
		}
		if(getPosition().equals(new Position(2, 2))){
			return GameConstants.MOUNTAINS;
		}
		else{
			return GameConstants.PLAINS;
		}
		*/
		return GameConstants.OCEANS;
	}

}
