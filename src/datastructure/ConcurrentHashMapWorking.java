package datastructure;

import java.util.concurrent.ConcurrentHashMap;

/*
 * In a multi-threaded environment we can get issues when using a map 
 * eg: two thread try to add a same new object at a time
 * To solve this we have HashTable and ConcurrentHashMap
 * Issue with HashTable is that it is fully syncronized i.e whole collection is locked hence operations are slow
 * In java 1.5 ConcurrentHashMap was introduced.
 * Advantage is that it has syncronized operations for add and update methods, get methods are not syncronized hence it is fast
 * Note: */
public class ConcurrentHashMapWorking {

	public static void main(String[] args) {
		ConcurrentHashMap<Integer, Integer> concMap=new ConcurrentHashMap<>();
	}
}
