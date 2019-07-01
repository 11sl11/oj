package hdu;

import java.io.FileInputStream;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Computer Transformation
 * @author 11sl11
 * ’“πÊ¬…
 */
public class hdu_1041 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch (Exception ex) { }
	}

	public static void main(String[] args) {
		BigInteger[] arrs = new BigInteger[1001];
		int i = 2;
		arrs[1] = BigInteger.valueOf(0);
		arrs[2] = BigInteger.valueOf(1);
		while(cin.hasNext()) {
			int n = cin.nextInt();
			while(i < n) {
				arrs[++i] = arrs[i-1].add(arrs[i-2].multiply(BigInteger.valueOf(2)));
			}
			System.out.println(arrs[n]);
		}
	}
}
