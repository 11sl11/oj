package hdu;

import java.io.FileInputStream;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Digital Roots
 * @author 11sl11
 *	大数加法
 */
public class hdu_1013 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch (Exception ex) {
		}
	}

	public static void main(String[] args) {
		while(cin.hasNext()) {
			String ss = cin.next();
			if(ss.equals("0")) break;
			while(ss.length() > 1) {
				BigInteger tmp = new BigInteger("0");
				for(int i=ss.length()-1; i>=0; i--) {
					tmp = tmp.add(new BigInteger(String.valueOf(ss.charAt(i))));
				}
				ss = tmp.toString();
			}
			System.out.println(ss);
		}
	}
}
