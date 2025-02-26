class Counter{
    //int count = 0;
    int count;
    synchronized  void increment(){
        count++;
    }
}
public class Sychronizedthread {
    public static void main(String[] args) throws Exception {
        Counter counter = new Counter();
        Thread t1 = new Thread(new Runnable(){
            public void run(){
                for(int i=0; i<10000; i++){
                    counter.increment();
                }
            }
        } );


        Thread t2 = new Thread(new Runnable(){
            public void run(){
                for(int i=0; i<10000; i++){
                    counter.increment();
                }
            }
        });

        
        t1.start();
        t1.join();
        t2.start();
        t2.join();   ////////////Main thread ke wait korar jonno , Main thread jate count er value age i print na kore
        
        System.out.println("Count "+counter.count);
    }
}