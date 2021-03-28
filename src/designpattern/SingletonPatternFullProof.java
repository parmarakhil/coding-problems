package designpattern;

import java.io.Serializable;

/*
 * The Singleton approach discussed in SingletonPattern class has some issuse
 * The Singleton pattern can be broken using Reflection, Serialization and cloning*/
public class SingletonPatternFullProof {
	

}

/*
 * To overcome issue raised by reflection, enums are used because java ensures
 * internally that enum value is instantiated only once. Since java Enums are
 * globally accessible, they can be used for singletons. Its only drawback is
 * that it is not flexible i.e it does not allow lazy initialization. As enums
 * don’t have any constructor so it is not possible for Reflection to utilize
 * it. Enums have their by-default constructor, we can’t invoke them by ourself.
 * JVM handles the creation and invocation of enum constructors internally. As
 * enums don’t give their constructor definition to the program, it is not
 * possible for us to access them by Reflection also. Hence, reflection can’t
 */
enum SingletonClass {
	INSTANCE;
}

/*
 * Suppose you serialize an object of a singleton class. Then if you
 * de-serialize that object it will create a new instance and hence break the
 * Singleton property To Solve the issue we override readResolve method
 * 
 * Another way of breaking the singleton property is through clone method As
 * clone returns a copy of an object if we clone a singleton class we will have
 * two copy of class hence singleton is broken
 * TO solve the issue we override the clone method and either return same instance
 * or throw CloneNotSupportedException
 */
class SingletonPattern implements Serializable, Cloneable {

	// public instance initialized when loading the class
	public static SingletonPattern instance = new SingletonPattern();

	private SingletonPattern() {

	}

	// TO solve singleton property breaking due to serialization
	protected Object readResolve() {
		return instance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return instance;
	}
}

