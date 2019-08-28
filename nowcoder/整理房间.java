/**
* 题目描述：（网易机试）
* 又到了周末，小易的房间乱得一团糟。他希望将地上的杂物稍微整理下，使每团杂物看起来都紧凑一些，没有那么乱。地上
* 一共有 n 团杂物，每团杂物都包含4个物品。第 i 物品的坐标用(ai,bi)表示，小易每次都可以将它绕着(xi,yi)逆时针
* 旋转90度，这将消耗他的一次移动次数。如果一团杂物的 4 个点构成了一个面积不为 0 的正方形，我们说它是紧凑的。
* 因为小易很懒，所以他希望你帮助他计算一下每团杂物最少需要多少步移动能使它变得紧凑。
*
* 输入描述：
* 第一行一个数n(1 <= n <= 100)，表示杂物的团数。接下来4n行，每4行表示一团杂物，每行4个数ai, bi，xi, yi, 
* (-10^4 <= xi, yi, ai, bi <= 10^4)，表示第i个物品旋转的它本身的坐标和中心点坐标。
*
* 输出描述：
* n行，每行1个数，表示最少移动次数，若不能达到要求输出-1。
*
* 示例
*   输入
*   4
*   1 1 0 0
*   -1 1 0 0
*   -1 1 0 0
*   1 -1 0 0
*
*   1 1 0 0
*   -2 1 0 0
*   -1 1 0 0
*   1 -1 0 0
*
*   1 1 0 0
*   -1 1 0 0
*   -1 1 0 0
*   -1 1 0 0
*
*   2 2 0 1
*   -1 0 0 -2
*   3 0 0 -2
*   -1 1 -2 0
*
*   输出
*   1（说明：对于第一团杂物，我们可以旋转第二个或者第三个物品1次。）
*   -1
*   3
*   3
*
*/

/**
* 解题思路：
* 点(x,y)绕原点逆时针旋转 α 得到(x',y')的公式：
* x'=xcosα-ysinα
* y'=xsinα+ycosα
* 现在顺时针旋转α,即逆时针旋转-α,用-α代替上面的α,并根据公式cos(-α)=cosα,sin(-α)=-sinα 得
* x'=xcosα+ysinα
* y'=-xsinα+ycosα
* 最后如果旋转中心为(a,b),在利用上面的公式时,需要把(a,b)沿向量(-a,-b)移动到原点,此时(x,y)
* 变成(x-a,y-b),(x',y')变成(x'-a,y'-b),整理得
* x'=(x-a)cosα+(y-b)sinα+a
* y'=-(x-a)sinα+(y-b)cosα+b
*
* 正方形判断：四边相等，两对角线相等的四边形
*/

import java.util.*;

public class Main {
	Scanner cin = new Scanner(System.in);
	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		while(cin.hasNext()) {
			int n = cin.nextInt(), ans;
			Cell[] cells = new Cell[4];
			while(n-- > 0) {
				for(int i=0; i<4; i++) {
					cells[i] = new Cell(cin.nextInt(), cin.nextInt(), cin.nextInt(), cin.nextInt());
				}
				ans = Integer.MAX_VALUE;
				for(int i0=0; i0<4; i0++) {
					for(int i1=0; i1<4; i1++) {
						for(int i2=0; i2<4; i2++) {
							for(int i3=0; i3<4; i3++) {
								if(dosth(cells[0].ps[i0], cells[1].ps[i1], cells[2].ps[i2], cells[3].ps[i3])) {
									ans = Math.min(ans, i0+i1+i2+i3);
								}
							}
						}
					}
				} System.out.println(ans<Integer.MAX_VALUE ? ans:-1);
			}
		}
	}
	
	boolean dosth(int[]... ps) {
		Set<Integer> set = new HashSet<>();
		for(int i=0; i<4; i++) {
			for(int j=i+1; j<4; j++) {
				int d = dist(ps[i], ps[j]);
				if(d == 0) return false;
				set.add(d);
			}
		} return set.size() == 2;
	}
	
	int dist(int[] p1, int[] p2) {
		return (p1[0]-p2[0])*(p1[0]-p2[0]) + (p1[1]-p2[1])*(p1[1]-p2[1]);
	}
	
	class Cell {
		int[][] ps = new int[4][2];
		int xt, yt;
		Cell(int x, int y, int xt, int yt) {
			ps[0][0] = x; ps[0][1] = y;
			this.xt = xt; this.yt = yt;
			
			for(int i=1; i<4; i++) {
				ps[i][0] = yt - ps[i-1][1] + xt;
				ps[i][1] = ps[i-1][0] - xt + yt;
			}
		}
	}
}
