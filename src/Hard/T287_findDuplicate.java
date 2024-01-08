package src.Hard;

public class T287_findDuplicate {
    /**
     *
     * 方法一：二分查找
     * 方法二：二进制
     * 如果测试用例的数组中 target\textit{target}target 出现了两次，其余的数各出现了一次，且 target\textit{target}target 的第 iii 位为 111，那么 nums\textit{nums}nums 数组中第 iii 位 111 的个数 xxx 恰好比 yyy 大一。如果target\textit{target}target 的第 iii 位为 000，那么两者相等。
     * 如果测试用例的数组中 target\textit{target}target 出现了三次及以上，那么必然有一些数不在 nums\textit{nums}nums 数组中了，这个时候相当于我们用 target\textit{target}target 去替换了这些数，我们考虑替换的时候对 xxx 的影响：
     * 如果被替换的数第 iii 位为 111，且 target\textit{target}target 第 iii 位为 111：xxx 不变，满足 x>yx>yx>y。
     * 如果被替换的数第 iii 位为 000，且 target\textit{target}target 第 iii 位为 111：xxx 加一，满足 x>yx>yx>y。
     * 如果被替换的数第 iii 位为 111，且 target\textit{target}target 第 iii 位为 000：xxx 减一，满足 x≤yx\le yx≤y。
     * 如果被替换的数第 iii 位为 000，且 target\textit{target}target 第 iii 位为 000：xxx 不变，满足 x≤yx\le yx≤y
     *
     * 方法三：快慢指针
     *  n个节点 1+(n-1)+1条边，必有环
     * 解释：，其数字都在 [1, n]所以0个节点；第一个1条边表示从数组index=0处开始，链表末端为第一个数，n-1表示不成环容纳的最多边，最后一个1表示必须有边使成环
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/find-the-duplicate-number/solutions/261119/xun-zhao-zhong-fu-shu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    public int findDuplicate_2(int[] nums) {
        int n=nums.length-1;
        int bits=(int)(Math.log(n+0.5)/Math.log(2))+1;

        int res=0;
        for (int i = 0; i < bits; i++) {
            int x=0; //
            int y=0;
            for (int j = 1; j <=n; j++) {
                if((j&(1<<i))!=0){
                    y++;
                }
                if((nums[j]&(1<<i))!=0){
                    x++;
                }
            }
            if((nums[0]&(1<<i))!=0){
                x++;
            }

            if(x>y){
                res+=(1<<i);
            }
        }

        return res;
    }

    public int findDuplicate(int[] nums) {
        int slow=nums[0],quick=nums[nums[0]];
        while (slow!=quick){
            slow=nums[slow];
            quick=nums[quick];
            quick=nums[quick];
        }
        slow=0;
        while (slow!=quick){
            slow=nums[slow];
            quick=nums[quick];
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(new T287_findDuplicate().findDuplicate(new int[]{1,3,4,2,2}));
    }

}
