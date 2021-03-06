package streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * Given an object. How to group them on basis of an attribute of object using stream
 * To achieve this we use groupingBy method of Collectors class.
 * Input of the method will be grouping key*/

public class Grouping {
	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		
		Map<String,List<Employee>> myMap=employeeList.stream().collect(Collectors.groupingBy(Employee::getGender));
		for (Map.Entry<String,List<Employee>> entry : myMap.entrySet())
			System.out.println(entry.getKey()+" are "+entry.getValue().size());
		
		employeeList.stream().map(e-> e.age).filter(new A()::isFalse);
		List<Employee> sortedList=employeeList.stream().sorted((ele1,ele2) -> ele1.getAge()-ele2.getAge()).collect(Collectors.toList());
		for(Employee e:sortedList) {
			System.out.println(e.getAge());
		}
	}
}
class A 
{

	public boolean isFalse(Integer o) {
		
		return false;
	}
}
