package hdu;

import java.io.FileInputStream;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * A + B Problem II 
 * @author 11sl11
 *	大数加法运算
 */
public class hdu_1002 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch(Exception ex) {}
	}
	
	public static void main(String[] args) {
		int nCase = cin.nextInt();
		for(int i=1; i<=nCase; i++) {
			BigInteger ai = new BigInteger(cin.next());
			BigInteger bi = new BigInteger(cin.next());
			System.out.println("Case " + i + ":");
			System.out.println(ai + " + " + bi + " = " + ai.add(bi));
			if(i < nCase) System.out.println();
		}
	}
}
