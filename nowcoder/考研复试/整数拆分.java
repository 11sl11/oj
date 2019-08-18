/**
* 题目描述：
* 一个整数总可以拆分为2的幂的和，例如： 7=1+2+4 7=1+2+2+2 7=1+1+1+4 7=1+1+1+2+2 7=1+1+1+1+1+2 7=1+1+1+1+1+1+1
* 总共有六种不同的拆分方式。 再比如：4可以拆分成：4 = 4，4 = 1 + 1 + 1 + 1，4 = 2 + 2，4=1+1+2。 用f(n)表示n的不
* 同拆分的种数，例如f(7)=6. 要求编写程序，读入n(不超过1000000)，输出f(n)%1000000000。
* 
* 输入描述：
* 每组输入包括一个整数：N(1<=N<=1000000)。
*
* 输出描述：
* 对于每组数据，输出f(n)%1000000000。
*
*/

/**
* 解题思路：
* 假设结果为f(n)，有递推公式f(2m+1)=f(2m)，f(2m)=f(2m-1)+f(m)，考虑分解中是否有1就很容易证明上述递推公式。
* f(2m)=f(2m-1)+f(m)分为奇数和偶数之和。
*/

import java.util.*;

public class Main {
	Scanner cin = new Scanner(System.in);
	public static void main(String[] args) {
		new Main().run();
	}

	final int MAXN = 1000000000;
	void run() {	
		while(cin.hasNext()) {
			int x = cin.nextInt();
			int[] dp = new int[x+1];
			dp[1] = 1; dp[2] = 2;
			for(int i=3; i<=x; i++) {
				if((i&1) == 1) {
					dp[i] = dp[i-1] % MAXN;
				} else dp[i] = (dp[i-1] + dp[i/2]) % MAXN;
			} System.out.println(dp[x]);
		}
	}
}

/**
* 解题思路：
* 完全背包问题。因为每一个拆分必须是1,2,4,2^3,...2^19(考虑n最大为10^6),所以对于一个整数n,
* 看它的这种拆分数有多少个,就相当于现在有20种物品,第i种物品的花费是2^(i-1),每一种可以重复取, 
* dp[i][j]表示前i种物品恰装满容量为j的物品时的方案总数,从而dp[i][j] = dp[i-1][j] + dp[i][j-a[i]]
*/
import java.util.*;

public class Main {
	Scanner cin = new Scanner(System.in);
	public static void main(String[] args) {
		new Main().run();
	}

	int[] W = new int[20];
	{ for(int i=0; i<20; i++) W[i] = 1<<i; }
	
	final int MAXN = 1000000000;
	void run() {	
		while(cin.hasNext()) {
			int x = cin.nextInt();
			int[] dp = new int[x+1];
			dp[0] = 1;
			for(int i=0; i<20; i++) {
				for(int j=W[i]; j<=x; j++) {
					dp[j] = (dp[j] + dp[j-W[i]]) % MAXN;
				}
			} System.out.println(dp[x]);
		}
	}
}

/**
* 背包问题之整数划分：
*
*  给定一个正整数 n 和 k:
*  1. 将 n 划分成若干正整数之和的划分数
*     完全背包( 有1--n个背包，每个物品可重复使用，第i个背包的重量为i,价值为i)
*     dp[0] = 1;
*     for(i=1; i<=n; i++) {
*         for(j=i; j<=n; j++) dp[j] = dp[j]+dp[j-i];
*     }
*
*  2. 将 n 划分为 k 个正整数之和的划分数
*     递归
*     int dfs(int n, int k) {
*         if(n==k || k==1) return 1;
*         if(n < k) return 0;
*         return dfs(n-k, k) + dfs(n-1, k-1);
*     }
*
*  3. 将 n 划分成最大数不超过 k 的划分数
*     用前 k 个背包来装，把 第1问中的第一个循环 n 改为k就行
*     dp[0] = 1;
*     for(i=1; i<=k; i++) {
*         for(j=i; j<=n; j++) dp[j] = dp[j] + dp[j-i];
*     }
*
*  4. 将 n 划分成若干奇正整数之和的划分数
*     为奇数，那么i=2,4,6,....，因为背包的种类不符合
*     dp[0] = 1;
*     for(i=1; i<=n; i+=2) {
*         for(j=i; j<=n; j++) dp[j] = dp[j] + dp[j-i];
*     }
*
*  5. 将 n 划分为若干不同整数之和的划分数
*     每个数只能使用一次，典型的0-1背包
*     dp[0] = 1;
*     for(i=1; i<=n; i++) {
*         for(j=n; j>=i; j--) dp[j] = dp[j] + dp[j-i];
*     }
*/
