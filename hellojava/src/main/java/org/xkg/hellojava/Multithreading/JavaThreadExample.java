package org.xkg.hellojava.Multithreading;

/**
 * @author : Xiangkui Guo
 * @date : 2018/12/29
 */
public class JavaThreadExample {

    public static void main(String args[]){
        System.out.println(Thread.currentThread().getName());
        Multi1 t1=new Multi1();
        t1.start();

        try{
//  The join() method waits for a thread to die. In other words, it causes the currently running threads to stop executing
// until the thread it joins with completes its task.
            t1.join();
        }catch(Exception e){System.out.println(e);}

        Multi2 m = new Multi2();
        Thread t2 =new Thread(m);
        t2.start();

        try {
            t2.join();
        }catch(Exception e){System.out.println(e);}


        TestMultiPriority1 m1=new TestMultiPriority1();
        TestMultiPriority1 m2=new TestMultiPriority1();
        m1.setPriority(Thread.MIN_PRIORITY);
        m2.setPriority(Thread.MAX_PRIORITY);
        m1.start();
        m2.start();
    }
}

class Multi1 extends Thread{
    public void run(){
        System.out.println(Thread.currentThread().getName());
        System.out.println("Thread thread is running...");
        for(int i=1;i<5;i++){
            try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
            System.out.println("Thread "+i);
        }
    }

}


class Multi2 implements Runnable{
    public void run(){
        System.out.println(Thread.currentThread().getName());
        System.out.println("Runnable thread is running...");
        for(int i=1;i<5;i++){
            try{Thread.sleep(200);}catch(InterruptedException e){System.out.println(e);}
            System.out.println("Runnable "+i);
        }
    }
}

class TestMultiPriority1 extends Thread {
    public void run() {
        System.out.println("running thread name is:" + Thread.currentThread().getName());
        System.out.println("running thread priority is:" + Thread.currentThread().getPriority());
    }
}
