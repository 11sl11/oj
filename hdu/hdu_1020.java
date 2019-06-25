package hdu;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Encoding
 * @author 11sl11
 *	Ä£Äâ
 */
public class hdu_1020 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch (Exception ex) { }
	}

	public static void main(String[] args) {
		int nCase = cin.nextInt();
		while(nCase-- > 0) {
			String ss = cin.next();
			StringBuilder sb = new StringBuilder();
			char c = ss.charAt(0);
			for(int i=1; i<ss.length(); ) {
				int cnt = 0;
				while(i<ss.length() && c == ss.charAt(i)) {
					i++; cnt++;
				}
				if(cnt > 1) sb.append(cnt);
				sb.append(c);
				if(i < ss.length()) c = ss.charAt(i);
			}
			System.out.println(sb);
		}
	}
}
