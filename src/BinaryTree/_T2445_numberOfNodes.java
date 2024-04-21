package src.BinaryTree;

import java.util.*;

public class _T2445_numberOfNodes {

    /**
     * https://leetcode.cn/problems/number-of-nodes-with-value-one/
     */

    public int numberOfNodes(int n, int[] queries) {
        // 去重，两个则消
        Arrays.sort(queries);
        Map<Integer,Integer> value = new HashMap<>();
        List<Integer> q  = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            if(i+1<queries.length && queries[i]==queries[i+1]){ // 两个则消
                i++;
            }else {
                q.add(queries[i]);
            }
        }
//        System.out.println(q);

        int res = 0;
        for (Integer i : q) {
            int count = children(i,n); //子树节点个数

            int tempFather = i; //已在查询中存在的祖先节点
            while (!value.isEmpty() && tempFather>1){
                if (value.containsKey(tempFather)){
                    break;
                }
                tempFather=tempFather/2;
            }

            // 祖先节点存在，且祖先的值是1，则此时需要-
            if(!value.isEmpty() &&value.containsKey(tempFather) && value.get(tempFather)==1){
                value.put(i,0);
                res-=count;
            }else { //否则，+
                value.put(i,1);
                res+=count;
            }

        }

        return res;
    }

    public int children (int i, int n){
        int level = (int) (Math.log(n/i)/Math.log(2));
        // 完整层+最后一层
        return (int)((Math.pow(2,level)-1)+ (Math.min(n,(i+1)*Math.pow(2,level)-1) -i*Math.pow(2,level)+1));
    }


    public static void main(String[] args) {
        int n = 5;
        int [] queries = new int[]{1,2,5};

        n = 3;
        queries = new int[]{2,3,3};


        n = 30;
        queries = new int[]{17,21,23,5,15,7,3,21,9,5,15,11,2,19,7,9,27,26,6,4,27,6,18,9,13,19,23,7,27,17,27,20,1,19,8,11,17,2,25,29,21,20,4,22,11,14,25,18,29,16,10,15,6,25,26,21,2,6,19,9,29,25,16,6,18,5,16,3,6,6,20,9,15};


        System.out.println(new _T2445_numberOfNodes().children(2,30));
        System.out.println(new _T2445_numberOfNodes().numberOfNodes(n,queries));
    }


}
