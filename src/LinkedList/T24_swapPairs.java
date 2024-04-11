package src.LinkedList;

import src.Trie.WordDictionary;

public class T24_swapPairs {

    /**
     * https://leetcode.cn/problems/swap-nodes-in-pairs/
     */

    public ListNode swapPairs(ListNode head) {

        ListNode hhead = new ListNode();
        hhead.next=head;
        ListNode already = hhead;

        while (already.next!=null && already.next.next!=null){
            ListNode a = already.next;
            ListNode b = a.next;

            already.next=b;
            a.next=b.next;
            b.next=a;

//            already=already.next.next;
            already=a;
        }

        return hhead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1,2,3,4,5});
        ListNode.display(head);
        ListNode.display(new T24_swapPairs().swapPairs(head));
    }



}
