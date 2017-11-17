import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;
/**
 * 
 * @author Stephanie Engelhardt
 *
 */
public class WorldTest extends TestCase{

	public World w;
	public World x;
	
	/*
	 * Tests that the set up for both random and text files works(non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	public void setUp() throws FileNotFoundException{
		w=new World(5);
		w.randomInit();
		x=new World("public1.txt");
	}
	
	/*
	 * Tests that the width for both worlds (from random and from a file) works correctly(non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Test
	public void testGetWidth() {
		assertEquals(5,w.getWidth());
		assertEquals(3, x.getWidth());
	}

	/*
	 * Tests that the writing to a file works and since I did not change the world, the strings should be equal
	 * so it also tests the toString method (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Test
	public void testWriteandtoString() throws FileNotFoundException {
		x.write("public1-write.txt");
		World old=new World("public1.txt");
		World test=new World("public1-write.txt");
		assertEquals(old.toString(),test.toString());
	}

}
