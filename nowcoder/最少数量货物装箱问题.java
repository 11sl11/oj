/**
* 题目描述：（拼多多机试）
* 有重量分别为3，5，7公斤的三种货物，和一个载重量为X公斤的箱子（不考虑体积等其它因素，只计算重量）需要向箱子内
* 装满X公斤的货物，要求使用的货物个数尽可能少（三种货物数量无限）
*
* 输入描述：
* 输入箱子载重量X(1 <= X <= 10000)，一个整数。
*
* 输出描述：
* 如果无法装满，输出 -1。如果可以装满，输出使用货物的总个数。
*
* 示例：
*   输入
*   4
*   8
*
*   输出
*   -1
*   2
*
*/

/**
* 解题思路：（完全背包问题）
* dp[i][v]表示前 i 种物品恰放入一个容量为 v 的背包的最大权值，其转移方程为：
* dp[i][v] = max(dp[i-1][v], dp[i−1][v−kC[i]] + kW[i]) (0 ≤ kC[i] ≤ v)
* 一维数组方式：
* dp[0..V] = 0
* for i<-1 to N
*   for v<-C[i] to V
*     dp[v]<-max(dp[v], dp[v−C[i]]+W[i])
*
* 要求“恰好装满背包”时的最优解：在初始化时除了dp[0]为 0，其它dp[1..V] 均设为 无穷小；
* 没有要求必须把背包装满，而是只希望价格尽量大：初始化时应该将dp[0..V]全部设为 0.
*/

import java.util.*;

public class Main {
	Scanner cin = new Scanner(System.in);
	public static void main(String[] args) {
		new Main().run();
	}

	final int[] C = {3, 5, 7};
	final int MAXN = 1<<22;
	void run() {
		while(cin.hasNext()) {
			int n = cin.nextInt();
			int[] dp = new int[n+1];
			Arrays.fill(dp, MAXN);
			dp[0] = 0;
			for(int i=0; i<C.length; i++) {
				for(int j=C[i]; j<=n; j++) {
					dp[j] = Math.min(dp[j], dp[j-C[i]]+1);
				}
			} System.out.println(dp[n]<MAXN ? dp[n]:-1);
		}
	}
}
