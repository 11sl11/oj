/**
* 题目描述：
* 用一维数组存储学号和成绩，然后，按成绩排序输出。
*
* 输入描述：
* 输入第一行包括一个整数N(1<=N<=100)，代表学生的个数。
* 接下来的N行每行包括两个整数p和q，分别代表每个学生的学号和成绩。
*
* 输出描述：
* 按照学生的成绩从小到大进行排序，并将排序后的学生信息打印出来。
* 如果学生的成绩相同，则按照学号的大小进行从小到大排序。
* 
* 示例
*   输入
*   3
*   1 90
*   2 87
*   3 92
*
*   输出
*   2 87
*   1 90
*   3 92
*
*/

import java.util.*;

public class Main {
	Scanner cin = new Scanner(System.in);
	public static void main(String[] args) {
		new Main().run();
	}

	void run() {	
		while(cin.hasNext()) {
			int n = cin.nextInt();
			Cell[] cells = new Cell[n];
			for(int i=0; i<n; i++) {
				cells[i] = new Cell(cin.nextInt(), cin.nextInt());
			}
			Arrays.sort(cells);
			for(int i=0; i<n; i++) {
				System.out.println(cells[i]);
			}
		}
	}
	
	class Cell implements Comparable<Cell> {
		int id, score;

		Cell(int id, int score) { this.id = id; this.score = score; }
		
		@Override
		public int compareTo(Cell o) {
			if(score == o.score) {
				return id < o.id ? -1:1;
			} return score < o.score ? -1:1;
		}
		
		@Override
		public String toString() {
			return id + " " + score;
		}
	}
}
