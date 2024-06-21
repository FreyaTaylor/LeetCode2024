package src.LinkedList;

public class MyLinkedList {

    /**
     * https://leetcode.cn/problems/design-linked-list/
     */

    ListNode head;
    int size;
    public MyLinkedList() {
        head = new ListNode();
        size=0;
    }

    public int get(int index) {

        if(index>=size){
            return -1;
        }

        ListNode cur= head;
        for (int i = 0; i <= index; i++) {
            cur=cur.next;
        }
        return cur.val;

    }

    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    public void addAtTail(int val) {
        addAtIndex(size,val);
    }



    /**
     *  将一个值为 val 的节点插入到链表中下标为 index 的节点之前。
     *  如果 index 等于链表的长度，那么该节点会被追加到链表的末尾
     *  如果 index 比长度更大，该节点将 不会插入 到链表中。
     * @param index
     * @param val
     */
    public void addAtIndex(int index, int val) {

        if(index<=size){
            ListNode cur= head;
            for (int i = 0; i < index; i++) {
                cur=cur.next;
            }

            ListNode temp = new ListNode(val);
            temp.next=cur.next;
            cur.next=temp;
            size++;
        }

    }

    /**
     * void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。
     * @param index
     */
    public void deleteAtIndex(int index) {
        if(index<size){
            ListNode cur= head;
            for (int i = 0; i < index; i++) {
                cur=cur.next;
            }
            cur.next=cur.next.next;
            size--;
        }

    }


    public static void main(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(2);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.addAtTail(2);
        myLinkedList.addAtTail(7);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtTail(2);
        myLinkedList.addAtTail(5);
        myLinkedList.addAtTail(5);


        System.out.println(myLinkedList.get(5));              // 返回 2

        myLinkedList.deleteAtIndex(6);
        myLinkedList.deleteAtIndex(4);
    }
}
