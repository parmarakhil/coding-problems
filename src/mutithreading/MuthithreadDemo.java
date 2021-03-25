package mutithreading;

 class MultithreadDemo1 implements Runnable{
	 
	 Thread guruthread;
	 private String guruname;
	 MultithreadDemo1(String name) {
	  guruname = name;
	 }
	 @Override
	 public void run() {
	  System.out.println("Thread running" + guruname);
	  for (int i = 0; i < 4; i++) {
	   System.out.println(i);
	   System.out.println(guruname);
	   try {
	    Thread.sleep(1000);
	   } catch (InterruptedException e) {
	    System.out.println("Thread has been interrupted");
	   }
	  }
	 }
	 public void start() {
	  System.out.println("Thread started");
	  if (guruthread == null) {
	   guruthread = new Thread(this, guruname);
	   guruthread.start();
	  }
	 
	 }

}
 public class MuthithreadDemo{
	 public static void main(String[] args) {
		 MultithreadDemo1 threadguru1 = new MultithreadDemo1("guru1");
		  threadguru1.start();
		  MultithreadDemo1 threadguru2 = new MultithreadDemo1("guru2");
		  threadguru2.start();
	    }
 }
