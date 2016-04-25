// Justin Austin @02707974


import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class Polynomial {
	
	//private variables
	
	private String funcName;
	private ArrayList<Term> polynomial;

   //new array list titled polynomial is created
	
	public Polynomial()
	{
		polynomial = new ArrayList<Term>();
	}
	
	
	//deletes cases within polynomial
	public void Delete(int x, int y){
		
		//prints statement to notify user
		System.out.println("Delete funct");
		
		ArrayList<Term> jog = new ArrayList<Term>();
		for(Term letter : polynomial)
		{
			//gets the specified coefficents and expoenents
			if(letter.getCo() == x && letter.getExpo() == y)
				jog.add(letter);
		}
		//calls a function to delete them
		polynomial.removeAll(jog);		
	}	
	
	//inserts term in the polynomial 
	public void Insert(int x, int y){
		//prints statement to notify user
		System.out.println("Insert funct");
		
		Term jog = new Term(x,y);
		polynomial.add(jog);
		
		//populates the polynomial by looping through iterations
		for(int i=0;i<polynomial.size();i++)
		
		{
			if(y > polynomial.get(i).getExpo())
			{
				
				Collections.swap(polynomial, polynomial.size()-1, i);
			    break;
			}
		}	
	}
	
	//function that formats polynomial as a string 
		public void Product()
		{
			System.out.println("Product function called");
			System.out.print(funcName+ " = ");
			
			/*for loops uses i as the index of 
			the array and places each entry into its rightful place holder*/
			
			for(int i=0;i<polynomial.size();i++)
			{
				if((i+1) == polynomial.size() || i==0)
				{
					System.out.print(polynomial.get(i).toString());
				}
				else if(polynomial.get(i).getCo() > 0)
				{
					System.out.print("+" + polynomial.get(i).toString());
				}
				else
				{
					System.out.print(polynomial.get(i).toString());
				}
			}
			
			//prints the finished polynomial
			System.out.println();
		
		}
		
		//reads the txt file to call in the specific polynomial entries
	public void Read(){
		
		//allows to get into folders
		String dir = System.getProperty("user.dir");
		
		//references the place in memory where the txt file is located
		String text = "Users/JusFly223/Documents/workspace/Final/src/infile.txt";
		
		//allocates memory for a new file
		File file = new File(dir+text);
		try {
			//accounts for reading in the new txt file
			Scanner txtRead = new Scanner(file);
			
			//looks for input with quotations
			String data = "";
			
			//stands for array i
		    String[] i ;
		    
			//after one line is read continues to the next line until done
			data = txtRead.nextLine();
			
			//splits the data at a colon
			i = data.split(";");
			
			//represents index 0 in array i
			funcName = i[0];
			
			//for loop is used to create the polynomial
			for(int x=1;x<i.length;x+=2){
				
				Insert(Integer.parseInt(i[x]), Integer.parseInt(i[x+1]));
				
				Product();
				
			}
			//calls function reverse and product
			Reverse();
			Product();
			
			while(txtRead.hasNextLine()){
				
				data = txtRead.nextLine();
			}
			txtRead.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//reverses the order of the polyomial 
	public void Reverse()
	{
		//prints statement to notify user 
		System.out.println("Reverse funct");
		Collections.reverse(polynomial);
	}
	
	
}
