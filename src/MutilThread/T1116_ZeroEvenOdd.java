package src.MutilThread;

import java.util.function.IntConsumer;

public class T1116_ZeroEvenOdd {
}


class ZeroEvenOdd {
    private int n;
    private volatile int curNum=1;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <=n ; i++) {
            synchronized (this){
                while (curNum%2==0){wait();}
                printNumber.accept(0);
                curNum++;
                notifyAll();

            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <=n ; i+=2) {
            synchronized (this){
                while (curNum%4!=2){wait();}
                printNumber.accept(curNum/2);
                curNum++;
                notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <=n ; i+=2) {
            synchronized (this){
                while (curNum%4!=0){wait();}
                printNumber.accept(curNum/2);
                curNum++;
                notifyAll();
            }
        }
    }
}