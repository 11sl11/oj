/**
* 题目描述：
* 有若干张邮票，要求从中选取最少的邮票张数凑成一个给定的总值。如，有1分，3分，3分，3分，4分五张邮票，
* 要求凑成10分，则使用3张邮票：3分、3分、4分即可。
*
* 输入描述：
* 有多组数据，对于每组数据，首先是要求凑成的邮票总值M，M<100。然后是一个数N，N〈20，表示有N张邮票。
* 接下来是N个正整数，分别表示这N张邮票的面值，且以升序排列。
*
* 输出描述：
* 对于每组数据，能够凑成总值M的最少邮票张数。若无解，输出0。
*
* 示例
*   输入
*   10
*   5
*   1 3 3 3 4
*
*   41
*   12
*   1 1 1 2 2 4 5 5 7 8 8 10
*
*   输出
*   3
*   7
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
			int m = cin.nextInt(), n = cin.nextInt();
			int[] arr = new int[n];
			for(int i=0; i<n; i++) arr[i] = cin.nextInt();
			int[] dp = new int[m+1];
			Arrays.fill(dp, m+1);
			dp[0] = 0;
			for(int i=0; i<n; i++) {
				for(int j=m; j>=arr[i]; j--) {
					dp[j] = Math.min(dp[j], dp[j-arr[i]]+1);
				}
			}
			System.out.println(dp[m]<=m ? dp[m]:0);
		}
	}
}
