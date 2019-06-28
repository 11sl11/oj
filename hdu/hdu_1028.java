package hdu;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Ignatius and the Princess III
 * @author 11sl11
 *	整数划分
 */
public class hdu_1028 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch (Exception ex) { }
	}

	public static void main(String[] args) {
		while(cin.hasNext()) {
			int n = cin.nextInt();
//			System.out.println(dfs(n, n));
//			System.out.println(parentFunction(n));
			for(int i=0; i<=n; i++) Arrays.fill(dp[i], -1);
			System.out.println(dp(n, n));
		}
	}

//	static int dfs(int n, int m) {
//		if(n==1 || m==1) return 1;
//		if(m > n) return dfs(n, n);
//		if(m == n) return 1 + dfs(n, n-1);
//		return dfs(n-m, m) + dfs(n, m-1);
//	}
	
	static int[][] dp = new int[121][121];
	static int dp(int n, int m) {
		if(dp[n][m] > 0) return dp[n][m];
		if(n<1 || m<1) return dp[n][m] = 0;
		if(n==1 || m==1) return dp[n][m] = 1;
		if(n < m) return dp(n, n);
		if(n == m) return dp[n][m] = dp(n, m-1)+1;
		return dp[n][m] = dp(n, m-1) + dp(n-m, m);
	}
	
//	static int[] A = new int[121];
//	static int[] B = new int[121];
//	static int parentFunction(int n) {
//		for(int i=0; i<=n; i++) {
//			A[i] = 1; B[i] = 0;
//		}
//		for(int i=2; i<=n; i++) {
//			for(int j=0; j<=n; j++) {
//				for(int k=0; k+j<=n; k+=i) {
//					B[k+j] += A[j];
//				}
//			}
//			for(int j=0; j<=n; j++) {
//				A[j] = B[j];
//				B[j] = 0;
//			}
//		}
//		return A[n];
//	}
}
