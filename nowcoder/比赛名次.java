/**
* 题目描述：（小米机试）
* 有N个比赛队（1<=N<=500），编号依次为1，2，3，...，N进行比赛，比赛结束后，裁判委员会要将所有参赛队伍从前往后
* 依次排名，但现在裁判委员会不能直接获得每个队的比赛成绩，只知道每场比赛的结果，即P1赢P2，用P1，P2表示，排名时
* P1在P2之前。现在请你编程序确定排名。
*
* 输入描述：
* 输入有若干组，每组中的第一行为二个数N（1<=N<=500），M；其中N表示队伍的个数，M表示接着有M行的输入数据。接下来
* 的M行数据中，每行也有两个整数P1，P2表示即P1队赢了P2队。
*
* 输出描述：
* 给出一个符合要求的排名。输出时队伍号之间有空格，最后一名后面没有空格。其他说明：符合条件的排名可能不是唯一的，
* 此时要求输出时编号小的队伍在前；输入数据保证是正确的，即输入数据确保一定能有一个符合要求的排名。
*
* 示例
*   输入
*   4 3
*   1 2
*   2 3
*   4 3
*
*   输出
*   1 2 4 3
*
*/

/**
* 解题思路：
* 先构造有向图，根据队列求解最小字典序拓扑排序序列
*/

import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }
    
    void run() {
        while(cin.hasNext()) {
        	int n = cin.nextInt(), m = cin.nextInt(), x, y;
        	boolean[][] edges = new boolean[n+1][n+1];
        	int[] ins = new int[n+1];
        	for(int i=0; i<m; i++) {
        		x = cin.nextInt(); y = cin.nextInt();
        		edges[x][y] = true;
        		ins[y]++;
        	}
        	
        	PriorityQueue<Integer> Q = new PriorityQueue<>();
        	for(int i=1; i<=n; i++) {
        		if(ins[i] == 0) Q.add(i);
        	}
        	boolean flag = false;
        	while(!Q.isEmpty()) {
        		int k = Q.poll();
        		if(flag) {
        			System.out.print(" ");
        		} System.out.print(k);
        		flag = true;
        		for(int i=1; i<=n; i++) {
        			if(edges[k][i] && (--ins[i] == 0)) {
        				Q.add(i);
        			}
        		}
        	} System.out.println();
        }
    }
}
