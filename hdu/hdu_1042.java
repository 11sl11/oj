package hdu;

import java.io.FileInputStream;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * N!
 * @author 11sl11
 * ½×³Ë
 */
public class hdu_1042 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch (Exception ex) { }
	}

	public static void main(String[] args) {
		BigInteger[] arrs = new BigInteger[10001];
		int i = 0;
		arrs[0] = BigInteger.valueOf(1);
		while(cin.hasNext()) {
			int n = cin.nextInt();
			while(n > i) {
				arrs[++i] = arrs[i-1].multiply(BigInteger.valueOf(i));
			}
			System.out.println(arrs[n]);
		}
	}
}
