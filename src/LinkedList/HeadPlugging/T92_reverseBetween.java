package src.LinkedList.HeadPlugging;



public class T92_reverseBetween {

    /**
     * https://leetcode.cn/problems/reverse-linked-list-ii/
     *   a 1 2 3 4 5 6 7 8 9 b
     *   a 2 3 4 5 6 7 8 9 1 b
     *   ->
     *   a 3 4 5 6 7 8 9 1 2 b
     *
     *   a:preLeft
     *   2:cur
     *   3:nextNode
     *   9:nodeRight
     *   b:afterRight
     *   1:already
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode hhead = new ListNode();
        hhead.next=head;

        ListNode pre = hhead;
        ListNode cur=hhead.next;
        int count=1;
        while (count<left){
            pre=pre.next;
            cur=cur.next;
            count++;
        }
        ListNode preLeft=pre;
        ListNode nodeLeft=cur;

        while (count<right){
            cur=cur.next;
            count++;
        }
        ListNode nodeRight = cur;
        ListNode afterRight=cur.next;

        cur=nodeLeft;
        ListNode nextNode=nodeLeft.next;
        ListNode already = afterRight; // 已经移送好的点
        while (preLeft.next!=nodeRight){
           preLeft.next=nextNode;
           cur.next=already;
           nodeRight.next=cur;
           already=cur;

           cur=nextNode;
           nextNode=cur.next;
//           ListNode.display(hhead);
        }

    return hhead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1,2,3,4,5});
        ListNode.display(head);
        ListNode.display(new T92_reverseBetween().reverseBetween(head,1,5));


    }

}
