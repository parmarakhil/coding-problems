package sorting;
import java.util.Arrays;

/*
 * Given two arrays of char and int. 
 * Sort char array according to int array
 * each value of int array correspond to value at same index of char array 
 */
public class SortOneArrayAccordingToOther {
	
	public static void main(String[] args) {
		int[] intArr= {4,1,3,2};
		char[] strArray= {
				'A','X','B','Y'
		};
		strArray=sortCharArrayUsingIntArray(strArray, intArr);
		for(char c:strArray) System.out.println(c);
	}
	
	/*
	 * static method to sort char array  based on int array
	 * @param intArray array of int
	 * @param charArray array of char
	 *  
	 */
	public static char[] sortCharArrayUsingIntArray(char[] charArray, int[] intArray) {
		int n=intArray.length;
		Pair[] arr=new Pair[n];
		for(int i=0;i<n;i++) {
			arr[i]=new Pair(intArray[i],charArray[i]);
		}
		Arrays.sort(arr,(ai1,ai2)-> (ai1.intValue-ai2.intValue));
		
		for(int i=0;i<n;i++) {
			charArray[i]=arr[i].charValue;
			
		}
		return charArray;
	}

}
/*
 * POJO to establish relation between int and char
 */
class Pair{
	int intValue;
	char charValue;
	public Pair(int in,char ch) {
		intValue=in;
		charValue=ch;
	}
}