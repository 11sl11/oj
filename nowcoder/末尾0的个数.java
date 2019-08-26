/**
* 题目描述：（滴滴机试）
* 输入一个正整数n,求n!(即阶乘)末尾有多少个0？ 比如: n = 10; n! = 3628800,所以答案为2
*
* 示例
*   输入
*   10
*   7
*
*   输出
*   2
*   1
*
*/

/**
* 解题思路：
* 8074！的末尾0个数为：
* [8074/5] + [8074/5^2] + [8074/5^3] + [8074/5^4] + ……
*/

import java.util.*;

public class Main {
	Scanner cin = new Scanner(System.in);
	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		while(cin.hasNext()) {
			int n = cin.nextInt(), ans = 0;
			for(int i=5; i<=n; i*=5) {
				ans += (int)(1.0*n/i);
			} System.out.println(ans);
		}
	}
}
