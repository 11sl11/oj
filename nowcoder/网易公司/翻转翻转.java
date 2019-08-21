/**
* 题目描述：
* 给定一个N*M的矩阵，在矩阵中每一块有一张牌，我们假定刚开始的时候所有牌的牌面向上。现在对于每个
* 块进行如下操作：翻转某个块中的牌，并且与之相邻的其余八张牌也会被翻转。
*   XXX
*   XXX
*   XXX
* 如上矩阵所示，翻转中间那块时，这九块中的牌都会被翻转一次。请输出在对矩阵中每一块进行如上操作以
* 后，牌面向下的块的个数。
*
* 输入描述：
* 输入的第一行为测试用例数t(1 <= t <= 100000)，接下来t行，每行包含两个整数N,M(1 <= N, 
* M <= 1,000,000,000)
*
* 输出描述：
* 对于每个用例输出包含一行，输出牌面向下的块的个数
*
* 示例
*   输入
*   5 1 1 1 2 3 1 4 1 2 2
*
*   输出
*   1 0 1 2 0
*
*/

/**
* 解题思路：（N >= M）
* 如果N == 1, M == 1，则只翻转一次，输出0;
* 如果N == 1, M > 1， 则首尾被翻转2次，其它 M - 2 个被翻转三次，输出 M - 2;
* 如果N > 1, M > 1, 则矩阵的四个角被翻转4次，四条边上除角以外的部分被翻转6次，
* 不在边上的部分会被翻转9次，所以输出 (N - 2) * (M - 2)。
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
			long x, y, ans;
			for(int i=0; i<n; i++) {
				x = cin.nextLong(); y = cin.nextLong();
				if(x==1 && y==1) {
					ans = 1;
				} else if(x==1 && y>1) {
					ans = y-2;
				} else if(x>1 && y==1) {
					ans = x-2;
				} else {
					ans = (x-2)*(y-2);
				} System.out.println(ans);
			}
		}
	}
}
