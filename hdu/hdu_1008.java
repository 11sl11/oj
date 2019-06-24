package hdu;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Elevator
 * @author 11sl11
 *	Ä£Äâ
 */
public class hdu_1008 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch (Exception ex) {
		}
	}

	public static void main(String[] args) {
		while(cin.hasNext()) {
			int n = cin.nextInt(), u, v, ans = 0;
			if(n == 0) break;
			v = u = cin.nextInt();
			ans += u*6 + 5;
			for(int i=1; i<n; i++) {
				u = cin.nextInt();
				if(u > v) {
					ans += (u-v)*6 + 5;
				} else {
					ans += (v-u)*4 + 5;
				}
				v = u;
			}
			System.out.println(ans);
		}
	}
}
