/**
* 题目描述：
* 找出正整数中偶数，并输出相加后的数
*
* 示例
*   输入
*   5548
*
*   输出
*   12
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
			String s = cin.next();
			int ans = 0;
			for(int i=0; i<s.length(); i++) {
				int x = s.charAt(i) - '0';
				if((x&1) == 0) {
					ans += x;
				}
			} System.out.println(ans);
		}
	}
}
