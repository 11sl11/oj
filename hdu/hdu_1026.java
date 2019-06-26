package hdu;

import java.io.FileInputStream;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class hdu_1026 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch (Exception ex) { }
	}
	
	static int n, m;
	static final int MAXN = 100;
	static String[] map = new String[MAXN+1];
	public static void main(String[] args) {
		while(cin.hasNext()) {
			n = cin.nextInt(); m = cin.nextInt();
			for(int i=0; i<=n; i++) {
				if(i < n) map[i] = cin.next();
				for(int j=0; j<=m; j++) {
					paths[i][j] = -1;
					visited[i][j] = false;
				}
			}
			
			if(bfs()) {
				System.out.println(new StringBuilder().append("It takes ").append(totalSecond)
					.append(" seconds to reach the target position, let me show you the way."));
				currSecond = 0;
				char c = map[0].charAt(0);
				if(Character.isDigit(c)) {
					fighting(c-'0', 0, 0);
				}
//				dfs(n-1, m-1);
				print();
			} else System.out.println("God please help our poor hero.");
			System.out.println("FINISH");
		}
	}

	static int currSecond;
//	static void dfs(int x, int y) {
//		if(paths[x][y] == -1) return;
//		int newX = x-move[paths[x][y]][0];
//		int newY = y-move[paths[x][y]][1];
//		dfs(newX, newY);
//		
//		System.out.println(new StringBuilder().append(++currSecond).append("s:(")
//			.append(newX).append(',').append(newY).append(")->(").append(x)
//			.append(',').append(y).append(')'));
//		char c = map[x].charAt(y);
//		if(Character.isDigit(c)) {
//			fighting(c-'0', x, y);
//		}
//	}
	
	static void print() {
		int x = n-1, y = m-1, newX, newY, idx;
		Stack<Integer> stack = new Stack<>();
		while(x != 0 || y != 0) {
			stack.push(paths[x][y]);
			newX = x-move[paths[x][y]][0];
			newY = y-move[paths[x][y]][1];
			x = newX; y = newY;
		}
		x = y = 0;
		while(!stack.isEmpty()) {
			idx = stack.pop();
			newX = x + move[idx][0];
			newY = y + move[idx][1];
			System.out.println(new StringBuilder().append(++currSecond).append("s:(")
				.append(x).append(',').append(y).append(")->(").append(newX)
				.append(',').append(newY).append(')'));
			char c = map[newX].charAt(newY);
			if(Character.isDigit(c)) fighting(c-'0', newX, newY);
			x = newX; y = newY;
		}
	}
	
	static void fighting(int cnt, int x, int y) {
		for(int i=0; i<cnt; i++) {
			System.out.println(new StringBuilder().append(++currSecond).append("s:FIGHT AT (")
				.append(x).append(',').append(y).append(')'));
		}
	}
	
	static int totalSecond;
	static int[][] paths = new int[MAXN+1][MAXN+1];
	static boolean[][] visited = new boolean[MAXN+1][MAXN+1];
	static final int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static boolean bfs() {
		char c = map[0].charAt(0);
		if(c == 'X') return false;
		PriorityQueue<Point> Q = new PriorityQueue<>(MAXN+1);
		Q.offer(new Point(0, 0, (c=='.' ? 0:(c-'0'))));
		while(!Q.isEmpty()) {
			Point point = Q.poll();
			visited[point.x][point.y] = true;
			if(point.x == n-1 && point.y == m-1) {
				totalSecond = point.s;
				return true;
			}
			
			for(int i=0; i<4; i++) {
				int newX = point.x+move[i][0], newY = point.y+move[i][1];
				if(newX<0 || newX>=n || newY<0 || newY>=m ||
					visited[newX][newY] || map[newX].charAt(newY)=='X') continue;
				int t = map[newX].charAt(newY) == '.' ? 0:(map[newX].charAt(newY)-'0');
				Q.offer(new Point(newX, newY, t + point.s+1));
				paths[newX][newY] = i;
			}
		}
		return false;
	}
	
	static class Point implements Comparable<Point> {
		int x, y, s;
		
		Point(int x, int y, int s) {
			this.x = x; this.y = y; this.s = s;
		}
		
		@Override
		public int compareTo(Point o) {
			return s - o.s;
		}
	}
}