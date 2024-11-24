package src.LinkedList;

import java.util.Queue;

public class T142_detectCycle {
    /**
     * https://leetcode.cn/problems/linked-list-cycle-ii/description/
     *
     * (a+b)*2=a+b+c+b
     * a=c
     * => slow:(a+b)+c=cur:a
     *         ListNode slow=head.next;
     *         ListNode quick=head.next;
     *         if(quick!=null){
     *             quick =slow.next;
     *         }
     */
    public ListNode detectCycle(ListNode head) {
        if(head==null){
            return null;
        }

        // 初始化注意：slow=head.next; quick=head.next.next;
        ListNode slow=head.next;
        ListNode quick=head.next;
        if(quick!=null){
            quick =slow.next;
        }

        while (quick!=null){
            if(quick==slow){ // (a+b)*2=a+b+c+b
                ListNode cur = head;
                while (slow!=cur){ //slow:(a+b)+c=cur:a
                    slow=slow.next;
                    cur=cur.next;
                }
                return slow;
            }

            slow=slow.next;
            quick=quick.next;
            if(quick!=null){
                quick=quick.next;
            }

        }

        return null;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        node.next=new ListNode(2);
        node.next.next=new ListNode(0);
        node.next.next.next=new ListNode(-4);
        node.next.next.next.next=node.next;

        System.out.println(new T142_detectCycle().detectCycle(node));

    }


}
