import java.util.Scanner;

/**
 * Ian Leeds
 * ileeds@brandeis.edu
 * An implementation of a postfix calculator
 */
public class PostfixCalculator {
	
	/**
	 * The implementation of a postfix calculator
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String line;
		
		//Initialize a stack used for calculation
		Stack stack=new Stack();
		//Push postfix input onto a stack
		while (!(line = scan.nextLine()).equalsIgnoreCase("quit")){
			//Check for various inputs: +,-,*,/,double,clear (Use Double.parseDouble())
			//When the user enters an operator the current value of the equation
			//should be displayed.
			//Continue with else if and so on ...
			//for operations, pop stack twice and perform operation on popped values
			if (line.equals("+")){
				double x=(double) stack.Pop();
				double y=(double) stack.Pop();
				System.out.println(y+x);
				stack.Push(y+x);
			}else if(line.equals("-")){
				double x=(double) stack.Pop();
				double y=(double) stack.Pop();
				System.out.println(y-x);
				stack.Push(y-x);
			}else if(line.equals("*")){
				double x=(double) stack.Pop();
				double y=(double) stack.Pop();
				System.out.println(y*x);
				stack.Push(y*x);
			}else if(line.equals("/")){
				double x=(double) stack.Pop();
				double y=(double) stack.Pop();
				System.out.println(y/x);
				stack.Push(y/x);
			//clears to new stack
			}else if(line.equals("clear")){
				stack=new Stack();
			//push doubles on stack
			}else{
				stack.Push(Double.parseDouble(line));
			}
		}
	}
	
}
