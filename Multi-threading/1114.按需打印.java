class Foo {
    public Foo() {}
    volatile int i = 1;
    
    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        i = 2;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(i != 2) ; // wait
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        i = 3;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(i != 3); // wait
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        i = 1;
    }
}

// 锁信号量
import java.util.concurrent.Semaphore;
class Foo {
    public Semaphore s1 = new Semaphore(0);
    public Semaphore s2 = new Semaphore(0);
    
    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        s1.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        s1.acquire();
        printSecond.run();
        s2.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        s2.acquire();
        printThird.run();
    }
}

// 构造2道屏障，second 线程等待 first 屏障，third 线程等待 second 屏障。
// first 线程会释放 first 屏障，而 second 线程会释放 second 屏障。
class Foo {
    
    private boolean firstFinished;
    private boolean secondFinished;
    private Object lock = new Object();

    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        synchronized (lock) {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            firstFinished = true;
            lock.notifyAll(); 
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        synchronized (lock) {
            while (!firstFinished) {
                lock.wait();
            }
        
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            secondFinished = true;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        synchronized (lock) {
           while (!secondFinished) {
                lock.wait();
            }

            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        } 
    }
}


