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
public class PredatorPreyTest extends TestCase {

	public World one;
	public World two;
	public World three;
	public World four;
	public World five;
	public World six;
	
	/*
	 * Tests that the set up works for all of the text files(non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	public void setUp() throws FileNotFoundException{
		one=new World("public1.txt");
		two=new World(one.getWidth());
		three=new World("public2.txt");
		four=new World(three.getWidth());
		five=new World ("public3.txt");
		six=new World(five.getWidth());
	}
	
	/*
	 * Ensures that after public1.txt has been ran 5 times,
	 * that it equals what it should equal (public1-5cycles.txt)
	 */
	@Test
	public void testUpdateWorld() throws FileNotFoundException {
		int cycles=5;
		for(int x=0; x<cycles; x++){
			if(x%2==0)
				PredatorPrey.updateWorld(one, two);
			else
				PredatorPrey.updateWorld(two,one);
		}
		World correct=new World("public1-5cycles.txt");
		assertEquals(correct.toString(),two.toString());
	}
	
	/*
	 * Ensures that after public2.txt has been ran 8 times,
	 * that it equals what it should equal (public2-8cycles.txt)
	 */
	@Test
	public void testUpdateWorld2() throws FileNotFoundException {
		int cycles=8;
		for(int x=0; x<cycles; x++){
			if(x%2==0)
				PredatorPrey.updateWorld(three, four);
			else
				PredatorPrey.updateWorld(four, three);
		}
		World correct=new World("public2-8cycles.txt");
		assertEquals(correct.toString(),three.toString());
	}

	/*
	 * Ensures that after public3.txt has been ran 6 times,
	 * that it equals what it should equal (public3-6cycles.txt)
	 */
	@Test
	public void testUpdateWorld3() throws FileNotFoundException {
		int cycles=6;
		for(int x=0; x<cycles; x++){
			if(x%2==0)
				PredatorPrey.updateWorld(five, six);
			else
				PredatorPrey.updateWorld(six,five);
		}
		World correct=new World("public3-6cycles.txt");
		assertEquals(correct.toString(),five.toString());
	}

}
