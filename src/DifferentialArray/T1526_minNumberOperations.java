package src.DifferentialArray;

public class T1526_minNumberOperations {
    /**
     * https://leetcode.cn/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/
     *
     * 方法一：
     * [3 1 5 4 2] 先找到最小值1，说明整体需要先+1，然后将数组分成两段[3] [5 4 2]，各自递归处理.
     * 对于[3] ，最小值3,整体+(3-1),
     * 对于[5 4 2]，最小值2,整体+(2-1),继续拆分
     * ...
     * 1+2+1+2+1=7
     * 超时
     *
     * 方法二：遍历
     * [15 2 7 4 3 8]
     * 数组可以看作是很多个山峰组成，第一个山峰范围内，需要的step=山峰的高度，
     * 第二个山峰需要的step，可以借用上上一个山峰右边最低点，即step=(山峰的高度-上一个山峰最右的高度)
     *
     * 方法二和官方解题里面差分数据很像，官方解题的思路很厉害，不好想，参考着理解一下就好
     */

//    int res=0;
//    public int minNumberOperations(int[] target) {
//        List<int[]> subs = new ArrayList<>();
//        subs.add(new int[]{0,target.length-1});
//        helper(target,subs,0);
//        return res;
//    }
//
//    public void helper(int[] target, List<int[]> subs, int already){
//
//        for (int[] sub : subs) {
//            int l=sub[0];
//            int r=sub[1];
//            if(l>r){continue;}
//            if(l==r){
//                res+=target[r]-already;
//                continue;
//            }
//
//            int min = Integer.MAX_VALUE;
//            for (int i = l; i <=r ; i++) {
//                min=Math.min(min,target[i]);
//            }
//            res+=min-already;
//
//            List<Integer> indexs = new ArrayList<>();
//            indexs.add(l-1);
//            for (int i = l; i <=r ; i++) {
//                if(target[i]==min){
//                    indexs.add(i);
//                }
//            }
//            indexs.add(r+1);
//
//            List<int[]> subsTemp = new ArrayList<>();
//            subsTemp.add(new int[]{l,indexs.get(0)-1});
//            for (int i = 1; i < indexs.size(); i++) {
//                subsTemp.add(new int[]{indexs.get(i-1)+1,indexs.get(i)-1});
//            }
//            helper(target,subsTemp,min);
//
//            }
//        }

    public int minNumberOperations(int[] target) {
        int preMin=0;
        int i=0;
        int res=0;
        while (i<target.length){
            while (i<target.length && (i==0 ||target[i]>=target[i-1])){i++;}
            int curMax = target[i-1];
            res+=curMax-preMin;
            while (i<target.length && (i==0 ||target[i]<=target[i-1])){i++;}
            preMin=target[i-1];

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T1526_minNumberOperations().minNumberOperations(new int[]{1,2,3,2,1}));
        System.out.println(new T1526_minNumberOperations().minNumberOperations(new int[]{3,1,5,4,2}));
    }
}
