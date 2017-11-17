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
public class LivingTest extends TestCase{

	World w;
	@Before
	public void setUp() throws FileNotFoundException{
		w=new World("public1.txt");
	}
	
	@Test
	public void testCensus() {
		int[] population=new int[5];
		w.grid[0][0].census(population);
		assertEquals(population[0], 1);
		assertEquals(population[1], 0);
		assertEquals(population[2], 2);
		assertEquals(population[3], 1);
		assertEquals(population[4], 0);
	}
	
	@Test
	public void testCensus2() {
		int[] population=new int[5];
		w.grid[2][2].census(population);
		assertEquals(population[0], 0);
		assertEquals(population[1], 1);
		assertEquals(population[2], 1);
		assertEquals(population[3], 1);
		assertEquals(population[4], 1);
	}
	
	@Test
	public void testCensus3() {
		int[] population=new int[5];
		w.grid[1][1].census(population);
		assertEquals(population[0], 1);
		assertEquals(population[1], 1);
		assertEquals(population[2], 4);
		assertEquals(population[3], 2);
		assertEquals(population[4], 1);
	}


}
