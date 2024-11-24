package src.LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class T23_mergeKLists_noNeed {

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode hhead = new ListNode();
        ListNode cur=hhead;
        PriorityQueue<ListNode> q = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });

        for (ListNode list : lists) {
            if(list!=null){
                q.add(list);
            }
        }

        while (!q.isEmpty()){
            ListNode small=q.poll();

            if(small.next!=null){
                q.add(small.next);
            }
            cur.next=small;
            cur=cur.next;
        }


        return hhead.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next=new ListNode(1);
        head1.next.next=new ListNode(4);

        ListNode head2 = new ListNode(1);
        head2.next=new ListNode(2);
        head2.next.next=new ListNode(6);
        head2.next.next.next=new ListNode(7);

        ListNode[] lists = new ListNode[]{head1,head2};

        ListNode res=new T23_mergeKLists_noNeed().mergeKLists(lists);
        ListNode.display(res);


    }
}
