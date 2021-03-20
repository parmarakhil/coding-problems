package sorting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Given an array print the elements in sorted order and also print index of element in original array 
 */
public class PrintIndexOfArrayAfterSorting {

	public static void main(String[] args) {
		int[] arr= {2,3,10,5,14,20};
		sortAndPrint(arr);
	}
	
	/*
	 * Sorts an array and print the value and index of original array
	 * @param arr array of int
	 */
	public static void sortAndPrint(int[] arr) {
		int n=arr.length;
		List<ArrayItem> list=new ArrayList<ArrayItem>();
		for(int i=0;i<n;i++)
			list.add(new ArrayItem(arr[i], i));
		// if you want to sort in reverse order then ai2.item-ai1.item
		Collections.sort(list,(ai1,ai2)-> (ai1.item-ai2.item));
		for(ArrayItem a:list) {
			System.out.println("item is "+a.item+" index is "+a.index);
		}
		
		
	}
	
}
/*
 * POJO for handling value and index efficiently
 */
class ArrayItem{
	int item;
	int index;
	public ArrayItem(int it,int inx) {
		index=inx;
		item=it;
	}
}
