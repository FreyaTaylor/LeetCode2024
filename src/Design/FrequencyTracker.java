package src.Design;

import java.util.HashMap;
import java.util.Map;

public class FrequencyTracker {
    /**
     * https://leetcode.cn/problems/frequency-tracker
     */

    private Map<Integer,Integer> numCount = new HashMap<>();
    private Map<Integer,Integer> frqCount = new HashMap<>();
    public FrequencyTracker() {
        numCount = new HashMap<>();
        frqCount = new HashMap<>();
    }

    public void add(int number) {
        if(numCount.containsKey(number) && numCount.get(number)>0){
            int oldFrq = numCount.get(number);
            numCount.put(number,oldFrq+1);
            frqCount.put(oldFrq,frqCount.getOrDefault(oldFrq,0)-1);
            frqCount.put(oldFrq+1,frqCount.getOrDefault(oldFrq+1,0)+1);
        }else {
            numCount.put(number,1);
            frqCount.put(1,frqCount.getOrDefault(1,0)+1);
        }

    }

    public void deleteOne(int number) {
        if(numCount.containsKey(number) && numCount.get(number)>0){
            int oldFrq = numCount.get(number);
            numCount.put(number,oldFrq-1);
            frqCount.put(oldFrq,frqCount.getOrDefault(oldFrq,0)-1);
            frqCount.put(oldFrq-1,frqCount.getOrDefault(oldFrq-1,0)+1);
        }

    }

    public boolean hasFrequency(int frequency) {
        if(frqCount.containsKey(frequency) && frqCount.get(frequency)>0){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        FrequencyTracker frequencyTracker = new FrequencyTracker();
        boolean b=frequencyTracker.hasFrequency(2); // 返回 false ，因为数据结构为空
        System.out.println(b);
        frequencyTracker.add(3); // 数据结构现在包含 [3]
        b=frequencyTracker.hasFrequency(1); // 返回 true ，因为 3 出现 1 次
        System.out.println(b);
    }

}
