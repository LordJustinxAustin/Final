// Justin Austin @02707974

//source code for the class called "Term"
public class Term {
	
//declaration of variables
	private int exponent;
	private int coefficient;
	
	public Term(int coefficient, int exponent){
		
		this.coefficient = coefficient;
		
		this.exponent = exponent;
		
	}
	
	public String toString(){
		//providing the math behind the equation
		String out;
		//exponent is 0 so it does not change
		if(exponent == 0){
			out=String.valueOf(coefficient); 
			}
		//if exponent is one it is equal to itself
		else if(exponent == 1){
			out=("x" + coefficient);
		}
		//if it isn't 0 or 1 then format the polynomial
		else{
			out=(coefficient + "x^" + exponent);
		} return out;		
	}
	
	//have to set a getter so the exponent is called
	
		public int getExpo()
		{
			return exponent;
		}
		
	//have to set a getter so the coefficient is called
	
	public int getCo()
	{
		return coefficient;
	}
	
}