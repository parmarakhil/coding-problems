package mutithreading;

class Notify1 extends Thread   
{  
    public void run()  
    {  
        synchronized(this)  
        {  
            System.out.println("Starting of notify 1" + Thread.currentThread().getName());  
            try {  
                this.wait(); 
//                notify();
            }  
            catch (InterruptedException e) {  
                e.printStackTrace();}  
            System.out.println(Thread.currentThread().getName() + " at notify 1...notified");  
        }  
    }  
}  
class Notify2 extends Thread {  
    Notify1 notify1;  
    Notify2(Notify1 notify1)  
    {  
        this.notify1 = notify1;  
    }  
    public void run()  
    {  
        synchronized(this.notify1)  
        {  
            System.out.println("Starting of notify 2" + Thread.currentThread().getName());  
            try {  
                this.notify1.wait();  
            }  
            catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
            System.out.println(Thread.currentThread().getName() + "...notified");  
        }  
    }  
}   
class Notify3 extends Thread   
{  
    Notify1 notify1;  
    Notify3(Notify1 notify1)  
    {  
        this.notify1 = notify1;  
    }  
    public void run()  
    {  
        synchronized(this.notify1)  
        {  
            System.out.println("Starting of notify 3" + Thread.currentThread().getName());  
            // call the notify() method  
            this.notify1.notify();  
            System.out.println(Thread.currentThread().getName() + " at notify 3...notified");  
        }  
    }  
}  
class Notify4 extends Thread   
{  
    Notify2 notify2;  
    Notify4(Notify2 notify2)  
    {  
        this.notify2 = notify2;  
    }  
    public void run()  
    {  
        synchronized(this.notify2)  
        {  
            System.out.println("Starting of notify 4" + Thread.currentThread().getName());  
            // call the notify() method
            System.out.println("I am notifying 2");
            this.notify2.notify();  
            System.out.println("done my part");
            System.out.println(Thread.currentThread().getName() + " at notify 3...notified");  
        }  
    }  
}  
public class JavaNotifyExp   
{  
    public static void main(String[] args) throws InterruptedException  
    {  
        Notify1 notify1 = new Notify1();  
//        Notify2 notify2 = new Notify2(notify1);  
        Notify3 notify3 = new Notify3(notify1); 
//        Notify4 notify4 = new Notify4(notify2);
          
        // creating the threads   
        Thread t1 = new Thread(notify1, "Thread-1");  
//        Thread t2 = new Thread(notify2, "Thread-2");  
        Thread t3 = new Thread(notify3, "Thread-3");
//        Thread t4=new Thread(notify4,"Thread-4");
          
        // call run() method  
//        t4.start();
        t1.start();  
//        t2.start();  
        System.out.println("calling sleep");
        Thread.sleep(100);  
        System.out.println("thread 3 to be called");
        t3.start();  
    }  
}  
