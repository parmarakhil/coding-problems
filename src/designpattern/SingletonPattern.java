package designpattern;

public class SingletonPattern {

}

/*
 * The Singleton class It is a creational design pattern A singleton pattern is
 * a design pattern which restricts a class to instantiate its multiple objects
 * This class is designed in such a way that only one instance of a class is
 * created in complete execution of program or project They are used for logging
 * , driver objects, caching and thread pools, database connections
 * java.lang.Runtime and java.awt.Desktop are 2 singleton classes provided by
 * JVM.
 */
class Singleton {

	/*
	 * Here it is a lazy initialization If we need eager initialization then instead
	 * of null you pass initialization and don't initialized at other places
	 * 
	 * We have declared the instance volatile which ensures that multiple threads offer
	 * the instance variable correctly when it is being initialized to Singleton
	 * instance.
	 */
	private static volatile Singleton instance = null;

	private Singleton() {
		System.out.println(
				" this is a private constructor. It will never be called publicly. Also will be called only once privately");
	}

	/*
	 * If the class is used in muti-threaded environment it will give issues if not
	 * synchronized. if synchronized is used in method declaration issue is that
	 * using synchronized every time while creating the singleton object is
	 * expensive and may decrease the performance of your program
	 * 
	 * The best solution is "Double checked locking" once an object is created
	 * synchronization is no longer useful because now instance will not be null and
	 * any sequence of operations will lead to consistent results. So we will only
	 * acquire lock on the getInstance() once, when the instance is null. This way
	 * we only synchronize the first way through, just what we want.
	 */
	public Singleton getInstance() {
		if (instance == null) {
			// To make thread safe
			synchronized (this) {
				if (instance == null)
					instance = new Singleton();
			}
		}

		return instance;
	}

}
