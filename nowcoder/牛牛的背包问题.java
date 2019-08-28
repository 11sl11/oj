/**
* 题目描述：（网易机试）
* 牛牛准备参加学校组织的春游, 出发前牛牛准备往背包里装入一些零食, 牛牛的背包容量为w。牛牛家里一共有n袋零食, 
* 第i袋零食体积为v[i]。牛牛想知道在总体积不超过背包容量的情况下,他一共有多少种零食放法(总体积为0也算一种放法)。
*
* 输入描述：
* 输入包括两行
* 第一行为两个正整数n和w(1 <= n <= 30, 1 <= w <= 2 * 10^9),表示零食的数量和背包的容量。
* 第二行n个正整数v[i](0 <= v[i] <= 10^9),表示每袋零食的体积。
*
* 输出描述：
* 输出一个正整数, 表示牛牛一共有多少种零食放法。
*
* 示例
*   输出
*   3 10
*   1 2 4
*
*   输入
*   8（说明：三种零食总体积小于10,于是每种零食有放入和不放入两种情况，一共有2*2*2 = 8种情况。）
*
*/

/**
* 解题思路：
* 对于放与不放组合问题，采用递归方式遍历每一种情况
*/

import java.util.*;

public class Main {
	Scanner cin = new Scanner(System.in);
	public static void main(String[] args) {
		new Main().run();
	}

	long arr[], w;
	int n, cnt;
	void run() {
		while(cin.hasNext()) {
			n = cin.nextInt(); w = cin.nextInt();
			arr = new long[n];
			long s = 0;
			for(int i=0; i<n; i++) {
				arr[i] = cin.nextLong();
				s += arr[i];
			}
			if(s <= w) {
				System.out.println(1<<n);
				continue;
			}
			cnt = 0;
			dfs(0, 0);
			System.out.println(cnt);
		}
	}
	
	void dfs(long s, int k) {
		if(s > w) return;
		cnt++;
		for(int i=k; i<n; i++) {
			dfs(s+arr[i], i+1);
		}
	}
}
