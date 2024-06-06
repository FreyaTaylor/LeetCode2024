package src.Uncategorized;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

public class T224_calculate {

    /**
     * https://leetcode.cn/problems/basic-calculator/
     */

//    public int calculate(String s) {
//        Deque<String> q = new ArrayDeque<>();
//        int i = 0;
//
//        while (i < s.length()) {
//            String cur = "";
//            if (Character.isDigit(s.charAt(i))) {
//                int nexti = i + 1;
//                while (nexti < s.length() && Character.isDigit(s.charAt(nexti))) {
//                    nexti++;
//                }
//                cur = s.substring(i, nexti);
//                i = nexti-1;
//            } else if (s.charAt(i) == ')') {
//                cur = q.removeLast();
//                if (q.getLast().equals("(")) {
//                    q.removeLast();
//                }
//            } else if (s.charAt(i) == '(' || s.charAt(i) == '+' || s.charAt(i) == '-') {
//                q.add(s.charAt(i) + "");
//            }
//            i++;
//
//
//        if (!cur.equals("")) {
//
//            int curn = Integer.valueOf(cur);
//            while(!q.isEmpty() && !q.getLast().equals("(")) {
//
//                    String op = q.removeLast();
//                    int lastn = 0;
//
//                    if (!q.isEmpty() && !q.getLast().equals("(")) {
//                        lastn = Integer.valueOf(q.removeLast());
//                    }
//
//                    if (op.equals("-")) {
//                        curn = lastn - curn;
//                    } else if (op.equals("+")) {
//                        curn = lastn + curn;
//                    }
//
//            }
//           q.addLast(curn+"");
//
//        }
//
//        }
//
//        if(q.size()==2 && q.getFirst().equals("-")){
//            return -1*Integer.valueOf(q.removeLast());
//        }
//        return Integer.valueOf(q.removeLast());
//    }

//    public int calculate(String s) {
//        Deque<String> q = new ArrayDeque<>();
//        int i = 0;
//
//        while (i < s.length()) {
//            String cur = "";
//            if (Character.isDigit(s.charAt(i))) {
//                int nexti = i + 1;
//                while (nexti < s.length() && Character.isDigit(s.charAt(nexti))) {
//                    nexti++;
//                }
//                cur = s.substring(i, nexti);
//                i=nexti;
//            } else if (s.charAt(i) == '(') {
//                int nexti = i + 1;
//                int l = 1;
//                while (nexti < s.length() && l != 0) {
//                    if (s.charAt(nexti) == '(') {
//                        l++;
//                    } else if (s.charAt(nexti) == ')') {
//                        l--;
//                    }
//                    nexti++;
//                }
//                //  i   nexti
//                //  (  )
//                cur = "" + calculate(s.substring(i + 1, nexti - 1));
//                i=nexti;
//            } else {
//                if (s.charAt(i) == '+' || s.charAt(i) == '-'){
//                    q.add(s.charAt(i)+"");
//                }
//                i++;
//
//            }
//
//
//            if (!cur.equals("")) {
//
//            int curn = Integer.valueOf(cur);
//            while(!q.isEmpty() && !q.getLast().equals("(")) {
//
//                    String op = q.removeLast();
//                    int lastn = 0;
//
//                    if (!q.isEmpty() && !q.getLast().equals("(")) {
//                        lastn = Integer.valueOf(q.removeLast());
//                    }
//
//                    if (op.equals("-")) {
//                        curn = lastn - curn;
//                    } else if (op.equals("+")) {
//                        curn = lastn + curn;
//                    }
//
//            }
//           q.addLast(curn+"");
//
//        }
//
//
//
//        }
//
//
//        return Integer.valueOf(q.removeLast());
//
//    }


    public int calculate(String s) {
        Deque<Integer> q = new ArrayDeque<>();
        int i = 0;
        int sig=1;
        int signum=1;
        s=s.replace(" ","");

        int res=0;
        while (i < s.length()) {

            if (Character.isDigit(s.charAt(i))) {
                String cur = "";
                int nexti = i + 1;
                while (nexti < s.length() && Character.isDigit(s.charAt(nexti))) {
                    nexti++;
                }
                cur = s.substring(i, nexti);
                if(i>0 && s.charAt(i-1)=='-'){
                    signum=-1;
                }else {
                    signum=1;
                }
                res+=sig*signum*Integer.valueOf(cur);
                i=nexti-1;

            } else if (s.charAt(i) == '(') {
                if(i>0 && s.charAt(i-1)=='-'){
                    sig=-1*sig;
                    q.addLast(-1);
                }else {
                    q.addLast(1);
                }
            } else if (s.charAt(i) == ')') {
                sig=sig*q.removeLast();
            }
            i++;

        }


        return res;

    }



    public static void main(String[] args) {
        System.out.println(new T224_calculate().calculate("- (3 + (4 + 5))"));

//        System.out.println(new T224_calculate().calculate("-(1-(-2))"));
    }





}
