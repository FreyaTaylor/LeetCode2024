package src.LinkedList.HeadPlugging;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    ListNode(int[] arr){
        this.val=arr[0];
        ListNode cur=this;
        for (int i = 1; i <arr.length ; i++) {
            cur.next=new ListNode(arr[i]);
            cur=cur.next;
        }
    }

    public static void display(ListNode node){
        ListNode cur=node;
        while (cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
        System.out.println();
    }
}
