package hdu;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Max Sum Plus Plus
 * @author 11sl11
 *	¶¯Ì¬¹æ»®
 */
public class hdu_1024 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch (Exception ex) { }
	}

	public static void main(String[] args) {
		while(cin.hasNext()) {
			int m = cin.nextInt(), n = cin.nextInt();
			int[] arr = new int[n+1];
			for(int i=1; i<=n; i++) {
				arr[i] = cin.nextInt();
			}
			System.out.println(dp(n, m, arr));
		}
	}

	static int dp(int n, int m, int[] arr) {
		int[][] dp = new int[2][n+1];
		int ans = Integer.MIN_VALUE;
		for(int i=1; i<=m; i++) {
			dp[i&1][i-1] = ans = Integer.MIN_VALUE;
			for(int j=i; j<=n; j++) {
				dp[i&1][j] = Math.max(dp[i&1][j-1], dp[(i-1)&1][j-1]) + arr[j];
				dp[i&1][j-1] = ans;
				ans = Math.max(ans, dp[i&1][j]);
			}
			dp[i&1][n] = ans;
		}
		return dp[m&1][n];
	}

//	static int dp(int n, int m, int[] arrs) {
//		int[] dp = new int[n+1], bf = new int[n+1];
//		
//		int tmp = Integer.MIN_VALUE;
//		for(int i=1; i<=m; i++) {
//			tmp = Integer.MIN_VALUE;
//			for(int j=i; j<=n; j++) {
//				dp[j] = Math.max(dp[j-1], bf[j-1]) + arrs[j];
//				bf[j-1] = tmp;
//				tmp = Math.max(tmp, dp[j]);
//			}
//		}
//		return tmp;
//	}
}
