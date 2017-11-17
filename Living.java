/**
 *  
 * @author Stephanie Engelhardt
 *
 */

/**
 * 
 * Living refers to the life form occupying a square in a world grid. It is a 
 * superclass of Empty, Grass, and Animal, the latter of which is in turn a superclass
 * of Badger, Fox, and Rabbit. Living has two abstract methods awaiting implementation. 
 *
 */
public abstract class Living {
	protected World world; // the world in which the life form resides
	protected int row;     // location of the square on which 
	protected int column;  // the life form resides
	
	// constants to be used as indices. 
	protected static final int BADGER = 0; 
	protected static final int EMPTY = 1; 
	protected static final int FOX = 2; 
	protected static final int GRASS = 3; 
	protected static final int RABBIT = 4; 
	
	public static final int NUM_LIFE_FORMS = 5; 
	
	// life expectancies 
	public static final int BADGER_MAX_AGE = 4; 
	public static final int FOX_MAX_AGE = 6; 
	public static final int RABBIT_MAX_AGE = 3; 
	
	
	/**
	 * Censuses all life forms in the 3 X 3 neighborhood in a world. 
	 * @param population  counts of all life forms
	 */
	protected void census(int population[]){
		//count what the living is
		if(this.world.grid[this.row][this.column].who()==State.RABBIT)
			population[RABBIT]++;
		else if(this.world.grid[this.row][this.column].who()==State.GRASS)
			population[GRASS]++;
		else if(this.world.grid[this.row][this.column].who()==State.FOX)
			population[FOX]++;
		else if(this.world.grid[this.row][this.column].who()==State.EMPTY)
			population[EMPTY]++;
		else if(this.world.grid[this.row][this.column].who()==State.BADGER)
			population[BADGER]++;
		//if possible, check to the left
		if(this.column-1>=0){
			if(this.world.grid[this.row][this.column-1].who()==State.RABBIT)
				population[RABBIT]++;
			else if(this.world.grid[this.row][this.column-1].who()==State.GRASS)
				population[GRASS]++;
			else if(this.world.grid[this.row][this.column-1].who()==State.FOX)
				population[FOX]++;
			else if(this.world.grid[this.row][this.column-1].who()==State.EMPTY)
				population[EMPTY]++;
			else if(this.world.grid[this.row][this.column-1].who()==State.BADGER)
				population[BADGER]++;
		}
		//if possible, check to the right
		if(this.column+1<this.world.grid.length){
			if(this.world.grid[this.row][this.column+1].who()==State.RABBIT)
				population[RABBIT]++;
			else if(this.world.grid[this.row][this.column+1].who()==State.GRASS)
				population[GRASS]++;
			else if(this.world.grid[this.row][this.column+1].who()==State.FOX)
				population[FOX]++;
			else if(this.world.grid[this.row][this.column+1].who()==State.EMPTY)
				population[EMPTY]++;
			else if(this.world.grid[this.row][this.column+1].who()==State.BADGER)
				population[BADGER]++;
			}
		//if possible, count living above
		if(this.row-1>=0){
			if(this.world.grid[this.row-1][this.column].who()==State.RABBIT)
					population[RABBIT]++;
			else if(this.world.grid[this.row-1][this.column].who()==State.GRASS)
				population[GRASS]++;
			else if(this.world.grid[this.row-1][this.column].who()==State.FOX)
				population[FOX]++;
			else if(this.world.grid[this.row-1][this.column].who()==State.EMPTY)
				population[EMPTY]++;
			else if(this.world.grid[this.row-1][this.column].who()==State.BADGER)
				population[BADGER]++;	
				//if possible, count living above and to the left
			if(this.column-1>=0){
				if(this.world.grid[this.row-1][this.column-1].who()==State.RABBIT)
					population[RABBIT]++;
				else if(this.world.grid[this.row-1][this.column-1].who()==State.GRASS)
					population[GRASS]++;
				else if(this.world.grid[this.row-1][this.column-1].who()==State.FOX)
					population[FOX]++;
				else if(this.world.grid[this.row-1][this.column-1].who()==State.EMPTY)
					population[EMPTY]++;
				else if(this.world.grid[this.row-1][this.column-1].who()==State.BADGER)
					population[BADGER]++;	
			}
			//if possible, count living above and to the right
			if(this.column+1<this.world.grid.length){
				if(this.world.grid[this.row-1][this.column+1].who()==State.RABBIT)
					population[RABBIT]++;
				else if(this.world.grid[this.row-1][this.column+1].who()==State.GRASS)
					population[GRASS]++;
				else if(this.world.grid[this.row-1][this.column+1].who()==State.FOX)
					population[FOX]++;
				else if(this.world.grid[this.row-1][this.column+1].who()==State.EMPTY)
					population[EMPTY]++;
				else if(this.world.grid[this.row-1][this.column+1].who()==State.BADGER)
					population[BADGER]++;	
			}
			
		} 
		//if possible, count living below
		if(this.row+1<this.world.grid.length){
			if(this.column-1>=0){
				//if possible, count living below and to the left
				if(this.world.grid[this.row+1][this.column-1].who()==State.RABBIT)
					population[RABBIT]++;
				else if(this.world.grid[this.row+1][this.column-1].who()==State.GRASS)
					population[GRASS]++;
				else if(this.world.grid[this.row+1][this.column-1].who()==State.FOX)
					population[FOX]++;
				else if(this.world.grid[this.row+1][this.column-1].who()==State.EMPTY)
					population[EMPTY]++;
				else if(this.world.grid[this.row+1][this.column-1].who()==State.BADGER)
					population[BADGER]++;	
			}
			//if possible, count living below and to the right
			if(this.column+1<this.world.grid.length){
				if(this.world.grid[this.row+1][this.column+1].who()==State.RABBIT)
					population[RABBIT]++;
				else if(this.world.grid[this.row+1][this.column+1].who()==State.GRASS)
					population[GRASS]++;
				else if(this.world.grid[this.row+1][this.column+1].who()==State.FOX)
					population[FOX]++;
				else if(this.world.grid[this.row+1][this.column+1].who()==State.EMPTY)
					population[EMPTY]++;
				else if(this.world.grid[this.row+1][this.column+1].who()==State.BADGER)
					population[BADGER]++;	
			}
			if(this.world.grid[this.row+1][this.column].who()==State.RABBIT)
				population[RABBIT]++;
			else if(this.world.grid[this.row+1][this.column].who()==State.GRASS)
				population[GRASS]++;
			else if(this.world.grid[this.row+1][this.column].who()==State.FOX)
				population[FOX]++;
			else if(this.world.grid[this.row+1][this.column].who()==State.EMPTY)
				population[EMPTY]++;
			else if(this.world.grid[this.row+1][this.column].who()==State.BADGER)
				population[BADGER]++;	
		} 
		
	}

	/**
	 * Gets the identity of the life form on the square.
	 * @return State
	 */
	public abstract State who();  
	
	/**
	 * Determines the life form on the square in the next cycle.
	 * @param  wNew  world of the next cycle
	 * @return Living 
	 */
	public abstract Living next(World wNew);    

}
