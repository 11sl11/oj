package hdu;

import java.io.FileInputStream;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Train Problem II 
 * @author 11sl11
 *	数论(卡特兰数)
 */
public class hdu_1023 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch (Exception ex) { }
	}

	static final int MAXN = 100;
	static BigInteger[] catalan = new BigInteger[MAXN+1];
	static {
		catalan[0] = BigInteger.valueOf(1);
		for(int i=1; i<=MAXN; i++) {
			catalan[i] = catalan[i-1].multiply(BigInteger.valueOf(4*i-2)).divide(BigInteger.valueOf(i+1));
		}
	}
	
	public static void main(String[] args) {
		while(cin.hasNext()) {
			int n = cin.nextInt();
			System.out.println(catalan[n]);
		}
	}
}
