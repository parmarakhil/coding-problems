package sorting;
import java.util.Arrays;

/*
 * Given two array having 1:1 correspondence between each other
 * Sort the array based on one array and display sorted data
 * Eg: sort student by marks 
 */
public class SortObjectByAttribute {

	public static void main(String[] args) {
		int[] rollNos= {1,2,4,3};
		int[] marks= {12,34,10,24};
		printStudentByMarks(rollNos, marks);
	}
	
	/*
	 * static method to sort student based on marks
	 * @param rollNos array of int roll numbers
	 * @param marks array of int marks
	 */
	public static void printStudentByMarks(int[] rollNos,int[] marks) {
		int n=rollNos.length;
		Student[] arr=new Student[n];
		for(int i=0;i<n;i++) arr[i]=new Student(rollNos[i],marks[i]);
		Arrays.sort(arr,(e1,e2)->(e1.marks-e2.marks));
		for(Student s:arr) {
			System.out.println(" student rollNo is "+s.rollNo+" marks is "+s.marks);
		}
			
	}
}
class Student{
	int rollNo;
	int marks;
	public Student(int roll, int mark) {
		rollNo=roll;
		marks=mark;
	}
}