package src.LinkedList;

public class T25_reverseKGroup_2 {

    /**
     * https://leetcode.cn/problems/reverse-nodes-in-k-group/
     *
     * 每次循环，要更新，下一个循环依赖的那个节点！
     */

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode hhead = new ListNode();
        hhead.next=head;


        ListNode cur=hhead;
        int count=0;

        ListNode node0=null;
        ListNode node4=null;

        ListNode node0Next=hhead; //分段处理，必须向下传递上一段的末尾


        while (true){
            node0=node0Next;
            node0Next=node0.next;

            // 找 3，4
            count=0;
            cur=node0;
            while (count<k && cur!=null){
                count++;
                cur=cur.next;
            }
            if(cur==null){
                break;
            }
            node4=cur.next;

            // 1 2 3 做头插
            ListNode tail=node4;
            count=0;
            ListNode next=node0.next; //头插，要传递 cur，因此需要next
            while (count<k){
                count++;
                cur=next;
                next=cur.next;

                cur.next=tail;
                tail=cur;
            }
            // 结尾，需要处理0 3
            node0.next=cur;
        }

        return hhead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1,2,3,4});
        ListNode.display(head);
        ListNode.display(new T25_reverseKGroup_2().reverseKGroup(head,2));
    }

}
