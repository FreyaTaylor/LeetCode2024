package src.MutilThread;

import java.util.concurrent.atomic.AtomicInteger;

public class T1114_PrintInOrder {

}

class Foo {

        private AtomicInteger firstDone = new AtomicInteger(0);
        private AtomicInteger secondDone = new AtomicInteger(0);
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstDone.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.

        while (firstDone.get()!=1);
        printSecond.run();
        secondDone.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while (secondDone.get()!=1);
        printThird.run();
    }
}