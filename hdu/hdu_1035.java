package hdu;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Robot Motion
 * @author 11sl11
 *	ËÑË÷
 */
public class hdu_1035 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch (Exception ex) { }
	}
	
	static int n, m;
	static int[][] map = new int[11][11];
	public static void main(String[] args) {
		while(cin.hasNext()) {
			n = cin.nextInt(); m = cin.nextInt();
			if(n == 0 && m == 0) break;
			int k = cin.nextInt();
			for(int i=0; i<n; i++) {
				String ss = cin.next();
				for(int j=0; j<m; j++) {
					switch(ss.charAt(j)) {
						case 'N': map[i][j] = 0; break;
						case 'S': map[i][j] = 1; break;
						case 'E': map[i][j] = 2; break;
						case 'W': map[i][j] = 3;
					}
					hops[i][j] = 0;
				}
			}
			cnt = loop = 0;
			int newX = move[map[0][k-1]][0];
			int newY = k-1 + move[map[0][k-1]][1];
			hops[0][k-1] = 1;
			if(dfs(newX, newY, 0, k-1)) {
				System.out.println(cnt + " step(s) to exit");
			} else System.out.println(new StringBuilder().append(cnt)
					.append(" step(s) before a loop of ").append(loop)
					.append(" step(s)"));
		}
	}
	
	static int cnt, loop;
	static int[][] hops = new int[11][11];
	static int[][] move = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static boolean dfs(int x, int y, int px, int py) {
		if(x<0 || x>=n || y<0 || y>=m) {
			cnt = hops[px][py];
			return true;
		}
		if(hops[x][y] > 0) {
			cnt = hops[x][y]-1;
			loop = hops[px][py] - hops[x][y]+1;
			return false;
		}
		
		hops[x][y] += hops[px][py]+1;
		int newX = x + move[map[x][y]][0];
		int newY = y + move[map[x][y]][1];
		return dfs(newX, newY, x, y);
	}
}