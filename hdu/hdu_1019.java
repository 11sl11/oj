package hdu;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Least Common Multiple
 * @author 11sl11
 * 	最小公倍数
 */
public class hdu_1019 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch (Exception ex) { }
	}

	public static void main(String[] args) {
		int nCase = cin.nextInt();
		while(nCase-- > 0) {
			int m = cin.nextInt(), a, b, g;
			a = cin.nextInt();
			for(int i=1; i<m; i++) {
				b = cin.nextInt();
				g = gcd(Math.max(a, b), Math.min(a, b));
				if(a % g == 0) {
					a /= g;
				} else b /= g;
				a *= b;
			}
			System.out.println(a);
		}
	}
	
	static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a%b);
	}
}
