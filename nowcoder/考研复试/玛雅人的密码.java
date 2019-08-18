/**
* 题目描述：
* 移动字符串中相邻的两个字符，使得包含“2012”子字符串，该字符串只包含0,1,2这三种字符。问这个字符串要最少移位几次才能
* 得出解。例如02120经过一次移位，可以得到20120,01220,02210,02102，其中20120符合要求，因此输出为1.如果无论移位多少
* 次都解不开密码，输出-1。
*
* 输入描述：
* 输入包含多组测试数据，每组测试数据由两行组成。
* 第一行为一个整数N，代表字符串的长度（2<=N<=13）。
* 第二行为一个仅由0、1、2组成的，长度为N的字符串。
*
* 输出描述：
* 对于每组测试数据，若可以解出密码，输出最少的移位次数；否则输出-1。
*
* 示例 
*   输入
*   5
*   02120
*   13
*   1122121122200
*
*   输出
*   1
*   4
*
*/

/**
* 解题思路：
* 类似于八数码问题，采用BFS遍历每种可能的结果。
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
			String ss = cin.next(), ans = ss;
			ArrayDeque<String> Q = new ArrayDeque<>();
			Map<String, Integer> map = new HashMap<>();
			Q.offer(ss);
			map.put(ss, 0);
			boolean flag = !ss.contains("2012");
			while(!Q.isEmpty() && flag) {
				ss = Q.poll();
				for(int i=1; i<n; i++) {
					String s = dosth(ss, i-1, i);
					if(map.containsKey(s)) continue;
					map.put(s, map.get(ss)+1);
					if(s.contains("2012")) {
						ans = s;
						flag = false;
						break;
					}
					Q.offer(s);
				}
			} System.out.println(flag ? -1:map.get(ans));
		}
	}

	String dosth(String s, int i, int j) {
		StringBuilder sb = new StringBuilder(s);
		char c = sb.charAt(i);
		sb.setCharAt(i, sb.charAt(j));
		sb.setCharAt(j, c);
		return sb.toString();
	}
}
