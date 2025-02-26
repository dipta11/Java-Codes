 class Q {
     int num;
     boolean valueset = false;
     synchronized public void put(int num) {
         while(valueset) {
             try{
                 wait();
             }catch(InterruptedException e) {e.printStackTrace();}
         }
         System.out.println("Put " + num);
         this.num = num;
         valueset = true;
         notify();
     }

     synchronized public void get(int num) {
         while(!valueset){
             try{wait();}
             catch(InterruptedException e) {e.printStackTrace();}
         }
         System.out.println( "Get " +num);
         valueset = false;
         notify();
     }
 }
    class Producer implements Runnable{
        Q  q;
        Producer(Q q) {
            this.q = q;
        }
        public void run(){
            int i=0;
            while(true) {
                q.put(i++);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
     class Consumer implements Runnable{
        Q q ;
        Consumer (Q q){
            this.q = q;
        }
         public void run(){
             int i=0;
             while(true) {
                 q.get(i++);
                 try {
                     Thread.sleep(1000);
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
             }
         }
     }

    public class InterThread  {

    public static void main(String[] args) {
        Q sharedq = new Q();
        Consumer c = new Consumer(sharedq);
        Thread t1 = new Thread(c,"Consumer thread");

        Producer p = new Producer(sharedq);
        Thread t2 = new Thread(p,"produced thread");
        
        t1.start();
        t2.start();
    }
}