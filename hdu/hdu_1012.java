package hdu;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * u Calculate e
 * @author 11sl11
 *	Ä£Äâ
 */
public class hdu_1012 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch (Exception ex) { }
	}

	public static void main(String[] args) {
//		System.out.println("n e\n" + 
//				"- -----------\n" + 
//				"0 1\n" + 
//				"1 2\n" + 
//				"2 2.5\n" + 
//				"3 2.666666667\n" + 
//				"4 2.708333333");
//		for(int i=5; i<10; i++) {
//			double ans = 0;
//			for(int j=0; j<=i; j++) {
//				ans += 1.0/factorial(j);
//			}
//			System.out.println(String.format("%d %.9f", i, ans));
//		}
		
		System.out.println("n e\r\n" + 
				"- -----------\r\n" + 
				"0 1\r\n" + 
				"1 2\r\n" + 
				"2 2.5\r\n" + 
				"3 2.666666667\r\n" + 
				"4 2.708333333\r\n" + 
				"5 2.716666667\r\n" + 
				"6 2.718055556\r\n" + 
				"7 2.718253968\r\n" + 
				"8 2.718278770\r\n" + 
				"9 2.718281526");
	}
	
	static int factorial(int n) {
		if(n == 0) return 1;
		int ans = 1;
		for(int i=1; i<=n; i++) ans *= i;
		return ans;
	}
}
