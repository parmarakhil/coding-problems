package mutithreading;

public class TeacherStudentNotify {
	public static void main(String[] args) {
		Student student1=new Student();
		Student student2=new Student();
		Teacher teacher1=new Teacher(student1);
		Teacher teacher2=new Teacher(student2);
		Principal principal=new Principal();
		
		Thread t1=new Thread(student1,"akhil");
		Thread t2=new Thread(student2,"akki");
		Thread t3=new Thread(teacher1,"maths-teacher");
		Thread t4=new Thread(teacher2," science teacher");
		Thread t5=new Thread(principal,"head-master");

		t1.start();
		t3.start();
		
		t2.start();
		t4.start();
		
		t5.start();
	}

}
class Student extends Thread{
	
	public void run() {
		synchronized (this) {
			try {
				System.out.println(" I am a student with name "+Thread.currentThread().getName()+" I am going to wait");
				this.wait();
				
				notify();
				System.out.println(" I am notifed by my teacher");
			} catch (InterruptedException e) {
				
				
				e.printStackTrace();
			}
			System.out.println("student with thread "+Thread.currentThread().getName()+" is notified");
		}
	}
}
class Teacher extends Thread{
	Student student;
	Teacher(Student student) {
		this.student=student;
	}
	public void run() {
		synchronized (this.student) {
			printMe();
			this.student.notify();
			System.out.println("successfully notified student");
		}
	}
	public void printMe() {
		System.out.println(" I am teacher with name "+Thread.currentThread().getName());
	}
}

class Principal extends Thread{
	public Principal() {
		
	}
	public void run() {
		synchronized (this) {
			printMe();
			System.out.println("let me notify all student ");
			notifyAll();
			System.out.println("successfully notified all student");
		}
	}
	public void printMe() {
		System.out.println(" I am principal with name "+this.currentThread().getName());
	}
}