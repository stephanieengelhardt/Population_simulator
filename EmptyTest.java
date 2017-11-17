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
public class EmptyTest extends TestCase{

	public int row, column;
	public World w;
	public Empty e;
	
	/*
	 * Sets up a empty in world w. (non-Javadoc)
	 * It ensures that the constructor works properly. 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	public void setUp() throws FileNotFoundException{
		row = 2;
		column=1;
		w= new World("public1.txt");
		e= (Empty) w.grid[row][column];
	  }
	
	/*
	 * Ensures that the State is implemented correctly and that when the grid from 
	 * the current world is called with this empty's row and column that the .who()
	 * method returns empty
	 */
	@Test
	public void testWho() {
		State who=w.grid[row][column].who();
		assertEquals(State.EMPTY,who);
	}


}
