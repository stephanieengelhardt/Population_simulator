import java.io.BufferedWriter;

/**
 *  
 * @author Stephanie Engelhardt
 *
 */

import java.io.File; 
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random; 

/**
 * @author Stephanie Engelhardt
 * The world is represented as a square grid of size width X width. 
 *
 */
public class World {
	private int width; // grid size: width X width 
	
	public Living[][] grid; 
	
	/**
	 *  Default constructor reads from a file 
	 */
	public World(String inputFileName) throws FileNotFoundException{		
        try {
            File file = new File(inputFileName);
            Scanner input = new Scanner(file);
            int x=0;
            while (input.hasNextLine()) {
            	int y=0;
            	String s = input.nextLine();
            	Scanner scan=new Scanner(s);
                scan.useDelimiter("");
                if(x==0 && y==0){
                	width=s.length()/3;
                	grid= new Living[width][width];
                }
                for(int z=0; z<grid.length; z++){
                	String c=scan.next();
                	if(c.equals("G")){
            			grid[x][y]= new Grass(this, x, y);
            			scan.next();
                	}
            		else if(c.equals("E")){
            			grid[x][y]= new Empty(this, x, y);
            			scan.next();
            		}
            		else if(c.equals("F"))
            			grid[x][y]= new Fox(this,  x, y, scan.nextInt());
            		else if(c.equals("R"))
            			grid[x][y]= new Rabbit(this,  x, y, scan.nextInt());
            		else if(c.equals("B"))
            			grid[x][y]= new Badger(this,  x, y, scan.nextInt());
            		scan.next();
            		y++;
                }
                x++;
                scan.close();
            }
            input.close();
            

        } catch (Exception ex) {
            ex.printStackTrace();
        }

	}
	
	/**
	 * Constructor that builds a w X w grid without initializing it. 
	 * @param width  the grid 
	 */
	public World(int w){
		width=w;
		grid= new Living[width][width];
	}
	
	
	public int getWidth(){ 
		return width;
	}
	
	/**
	 * Initialize the world by randomly assigning to every square of the grid  
	 * one of BADGER, FOX, RABBIT, GRASS, or EMPTY.  
	 * 
	 * Every animal starts at age 0.
	 */
	public void randomInit(){
		Random generator = new Random();
		for (int x= 0; x< grid.length; x++ ) {
			for ( int y= 0; y< grid[0].length; y++ ){
				int next=generator.nextInt(5);
				if(next==0)
					grid[x][y]=new Badger(this, x, y, 0);
				else if(next==1)
					grid[x][y]= new Empty(this, x, y);
				else if(next==2)
					grid[x][y]=new Fox(this, x, y, 0);
				else if(next==3)
					grid[x][y]= new Grass(this, x, y);
				else
					grid[x][y]=new Rabbit(this, x, y, 0);
			}
		}
	}
	
	
	/**
	 * Output the world grid. For each square, output the first letter of the living form
	 * occupying the square. If the living form is an animal, then output the age of the animal 
	 * followed by a blank space; otherwise, output two blanks.  
	 */
	public String toString(){
		String result= new String();
		for (int x= 0; x< grid.length; x++ ) {
			for ( int y= 0; y< grid[0].length; y++ ){
				if(grid[x][y].who()==State.BADGER){
					Badger b= (Badger) grid[x][y];
					result+=("B"+b.myAge()+ " ");
				}
				else if(grid[x][y].who()==State.RABBIT){
					Rabbit r= (Rabbit) grid[x][y];
					result+=("R"+r.myAge()+ " ");
				}
				else if(grid[x][y].who()==State.FOX){
					Fox f= (Fox) grid[x][y];
					result+=("F"+f.myAge()+ " ");
				}
				else if(grid[x][y].who()==State.GRASS){
					result+=("G  ");
				}
				else{
					result+=("E  ");
				}
			}
			result= result+ "\n";
		}
		
		return result; 
	}
	

	/**
	 * Write the world grid to an output file.  Also useful for saving a randomly 
	 * generated world for debugging purpose. 
	 * @throws FileNotFoundException
	 */
	public void write(String outputFileName) throws FileNotFoundException{
		 BufferedWriter writer = null;
	        try {
	            File file = new File(outputFileName);
	            writer = new BufferedWriter(new FileWriter(file));
	            for(int x=0; x<this.grid.length; x++){
	            	for(int y=0; y<this.grid[0].length; y++){
	            		if(this.grid[x][y].who()==State.BADGER)
	            			writer.write("B"+ ((Badger) this.grid[x][y]).myAge()+ " ");
	            		else if(this.grid[x][y].who()==State.FOX)
	            			writer.write("F"+ ((Fox) this.grid[x][y]).myAge()+ " ");
	            		else if(this.grid[x][y].who()==State.RABBIT)
	            			writer.write("R"+ ((Rabbit) this.grid[x][y]).myAge()+ " ");
	            		else if(this.grid[x][y].who()==State.EMPTY)
	            			writer.write("E"+ "  ");
	            		else if(this.grid[x][y].who()==State.GRASS)
	            			writer.write("G"+ "  ");
	            	}
	            	writer.newLine();
	            }
	        } 
	        catch (Exception e) {
	            e.printStackTrace();
	        } 
		try {
			writer.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}			
}
