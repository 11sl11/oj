package hdu;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Delta-wave
 * @author 11sl11
 *	数论(找规律)
 */
public class hdu_1030 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch (Exception ex) { }
	}

	public static void main(String[] args) {
		while(cin.hasNext()) {
			int n = cin.nextInt(), m = cin.nextInt();
			int xn = (int)Math.ceil(Math.sqrt(n)), xm = (int)Math.ceil(Math.sqrt(m));
			int yn = (n-(xn-1)*(xn-1)+1)/2,  ym = (m-(xm-1)*(xm-1)+1)/2;
			int zn = (xn*xn - n)/2 + 1, zm = (xm*xm - m)/2 + 1;
			System.out.println(Math.abs(xn-xm) + Math.abs(yn-ym) + Math.abs(zn-zm));
		}
	}
}
