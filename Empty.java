/**
 *  
 * @author Stephanie Engelhardt
 *
 */

/** 
 * Empty squares are competed by various forms of life.
 */
public class Empty extends Living {

	public Empty (World w, int r, int c){
		super.world=w; 
		super.row=r;
		super.column=c;
	}
	
	public State who(){
		return State.EMPTY; 
	}
	
	/**
	 * An empty square will be occupied by a neighboring Badger, Fox, Rabbit, or Grass, or 
	 * remain empty. 
	 * @param wNew     world of the next life cycle.
	 * @return Living  life form in the next cycle.   
	 */
	public Living next(World wNew){	
		int[] neighborhood= new int[NUM_LIFE_FORMS];
		this.census(neighborhood);
		//a) Rabbit, if more than one neighboring Rabbit;
		if(neighborhood[RABBIT]>1)
			return new Rabbit(wNew, this.row, this.column, 0);
		//b) otherwise, Fox, if more than one neighboring Fox;
		else if(neighborhood[FOX]>1)
			return new Fox(wNew, this.row, this.column, 0);
		//c) otherwise, Badger, if more than one neighboring Badger;
		else if(neighborhood[BADGER]>1)
			return new Badger(wNew, this.row, this.column, 0);
		//d) otherwise, Grass, if at least one neighboring Grass;
		else if(neighborhood[GRASS]>0)
			return new Grass(wNew, this.row, this.column);
		//e) otherwise, Empty. 
		else
			return new Empty(wNew, this.row, this.column);
	}
}
