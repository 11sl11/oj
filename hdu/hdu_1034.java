package hdu;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Candy Sharing Game
 * @author 11sl11
 *	Ä£Äâ
 */
public class hdu_1034 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch (Exception ex) { }
	}
	
	public static void main(String[] args) {
		while(cin.hasNext()) {
			int n = cin.nextInt();
			if(n == 0) break;
			
			int[] arrs = new int[n];
			for(int i=0; i<n; i++) arrs[i] = cin.nextInt();
			
			int cnt = sharing(arrs);
			System.out.println(cnt + " " + arrs[0]);
		}
	}
	
	static int sharing(int[] arrs) {
		int cnt =1;
		int[] tmp = new int[arrs.length];
		while(true) {
			boolean flag = true;
			for(int i=1; i<arrs.length; i++) {
				if(arrs[i-1] != arrs[i]) {
					flag = false;
					break;
				}
			}
			if(flag) return cnt-1;
			cnt++;
			for(int i=0; i<arrs.length; i++) {
				arrs[i] /= 2;
				tmp[i] = arrs[i];
			}
			for(int i=0; i<arrs.length; i++) {
				int j = (i+1) % arrs.length;
				arrs[j] += tmp[i];
				if(arrs[j]%2 == 1) arrs[j]++;
			}
		}
	}
}
