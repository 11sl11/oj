package hdu;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Big Number
 * @author 11sl11
 *	斯大林公式
 */
public class hdu_1018 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch (Exception ex) { }
	}

	public static void main(String[] args) {
		int nCase = cin.nextInt();
		while(nCase-- > 0) {
			int n = cin.nextInt();
			double ans = 1.0;
			for(int i=1; i<=n; i++) {
				ans += Math.log10(i);
			}
			System.out.println((int)ans);
		}
	}
}
