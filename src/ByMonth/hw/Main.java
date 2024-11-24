package src.ByMonth.hw;

public class Main {

    /**
     * huangwenlong h00609884
     * 题目：一局游戏有10位玩家参与，分为两组，每组5人。
     * 每位玩家都有一个战斗力分值，我们需要把玩家们分为[实力尽量相等]的两组。
     * 一组的实力可以表示为这一组5位玩家的战斗力和。现在，给你10位玩家的战斗力，
     * 请你把他们分为实力尽量相等的两组。请你输出这两组的实力差。
     *
     *
     * 提示：
     * 枚举取哪5个在一组就好，记录最小值就可以了。
     *
     * 举例：
     * 155, 2128, 300, 41, 588, 1286, 3357, 778, 2281, 668， 两组最小差值为50
     *
     * 1, 2, 3, 4, 5, 6, 7, 8, 9, 10， 两组最小差值为1
     *
     * 222, 333, 444, 555, 1666, 2777, 3888, 1000, 1234, 5678，  两组最小差值为1
     *
     * ==100
     * min |sum(5)-50|
     */

    int diff=Integer.MAX_VALUE;
    int sum=0;
    public int fenzu(int[] nums){
        for (int i = 0; i < 10; i++) {
            sum+=nums[i];
        }

        dfs(nums,0,0,0);
        return diff;
    }
    public void dfs(int[] nums,int cur,int curSum,int count){
        if(cur>=10){
            if(count==5){
                diff=Math.min(diff,Math.abs(sum-2*curSum));
            }
            return;
        }

        dfs(nums,cur+1,curSum,count); //no

        if(count<5){
            dfs(nums,cur+1,curSum+nums[cur],count+1); //yes
        }

    }



    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(new Main().fenzu(nums));
        nums = new int[]{155, 2128, 300, 41, 588, 1286, 3357, 778, 2281, 668};
        System.out.println(new Main().fenzu(nums));
        nums = new int[]{222, 333, 444, 555, 1666, 2777, 3888, 1000, 1234, 5678};
        System.out.println(new Main().fenzu(nums));

    }



}
