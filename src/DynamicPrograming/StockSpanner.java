package src.DynamicPrograming;

import java.util.*;

public class StockSpanner {

    private List<Integer> nums;
    Deque<Integer> q;
    int cur;

    public StockSpanner() {
        nums=new ArrayList<>();
        q = new ArrayDeque<>();
        cur =0;
    }

    public int next(int price) {

        while (!q.isEmpty() && nums.get(q.getLast())<=price){
            q.removeLast();
        }
        int last=-1;
        if(!q.isEmpty()){
            last=q.getLast();
        }
        int res=cur-last;

        nums.add(price);
        q.add(cur++);

        return res;
    }

    public static void main(String[] args) {
        StockSpanner obj = new StockSpanner();

        System.out.println(obj.next(100));
        System.out.println(obj.next(80));
        System.out.println(obj.next(60));
        System.out.println(obj.next(70));
        System.out.println(obj.next(60));
        System.out.println(obj.next(75));
        System.out.println(obj.next(85));

    }
}
