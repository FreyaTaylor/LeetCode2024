package src.Greedy;

public class T1793_maximumScore {

    /**
     * https://leetcode.cn/problems/maximum-score-of-a-good-subarray/
     *
     * 遍历长度为1，2，3.。。的最佳maximumScore
     */

    public int maximumScore(int[] nums, int k) {
        int i=k-1,j=k+1;
        int count = 1;
        int score = nums[k];
        int res = score;
        int minNum = nums[k];
        int minNumNew = nums[k];
        while (i>=0 && j<nums.length){
            int nextNum=0;
            if(nums[i]>=nums[j]){
                nextNum=nums[i--];
            }else {
                nextNum=nums[j++];
            }
            minNumNew=Math.min(minNum,nextNum);
            score+=-count*(minNum-minNumNew)+minNumNew;
            res = Math.max(res,score);
            minNum=minNumNew;
            count++;
        }

        while (i>=0){
            int nextNum=nums[i--];
            minNumNew=Math.min(minNum,nextNum);
            score+=-count*(minNum-minNumNew)+minNumNew;
            res = Math.max(res,score);
            minNum=minNumNew;
            count++;
        }

        while (j<nums.length){
            int nextNum=nums[j++];
            minNumNew=Math.min(minNum,nextNum);
            score+=-count*(minNum-minNumNew)+minNumNew;
            res = Math.max(res,score);
            minNum=minNumNew;
            count++;
        }


        return res;
    }

    public static void main(String[] args) {
//        System.out.println(new T1793_maximumScore().maximumScore(
//                new int[]{1,4,3,7,4,5},3));

        System.out.println(new T1793_maximumScore().maximumScore(
                new int[]{5,5,4,5,4,1,1,1},3));
    }
}
