class Resource {
    synchronized void methodA(Resource r) {
        System.out.println(Thread.currentThread().getName() + " locked methodA");

        try { Thread.sleep(100); } catch (InterruptedException e) {}

        System.out.println(Thread.currentThread().getName() + " trying to call methodB");
        r.methodB(this); // Calls methodB of another object
    }

    synchronized void methodB(Resource r) {
        System.out.println(Thread.currentThread().getName() + " locked methodB");

        try { Thread.sleep(100); } catch (InterruptedException e) {}

        System.out.println(Thread.currentThread().getName() + " trying to call methodA");
        r.methodA(this); // Calls methodA of another object
    }
}

class MyThread1 extends Thread {
    Resource r1, r2;

    MyThread1(Resource r1, Resource r2) {
        this.r1 = r1;
        this.r2 = r2;
    }

    public void run() {
        r1.methodA(r2);
    }
}

class MyThread2 extends Thread {
    Resource r1, r2;

    MyThread2(Resource r1, Resource r2) {
        this.r1 = r1;
        this.r2 = r2;
    }

    public void run() {
        r2.methodB(r1);
    }
}

public class Practice {
    public static void main(String[] args) {
        Resource r1 = new Resource();
        Resource r2 = new Resource();

        MyThread1 t1 = new MyThread1(r1, r2);
        MyThread2 t2 = new MyThread2(r1, r2);

        t1.start();
        t2.start();
    }
}


 

