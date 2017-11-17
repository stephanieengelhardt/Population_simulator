/**
 *  
 * @author Stephanie Engelhardt
 *
 */

/**
 * A fox eats rabbits and competes against a badger. 
 */
public class Fox extends Animal {
	/**
	 * Constructor 
	 * @param w: world
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Fox (World w, int r, int c, int a){
		super.age=a;
		super.world=w;
		super.row=r;
		super.column=c;
	}
		
	/**
	 * A fox occupies the square. 	 
	 */
	public State who(){
		return State.FOX; 
	}
	
	/**
	 * A fox dies of old age or hunger, or from attack by numerically superior badgers. 
	 * @param wNew     world of the next cycle
	 * @return Living  life form occupying the square in the next cycle. 
	 */
	public Living next(World wNew){
		int[] neighborhood= new int[NUM_LIFE_FORMS];
		this.census(neighborhood);	
		//a) Empty if the Fox is currently at age 6;
		if(this.myAge()>=FOX_MAX_AGE)
			return new Empty(wNew, this.row, this.column);
		//b) otherwise, Badger, if there are more Badgers than Foxes in the neighborhood;
		else if(neighborhood[BADGER]>neighborhood[FOX])
			return new Badger(wNew, this.row, this.column, 0);		
		//c) otherwise, Empty, if Badgers and Foxes together outnumber Rabbits in the neighborhood;
		else if((neighborhood[BADGER]+neighborhood[FOX])>neighborhood[RABBIT])
			return new Empty(wNew, this.row, this.column);	
		//d) otherwise, Fox (the fox will live on). 
		else
			return (new Fox(wNew, this.row, this.column, this.age+1));
		 
	}
}
