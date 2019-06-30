package hdu;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * The 3n + 1 problem
 * @author 11sl11
 *	Ä£Äâ
 */
public class hdu_1032 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch (Exception ex) { }
	}

	public static void main(String[] args) {
		while(cin.hasNext()) {
			int n = cin.nextInt(), m = cin.nextInt(), a, b, ans=0;
			a = Math.min(n, m); b = Math.max(n, m);
			for(int i=a; i<=b; i++) {
				ans = Math.max(ans, T(i));
			}
			System.out.println(n + " " + m + " " + ans);
		}
	}
	
	static int T(int x) {
		int ans = 1;
		while(x != 1) { 
			if(x % 2 == 1) {
				x = 3*x + 1;
			} else x /= 2;
			ans++;
		}
		return ans;
	}
}
