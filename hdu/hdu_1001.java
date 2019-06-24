package hdu;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Sum Problem 
 * @author 11sl11
 *	 等差数列求和
 */
public class hdu_1001 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch(Exception ex) {}
	}

	public static void main(String[] args) {
		while(cin.hasNext()) {
			int n = cin.nextInt();
			System.out.println((n%2 == 1) ? ((n+1)/2*n) : (n/2*(n+1)));
			System.out.println();
		}
	}
}
