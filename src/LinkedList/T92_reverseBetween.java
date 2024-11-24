package src.LinkedList;


import src.LinkedList.ListNode;

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
    public src.LinkedList.ListNode reverseBetween(src.LinkedList.ListNode head, int left, int right) {
        src.LinkedList.ListNode hhead = new src.LinkedList.ListNode();
        hhead.next=head;

        src.LinkedList.ListNode pre = hhead;
        src.LinkedList.ListNode cur=hhead.next;
        int count=1;
        while (count<left){
            pre=pre.next;
            cur=cur.next;
            count++;
        }
        src.LinkedList.ListNode preLeft=pre;
        src.LinkedList.ListNode nodeLeft=cur;

        while (count<right){
            cur=cur.next;
            count++;
        }
        src.LinkedList.ListNode nodeRight = cur;
        src.LinkedList.ListNode afterRight=cur.next;

        cur=nodeLeft;
        src.LinkedList.ListNode nextNode=nodeLeft.next;
        src.LinkedList.ListNode already = afterRight; // 已经移送好的点
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
        src.LinkedList.ListNode head = new src.LinkedList.ListNode(new int[]{1,2,3,4,5});
        src.LinkedList.ListNode.display(head);
        ListNode.display(new T92_reverseBetween().reverseBetween(head,1,5));


    }

}
