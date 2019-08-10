/**
* 题目描述：
* 有N个比赛队（1<=N<=500），编号依次为1，2，3，……，N进行比赛，比赛结束后，裁判委员会要将所有参赛
* 队伍从前往后依次排名，但现在裁判委员会不能直接获得每个队的比赛成绩，只知道每场比赛的结果，即P1
* 赢P2，用P1，P2表示，排名时P1在P2之前。现在请你编程序确定排名。
*
* 输入描述：
* 输入有若干组，每组中的第一行为二个数N（1<=N<=500），M；其中N表示队伍的个数，M表示接着有M行的输
* 入数据。接下来的M行数据中，每行也有两个整数P1，P2表示即P1队赢了P2队。
*
* 输出描述：
* 给出一个符合要求的排名。输出时队伍号之间有空格，最后一名后面没有空格。
* 其他说明：符合条件的排名可能不是唯一的，此时要求输出时编号小的队伍在前；输入数据保证是正确的，即
* 输入数据确保一定能有一个符合要求的排名。
*
* 示例1
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
//          int top = -1;
//        	for(int i=n; i>0; i--) {
//        		if(ins[i] == 0) {
//        			ins[i] = top; top = i;
//        		}
//        	}
//        	for(int i=0, k; i<n; i++) {
//        		if(top == -1) {
//        			System.out.println("存在环路！");
//        			break;
//        		}
//        		if(i > 0) {
//        			System.out.print(" ");
//        		} System.out.print(top);
//        		k = top;
//        		top = ins[top];
//        		for(int j=n; j>0; j--) {
//        			if(edges[k][j] && (--ins[j] == 0)) {
//        				ins[j] = top; top = j;
//        			}
//        		}
//        	} System.out.println();
        	
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


/**
示例2

输入
10 16
10 7
10 1
10 5
6 9
6 1
6 5
7 1
7 4
3 2
3 8
1 2
1 4
2 5
2 8
4 5
4 8
10 14
6 7
6 4
7 3
7 10
7 4
7 1
9 8
9 10
9 2
8 5
3 1
3 5
10 5
5 2
10 14
8 10
9 10
9 2
9 6
7 10
7 4
7 1
7 3
10 4
10 5
10 3
4 2
5 2
1 3
10 21
6 9
6 1
6 5
2 9
2 8
2 5
2 7
9 3
9 8
9 5
9 7
4 1
4 3
4 5
1 5
10 8
10 7
3 5
3 7
8 7
5 7
10 23
3 10
3 6
3 2
3 9
3 8
3 4
10 6
10 5
10 2
10 8
6 1
6 2
6 9
1 8
1 4
5 2
5 7
5 9
5 4
2 9
7 8
7 4
9 8

输出
3 6 9 10 7 1 2 4 5 8
6 7 3 1 4 9 8 10 5 2
7 1 8 9 6 10 3 4 5 2
2 4 6 1 9 3 5 10 8 7
3 10 5 6 1 2 7 4 9 8

*/
