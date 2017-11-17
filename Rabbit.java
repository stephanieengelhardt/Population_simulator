/**
 *  
 * @author Stephanie Engelhardt
 *
 */

/*
 * A rabbit eats grass and lives no more than three years.
 */
public class Rabbit extends Animal {	
	/**
	 * Creates a Rabbit object.
	 * @param w: world  
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Rabbit (World w, int r, int c, int a){
		super.age=a;
		super.world=w;
		super.row=r;
		super.column=c;
	}
		
	public State who(){
		return State.RABBIT; 
	}
	
	/**
	 * A rabbit dies of old age or hunger, or it is eaten if there are as many 
	 * foxes and badgers in the neighborhood.  
	 * @param wNew     world of the next cycle 
	 * @return Living  new life form occupying the same square
	 */
	public Living next(World wNew){
		int[] neighborhood= new int[NUM_LIFE_FORMS];
		this.census(neighborhood);
		//	a) Empty if the Rabbit's current age is 3;
		if(this.myAge()>=RABBIT_MAX_AGE)
			return new Empty(wNew, this.row, this.column);
		//	b) otherwise, Empty if there is no Grass in the neighborhood (the rabbit needs food);
		else if(neighborhood[GRASS]==0)
			return new Empty(wNew, this.row, this.column);
		//	c) otherwise, Fox if in the neighborhood there are at least as many Foxes and Badgers
		//	combined as Rabbits, and furthermore, if there are more Foxes than Badgers;
		else if(((neighborhood[FOX]+neighborhood[BADGER])>=neighborhood[RABBIT]) && (neighborhood[FOX]>neighborhood[BADGER]))
			return new Fox(wNew, this.row, this.column, 0);
		//	d) otherwise, Badger if there are more Badgers than Rabbits;
		else if(neighborhood[BADGER]>neighborhood[RABBIT])
			return new Badger(wNew, this.row, this.column, 0);
		//	e) otherwise, Rabbit (the rabbit will live on). 
		else
			return new Rabbit(wNew, this.row, this.column, this.age+1);
	}
}
