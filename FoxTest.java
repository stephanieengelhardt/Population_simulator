import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;
import org.junit.Before;
import junit.framework.TestCase;

/**
 * 
 * @author Stephanie Engelhardt
 *
 */
public class FoxTest extends TestCase {

	public int row, age, column;
	public World w;
	public Fox f;
	
	/*
	 * Sets up a fox in world w with the age of 0. (non-Javadoc)
	 * It ensures that the constructor works properly. 
	 * @see junit.framework.TestCase#setUp()
	 */  
	@Before
	public void setUp() throws FileNotFoundException{
		age=0;
		row = 1;
		column=0;
		w= new World("public1.txt");
		f= (Fox) w.grid[row][column];
	  }

	/*
	 * Ensures that the State is implemented correctly and that when the grid from 
	 * the current world is called with this fox's row and column that the .who()
	 * method returns fox
	 */
	@Test
	public void testWho() {
		State who=w.grid[row][column].who();
		assertEquals(State.FOX, who);
	}

	/*
	 * Tests the myAge() method from the Animal class
	 */
	@Test
	public void testAge() {
		int age= f.myAge();
		assertEquals(0,age);
	}


}
