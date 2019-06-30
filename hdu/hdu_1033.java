package hdu;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Edge
 * @author 11sl11
 *	Ä£Äâ
 */
public class hdu_1033 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch (Exception ex) { }
	}

	static int[][] move = {{0, 10}, {-10, 0}, {0, -10}, {10, 0}};
	public static void main(String[] args) {
		while(cin.hasNext()) {
			String ss = cin.next();
			System.out.println("300 420 moveto");
			System.out.println("310 420 lineto");
			
			int x = 310, y = 420, dir = 0;
			for(int i=0; i<ss.length(); i++) {
				if(ss.charAt(i) =='V') {
					x += move[dir][0];
					y += move[dir][1];
					dir = (dir + 1) % 4;
				} else {
					x -= move[dir][0];
					y -= move[dir][1];
					dir = (dir+3) % 4;
				}
				System.out.println(new StringBuilder().append(x)
					.append(' ').append(y).append(' ').append("lineto"));
			}
			System.out.println("stroke");
			System.out.println("showpage");
		}
	}
}
