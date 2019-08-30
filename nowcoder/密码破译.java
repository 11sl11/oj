/**
* 题目描述：（小米）
* 我们来做一个简单的密码破译游戏。破译的规则很简单，将数字转换为字母，1转化为a，2转化为b，依此类推，26转化为z。
* 现在输入的密码是一串数字，输出的破译结果是该数字串通过转换规则所能产生的所有字符串。
*
* 输入描述：
* 多行数据，每行为一个数字串。保证数字串的总长度不超过1000，每行数据的答案至少有1个且不超过1000个。
*
* 输出描述：
* 多行数据，每行对应输出通过数字串破译得到的所有字符串，并按照字符串顺序排列，字符串之间用单个空格分隔。每行开
* 头和结尾不允许有多余的空格。
*
* 示例
*   输入
*   1
*   12
*   1203
*
*   输出
*   a
*   ab l
*   atc
*
*/

/**
* 解题思路：
* 组合顺序遍历一位和两位数，当遍历一位数为 0 时，该遍历路径无效
*/

import java.util.*;

public class Main {
	Scanner cin = new Scanner(System.in);
	public static void main(String[] args) {
		new Main().run();
	}

	String s;
	Set<String> set;
	void run() {
		while(cin.hasNext()) {
			s = cin.next();
			set = new TreeSet<>();
			sb = new StringBuilder();
			dfs(0, 0);
			boolean flag = false;
			for(String s: set) {
				if(flag) System.out.print(" ");
				flag = true;
				System.out.print(s);
			} System.out.println();
		}
	}
	
	StringBuilder sb;
	void dfs(int k, int t) {
		if(k >= s.length()) {
			set.add(sb.substring(0, t));
			return;
		}
		int x;
		x = Integer.parseInt(s.substring(k, k+1));
		if(x>0 && x<27) {
			if(t >= sb.length()) {
				sb.append((char)('a'+x-1));
			} else sb.setCharAt(t, (char)('a'+x-1));
			dfs(k+1, t+1);
			if(k < s.length()-1) {
				x = Integer.parseInt(s.substring(k, k+2));
				if(x>0 && x<27) {
					if(t >= sb.length()) {
						sb.append((char)('a'+x-1));
					} else sb.setCharAt(t, (char)('a'+x-1));
					dfs(k+2, t+1);
				}
			}
		}
	}
}

/**
* 类似题目 在整数划分中：
* Eg. 4 = 4
*       = 3+1
*       = 2+2、2+1+1
*       = 1+3、1+2+1、1+1+2、1+1+1+1
* 该类题目也可通过组合遍历的方式枚举出每条可能的路径
*
* void run() {
*    	arr = new int[5];
*    	dfs(4, 0);
* }
*    
* int[] arr = null;
* void dfs(int n, int k) {
*     if(n == 0) {
*         for(int i=0; i<k; i++) {
*    			    System.out.print(arr[i] + " ");
*    		  } System.out.println();
*    		  return;
*    	}
*    	for(int i=1; i<=n; i++) {
*    		arr[k] = i;
*    		dfs(n-i, k+1);
*    	}
* }
*
*/
