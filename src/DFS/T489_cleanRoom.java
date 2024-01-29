package src.DFS;

import java.util.*;

public class T489_cleanRoom {

    /**
     * https://leetcode.cn/problems/robot-room-cleaner/?company_slug=microsoft
     * 难点：
     * 1. 房间的位置，用(x,y) 记录，初始位置为(0,0) 向上向左为正，反之为负数
     * 因为 1 <= n <= 200 1 <= m <= 100，因此每个位置+200都变成正数 ，则 x,y范围在0-400之间，可用int的后六位表示
     * 举例：(0,0) (0+200,0+200) 200*1000+200=200200
     *
     * 2.朝向，每个位置处理四个方向，每个方向：
     * 2.1判断是否可move
     * 2.2可，则move，然后dfs
     * 2.3回退到本位置
     *
     * 3.朝向，通过(toward+i)%4可保证，每次都是左转，不论最开始的toward是多少
     */

    public void cleanRoom(Robot robot) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> wall = new HashSet<>();
        Map<Integer,Integer> moveTo = new HashMap<>();
        moveTo.put(0,201000); //上
        moveTo.put(1,201); //左
        moveTo.put(2,-201000); //下
        moveTo.put(3,-201); //右
        dfs(robot,visited,wall,1000*(0+200)+(0+200),0,moveTo);
    }


    public void dfs(Robot robot,Set<Integer> visited,Set<Integer> wall,int curPos,int toward,Map<Integer,Integer> moveTo){
        robot.clean();
        visited.add(curPos);

        for (int i = 0; i < 4; i++) { //通过(toward+i)%4可保证，每次都是左转，不论最开始的toward是多少

            int nextPos = curPos+moveTo.get((toward+i)%4);
            if(!visited.contains(nextPos) && !wall.contains(nextPos)){
                if(robot.move()){
                    dfs(robot,visited,wall,nextPos,(toward+i)%4,moveTo);
                    robot.turnLeft();
                    robot.turnLeft();
                    robot.move();
                    robot.turnLeft();
                    robot.turnLeft();
                }else {
                    wall.add(nextPos);
                }
            }
            robot.turnLeft();
        }


    }




}



  // This is the robot's control interface.
  // You should not implement it, or speculate about its implementation
  interface Robot {
      // Returns true if the cell in front is open and robot moves into the cell.
      // Returns false if the cell in front is blocked and robot stays in the current cell.
      public boolean move();

      // Robot will stay in the same cell after calling turnLeft/turnRight.
      // Each turn will be 90 degrees.
      public void turnLeft();
      public void turnRight();

      // Clean the current cell.
      public void clean();
  }