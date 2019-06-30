package hdu;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Design T-Shirt
 * @author 11sl11
 *	Ä£Äâ
 */
public class hdu_1031 {
static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch (Exception ex) { }
	}
	
	static ArrayList<Couple> arrs = new ArrayList<>();
	public static void main(String[] args) {
		while(cin.hasNext()) {
			int n=cin.nextInt(), m=cin.nextInt(), k=cin.nextInt();
			arrs.clear();
			for(int i=0; i<m; i++) {
				double x = cin.nextDouble();
				arrs.add(new Couple(x, i+1));
			}
			for(int i=1; i<n; i++) {
				for(int j=0; j<m; j++) {
					arrs.set(j, new Couple(arrs.get(j).x+cin.nextDouble(), arrs.get(j).idx));
				}
			}
			Collections.sort(arrs);
			ArrayList<Integer> ans = new ArrayList<>(k);
			for(int i=0; i<k; i++) ans.add(arrs.get(i).idx);
			Collections.sort(ans, Collections.reverseOrder());
			System.out.print(ans.get(0));
			for(int i=1; i<k; i++) {
				System.out.print(" " + ans.get(i));
			} System.out.println();
		}
	}
	
	static class Couple implements Comparable<Couple> {
		double x;
		int idx;

		Couple(double x, int idx) {
			this.x = x; this.idx = idx;
		}
		
		@Override
		public int compareTo(Couple o) {
			if(x == o.x) {
				return idx - o.idx;
			} else return x < o.x ? 1:-1;
		}
	}
}
