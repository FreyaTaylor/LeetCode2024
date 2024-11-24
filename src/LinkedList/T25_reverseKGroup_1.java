package src.LinkedList;

public class T25_reverseKGroup_1 {

    /**
     * https://leetcode.cn/problems/reverse-nodes-in-k-group/
     *
     * 分段处理！三段！
     */

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode hhead = new ListNode();
        hhead.next=head;
        ListNode travel=hhead;
        //  0 1 2 3 4 （k=3）
        ListNode node0=null; //0
        ListNode node1=null;//1
        ListNode node4=null; //4
        ListNode nextNode0=hhead;


        while (travel!=null){
            int count=0;
            while (count<k && travel!=null){
                travel=travel.next;
                count++;
            }

            if(travel==null){
                break;
            }

            node0=nextNode0;
            node4=travel.next; //前移
            nextNode0=node0.next; //1
            travel=node0.next;// 1

            count=0;
            while (count<k){
                count++;
                node1=node0.next;
                node0.next=node0.next.next;

                node1.next=node4;
                node4=node1;

//                ListNode.display(hhead);
            }
            node0.next=node4; //逆序的



            ListNode.display(hhead);
        }



        return hhead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1,2,3,4,5});
        ListNode.display(head);
        ListNode.display(new T25_reverseKGroup_1().reverseKGroup(head,2));
    }

}
