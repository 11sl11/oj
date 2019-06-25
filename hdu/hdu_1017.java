package hdu;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * A Mathematical Curiosity
 * @author 11sl11
 *	Ä£Äâ
 */
public class hdu_1017 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch (Exception ex) { }
	}

	public static void main(String[] args) {
		int nCase = cin.nextInt(), n, m;
		while(nCase-- >0) {
			int cnt = 0, ans;
			while(true) {
				n = cin.nextInt(); m = cin.nextInt();
				if(n == 0 && m == 0) break;
				ans = 0;
				for(int b=2; b<n; b++) {
					for(int a=1; a<b; a++) {
						if((a*a + b*b + m)%(a*b) == 0) ans++;
					}
				}
				System.out.println("Case " + (++cnt) + ": " + ans);
			}
			if(nCase >0) System.out.println();
		}
	}
}
