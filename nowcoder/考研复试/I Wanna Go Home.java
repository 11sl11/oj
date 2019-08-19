/**
* 题目描述：
* 图中的节点分别隶属于 1 或 2 阵营，求从 节点1 到 节点2 最短路径，要求所求路径只能跨越不同阵营一次。
*
* 输入描述：
* 存在多组测试数据
* 测试数据组第一行为节点个数 N(2<=N<=600)，第二行为无向边条数 M(0<=M<=10000)，之后的 M 行由三个整数组成，
* 分别表示节点 A、B 以及边的权值 T(1<=T<=500)。第 M+3 为节点的隶属，每个节点只能隶属于 1 或 2。当 N=0 时，
* 结束测试数据输入。
*
* 输出描述：
* 若存在从节点1到节点2的最短路径，则输出最小权值；否则输出-1.
*
* 示例
*   输入
*   2
*   1
*   1 2 100
*   1 2
*   3
*   3
*   1 2 100
*   1 3 40
*   2 3 50
*   1 2 1
*   5
*   5
*   3 1 200
*   5 3 150
*   2 5 160
*   4 3 170
*   4 2 170
*   1 2 2 2 1
*   0
*
*   输出
*   100
*   90
*   540
*
*/

import java.util.*;

public class Main {
	Scanner cin = new Scanner(System.in);
	public static void main(String[] args) {
		new Main().run();
	}

	final int MAX_VALUE = 1<<22;
	void run() {
		while(cin.hasNext()) {
			int n = cin.nextInt(), m, x, y, z;
			if(n == 0) break;
			m = cin.nextInt();
			cities = new int[n+1];
			visited = new boolean[n+1];
			graph = new int[n+1][n+1];
			for(int i=0; i<=n; i++) {
				Arrays.fill(graph[i], MAX_VALUE);
				graph[i][i] = 0;
			}
			for(int i=0; i<m; i++) {
				x = cin.nextInt();
				y = cin.nextInt();
				z = cin.nextInt();
				if(graph[x][y] > z) {
					graph[x][y] = graph[y][x] = z;
				}
			}
			for(int i=1; i<=n; i++) {
				cities[i] = cin.nextInt();
			}
			dosth(n);
		}
	}
	
	int[][] graph;
	int[] cities;
	boolean[] visited;
	void dosth(int n) {
		int[] dist = new int[n+1];
		for(int i=1; i<=n; i++) {
			dist[i] = graph[1][i];
		}
		int k = 1, min;
		visited[k] = true;
		for(int i=1; i<n; i++) {
			min = MAX_VALUE;
			for(int j=1; j<=n; j++) {
				if(!visited[j] && min>dist[j]) {
					min = dist[j];
					k = j;
				}
			}
			visited[k] = true;
			for(int j=1; j<=n; j++) {
				if(!visited[j] && graph[k][j]<MAX_VALUE &&
					!(cities[k]==2 && cities[j]==1)) {
					if(dist[j] > (dist[k]+graph[k][j])) {
						dist[j] = dist[k] + graph[k][j];
					}
				}
			}
		} System.out.println(dist[2]<MAX_VALUE ? dist[2]:-1);
	}
}
