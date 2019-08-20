/**
* 题目描述：
* 又到了丰收的季节，恰逢小易去牛牛的果园里游玩。牛牛常说他对整个果园的每个地方都了如指掌，小易不太相信，
* 所以他想考考牛牛。在果园里有N堆苹果，每堆苹果的数量为ai，小易希望知道从左往右数第x个苹果是属于哪一堆
* 的。牛牛觉得这个问题太简单，所以希望你来替他回答。
*
* 输入描述：
* 第一行一个数n(1 <= n <= 10^5)。第二行n个数ai(1 <= ai <= 1000)，表示从左往右数第i堆有多少苹果
* 第三行一个数m(1 <= m <= 10^5)，表示有m次询问。第四行m个数qi，表示小易希望知道第qi个苹果属于哪一堆。
*
* 输出描述：
* m 行，第i行输出第 qi 个苹果属于哪一堆。
*
* 示例
*   输入
*   5
*   2 7 3 4 9
*   3
*   1 25 11
*
*   输出
*   1
*   5
*   3
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
			int n = cin.nextInt(), m, x;
			int[] arr = new int[n+1];
			for(int i=1; i<=n; i++) {
				arr[i] = arr[i-1] + cin.nextInt();
			}
			m = cin.nextInt();
			int[] qs = new int[m];
			Map<Integer, Integer> map = new TreeMap<>();
			for(int i=0; i<m; i++) {
				qs[i] = cin.nextInt();
				map.put(qs[i], 0);
			}
			int i = 0;
			for(Integer q: map.keySet()) {
				x = Arrays.binarySearch(arr, i, n, q);
				if(x < 0) x = -(x+1);
				i = x;
				map.replace(q, x);
			}
			for(i=0; i<m; i++) {
				System.out.println(map.get(qs[i]));
			}
		}
	}
}
