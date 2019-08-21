/**
* 题目描述：
* 小易准备去拜访他的朋友，他的家在0点，但是他的朋友的家在x点(x > 0)，均在一条坐标轴上。小易每一次
* 可以向前走1，2，3，4或者5步。问小易最少走多少次可以到达他的朋友的家。
*
* 输入描述：
* 一行包含一个数字x(1 <= x <= 1000000)，代表朋友家的位置。
*
* 输出描述：
* 一个整数，最少的步数。
*
* 示例
*   输入
*   10
*
*   输出
*   2
*
*/

import java.util.*;

public class Main {
	Scanner cin = new Scanner(System.in);
	public static void main(String[] args) {
		new Main().run();
	}

	final int MAX_VALUE = 1<<22;
	void run() {
		while(cin.hasNext()) {
			int n = cin.nextInt();
			int[] dp = new int[n<6?6:(n+1)];
			Arrays.fill(dp, MAX_VALUE);
			dp[0] = 0;
			dp[1] = dp[2] = dp[3] = dp[4] = dp[5] = 1;
			for(int i=6; i<=n; i++) {
				for(int j=1; j<6; j++) {
					dp[i] = Math.min(dp[i], dp[i-j]+1);
				}
			} System.out.println(dp[n]);
		}
	}
}
