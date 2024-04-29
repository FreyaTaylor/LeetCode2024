package src.LinkedList;

public class T206_reverseList {

    public ListNode reverseList(ListNode head) {

        if(head==null || head.next==null){
            return head;
        }

        ListNode hhead = new ListNode();
        hhead.next=hhead;
        ListNode node1 = head;
        ListNode node3 = head.next;
        ListNode node2 = head;
        while (node1.next!=null){
            node1.next=node3.next;
            hhead.next=node3;
            node3.next=node2;

            node3=node1.next;
            node2=hhead.next;
        }

        return hhead.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        ListNode res = new T206_reverseList().reverseList(node);
        System.out.println();
    }
}
