/**
* 题目描述：
* 给定各个点的坐标，要求用笔画直线连接各个节点，为了节省墨水，求最佳连线方式。墨水消耗量与直线长度呈
* 正比。
* 
* 输入描述：
* 第一行 N 为节点个数，之后 N 行为节点的坐标。
*
* 输出描述：
* 最少墨水需求量，结果精确到小数后两位。
*
* 示例
*   输入
*   3
*   1.0 1.0
*   2.0 2.0
*   2.0 4.0
*
*   输出
*   3.14
*
*/

import java.util.*;

public class Main {
	Scanner cin = new Scanner(System.in);
	public static void main(String[] args) {
		new Main().run();
	}

	double[][] graph;
	void run() {
		while(cin.hasNext()) {
			int n = cin.nextInt();
			Cell[] cells = new Cell[n];
			graph = new double[n][n];
			visited = new boolean[n];
			for(int i=0; i<n; i++) {
				cells[i] = new Cell(cin.nextDouble(), cin.nextDouble());
				for(int j=0; j<=i; j++) {
					graph[i][j] = graph[j][i] = cells[i].dist(cells[j]);
				}
			}
			System.out.println(String.format("%.2f", dosth(n)));
		}
	}
	
	boolean[] visited;
	double dosth(int n) {
		double[] dist = new double[n];
		int k = 0;
		for(int i=1; i<n; i++) dist[i] = graph[k][i];
		visited[k] = true;
		double result = 0, min;
		for(int i=1; i<n; i++) {
			min = Double.POSITIVE_INFINITY;
			for(int j=0; j<n; j++) {
				if(!visited[j] && min>dist[j]) {
					min = dist[j];
					k = j;
				}
			}
			result += min;
			visited[k] = true;
			for(int j=0; j<n; j++) {
				if(!visited[j] && dist[j]>graph[k][j]) {
					dist[j] = graph[k][j];
				}
			}
		}
		return result;
	}
	
	class Cell {
		double x, y;
		Cell(double x, double y) {
			this.x = x; this.y = y;
		}
		
		double dist(Cell o) {
			return Math.sqrt((x-o.x)*(x-o.x) + (y-o.y)*(y-o.y));
		}
	}
}
