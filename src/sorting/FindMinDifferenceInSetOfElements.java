package sorting;
import java.util.Arrays;

/*
 * Given an array of n elements find min difference of sub array of K elements
 *  
 */
public class FindMinDifferenceInSetOfElements {

	public static void main(String[] args) {
		int[] arr= {4,2,5,7,11,10,9};
		int k=3;
		System.out.println(minDifferenceInKSubArray(arr, k));
	}
	
	/*
	 * method to find min difference of elements in subarray of arr with length K
	 * @param arr main integer arr
	 * @param K length of sub array 
	 */
	public static int minDifferenceInKSubArray(int[] arr,int K) {
		/*
		 * Approach:
		 * Since we need to find minimum difference, we will sort the array in ascending order 
		 * now closet element will always be minimum 
		 */
		// if K is greater than arr length then we can't have sub array
		if(K>arr.length) return Integer.MAX_VALUE;
		Arrays.sort(arr);
		int res=arr[K-1]-arr[0];
		for(int i=0; (i+K-1)<arr.length;i++)
			res=Math.min(res, (arr[i+K-1]-arr[i]));
		return res;
	
	}
	
	
}
