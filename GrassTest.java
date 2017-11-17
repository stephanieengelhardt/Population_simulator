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
public class GrassTest extends TestCase{

	public int row, column;
	public World w;
	public Grass g;
	
	/*
	 * Sets up a grass in world w. (non-Javadoc)
	 * It ensures that the constructor works properly. 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	public void setUp() throws FileNotFoundException{
		row = 0;
		column=0;
		w= new World("public1.txt");
		g= (Grass) w.grid[row][column];
	  }

	/*
	 * Ensures that the State is implemented correctly and that when the grid from 
	 * the current world is called with this grass's row and column that the .who()
	 * method returns grass
	 */
	@Test
	public void testWho() {
		State who=w.grid[row][column].who();
		assertEquals(State.GRASS,who);
	}

}
