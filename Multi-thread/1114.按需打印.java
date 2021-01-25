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
