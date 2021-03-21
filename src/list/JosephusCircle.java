package list;

import java.util.Iterator;
import java.util.LinkedList;

public class JosephusCircle {
	
	public static void main(String[] args) {
		System.out.println(josephus(10, 3));
	}
	public static int josephus(int n, int k)
	{
	    LinkedList<Integer> ll=new LinkedList<Integer>();
	    for(int i=0;i<n;i++) ll.add(i);
	    Iterator<Integer> it=ll.iterator();
	    while(ll.size()>1){
	        int count=0;
	        while(count<k){
	            while(it.hasNext() && count<k){
	                count++;
	                it.next();
	            }
	            if(count<k){
	                it=ll.iterator();
	                it.next();
	                count++;
	            }
	        }
	        it.remove();
	    }
	    return ll.getFirst();
	}

}
