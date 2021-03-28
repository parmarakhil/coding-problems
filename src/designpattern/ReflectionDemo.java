package designpattern;


import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.Constructor;

public class ReflectionDemo {
	public static void main(String args[]) throws Exception
    {
        // We check property of the MyClass Object
    	MyClass obj = new MyClass();
  
        // Creating class object from the object using
        // getclass method
        Class clazz = obj.getClass();
        System.out.println("The name of class is " +
                            clazz.getName());
  
        // Getting the constructor of the class through the
        // object of the class
        Constructor constructor = clazz.getConstructor();
        System.out.println("The name of constructor is " +
                            constructor.getName());
  
        System.out.println("The public methods of class are : ");
  
        // Getting methods of the class through the object
        // of the class by using getMethods
        Method[] methods = clazz.getMethods();
  
        // Printing method names
        for (Method method:methods)
            System.out.println(method.getName());
  
        // creates object of desired method by providing the
        // method name and parameter class as arguments to
        // the getDeclaredMethod
        Method methodcall1 = clazz.getDeclaredMethod("getAge",
                                                 int.class);
  
        // invokes the method at runtime
        methodcall1.invoke(obj, 25);
  
        // creates object of the desired field by providing
        // the name of field as argument to the 
        // getDeclaredField method
        Field field = clazz.getDeclaredField("name");
  
        // allows the object to access the field irrespective
        // of the access specifier used with the field
        // here we will be able to access private attribute of MyClass
        field.setAccessible(true);
  
        // takes object and the new value to be assigned
        // to the field as arguments
        field.set(obj, "Akhil Singh");
  
        // Creates object of desired method by providing the
        // method name as argument to the getDeclaredMethod
        Method methodcall2 = clazz.getDeclaredMethod("getName");
  
        // invokes the method at runtime
        methodcall2.invoke(obj);
  
        // Creates object of the desired method by providing
        // the name of method as argument to the 
        // getDeclaredMethod method
        Method methodcall3 = clazz.getDeclaredMethod("getConfidentialData");
  
        // allows the object to access the method irrespective 
        // of the access specifier used with the method
        // here we will able to access private method
        methodcall3.setAccessible(true);
  
        // invokes the method at runtime
        methodcall3.invoke(obj);
    }
}

  
// Class whose object will be created
class MyClass
{
    //  a private field
    private String name;
  
    // a public constructor
    public MyClass()  {  name = "Akhil"; }
  
    // a public method to get name
    public void getName()  {
        System.out.println("The name is " + name);
    }
  
    // a public method to getAge with int age as argument
    public void getAge(int age)  {
        System.out.println("The age is " + age);
    }
  
    // a private method to get confidential data
    private void getConfidentialData() {
        System.out.println("This is a confidential data");
    }
}
