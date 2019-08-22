/**
* 题目描述：
* 节日到啦，牛牛和妞妞邀请了好多客人来家里做客。他们摆出了一座高高的香槟塔，牛牛负责听妞妞指挥，往香槟塔里倒香
* 槟。香槟塔有个很优雅的视觉效果就是如果这一层的香槟满了，就会从边缘处往下一层流去。妞妞会发出两种指令，指令一
* 是往第x层塔内倒体积为v的香槟，指令二是询问第k层塔香槟的体积为多少。告诉你香槟塔每层香槟塔的初始容量，你能帮
* 牛牛快速回答妞妞的询问吗？
*
* 输入描述：
* 第一行为两个整数n，m。表示香槟塔的总层数和指令条数。第二行为n个整数ai，表示每层香槟塔的初始容量。第三行到第
* 2+m行有两种输入，一种输入是“2 x v”表示往第x层倒入体积为v的香槟；另一种输入是“1 k”表示询问第k层当前有多少香
* 槟。1 <= n, m <= 10^3。1 <= n ,m <= 2x10^5，1 <= ai ,v <= 10^9。
*
* 输出描述：
* 对于每个询问，输出一个整数，表示第k层香槟的容量。
*
* 示例
*   输入
*   1 2
*   8
*   2 1 9
*   1 1
*
*   5 4
*   1 2 2 10 1
*   1 3
*   2 2 5
*   2 4 3
*   1 4
*
*   输出
*   8
*   
*   0
*   4
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
			int n = cin.nextInt(), m = cin.nextInt(), x, y, z;
			int[] V = new int[n+1], W = new int[n+1];
			for(int i=1; i<=n; i++) V[i]=cin.nextInt();
			while(m-- > 0) {
				x = cin.nextInt();
				if(x == 1) {
					y = cin.nextInt();
					System.out.println(W[y]);
				} else {
					y=cin.nextInt(); z=cin.nextInt();
					for(int i=y; i<=n; i++) {
						if(W[i]+z >= V[i]) {
							z = W[i]+z - V[i];
							W[i] = V[i];
						} else {
							W[i] += z;
							z = 0;
						}
						if(z == 0) break;
					}
				}
			}
		}
	}
}
