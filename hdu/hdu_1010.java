package hdu;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Tempter of the Bone
 * @author 11sl11
 *	ËÑË÷+ÆæÅ¼¼ôÖ¦
 */
public class hdu_1010 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch (Exception ex) { }
	}

	static int startX, startY, endX, endY, M, N, T;
	public static void main(String[] args) {
		while(cin.hasNext()) {
			N = cin.nextInt(); M = cin.nextInt(); T = cin.nextInt();
			if(N == 0 && M == 0 && T == 0) break;
			
			int wall = 0;
			String[] map = new String[N+1];
			for(int i=1; i<=N; i++) {
				map[i] = cin.next();
				for(int j=1; j<=M; j++) {
					char c = map[i].charAt(j-1);
					if(c == 'S') {
						startX = i; startY = j;
					} else if(c == 'D') {
						endX = i; endY = j;
					} else if(c == 'X') wall++;
				}
			}
			
			if(T > (N*M-wall-1)) {
				System.out.println("NO");
				continue;
			}
			boolean[][] visited = new boolean[N+1][M+1];
			visited[startX][startY] = true;
			System.out.println(dfs(startX, startY, 0, map, visited) ? "YES":"NO");
		}
	}
	
	static final int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0,-1}};
	static boolean dfs(int x, int y, int t, String[] map, boolean[][] visited) {
		if(x==endX && y==endY && t==T) return true;
		int k = (T-t) - Math.abs(x-endX) - Math.abs(y-endY);
		if(k<0 || (k&1)==1) return false;
		for(int i=0; i<4; i++) {
			int newX = x+move[i][0], newY = y+move[i][1];
			if(newX>0 && newX<=N && newY>0 && newY<=M && map[newX].charAt(newY-1)!='X' &&
				!visited[newX][newY]) {
				visited[newX][newY] = true;
				if(dfs(newX, newY, t+1, map, visited)) return true;
				visited[newX][newY] = false;
			}
		}
		return false;
	}
}
