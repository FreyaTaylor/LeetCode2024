package src.MonotoneStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;

public class hard_T456_find132pattern {

    /**
     * https://leetcode.cn/problems/132-pattern/description/
     * Integer ceilingKey = treeMap.ceilingKey(4);返回在 TreeMap 中大于或等于指定键的所有键中的最小键。
     */

    // 从右到作品遍历2&3，找1
    public boolean find132pattern_1(int[] nums) {

        Deque<Integer> q = new ArrayDeque<>();
        q.add(Integer.MAX_VALUE); //降序
        int num2 = Integer.MIN_VALUE;
        for (int i = nums.length-1; i>-1; i--) {
            int cur = nums[i];

            // cur 做 1
            if(cur<num2){ //如果向前找到1，则true
                return true;
            }

            // cur 做 3，更新2
            while (cur>q.getFirst()){ // cur更大，那么q首的都可以作为num2
                num2=q.removeFirst();
            }

            // cur做2，等待后续的3
            q.addFirst(cur);
        }

       return false;
    }

    // 遍历 3
    public boolean find132pattern(int[] nums) {
        int num1 = nums[0];

        TreeMap<Integer,Integer> treeMap = new TreeMap<>(); // num3
        for (int i = 2; i < nums.length; i++) {
            treeMap.put(nums[i],treeMap.getOrDefault(nums[i],0)+1);
        }

        for (int i = 1; i <nums.length-1 ; i++) {

            if(nums[i]>num1){
                Integer num3 = treeMap.ceilingKey(num1+1); //>=num1+1的最小数
                if(num3!=null && nums[i]>num3){
                    return true;
                }
            }

            // 右移 i-1,[i],i+1,i+2 ==> i-1,i,[i+1],i+2
            num1 = Math.min(num1,nums[i]);
            treeMap.put(nums[i+1],treeMap.get(nums[i+1])-1);
            if(treeMap.get(nums[i+1])==0){
                treeMap.remove(nums[i+1]);
            }

        }

        return false;

    }

//    public boolean find132pattern(int[] nums) {
//
//        List<Integer> list = new ArrayList<>();
//        list.add(0);
//        for (int i = 0; i < nums.length; i++) {
//            if(nums[list.get(list.size()-1)]>nums[i]){
//                list.add(i);
//            }
//        }
//
//        for (Integer integer : list) {
//
//            int numi=nums[integer];
//            int numj=Integer.MIN_VALUE;
//
//            for (int l = integer+1; l < nums.length ; l++) {
//                int cur = nums[l];
//
//                if(cur>numi && cur<numj){
//                    return true;
//                }
//
//                if(cur>numj){
//                    numj=cur;
//                }
//            }
//
//        }
//
//        return false;
//    }

    public static void main(String[] args) {
        System.out.println(new hard_T456_find132pattern().find132pattern(new int[]{1,2,3,4}));
//        System.out.println(new _T456_find132pattern().find132pattern(new int[]{1,3,2,4,5,6,7,8,9,10}));
//        System.out.println(new _T456_find132pattern().find132pattern(new int[]{10,100,7,9}));
//        System.out.println(new T456_find132pattern().find132pattern(new int[]{3,1,4,2}));
    }
}
