package hdu;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * As Easy As A+B
 * @author 11sl11
 *	Ä£Äâ
 */
public class hdu_1040 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch (Exception ex) { }
	}

	public static void main(String[] args) {
		int nCase = cin.nextInt(), n;
		while(nCase-- > 0) {
			n = cin.nextInt();
			int[] arrs = new int[n];
			for(int i=0; i<n; i++) arrs[i] = cin.nextInt();
			Arrays.sort(arrs);
			
			System.out.print(arrs[0]);
			for(int i=1; i<n; i++) {
				System.out.print(" " + arrs[i]);
			} System.out.println();
		}
	}
}
