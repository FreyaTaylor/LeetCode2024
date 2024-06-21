package src.Uncategorized;

public class T1635_minimumDeletions {

    /**
     * https://leetcode.cn/problems/minimum-deletions-to-make-string-balanced/
     *
     * 贪心：从左右边界开始收缩，结果为中间处理结果，三种处理方式：
     * 1.全a
     * 2.全b
     * 3.前a后b：处理左起的bbbaaa,和右起的aaabbb，处理长度为左起的b和右起的a的长度，加上中间结果递归之和
     *
     *
     * leetcode官方：
     * 遍历【分割点】，分割点前全是a，后全是b
     *
     */

    public int minimumDeletions(String s) {

        int anum=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='a'){
                anum++;
            }
        }
        int bnum=s.length()-anum;

        return del(s,anum,bnum,0,s.length()-1);
    }

    public int del(String s,int anum,int bnum,int i, int j){
        if(i>=j){
            return 0;
        }

        int res=Math.min(anum,bnum);
        int temp=0;
        while (i<j&& s.charAt(i)=='b'){
            i++;
            bnum--;
            temp++;
        }

        while (i<j&& s.charAt(i)=='a'){
            i++;
            anum--;
        }

        while (i<j&& s.charAt(j)=='a'){
            j--;
            anum--;
            temp++;
        }
        while (i<j&& s.charAt(j)=='b'){
            j--;
            bnum--;
        }

        res=Math.min(res,temp+del(s,anum,bnum,i,j));
        return res;

    }


    public static void main(String[] args) {
        System.out.println(new T1635_minimumDeletions().minimumDeletions("bbaaaaabb"));
    }
}
