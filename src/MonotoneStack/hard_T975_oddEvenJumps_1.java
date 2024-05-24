package src.MonotoneStack;

import java.util.*;

public class hard_T975_oddEvenJumps_1 {

    /**
     * 超时
     */

    Map<Integer,Boolean> nextB = new HashMap();
    Map<Integer,Boolean> nextS = new HashMap();
    public int oddEvenJumps(int[] arr) {
        int n = arr.length;

        int[] nextBigger = new int[n];
        Arrays.fill(nextBigger,-1);
        Deque<Integer> q = new ArrayDeque<>(); //降序
        Deque<Integer> temp = new ArrayDeque<>();
        for (int i = n-1; i >-1 ; i--) {
            while (!q.isEmpty() && arr[q.getLast()]<arr[i]){
                temp.addLast(q.removeLast());
            }
            if(!q.isEmpty()){
                nextBigger[i]=q.getLast();
            }

            q.addLast(i);
            while (!temp.isEmpty()){
                q.addLast(temp.removeLast());
            }
//            System.out.println();
        }

        int[] nextSmaller = new int[n];
        Arrays.fill(nextSmaller,-1);
        q = new ArrayDeque<>(); //升序
        temp = new ArrayDeque<>();
        for (int i = n-1; i >-1 ; i--) {
            while (!q.isEmpty() && arr[q.getLast()] > arr[i]){
                temp.addFirst(q.removeLast());
            }
            if(!q.isEmpty()){
                nextSmaller[i]=q.getLast();
            }
            q.addLast(i);
            while (!temp.isEmpty()){
                q.addLast(temp.removeFirst());
            }
            System.out.println();
        }


        int res=0;

        for (int i = 0; i < n; i++) {
            if(isNextBOk(nextBigger,nextSmaller,i)){
                res++;
            }
        }

        return res;
    }

    public boolean isNextBOk(int[] nextBigger, int[] nextSmaller,int cur ){
        if(nextB.containsKey(cur)){
            return nextB.get(cur);
        }
        boolean res=false;
        if(cur==nextBigger.length-1){
            res=true;
        }else {
            if (nextBigger[cur] != -1) {
                res = isNextSOk(nextBigger, nextSmaller, nextBigger[cur]);
            }
        }
        nextB.put(cur,res);
        return res;
    }

    public boolean isNextSOk(int[] nextBigger, int[] nextSmaller,int cur ){
        if(nextS.containsKey(cur)){
            return nextS.get(cur);
        }

        boolean res=false;
        if(cur==nextBigger.length-1){
            res=true;
        }else {
            if (nextSmaller[cur] != -1) {
                res = isNextBOk(nextBigger, nextSmaller, nextSmaller[cur]);
            }
        }
        nextS.put(cur,res);
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(new hard_T975_oddEvenJumps_1().oddEvenJumps(new int[]{2,3,1,1,4}));
//        System.out.println(new hard_T975_oddEvenJumps_1().oddEvenJumps(new int[]{5,1,3,4,2}));
//        System.out.println(new hard_T975_oddEvenJumps_1().oddEvenJumps(new int[]{1,2,3,2,1,4,4,5}));
        System.out.println(new hard_T975_oddEvenJumps_1().oddEvenJumps(new int[]{22,79,33,81,10,14,69,4,57,91}));
    }
}
