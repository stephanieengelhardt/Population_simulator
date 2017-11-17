import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;

/**
 * 
 * @author Stephanie Engelhardt
 *
 */
public class AnimalTest extends TestCase{

	public World w=new World(3);
	public Animal b;
	public Animal r;
	public Animal f;
	/*
	 * Sets up all of the different types of animals (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	public void setUp(){
		b=new Badger(w, 0, 0, 3);
		r=new Rabbit(w, 0, 1, 2);
		f=new Rabbit(w, 0, 2, 0);
	}
	/*
	 * Tests each animal to ensure that the myAge() method works for each animal
	 */
	@Test
	public void testMyAge() {
		assertEquals(3, b.myAge());
		assertEquals(2, r.myAge());
		assertEquals(0, f.myAge());
	}

}
