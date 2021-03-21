package list;

import java.util.ArrayList;

/*
 * Given an ArrayList<ArrayList<Integer>> find the min sum of elements in vertical order
 * eg:
 * 1
 * 2 3
 * 3 4 5
 * 6 5 6 1
 * here vertical sums are 12, 12, 11,1 hence min is 1*/
public class MinVerticalSum {
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> list=new ArrayList<>();
		ArrayList<Integer> l1=new ArrayList<>();
		l1.add(1);
		list.add(l1);
		ArrayList<Integer> l2=new ArrayList<>();
		l2.add(2);
		l2.add(3);
		list.add(l2);
		ArrayList<Integer> l3=new ArrayList<>();
		l3.add(3);
		l3.add(4);
		l3.add(5);
		list.add(l3);
		ArrayList<Integer> l4=new ArrayList<>();
		l4.add(6);
		l4.add(5);
		l4.add(6);
		l4.add(1);
		list.add(l4);
		System.out.println(minimumVerticalSum(list));
	}

	public static int minimumVerticalSum(ArrayList<ArrayList<Integer>> arr)
	{
	    //Your code here
	    int maxCol = 0;
	    for(int i = 0; i < arr.size(); i++)
	    {
	        maxCol = Math.max(maxCol, arr.get(i).size());
	    }
	    
	    int verSum = Integer.MAX_VALUE;
	    for(int i = 0; i < maxCol; i++)
	    {
	        int colSum = 0;
	        for(int j = 0; j < arr.size(); j++)
	        {
	            if(i < arr.get(j).size())
	            {
	                colSum += arr.get(j).get(i);
	            }
	        }
	        
	        verSum = Math.min(verSum, colSum);
	    }
	    return verSum;
	}
}
