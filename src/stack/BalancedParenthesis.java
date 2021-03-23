package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Given a string of parenthesis. find out if it is balanced
 * 
 */
public class BalancedParenthesis {
	
	public static void main(String[] args) {
		System.out.println(isBalancedParenthesis("{([])}"));
	}
	
	/*
	 * Method uses stack to find balanced parenthesis
	 * @param x parenthesis string
	 */
	static boolean isBalancedParenthesis(String x)
    {
        // add your code here
        if(x.length()%2!=0) return false;
        Deque<Character> stack=new ArrayDeque<Character>();
        for (char c : x.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

}
