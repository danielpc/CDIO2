package test;

import spil.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class landUnitTest {
	private  Field[] field;
	
	@Test
	public void testStartBalance() {
		Player p1 = new Player("player");
		assertEquals(1000, p1.getBalance());
	}
	
	@Test
	public void testAddPositiveValue(){
		Player p1 = new Player("player");
		field = new Field[1];
		field[0] = new Field("Positive field","", 250, false); 
		field[0].land(p1);
		assertEquals(1250, p1.getBalance());		
	}
	
	@Test
	public void testAddNegativeValue(){
		Player p1 = new Player("player");
		field = new Field[1];
		field[0] = new Field("Negative field","", -100, false); 
		field[0].land(p1);
		assertEquals(900, p1.getBalance());		
	}
	
	@Test
	public void testExtraTurn(){
		Player p1 = new Player("player");
		field = new Field[1];
		field[0] = new Field("Extra turn field","", 0, true); 
		field[0].land(p1);
		assertEquals(true, field[0].isExtraTurn());		
	}
	
	@Test
	public void testNotExtraTurn(){
		Player p1 = new Player("player");
		field = new Field[1];
		field[0] = new Field("Not extra turn field","", 0, false); 
		field[0].land(p1);
		assertEquals(false, field[0].isExtraTurn());		
	}
	
	@Test
	public void testValidTurn(){
		Player p1 = new Player("player");
		field = new Field[1];
		field[0] = new Field("Not extra turn field","", -1001, false); 
		boolean validTurn = field[0].land(p1);
		assertEquals(false, validTurn);		
	}
	
	@Test
	public void testBalanceNotUnderZero(){
		Player p1 = new Player("player");
		field = new Field[1];
		field[0] = new Field("Not extra turn field","", -1001, false);
		field[0].land(p1);
		assertEquals(1000, p1.getBalance());
	}
	
	

}
