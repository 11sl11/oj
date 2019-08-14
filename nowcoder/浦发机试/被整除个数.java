/**
* 题目描述：
* 输入 n 和 b , 找出 1 到 n 中被 b 整除的个数
*
* 示例
*   输入
*   6 3
*
*   输出
*   2
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
			int n = cin.nextInt(), b = cin.nextInt(), ans = 0;
			for(int i=1; i<=n; i++) {
				if((i%b) == 0) ans++;
			} System.out.println(ans);
		}
	}
}
