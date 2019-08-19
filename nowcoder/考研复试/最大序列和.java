/**
* 题目描述：
* 给出一个整数序列S，其中有N个数，定义其中一个非空连续子序列T中所有数的和为T的“序列和”。 
* 对于S的所有非空连续子序列T，求最大的序列和。 变量条件：N为正整数，N≤1000000，结果序列
* 和在范围（-2^63,2^63-1）以内。
*
* 示例
*   输入
*   5
*   1 5 -3 2 4
*
*   6
*   1 -2 3 4 -10 6
*
*   4
*   -3 -1 -2 -5
*
*   输出
*   9
*   7
*   -1
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
			long x, y = Long.MIN_VALUE, ans = Long.MIN_VALUE;
			for(int i=0; i<n; i++) {
				x = cin.nextInt();
				if(y == Long.MIN_VALUE) {
					y = x;
				} else y = Math.max(y+x, x);
				ans = Math.max(ans, y);
			} System.out.println(ans);
		}
	}
}
