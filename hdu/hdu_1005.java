package hdu;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Number Sequence
 * @author 11sl11
 *	’“πÊ¬…
 */
public class hdu_1005 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch (Exception ex) { }
	}
	
	static int[] arrs = new int[50];
	public static void main(String[] args) {
		arrs[1] = arrs[2] = 1;
		while(cin.hasNext()) {
			int x =cin.nextInt(), y =cin.nextInt(), m =cin.nextInt();
			if(x ==0 && y ==0 && m ==0) break;
			for(int i=3; i<50; i++) {
				arrs[i] = (x*arrs[i-1] + y*arrs[i-2]) % 7;
			}
			System.out.println(arrs[m%49]);
		}
	}
}
