/**
* 题目描述：（招商银行信用卡中心机试）
* 一条包含字母 A-Z 的消息通过以下方式进行了编码：
* 'A' -> 1
* 'B' -> 2
*   ...
* 'Z' -> 26
* 给定一个只包含数字的非空字符串，请计算解码方法的总数。
*
* 输入描述：
* 一串编码过的数字，比如12
*
* 输出描述：
* 解码方法的总数
*
* 示例
*   输入
*   12
*
*   输出
*   2（说明：12可以解码成“AB”，“A，B”这两种）
*
*/

/**
* 解题思路：
* 按顺序组合遍历一位或两位数字的所有情况，因此采用深度搜索方法
* 临界值判断：当遍历的数字应位于[1,26]之间。
*/

import java.util.*;

public class Main {
	Scanner cin = new Scanner(System.in);
	public static void main(String[] args) {
		new Main().run();
	}

	int ans;
	String s;
	void run() {
		while(cin.hasNext()) {
			s = cin.next();
			ans = 0;
			dfs(0);
			System.out.println(ans);
		}
	}
	
	void dfs(int k) {
		if(k >= s.length()) {
			ans++; return;
		}
		int x;
		if(k < s.length()) {
			x = Integer.parseInt(s.substring(k, k+1));
			if(x>0 && x<27) dfs(k+1);
		}
		if(k < s.length()-1) {
			x = Integer.parseInt(s.substring(k, k+2));
			if(x>0 && x<27) dfs(k+2);
		}
	}
}
