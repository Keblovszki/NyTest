package hotciv.standard;

import hotciv.framework.*;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Skeleton class for AlphaCiv test cases
 * 
 * This source code is from the book "Flexible, Reliable Software: Using
 * Patterns and Agile Development" published 2010 by CRC Press. Author: Henrik B
 * Christensen Computer Science Department Aarhus University
 * 
 * This source code is provided WITHOUT ANY WARRANTY either expressed or
 * implied. You may study, use, modify, and distribute it for non-commercial
 * purposes. For any commercial use, see http://www.baerbak.com/
 */
public class TestAlphaCiv {
	private Game game;

	/** Fixture for alphaciv testing. */
	@Before
	public void setUp() {
		game = new GameImpl();
	}

	@Test
	public void shouldHaveRedCityAt1_1() {
		City c = game.getCityAt(new Position(1, 1));
		assertNotNull("There should be a city at (1, 1)", c);
		Player p = c.getOwner();
		assertEquals("City at (1, 1) should be owned by red", Player.RED, p);
	}

	@Test
	public void NoCityAt2_2() {
		City c = game.getCityAt(new Position(2, 2));
		assertNull("There shouldn't be a city at (2, 2)", c);
	}

	@Test
	public void NoCityAt3_2() {
		City c = game.getCityAt(new Position(3, 2));
		assertNull("There shouldn't be a city at (3, 2)", c);
	}

	@Test
	public void RedShouldWinInYear3000BC() {
		//runs the first ten rounds
		for(int i = 0; i < 20; i++){
			game.endOfTurn();
		}
		int age = game.getAge();
		assertEquals("The year is 3000 BC", -3000, age);
		assertEquals("The winner is red", Player.RED, game.getWinner());
		// assertNull("No winner yet", game.getWinner());
	}
	
	@Test
	public void shouldHaveBlueCityAt4_1() {
		City c = game.getCityAt(new Position(4, 1));
		assertNotNull("There should be a city at (4, 1)", c);
		Player p = c.getOwner();
		assertEquals("City at (4, 1) should be owned by red", Player.BLUE, p);
	}
	
	@Test
	public void redPlayerStarts() {
		Player p = game.getPlayerInTurn();
		assertEquals("Red is the first player in turn", Player.RED, p);
	}
	
	@Test
	public void gameShouldStartIn4000BC(){
		int age = game.getAge();
		assertEquals("At game start, age should be 4000 BC", -4000, age);
	}
	
	@Test
	public void advanceYearWith100PrRound(){
		
		//runs the first round
		for(int i = 0; i < 2; i++){
			game.endOfTurn();
		}
		
		int age = game.getAge();
		assertEquals("The year should be -3900 after the first round", -3900, age);
		
		//runs the second round
		for(int i = 0; i < 2; i++){
			game.endOfTurn();
		}
		age = game.getAge();
		assertEquals("The year should be -3800 after the second round", -3800, age);
		
		//runs the next five rounds
		for(int i = 0; i < 10; i++){
			game.endOfTurn();
		}
		age = game.getAge();
		assertEquals("There year should be -3300 after the seventh round", -3300, age);
	}
	
	@Test
	//Firstly it is red in turn, afterward it is blue in turn and round we go ==> exactly two players red and blue
	public void exactlyTwoPlayersRedAndBlue(){
		//switch turn for the first ten rounds...
		for(int i = 0; i < 10; i++){
		game.endOfTurn();
		assertEquals("The player in turn should be blue", Player.BLUE, game.getPlayerInTurn() );
		game.endOfTurn();
		assertEquals("The player in turn should be red", Player.RED, game.getPlayerInTurn() );
		}
	}
	
	@Test
	public void redCityPopulationIs1() {
		City c = game.getCityAt(new Position(1, 1));
		assertEquals("Cities has size 1", 1, c.getSize());
	}
	
	//Det er de tre nedenst�ende som giver error og jeg ved ikke lige hvorfor - synes det burde se s�ledes ud..!
	@Test
	public void tileAt1_0ShouldBeAnOcean(){
		Tile t = game.getTileAt(new Position(1, 0));
		assertNotNull("t should not be null", t);
		assertEquals("The tile at position (1, 0) should be an ocean", GameConstants.OCEANS, t.getTypeString() );
		assertEquals("The position shuold be (1, 0)", new Position (1, 0), t.getPosition() );
	}
	
	@Test
	public void tileAt0_1ShouldBeAHill(){
		Tile t = game.getTileAt(new Position(0, 1));
		assertNotNull("t should not be null", t);
		assertEquals("The tile at position (0, 1) should be a hill", GameConstants.HILLS, t.getTypeString() );
		assertEquals("The position shuold be (0, 1)", new Position (0, 1), t.getPosition() );
	}
	
	@Test
	public void tileAt2_2ShouldBeAMountain(){
		Tile t = game.getTileAt(new Position(2, 2));
		assertNotNull("t should not be null", t);
		assertEquals("The tile at position (2, 2) should be a mountain", GameConstants.MOUNTAINS, t.getTypeString() );
		assertEquals("The position shuold be (2, 2)", new Position (2, 2), t.getPosition() );
	}
	
	@Test
	public void restOfTheTilesArePlains(){
		Tile t = game.getTileAt(new Position (4, 4));
		assertNotNull("t should not be null", t);
		assertEquals("The tile at position (4, 4) should be a mountain", GameConstants.PLAINS, t.getTypeString() );
		assertEquals("The position shuold be (4, 4)", new Position (4, 4), t.getPosition() );
	}
	
	@Test
	public void restOfTheTilesArePlains1(){
		Tile t = game.getTileAt(new Position (12, 13));
		assertNotNull("t should not be null", t);
		assertEquals("The tile at position (12, 13) should be a mountain", GameConstants.PLAINS, t.getTypeString() );
		assertEquals("The position shuold be (12, 13)", new Position (12, 13), t.getPosition() );
	}
	
	@Test
	public void cityAt1_1Gain6productionEachRound(){
		City c = game.getCityAt(new Position(1, 1));
		assertEquals("The city at position (1, 1) should have production 0", 0, c.getProduction());
		
		//runs the first round
		for(int i = 0; i < 2; i++){
			game.endOfTurn();
		}
		assertEquals("The city at position (1, 1) should have production 7", 7, c.getSize() );
		
		//runs three rounds more
		for(int i = 0; i < 6; i++){
			game.endOfTurn();
		}
		assertEquals("The city at position (1, 1) should have production 25", 25, c.getSize() );
	}
	
}