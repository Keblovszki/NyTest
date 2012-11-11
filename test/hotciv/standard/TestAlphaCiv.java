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
	public void redCityPopulationIs1() {
		City c = game.getCityAt(new Position(1, 1));
		assertEquals("Cities has size 1", 1, c.getSize());
	}
}