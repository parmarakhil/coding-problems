package sorting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given an array of int, sort the array by frequency
 * If two elements have same frequency the smaller element should come first 
 */
public class SortElementsByFrequency {

	public static void main(String[] args) {
		int[] arr= {10,20,30,20,30};
		arr=sortListByFreq(arr);
		for(int i:arr) {
			System.out.println(i);
		}
	}
	/*
	 * Approach :
	 * create a hashmap of element and frequenct
	 * Create a list of map entries
	 * sort elements by key
	 * Modify original array using list
	 */
	public static int[] sortListByFreq(int[] arr) {
		Map<Integer, Integer> myMap=new HashMap<Integer,Integer>();
		for(int i:arr) myMap.put(i, myMap.getOrDefault(i, 0)+1);
		List<Map.Entry<Integer,Integer>> listEntry=new ArrayList<>(myMap.entrySet());
		Collections.sort(listEntry,new MyComparator());
		int index=0;
		for(Map.Entry<Integer, Integer> e:listEntry) {
			for(int i=0;i<e.getValue();i++) {
				arr[index++]=e.getKey();
			}
		}
		return arr;
	}
	
	
	
}
class MyComparator implements Comparator<Map.Entry<Integer, Integer>>{
	
	public int compare(Map.Entry<Integer, Integer> m1,Map.Entry<Integer, Integer> m2) {
		if(m1.getValue()==m2.getValue()) return m1.getKey()-m2.getKey();
		else {
			return m2.getValue()-m1.getValue();
		}
	}
}