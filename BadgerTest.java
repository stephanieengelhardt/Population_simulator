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
public class BadgerTest extends TestCase{

	public int row, age, column;
	public World w;
	public Badger b;
	   
	/*
	 * Sets up a badger in world w with the age of 0. (non-Javadoc)
	 * It ensures that the constructor works properly. 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	public void setUp() throws FileNotFoundException{
		age=0;
		row = 0;
		column=1;
		w= new World("public1.txt");
		b= (Badger) w.grid[row][column];
	  }

	/*
	 * Ensures that the State is implemented correctly and that when the grid from 
	 * the current world is called with this badger's row and column that the .who()
	 * method returns badger
	 */
	@Test
	public void testWho() {
		assertEquals(State.BADGER,w.grid[row][column].who());
	}

	/*
	 * Tests the myAge() method from the Animal class
	 */
	@Test
	public void testAge() {
		int age= b.myAge();
		assertEquals(0,age);
	}

}
