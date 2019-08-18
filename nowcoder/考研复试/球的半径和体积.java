/**
* 题目描述：
* 输入球的中心点和球上某一点的坐标，计算球的半径和体积。
*
* 输入描述：
* 球的中心点和球上某一点的坐标，以如下形式输入：x0 y0 z0 x1 y1 z1
*
* 输出描述：
* 输入可能有多组，对于每组输入，输出球的半径和体积，并且结果保留三位小数
* 为避免精度问题，PI值请使用arccos(-1)。
*
* 示例
*   输入
*   0 0 0 1 1 1
* 
*   输出
*   1.732 21.766
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
			Cell o1 = new Cell(cin.nextInt(), cin.nextInt(), cin.nextInt());
			Cell o2 = new Cell(cin.nextInt(), cin.nextInt(), cin.nextInt());
			double r = o1.dist(o2);
			double v = 4*Math.acos(-1)*Math.pow(r, 3)/3;
			System.out.println(String.format("%.3f %.3f", r, v));
		}
	}
	
	class Cell {
		int x, y, z;
		
		Cell(int x, int y, int z) {
			this.x = x; this.y = y; this.z = z;
		}
		
		double dist(Cell o) {
			return Math.sqrt((x-o.x)*(x-o.x) +
				(y-o.y)*(y-o.y) + (z-o.z)*(z-o.z));
		}
	}
}
