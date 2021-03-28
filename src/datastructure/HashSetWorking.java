package datastructure;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

/*
 * A demo implementation of hashset
 * Have added add and addAll method. Rest all methods of hashSet will be inherited from hashSet class*/
class HashSetDemo<E> extends HashSet<E> implements Serializable,Cloneable{
	
	/**
	 * This is serial id
	 */
	private static final long serialVersionUID = -2880885467234516107L;
	private static final Object PRESENT=new Object();;
	private  HashMap<E,Object> myHashMap;
	public HashSetDemo() {
		myHashMap=new HashMap<>();
		
	}
	
	public HashSetDemo(int initialCapacity) {
		myHashMap=new HashMap<>(initialCapacity);
	}
	
	public HashSetDemo(int initialCapacity, float loadFactor) {
		myHashMap=new HashMap<>(initialCapacity,loadFactor);
	}
	public HashSetDemo(Collection<? extends E> c) {
		myHashMap = new HashMap<>(Math.max((int) (c.size()/.75f) + 1, 16));
        addAll(c);
    }
	@Override
	public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        for (E e : c)
            if (add(e))
                modified = true;
        return modified;
    }
	@Override
	public boolean add(E e) {
        return myHashMap.put(e, PRESENT)==null;
    }
	
	/**
     * Returns a shallow copy of this {@code HashSetDemo} instance: the elements
     * themselves are not cloned.
     *
     * @return a shallow copy of this set
     */
  
	@SuppressWarnings("unchecked")
    @Override
    public Object clone() {
        
		HashSetDemo<E> newSet = (HashSetDemo<E>) super.clone();
		newSet.myHashMap = (HashMap<E, Object>) myHashMap.clone();
		return newSet;
    }
	

}
public class HashSetWorking{
	
	public static void main(String[] args) {
		HashSetDemo<Integer> myDemoClass= new HashSetDemo<>();
		System.out.println(myDemoClass.add(1));
		System.out.println(myDemoClass.add(1));
		myDemoClass.remove(1);
		System.out.println(myDemoClass.size());
		
	}
}
