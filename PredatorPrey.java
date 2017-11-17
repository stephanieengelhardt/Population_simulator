import java.io.FileNotFoundException;
import java.util.Scanner; 

/**
 *  
 * @author Stephanie Engelhardt
 *
 */

/**
 * 
 * The PredatorPrey class performs the predator-prey simulation over a grid world 
 * with squares occupied by badgers, foxes, rabbits, grass, or none. 
 *
 */
public class PredatorPrey {
	/**
	 * Update the new world from the old world in one cycle. 
	 * @param wOld  old world
	 * @param wNew  new world 
	 */
	public static void updateWorld(World wOld, World wNew){
			for (int x=0; x<wOld.grid.length; x++){
				for (int y=0; y<wOld.grid.length; y++){
					wNew.grid[x][y]=wOld.grid[x][y].next(wNew);
				}
			}
	}
	
	/**
	 * Repeatedly generates worlds either randomly or from reading files. 
	 * Over each world, carries out an input number of cycles of evolution. 
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException{	
		Scanner scan = new Scanner(System.in);
		System.out.println("The Predator-Prety Simulator");
		System.out.println("keys: 1 (random world) 2 (file input) 3 (exit)");
		int trail=1;
		System.out.print("Trial "+ trail+ ": ");
		int type= scan.nextInt();
		while(type!=3){
			World even=null;
			if(type==1){
				System.out.println("Random world");
				System.out.print("Enter grid width: ");
				int width= scan.nextInt();
				even=new World(width);
				even.randomInit();
			}
			else if(type==2){
				Scanner scanned=new Scanner(System.in);
				System.out.println("World input from a file");
				System.out.print("File name: ");
				even= new World(scanned.next());
			}
			System.out.print("Enter number of cycles: ");
			int cycles=scan.nextInt();
			while(cycles<0){
				System.out.print("Please enter a positive number of cycles: ");
				cycles=scan.nextInt();
			}
			System.out.println("Initial world:");
			System.out.println(even.toString());
			World odd=new World(even.getWidth());
			boolean even2=true;
			for(int x=0; x<cycles; x++){
				if(x%2==0){
					updateWorld(even, odd);
					even2=false;
				}
				else{
					updateWorld(odd,even);
					even2=true;
				}
			}
			System.out.println("Final world:");
			if(even2)
				System.out.println(even.toString());
			else
				System.out.println(odd.toString());
			trail++;
			System.out.print("Trial "+ trail+ ": ");
			type=scan.nextInt();
		}
		scan.close();
	}
}
