import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;


public class RPNTest {

	@Test
	public void test() {
		RPN calculator = new RPN();
		Stack<Integer> stack;
		stack = calculator.evaluate("25 7 32 * ");

	}

}
