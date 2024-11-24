package src.LinkedList;

import java.util.ArrayDeque;
import java.util.Deque;

public class T143_reorderList {

    /**
     * https://leetcode.cn/problems/reorder-list/description/
     * @param head
     */

    public void reorderList(ListNode head) {

        int n = 0;
        ListNode cur = head;
        while (cur!=null){
            cur=cur.next;
            n++;
        }
        int swapLen=(n-1)/2;

        cur = head;
        Deque<ListNode> q = new ArrayDeque<>();
        int count=0;
        while (count<swapLen){
            q.addLast(cur);
            cur=cur.next;
            count++;
        }

        for (int i = 0; i < n-2*swapLen-1; i++) {
            cur=cur.next;
        }

        ListNode tail = cur.next;
        cur.next=null;


        ListNode tail_next=tail;
        while (!q.isEmpty()){
            tail=tail_next;
            tail_next=tail.next;
            cur=q.removeLast();

            tail.next=cur.next;
            cur.next=tail;


//            System.out.println();
        }

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1,2,3,4,5});
        ListNode.display(head);
        new T143_reorderList().reorderList(head);
        ListNode.display(head);
    }



}
