package hdu;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Max Sum
 * @author 11sl11
 *	最大子序列和
 */
public class hdu_1003 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch (Exception ex) { }
	}

	static int[] arrs = new int[100001];
	public static void main(String[] args) {
		int nCase = cin.nextInt();
		for(int i=1; i<=nCase; i++) {
			int n = cin.nextInt();
			for(int j=0; j<n; j++) arrs[j] = cin.nextInt();
			System.out.println("Case " + i + ":");
			System.out.println(res(n));
			if(i < nCase) System.out.println();
		}
	}
	
//	static String res(int n) {
//		int best=arrs[0], left=0, right=0;
//		for(int i=0; i<n; i++) {
//			for(int j=i; j<n; j++) {
//				int sum = 0;
//				for(int k=i; k<j; k++) sum += arrs[k];
//				if(sum > best) {
//					best = sum;
//					left = i+1;
//					right = j;
//				}
//			}
//		}
//		return best + " " + left + " " + right;
//	}
	
//	static String res(int n) {
//		int[] s = new int[n];
//		s[0] = 0;
//		int best=arrs[0], left=0, right=0;
//		for(int i=1; i<n; i++) s[i] = s[i-1] + arrs[i-1];
//		for(int i=0; i<n; i++) {
//			for(int j=i; j<n; j++) {
//				if(best < (s[j]-s[i])) {
//					best = s[j] - s[i];
//					left = i+1;
//					right = j;
//				}
//			}
//		}
//		return best + " " + left + " " + right;
//	}
	
	static String res(int n) {
		int maxsum=Integer.MIN_VALUE, best, sum=0, x=0, y=0, left=0, right=0;
		for(int i=0; i<n; i++) {
			if(sum >= 0) {
				best = sum + arrs[i];
				y = i;
			} else {
				best = arrs[i];
				x = y = i;
			}
			if(maxsum < best) {
				maxsum = best;
				left = x+1;
				right = y+1;
			}
			sum = best;
		}
		return maxsum + " " + left + " " + right;
	}
}
