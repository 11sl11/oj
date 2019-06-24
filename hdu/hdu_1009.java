package hdu;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * FatMouse' Trade
 * @author 11sl11
 *	¼òµ¥Ì°ÐÄ
 */
public class hdu_1009 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch (Exception ex) { }
	}

	static ArrayList<Cell> cells = new ArrayList<>();
	public static void main(String[] args) {
		while(cin.hasNext()) {
			int M = cin.nextInt(), N = cin.nextInt(), J, F;
			if(M <0 && N <0) break;
			cells.clear();
			for(int i=0; i<N; i++) {
				J = cin.nextInt();
				F = cin.nextInt();
				cells.add(new Cell(J, F));
			}
			Collections.sort(cells);
			double ans = 0, m = 1.0*M;
			for(int i=0; i<cells.size() && m>0; i++) {
				if(m >= cells.get(i).F) {
					ans += cells.get(i).J;
					m -= cells.get(i).F;
				} else {
					ans += cells.get(i).ratio * m;
					m = 0;
				}
			}
			System.out.println(String.format("%.3f", ans));
		}
	}
	
	static class Cell implements Comparable<Cell> {
		double ratio;
		int J, F;
		
		Cell(int J, int F) {
			this.J = J;
			this.F = F;
			this.ratio = 1.0*J /F;
		}

		@Override
		public int compareTo(Cell o) {
			return ratio < o.ratio ? 1:-1;
		}
	}
}
