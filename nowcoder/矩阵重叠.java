/**
* 题目描述：（网易机试）
* 平面内有n个矩形, 第i个矩形的左下角坐标为(x1[i], y1[i]), 右上角坐标为(x2[i], y2[i])。如果两个或者多个矩形
* 有公共区域则认为它们是相互重叠的(不考虑边界和角落)。请你计算出平面内重叠矩形数量最多的地方,有多少个矩形相互
* 重叠。
*
* 输入描述：
* 输入包括五行。
* 第一行包括一个整数n(2 <= n <= 50), 表示矩形的个数。
* 第二行包括n个整数x1[i](-10^9 <= x1[i] <= 10^9),表示左下角的横坐标。
* 第三行包括n个整数y1[i](-10^9 <= y1[i] <= 10^9),表示左下角的纵坐标。
* 第四行包括n个整数x2[i](-10^9 <= x2[i] <= 10^9),表示右上角的横坐标。
* 第五行包括n个整数y2[i](-10^9 <= y2[i] <= 10^9),表示右上角的纵坐标。
*
* 输出描述：
* 输出一个正整数, 表示最多的地方有多少个矩形相互重叠,如果矩形都不互相重叠,输出1。
*
* 示例
*   输入
*   2
*   0 90
*   0 90
*   100 200
*   100 200
*
*   输出
*   2
*
*/

/**
* 解题思路：
* 计算某个重合区域在多少个矩形内，可以转化为计算这个重合区域的左下角在多少个矩形内。重合区域的左下角可以通过组
* 合矩形左下角的横坐标与纵坐标得到。
*/

import java.util.*;

public class Main {
	Scanner cin = new Scanner(System.in);
	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		while(cin.hasNext()) {
			int n = cin.nextInt(), ans = 0, cnt;
			int[] x1=new int[n], y1=new int[n], x2=new int[n], y2=new int[n];
			for(int i=0; i<n; i++) x1[i] = cin.nextInt();
			for(int i=0; i<n; i++) y1[i] = cin.nextInt();
			for(int i=0; i<n; i++) x2[i] = cin.nextInt();
			for(int i=0; i<n; i++) y2[i] = cin.nextInt();
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					cnt = 0;
					for(int k=0; k<n; k++) {
						if((x1[i]>=x1[k] && x1[i]<x2[k]) && (y1[j]>=y1[k] && y1[j]<y2[k])) {
							cnt++;
						}
					}
					ans = Math.max(ans, cnt);
				}
			} System.out.println(ans);
		}
	}
}
