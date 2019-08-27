/**
* 题目描述：（拼多多机试）
* 又到了吃午饭的时间，你和你的同伴刚刚研发出了最新的GSS-483型自动打饭机器人，现在你们正在对机器人进行功能测试。
* 为了简化问题，我们假设午饭一共有N个菜，对于第i个菜，你和你的同伴对其定义了一个好吃程度（或难吃程度，如果是负
* 数的话……）A[i]，由于一些技（经）术（费）限制，机器人一次只能接受一个指令：两个数L, R——表示机器人将会去打第
* L~R一共R-L+1个菜。本着不浪费的原则，你们决定机器人打上来的菜，含着泪也要都吃完，于是你们希望机器人打的菜的好
* 吃程度之和最大然而，你善变的同伴希望对机器人进行多次测试（实际上可能是为了多吃到好吃的菜），他想知道机器人打M
* 次菜能达到的最大的好吃程度之和当然，打过一次的菜是不能再打的，而且你也可以对机器人输入-1, -1，表示一个菜也不打
*
* 输入描述：
* 第一行：N, M(1<=N<=100000, 1<=M<=10000)
* 第二行：A[1], A[2], ..., A[N](|A[i]|<=10000)
*
* 输出描述：
* 一个数字S，表示M次打菜的最大好吃程度之和
*
* 示例
*   输入
*   7 2
*   1 2 3 -2 3 -10 3
*
*   7 4
*   1 2 3 -2 3 -10 3
*
*   输出
*   10 （说明：[1 2 3 -2 3] -10 [3]）
*
*   12 （说明：[1 2 3] -2 [3] -10 [3]， 第四次给机器人-1, -1的指令）
*
*/

/**
* 解题思路：
* m段最大子序列和问题：对于前j个数分成i组，可以得到最大的子序列和可以记为dp[i][j]，其转移方程：
* dp[i][j] = dp[i][j-1]+a[j] 第j个数位于第i子段中；
* dp[i][j] = max(dp[i-1][k])+a[j] (i-1<=k<j)第j个数开创第i子段,最大值肯定是前i-1个子段的最大值加上当前的a[j]
*/

import java.util.*;

public class Main {
	Scanner cin = new Scanner(System.in);
	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		while(cin.hasNext()) {
			int n = cin.nextInt(), m = cin.nextInt(), ans=Integer.MIN_VALUE;
			int[] arr = new int[n+1];
			int[][] dp = new int[2][n+2];
			for(int i=1; i<=n; i++) arr[i]=cin.nextInt();
			for(int i=1; i<=m; i++) {
				dp[i&1][i-1] = ans = Integer.MIN_VALUE;
				for(int j=i; j<=n-m+i; j++) {
					ans = Math.max(ans, dp[(i-1)&1][j-1]);
					dp[i&1][j] = Math.max(ans, dp[i&1][j-1]) + arr[j];
				}
			}
			ans = Integer.MIN_VALUE;
			for(int i=m; i<=n; i++) {
				ans = Math.max(ans, dp[m&1][i]);
			} System.out.println(ans);
		}
	}
}
