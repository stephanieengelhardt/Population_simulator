/**
 *  
 * @author Stephanie Engelhardt
 *
 */

/**
 * A badger eats a rabbit and competes against a fox. 
 */
public class Badger extends Animal{

	/**
	 * Constructor 
	 * @param w: world
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Badger (World w, int r, int c, int a){
		super.age=a;
		super.world=w;
		super.row=r;
		super.column=c;
	}
	
	/**
	 * A badger occupies the square. 	 
	 */
	public State who(){
		return State.BADGER; 
	}
	
	/**
	 * A badger dies of old age or hunger, from isolation and attack by a group of foxes. 
	 * @param wNew     world of the next cycle
	 * @return Living  life form occupying the square in the next cycle. 
	 */
	public Living next(World wNew){
		int[] neighborhood= new int[NUM_LIFE_FORMS];
		this.census(neighborhood);		
		//a) Empty if the Badger is currently at age 4;
		if(this.myAge()>=BADGER_MAX_AGE)
			return new Empty(wNew, this.row, this.column);
		//b) otherwise, Fox, if there is only one Badger but there are more than one Fox in the neighborhood
		else if(neighborhood[FOX]>1 && neighborhood[BADGER]==1)
			return new Fox(wNew, this.row, this.column, 0);	
		//c) otherwise, Empty, if Badgers and Foxes together outnumber Rabbits in the neighborhood;
		else if((neighborhood[BADGER]+neighborhood[FOX])>neighborhood[RABBIT])
			return new Empty(wNew, this.row, this.column);		
		//d) otherwise, Badger (the badger will live on). 
		else
			return (new Badger(wNew, this.row, this.column, this.age+1));
	}
}
