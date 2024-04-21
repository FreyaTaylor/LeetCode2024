package src.Uncategorized;

import java.util.ArrayDeque;
import java.util.Deque;

public class T2355_maximumBooks {

    /**
     * https://leetcode.cn/problems/maximum-number-of-books-you-can-take/
     *
     * 超时，试着用 数组，而不是队列
     * 数组还是超时
     *
     * 参考答案：动规+单调栈!!!
     */

    public long maximumBooks(int[] books) {
        int n = books.length;
        int[] diff = new int[n];
        diff[0]=books[0];

        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(0); // diff数组增加的index队列

        long[] presum = new long[n+1]; //包含当前元素的，可取书本数量
        presum[1]=books[0];

        long res=books[0];

        for (int i = 1; i < n; i++) {
            diff[i]=books[i]-i;
            while (!q.isEmpty() && diff[q.getLast()]>=diff[i]){
                q.removeLast();
            }

            if(q.isEmpty()){ // 需要判断连家的起始位：9 6 7 2 => NULL 0 1 2
                // from, books[i]
                int from = Math.max(0,books[i]-i); // books[i]-i：index是0时候的数值
                presum[i+1]=((long)(books[i]+from)*(books[i]-from+1))/2;
            }else {
                // 0,... index + [index+1,i]
                int index = q.getLast();
                presum[i + 1] = presum[index + 1]+((long) (i - index) * (books[i] + books[i] - (i - index - 1))) / 2;
            }

            res = Math.max(res,presum[i+1]);
            q.addLast(i);
        }

        return res;
    }

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



<<<<<<< Updated upstream:src/Uncategorized/T2355_maximumBooks.java
=======
        for (int i = 0; i < n; i++) {
            diff[i]=books[i]-1;
        }

        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && diff[q.getLast()]>=diff[i]){

            }
        }

        return -1;
    }
>>>>>>> Stashed changes:src/Uncategorized/_T2355_maximumBooks.java

    public static void main(String[] args) {
        int[] books = new int[]{8,5,2,7,9};
//        books = new int[]{8,2,3,7,3,4,0,1,4,3};
        books = new int[]{7,0,3,4,5};
//        books = new int[]{2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,100};

//        books = new int[]{2,4,9,11,12,17,15};
        books = new int[]{5,5,5};
        books = new int[]{7,99,98,97,96,95,94,93,92,91,90,89,88,87,86,85,84,83,82,81,80,79,78,77,76,75,74,73,72,71,70,69,68,67,66,65,64,63,62,61,60,59,58,57,56,55,54,53,52,51,50,49,48,47,46,45,44,43,42,41,40,39,38,37,36,35,34,33,32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};

//        int n=10000;
//        books = new int[n];
//        for (int i = 0; i < n-1; i++) {
//            books[i]=i+2;
//        }
//        books[n-1]=n;

        System.out.println(new T2355_maximumBooks().maximumBooks(books));
    }
}
