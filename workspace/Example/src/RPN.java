import java.io.StringReader;
import java.util.Scanner;
import java.util.Stack;


public class RPN {
	
	Stack<Integer>stack = new Stack<Integer>();
	
	Stack<Integer> evaluate(String expression)
	{
		
		StringReader sr = new StringReader(expression);
		Scanner scanner = new Scanner(sr);
		while(scanner.hasNext())
		{
			//System.out.println(scanner.next());
			String token = scanner.next();
			
			//check for +, -, /, *
			if(token.equals("+"))
			{
				//do the appropriate things
				//pop 2 items off stack, and place result
				//onto stack
				
				stack.push((Integer)stack.pop()+(Integer)stack.pop());
				
			}
			
			if(token.equals("-"))
			{
				stack.push(stack.pop()+stack.pop());
			}
			
			if(token.equals("/"))
			{
				//stack.push((Integer)stack.pop()+(Integer)stack.pop());
				stack.push(stack.pop()+stack.pop());
			}
			
			if(token.equals("*"))
			{
				stack.push(stack.pop()+stack.pop());
			}
			//catch all case
			//put the integer on the stack
			//Integer.parseInt(token);
			else
			{
				stack.push(Integer.parseInt(token));
			}
			System.out.println(stack);
			
			
			
		}
		
		
		return stack;
	}
	
	void clear()
	{
		stack.clear();
	}
	
}
