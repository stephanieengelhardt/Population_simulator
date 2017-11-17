/**
 *  
 * @author Stephanie Engelhardt
 *
 */

/**
 * Grass remains if more than rabbits in the neighborhood;
 * otherwise, it is eaten. 
 *
 */
public class Grass extends Living {
	
	public Grass (World w, int r, int c){
		super.world=w;
		super.row=r;
		super.column=c;
	}
	
	public State who(){
		return State.GRASS; 
	}
	
	/**
	 * Grass can be eaten out by too many rabbits in the neighborhood. Rabbits may also 
	 * multiply fast enough to take over Grass. 
	 */



	public Living next(World wNew){
		int[] neighborhood= new int[NUM_LIFE_FORMS];
		this.census(neighborhood);
		//a) Empty if at least three times as many Rabbits as Grasses in the neighborhood;
		if((neighborhood[RABBIT]/3)>=neighborhood[GRASS])
			return new Empty(wNew, this.row, this.column);
		//b) otherwise, Rabbit if there are at least three Rabbits in the neighborhood;
		else if(neighborhood[RABBIT]>2)
			return new Rabbit(wNew, this.row, this.column, 0);
		//c) otherwise, Grass. 
		else
			return new Grass(wNew, this.row, this.column);
	}
}
