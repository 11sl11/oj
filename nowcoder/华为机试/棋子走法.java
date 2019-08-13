/**
* 题目描述：
* 计算n x m的棋盘格子（n为横向的格子数，m为竖向的格子数）沿着各自边缘线从左上角走到右下角，
* 总共有多少种走法，要求不能走回头路，即：只能往右和往下走，不能往左和往上走。
*
* 示例
*   输入
*   2 2
*
*   输出
*   6
*
*/

/**
* 解题思路
* 只要走到边缘，只有一种走法
*/

import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }

    int n, m;
    void run() {
    	while(cin.hasNext()) {
    		n = cin.nextInt(); m = cin.nextInt();
    		System.out.println(dfs(0, 0));
        }
    }
    
    int dfs(int x, int y) {
    	if(x==n || y==m) {
    		return 1;
    	}
    	return dfs(x+1, y) + dfs(x, y+1);
    }
}
