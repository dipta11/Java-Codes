import java.util.Scanner;
import java.lang.Thread;
import java.io.*;
class Mythread extends Thread {
    Mythread(String s){
        super(s);
    }
    public void run() {
        for(int i=0;i<100;i++){
            System.out.println("Hello Guys!");
        }
    }
}
class Mythreda2 extends Thread{
    Mythreda2(String s){
        super(s);
    }
    public void run(){
        for(int i=0;i<100;i++)
        System.out.println("Hello Girls");
    }
}
public class Threading{
        public static void main(String[] args){
        Thread t1 = new Mythread("Malda");
        Thread t2 = new Mythreda2("Ghashkata");
        //t1.setPriority(Thread.MAX_PRIORITY);
      System.out.println(t1.getName());
      System.out.println(t2.getName());
      System.out.println(t1.isAlive());
     
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        System.out.println(t1.getState());
        try{
            t2.sleep(500);
        }catch(Exception e){
            e.printStackTrace();
        }
        t2.start();
        }
    }
