/**
* 题目描述：（滴滴机试）
* 一个数组有 N 个元素，求连续子数组的最大和。 例如：[-1,2,1]，和最大的连续子数组为[2,1]，其和为 3
*
* 输入描述：
* 输入为两行。 第一行一个整数n(1 <= n <= 100000)，表示一共有n个元素 第二行为n个数，即每个元素,每个整数都在32
* 位int范围内。以空格分隔。
*
* 输出描述：
* 所有连续子数组中和最大的值。
*
* 示例
*   输入
*   3 -1 2 1
* 
*   输出
*   3
*
*/

/**
* 解题思路：
* 用dp[i]表示到第i个数最大值，其转移方程为：
* dp[i] = max(dp[i-1]+a[i], a[i]), a[i]要么加入连续序列中，要么重新开始
*/

import java.util.*;

public class Main {
	Scanner cin = new Scanner(System.in);
	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		while(cin.hasNext()) {
			int n = cin.nextInt(), ans=Integer.MIN_VALUE;
			int[] arr = new int[n], dp = new int[n+1];
			for(int i=0; i<n; i++) arr[i]=cin.nextInt();
			dp[1] = arr[0];
			for(int i=0; i<n; i++) {
				dp[i+1] = Math.max(dp[i]+arr[i], arr[i]);
				ans = Math.max(ans, dp[i+1]);
			} System.out.println(ans);
		}
	}
}
