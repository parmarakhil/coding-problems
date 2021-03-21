package sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given an array of int, sort the array by frequency
 * If two elements have same frequency then element which appeared first should come first 
 * solution in linear time
 */
public class SortElementsByFreq {

	public static void main(String[] args) {
		int[] arr= {1,2,3,2,3};
//		arr=normalSortingByFreq(arr);
		arr=sortingByFreqInAppearOrder(arr);
		for(int i:arr) System.out.println(i);
	}
	
	/*
	 * This method doesn't care about order of values in case of a tie
	 * 
	 */
	public static int[] normalSortingByFreq(int[] arr) {
		Map<Integer,Integer> myMap=new HashMap<Integer, Integer>();
		for(int i:arr) myMap.put(i, myMap.getOrDefault(i, 0)+1);
		List<List<Integer>> freq =new ArrayList<>();
		int n=arr.length;
		//Created list of frequencies from 0 to arr length hence n=length loop
		for(int i=0;i<=n;i++)freq.add(new ArrayList<Integer>());
		//add data in freq in order of 
		// element with 0 freq are at 0th position
		// element with 1 freq are at 1st position
		// here each element is a list
		for(Map.Entry<Integer, Integer> e:myMap.entrySet()) freq.get(e.getValue()).add(e.getKey());
		int index=0;
		for(int i=n;i>0;i--) {
			for(int x:freq.get(i)) {
				for(int j=0;j<i;j++) {
					arr[index++]=x;
				}
			}
		}
		return arr;
		
	}
	
	/*
	 * This method maintains order of element in array incase of tie
	 * 
	 */
	public static int[] sortingByFreqInAppearOrder(int[] arr) {
		Map<Integer,Integer> myMap=new HashMap<Integer, Integer>();
		for(int i:arr) myMap.put(i, myMap.getOrDefault(i, 0)+1);
		List<List<Integer>> freq =new ArrayList<>();
		int n=arr.length;
		//Created list of frequencies from 0 to arr length hence n=length loop
		for(int i=0;i<=n;i++)freq.add(new ArrayList<Integer>());
		// To maintain order, traverse original array
		// We mark element freq as -1 once it is traversed
		for(int i=0;i<n;i++) {
			int f=myMap.get(arr[i]);
			if(f!=-1) {
				freq.get(f).add(arr[i]);
				myMap.put(arr[i], -1);
			}
		}
		int index=0;
		for(int i=n;i>0;i--) {
			for(int x:freq.get(i)) {
				for(int j=0;j<i;j++) {
					arr[index++]=x;
				}
			}
		}
		return arr;
		
	}
}
