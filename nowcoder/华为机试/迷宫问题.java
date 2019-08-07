/**
* 题目描述：
* 定义一个二维数组N*M（其中2<=N<=10;2<=M<=10），如5 × 5数组下所示：
* int maze[5][5] = {
*   0, 1, 0, 0, 0,
*   0, 1, 0, 1, 0,
*   0, 0, 0, 0, 0,
*   0, 1, 1, 1, 0,
*   0, 0, 0, 1, 0 };
* 它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，
* 要求编程序找出从左上角到右下角的最短路线。入口点为[0,0],既第一空格是可以走的路。
*
* 输入描述：
* 一个N × M的二维数组，表示一个迷宫。数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。
*
* 输出描述：
* 左上角到右下角的最短路径
*
* 示例
*   输入
*   5 5
*   0 1 0 0 0
*   0 1 0 1 0
*   0 0 0 0 0
*   0 1 1 1 0
*   0 0 0 1 0
* 
*   输出
*   (0,0)
*   (1,0)
*   (2,0)
*   (2,1)
*   (2,2)
*   (2,3)
*   (2,4)
*   (3,4)
*   (4,4)
*
*/

import java.util.*;

public class Main {
	Scanner cin = new Scanner(System.in);
	public static void main(String[] args) {
		new Main().run();
	}
	
	final int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	void run() {
		while(cin.hasNext()) {
			int n = cin.nextInt(), m = cin.nextInt();
			int[][] map = new int[n][m];
			Cell[][] path = new Cell[n][m];
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) map[i][j] = cin.nextInt();
			}
			ArrayDeque<Cell> Q = new ArrayDeque<>();
			Q.offer(path[0][0] = new Cell(0, 0));
			while(!Q.isEmpty()) {
				Cell cell = Q.poll();
				for(int i=0; i<4; i++) {
					int x = cell.x+move[i][0], y = cell.y+move[i][1];
					if(x<0||x>=n||y<0||y>=m||map[x][y]==1||path[x][y]!=null) continue;
					path[x][y] = cell;
					Q.offer(new Cell(x, y));
					if(x==n-1 && y==m-1) break;
				}
			}
			
			int x = n-1, y = m-1;
			ArrayList<Cell> ans = new ArrayList<>();
			ans.add(new Cell(x, y));
			do {
				Cell cell = path[x][y];
				x = cell.x; y = cell.y;
				ans.add(new Cell(x, y));
			} while(x>0 || y>0);
			for(int i=ans.size()-1; i>=0; i--) {
				System.out.println(ans.get(i));
			}
		}
	}
	
	class Cell {
		int x, y;
		public Cell(int x, int y) {
			this.x = x; this.y = y;
		}
		@Override
		public String toString() {
			return "(" + x + "," + y + ")";
		}
	}
}
