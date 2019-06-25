package hdu;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Fibonacci Again
 * @author 11sl11
 *	¹æÂÉ
 */
public class hdu_1021 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch (Exception ex) { }
	}

	public static void main(String[] args) {
		while(cin.hasNext()) {
			System.out.println(cin.nextInt()%4 == 2 ? "yes":"no");
		}
	}
}
