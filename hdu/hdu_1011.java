package hdu;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Starship Troopers
 * @author 11sl11
 *	Ê÷ÐÎ±³°üdp
 */
public class hdu_1011 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch (Exception ex) { }
	}

	static final int MAXN = 101;
	static int[] cost = new int[MAXN];
	static int[] value = new int[MAXN];
	static int[][] tree = new int[MAXN][MAXN];
	public static void main(String[] args) {
		while(cin.hasNext()) {
			int N = cin.nextInt(), M = cin.nextInt(), x, y;
			if(N <0 && M <0) break;
			for(int i=1; i<=N; i++) {
				cost[i] = cin.nextInt();
				value[i] = cin.nextInt();
			}
			for(int i=0; i<=N; i++) Arrays.fill(tree[i], 0);
			for(int i=1; i<N; i++) {
				x = cin.nextInt(); y = cin.nextInt();
				tree[x][0]++; tree[x][tree[x][0]] = y;
				tree[y][0]++; tree[y][tree[y][0]] = x;
			}
			if(M == 0) {
				System.out.println("0");
				continue;
			}
			for(int i=0; i<=N; i++) Arrays.fill(dp[i], 0);
			Arrays.fill(visited, false);
			dfs(1, M);
			System.out.println(dp[1][M]);
		}
	}
	
	static int[][] dp = new int[MAXN][MAXN];
	static boolean[] visited = new boolean[MAXN];
	static void dfs(int root, int M) {
		visited[root] = true;
		int expense = (cost[root]+19)/20;
		for(int i=expense; i<=M; i++) dp[root][i] = value[root];
		for(int i=1; i<=tree[root][0]; i++) {
			int u = tree[root][i];
			if(visited[u]) continue;
			dfs(u, M);
			for(int j=M; j>=expense; j--) {
				for(int k=1; k+j<=M; k++) {
					if(dp[u][k] != 0) {
						dp[root][j+k] = Math.max(dp[root][j+k], dp[root][j]+dp[u][k]);
					}
				}
			}
		}
	}
}
