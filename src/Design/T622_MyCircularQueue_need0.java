package src.Design;

public class T622_MyCircularQueue_need0 {

    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
        circularQueue.enQueue(1);  // 返回 true
        circularQueue.enQueue(2);  // 返回 true
        circularQueue.enQueue(3);  // 返回 true
        circularQueue.enQueue(4);  // 返回 false，队列已满
        System.out.println(circularQueue.Rear());;  // 返回 3
        circularQueue.isFull();  // 返回 true
        circularQueue.deQueue();  // 返回 true
        circularQueue.enQueue(4);  // 返回 true
        System.out.println(circularQueue.Rear());;  // 返回 4
    }


}


/**
 * https://leetcode.cn/problems/design-circular-queue/description/
 * 注意区分 isEmpty isFull 需要多一个位置，不然两个状态时一样的
 */
class MyCircularQueue {

    int[] q;
    int k;
    int head;
    int tail;
    public MyCircularQueue(int k) {
        q = new int[k+1];
        this.k=k;
        head=0;
        tail=0;
    }

    public boolean enQueue(int value) {
        if(!isFull()){
            q[tail]=value;
            tail=(tail+1)%(k+1);
            return true;
        }
        return false;
    }

    public boolean deQueue() {
        if(!isEmpty()){
            head=(head+1)%(k+1);
            return true;
        }
        return false;
    }

    public int Front() {
        if(!isEmpty()){
            return q[head];
        }
        return -1;
    }

    public int Rear() {
        if(!isEmpty()){
            return q[(tail+k)%(k+1)];
        }
        return -1;
    }

    public boolean isEmpty() {
        if(head==tail){
            return true;
        }
        return false;
    }

    public boolean isFull() {

        if((tail+1)%(k+1)==head){
            return true;
        }
        return false;
    }
}