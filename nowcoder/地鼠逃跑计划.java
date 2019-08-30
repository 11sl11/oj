/**
* 题目描述：（小米机试）
* 有一只地鼠不小心跑进了一个m*n 的矩形田地里，假设地鼠在这块田地的初始位置为（x,y），并且每次只能向相邻的上下
* 左右四个方向移动一步，那么在最多移动K 次的情况下，有多少条路径可以逃出这片田地（一旦出去田地的边界就不能再往
* 回走）？下面是样例示意图：
*          ^   ^   ^
*        +-|-+-|-+-|-+
*      <-|-+-| X |-+-|->
*        +---+---+---+
*        |   | | |   |
*        +---+-|-+---+
*              v
*
* 输入描述：
* 输入数据包括五个参数：m,n,x,y,K，其中m和n的范围均为是[1,10]，K的范围是[0,10]。0<=x<m,0<=y<n。
*
* 输出描述：
* 输出成功逃跑的路径数量。
*
* 示例
*   输入
*   2 3 0 1 2
*
*   输出
*   6
*
*/

import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }
    
    int m, n, ans;
    void run() {
        while(cin.hasNext()) {
        	m=cin.nextInt(); n=cin.nextInt();
        	int x=cin.nextInt()+1, y=cin.nextInt()+1, k=cin.nextInt();
        	ans = 0;
        	dfs(x, y, k);
        	System.out.println(ans);
        }
    }
    
    void dfs(int x, int y, int k) {
    	if(x*y == 0 || x>m || y>n) {
//    		System.out.println(k + ":("+x+","+y+")");
    		ans++; return;
    	}
    	if(k<=0) return;
    	dfs(x-1, y, k-1);
    	dfs(x+1, y, k-1);
    	dfs(x, y-1, k-1);
    	dfs(x, y+1, k-1);
    }
}
