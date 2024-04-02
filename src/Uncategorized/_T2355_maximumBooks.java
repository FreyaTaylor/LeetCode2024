package src.Uncategorized;

import java.util.ArrayDeque;
import java.util.Deque;

public class _T2355_maximumBooks {

    /**
     * https://leetcode.cn/problems/maximum-number-of-books-you-can-take/
     *
     * 超时，试着用 数组，而不是队列
     * 数组还是超时
     *
     * 参考答案：动规+单调栈
     */

//    public long maximumBooks(int[] books) {
//        Deque<Integer> q = new ArrayDeque<>();
//        Deque<Integer> temp = new ArrayDeque<>();
//
//        long res = 0;
//        long curBooks = 0;
//        for (int i = 0; i < books.length; i++) {
//            int  cur = books[i];
//
//            temp = new ArrayDeque<>();
//            while (!q.isEmpty() && q.getLast()>=cur && cur>0){
//                curBooks-=q.getLast();
//                q.removeLast();
//                temp.addFirst(cur-1);
//                cur-=1;
//            }
//
//            if(cur==0){
//                q = new ArrayDeque<>();
//                curBooks=0;
//            }
//
//            while (!temp.isEmpty()){
//                curBooks +=temp.getFirst();
//                q.addLast(temp.removeFirst());
//            }
//            q.addLast(books[i]);
//            curBooks+=books[i];
//
//            res = Math.max(res,curBooks);
////            System.out.println(q);
//        }
//
//        return res;
//    }



//    public long maximumBooks(int[] books) {
//        int[] q = new int[books.length];
//        int index=-1;
//
//        long res = 0;
//        long curBooks = 0;
//
//        for (int i = 0; i < books.length; i++) {
//            int  cur = books[i];
//
//            int addBooks=0;
//            while (index>-1 && q[index]>=cur && cur>0){
//                curBooks-=q[index];
//
//                addBooks+=--cur;
//                q[index--]=cur;
//            }
//
//            if(cur==0){
//                curBooks=0;
//            }
//
//            curBooks+=addBooks;
//
//            q[i]=books[i];
//            curBooks+=books[i];
//            index=i;
//
//            res = Math.max(res,curBooks);
////            System.out.println(Arrays.toString(q));
////            System.out.println(curBooks);
//        }
//
//        return res;
//    }


    public long maximumBooks(int[] books) {
        int n = books.length;
        Deque<Integer> q = new ArrayDeque<>();
        int [] diff = new int[n];
        int [] presum = new int[n];
        int index=-1;

        for (int i = 0; i < n; i++) {
            diff[i]=books[i]-1;
        }

        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && diff[q.getLast()]>=diff[i]){

            }
        }

    }

    public static void main(String[] args) {
        int[] books = new int[]{8,5,2,7,9};
//        books = new int[]{8,2,3,7,3,4,0,1,4,3};
//        books = new int[]{7,0,3,4,5};
        books = new int[]{2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,100};

        int n=10000;
        books = new int[n];
        for (int i = 0; i < n-1; i++) {
            books[i]=i+2;
        }
        books[n-1]=n;
        System.out.println(new _T2355_maximumBooks().maximumBooks(books));
    }
}
