/**
* 题目描述：
* 小易觉得高数课太无聊了，决定睡觉。不过他对课上的一些内容挺感兴趣，所以希望你在老师讲到有趣的部分的时候
* 叫醒他一下。你知道了小易对一堂课每分钟知识点的感兴趣程度，并以分数量化，以及他在这堂课上每分钟是否会睡
* 着，你可以叫醒他一次，这会使得他在接下来的k分钟内保持清醒。你需要选择一种方案最大化小易这堂课听到的知
* 识点分值。
*
* 输入描述：
* 第一行 n, k (1 <= n, k <= 105) ，表示这堂课持续多少分钟，以及叫醒小易一次使他能够保持清醒的时间。
* 第二行 n 个数，a1, a2, ... , an(1 <= ai <= 104) 表示小易对每分钟知识点的感兴趣评分。
* 第三行 n 个数，t1, t2, ... , tn 表示每分钟小易是否清醒, 1表示清醒。
*
* 输出描述：
* 小易这堂课听到的知识点的最大兴趣值。
*
* 示例
*   输入
*   6 3
*   1 3 5 2 5 4
*   1 1 0 1 0 0
*
*   10 5
*   6481 6127 4477 5436 7356 3137 1076 7182 8147 835
*   1 0 1 0 1 1 0 0 0 1
*
*   输出
*   16
*   38691
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
			int n = cin.nextInt(), k = cin.nextInt(), ans = 0;
			int[] arr = new int[n];
			for(int i=0; i<n; i++) arr[i] = cin.nextInt();
			boolean[] wake = new boolean[n];
			for(int i=0; i<n; i++) {
				wake[i] = cin.nextInt()==1;
				if(wake[i]) {
					ans += arr[i];
					arr[i] = 0;
				}
			}
			int s = 0, x;
			for(int i=0; i<n; i++) {
				if(wake[i]) continue;
				x = 0;
				for(int j=0; j<k && i+j<n; j++) {
					x += arr[i+j];
				}
				s = Math.max(s, x);
			} System.out.println(ans+s);
		}
	}
}
