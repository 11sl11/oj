package hdu;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Constructing Roads In JGShining's Kingdom
 * @author 11sl11
 *	最长递增子序列
 */
public class hdu_1025 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch (Exception ex) { }
	}

	public static void main(String[] args) {
		int cnt = 0;
		while(cin.hasNext()) {
			int n = cin.nextInt();
			int[] bf = new int[n+1];
			for(int i=0; i<n; i++) bf[cin.nextInt()] = cin.nextInt();
			System.out.println("Case " + (++cnt) + ":");
			int ans = dp(n, bf);
			System.out.println("My king, at most " + ans + 
					(ans == 1 ? " road":" roads") +  " can be built.\n");
		}
	}
	
//	public static int dp(int n, int[] bf) {
//		int[] dp = new int[n+1];
//		int ans = 0;
//		for(int i=1; i<=n; i++) {
//			for(int j=1; j<i; j++) {
//				if(bf[i] > bf[j]) dp[i] = Math.max(dp[i], dp[j]+1);
//			}
//			ans = Math.max(ans, dp[i]);
//		}
//		return ans+1;
//	}
	
	public static int dp(int n, int[] bf) {
		int[] low = new int[n+1];
		int ans = 1;
		low[1] = bf[1];
		for(int i=2; i<=n; i++) {
			int left=1, right=ans, mid;
			while(left <= right) {
				mid = (left+right)/2;
				if(low[mid] < bf[i]) {
					left = mid+1;
				} else right = mid-1;
			}
			low[left] = bf[i];
			ans = Math.max(ans, left);
		}
		return ans;
	}
}
