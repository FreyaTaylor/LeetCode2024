package src.ByMonth.M2408;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T690_getImportance {

    int res=0;
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer,List<Integer>> subs = new HashMap<>();
        Map<Integer,Integer> ipts = new HashMap<>();

        for (Employee employee : employees) {
            subs.put(employee.id,employee.subordinates);
            ipts.put(employee.id,employee.importance);
        }

        helper(subs,ipts,id);
        return res;
    }

    public void helper(Map<Integer,List<Integer>> subs,Map<Integer,Integer> ipts,int cur){

        res+=ipts.get(cur);
        if(subs.get(cur)!= null && !subs.get(cur).isEmpty()){
            for (Integer i : subs.get(cur)) {
                helper(subs,ipts,i);
            }
        }
    }


    // Definition for Employee.
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };



}
