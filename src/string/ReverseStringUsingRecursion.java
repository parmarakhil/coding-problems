package string;

public class ReverseStringUsingRecursion {

	public String reverse(String str) {
		if(str.isEmpty()) 
		{
			System.out.println("String is empty");
			return str;
		}
		else {
			return reverse(str.substring(1)+str.charAt(0));
			
		}
	}
}
