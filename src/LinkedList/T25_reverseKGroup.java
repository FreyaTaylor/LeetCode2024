package src.LinkedList;

public class T25_reverseKGroup {

    /**
     * https://leetcode.cn/problems/reverse-nodes-in-k-group/
     */

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode hhead = new ListNode();
        hhead.next=head;

        ListNode preTail=hhead;
        ListNode tail=head;
        ListNode nextTail;
        ListNode cur;
        int count=0;
        while (true){
            cur=tail;
            count=1;
            while (cur!=null && count<k){
                cur=cur.next;
                count++;
            }

            if(cur==null){
                break;
            }

            nextTail=cur.next;

            for (int i = 0; i < k-1; i++) {
                cur=tail.next;
                tail.next=tail.next.next;
                cur.next=preTail.next;
                preTail.next=cur;
//                ListNode.display(hhead.next);
            }
            preTail=tail;
            tail=nextTail;
//            ListNode.display(hhead.next);



        }


        return hhead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1,2,3,4});
        ListNode.display(head);
        ListNode.display(new T25_reverseKGroup().reverseKGroup(head,2));
    }

}
