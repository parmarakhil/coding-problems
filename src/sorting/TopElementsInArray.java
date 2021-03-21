package sorting;

import java.util.*;
public class TopElementsInArray {

	public static void main(String[] args) {
		int[] arr= {1,20,5,30,50,30,50,100,20};
		int K=3;
		int[] output=(topKElements(arr, K));
		for(int i:output) System.out.println(i);
	}
	public static int[] topKElements(int[] arr, int K) {
		int[] result=new int[K];
		Map<Integer, Integer> myMap=new TreeMap<>(Collections.reverseOrder());
		for(int i=0;i<arr.length;i++) {
			myMap.put(arr[i], i);
			
		}
		int index=0;
		for(Integer key:myMap.keySet()) {
			System.out.println("key is "+key);
			result[index]=myMap.get(key);
			index++;
			if (index==3) break;
		}
		return result;
	}
}
