package src.ByMonth.M2409;

public class T2516_takeCharacters {

    /**
     * https://leetcode.cn/problems/take-k-of-each-character-from-left-and-right/description/
     * 按照题意所述，从最左和最右侧取走后，原字符串还剩下一个连续的区间，那么可以转化为求一个最长的子区间，使得区间两边的所有字符加起来满足题目要求。
     *
     * 没使用逆向思维：先找到从左开始的字串，然后左移，并且从左侧左移。实现起来麻烦，因为l，r的定义比较含糊
     */

    // 你可以选择取走 s 最左侧 还是 最右侧 的那个字符。不能中间
//    public int takeCharacters(String s, int k) {
//
//        int len = s.length();
//        s=s+s;
//        int l=0,r=0;
//
//        int res=Integer.MAX_VALUE;
//        int[] count=new int[3];
//        int diff=k*3;
//        while (l<len && r<len*2){
//            int c=s.charAt(r++);
//            count[c-'a']++;
//            if(count[c-'a']<=k){
//                diff--;
//            }
//
//            if(diff==0){
//                while (diff==0){
//                    c=s.charAt(l++);
//                    count[c-'a']--;
//                    if(count[c-'a']<k){
//                        diff++;
//                        break;
//                    }
//                }
//
//                if( diff==0){
//                    res=Math.min(res,r-l+1);
//                }
//
//            }
//
//        }
//
//
//        if(diff==0){
//            res=Math.min(res,r-l+1);
//        }
//
//        if(res==Integer.MAX_VALUE){
//            return -1;
//        }
//        return res;
//    }



    public int takeCharacters(String s, int k) {

        int[] count = new int[4];
        int diff=3*k;

        int i = 0;
        // [0,r]移动到合法,for循环先操作再+1，然后比较，因从退出时候的i是合法串的下一个index
        for (; i < s.length() && diff>0; i++) {
            int index=s.charAt(i)-'a';
            count[index]++;
            if(count[index]<=k && index!=3){
                diff--;
            }
        }

        if(diff!=0){
            return -1;
        }

        int l=s.length()-1;
        int r=i-1;


        //[0,r] [l+1,s.length()-1]
        int res=r+(s.length()-l);

        while (r>=0){
            //左移r到非法
            while (diff==0 && r>=0){
                int index=s.charAt(r--)-'a';
                count[index]--;
                if(count[index]<k&& index!=3){
                    diff++;
                    break;
                }

            }

            // [0,r+1] [l+1,s.length()-1]

            System.out.println(r+" "+l+" "+res);

            if(diff==0){ //r左移到-1时，依然成立，则0位置的可不计入
                res=Math.min(res,r+s.length()-l);
                break;
            }else {
                res=Math.min(res,r+1+s.length()-l);
            }


            // 左移l到合法
            while (diff>0){
                int index=s.charAt(l--)-'a';
                count[index]++;
                if(count[index]<=k&& index!=3){
                    diff--;
                    break;
                }
            }
        }


        return res;
    }


    public static void main(String[] args) {
        System.out.println(new T2516_takeCharacters().takeCharacters("abc" ,1));
//        System.out.println(new T2516_takeCharacters().takeCharacters("cbbac",1));
//        System.out.println(new T2516_takeCharacters().takeCharacters("aabaaaacaabc",2));
//        System.out.println(new T2516_takeCharacters().takeCharacters("ccbabcc",1));
    }


}
