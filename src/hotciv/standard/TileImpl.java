package hotciv.standard;

import hotciv.framework.Position;
import hotciv.framework.Tile;

public class TileImpl implements Tile {
	private String ocean;
	private String hill;
	private String mountain;
	private String plain;
	
	@Override
	public Position getPosition() {
		if(getTypeString() == ocean){
			return new Position(1, 0);
		}
		if(getTypeString() == hill){
			return new Position(0, 1);
		}
		if(getTypeString() == mountain){
			return new Position(0, 1);
		}
		else{
			return null;
		}
		
	}

	@Override
	public String getTypeString() {		
		if(getPosition().equals(new Position(1, 0))){
			return ocean;
		}
		if(getPosition().equals(new Position(0, 1))){
			return hill;
		}
		if(getPosition().equals(new Position(2, 2))){
			return mountain;
		}
		else{
			return plain;
		}
	}

}
