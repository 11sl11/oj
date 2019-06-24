package hdu;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Uniform Generator
 * @author 11sl11
 *	ÊýÑ§(»¥ÖÊ)
 */
public class hdu_1014 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch (Exception ex) { }
	}

	public static void main(String[] args) {
		boolean first = true;
		while(cin.hasNext()) {
			int STEP = cin.nextInt(), MOD = cin.nextInt(), x, a, b;
			a = STEP; b = MOD;
			if(STEP > MOD) {
				x = STEP; STEP = MOD; MOD = x;
			}
			while(STEP != 0) {
				x = MOD % STEP;
				MOD = STEP;
				STEP = x;
			}
			if(!first) System.out.println();
			first = false;
			String out = String.format("%10d%10d    ", a, b);
			System.out.println(out + (MOD!=1 ? "Bad":"Good") + " Choice");
		}
	}
}
