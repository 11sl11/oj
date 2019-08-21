/**
* 题目描述：
* 小易有一些立方体，每个立方体的边长为1，他用这些立方体搭了一些塔。现在小易定义：这些塔的不稳定值为
* 它们之中最高的塔与最低的塔的高度差。小易想让这些塔尽量稳定，所以他进行了如下操作：每次从某座塔上取
* 下一块立方体，并把它放到另一座塔上。注意，小易不会把立方体放到它原本的那座塔上，因为他认为这样毫无
* 意义。现在小易想要知道，他进行了不超过k次操作之后，不稳定值最小是多少。
*
* 输入描述：
* 第一行两个数n,k (1 <= n <= 100, 0 <= k <= 1000)表示塔的数量以及最多操作的次数。
* 第二行n个数，ai(1 <= ai <= 104)表示第i座塔的初始高度。
*
* 输出描述：
* 第一行两个数s, m，表示最小的不稳定值和操作次数(m <= k)
* 接下来m行，每行两个数x,y表示从第x座塔上取下一块立方体放到第y座塔上。
*
* 示例
*   输入
*   3 2
*   5 8 5
*
*   输出
*   0 2
*   2 1
*   2 3
*
*/

import java.util.*;

public class Main {
	Scanner cin = new Scanner(System.in);
	public static void main(String[] args) {
		new Main().run();
	}

	Cell[] cells;
	void run() {
		while(cin.hasNext()) {
			int n = cin.nextInt(), k = cin.nextInt(), s=0;
			cells = new Cell[n];
			for(int i=0; i<n; i++) {
				cells[i] = new Cell(cin.nextInt(), i+1);
			}
			Cell x, y;
			ArrayDeque<Integer> move = new ArrayDeque<>();
			for(int i=0; i<=k; i++) {
				x = elem_k(n-1, n); y = elem_k(0, n);
				s = x.h - y.h;
				if(s < 2) break;
				if(i < k) {
					x.h--; y.h++;
					move.offer(x.i); move.offer(y.i);
				}
			}
			System.out.println(s + " " + move.size()/2);
			while(!move.isEmpty()) {
				System.out.println(move.poll() + " " + move.poll());
			}
		}
	}
	
	Cell elem_k(int k, int n) {
		int left = 0, right = n-1, i, j;
		while(left < right) {
			i=left-1; j=right+1;
			for(Cell cell = cells[(i+j)>>1]; i<j; ) {
				for(j--; cell.compareTo(cells[j])<0; j--);
				for(i++; cell.compareTo(cells[i])>0; i++);
				if(i < j) {
					Cell tmp = cells[i];
					cells[i] = cells[j];
					cells[j] = tmp;
				}
			}
			if(k > j) {
				left = j+1;
			} else right = j;
		}
		return cells[k];
	}
	
	class Cell implements Comparable<Cell> {
		int h, i;
		Cell(int h, int i) {
			this.h = h; this.i = i;
		}

		@Override
		public int compareTo(Cell o) {
	        if(h == o.h) {
	            return i - o.i;
	        } return h - o.h;
		}
	}
}
