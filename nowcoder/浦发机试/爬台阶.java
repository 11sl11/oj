/**
* 题目描述：
* 爬一个或者两个台阶，输入 1 <= n < 90 的数字为台阶数，以输入 0 作为结束标志，输出n个台阶共有多少种上楼方式.
*
* 示例
*   输入
*   1
*   2
*   3
*   4
*   0
*
*   输出
*   1
*   2
*   3
*   5
*
*/

import java.util.*;

public class Main {
	Scanner cin = new Scanner(System.in);
	public static void main(String[] args) {
		new Main().run();
	}
	
	final int MAXN = 90;
	int[] dp = new int[MAXN];
	{
		dp[0] = 0; dp[1] = 1; dp[2] = 2;
		for(int i=3; i<MAXN; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
	}
	
	void run() {
		while(cin.hasNext()) {
			int x = cin.nextInt();
			if(x == 0) break;
			System.out.println(dp[x]);
		}
	}
}
