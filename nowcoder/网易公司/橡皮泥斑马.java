/**
* 题目描述：
* 小易很喜欢斑马，因为它们身上黑白相间的花纹。一天小易得到了一串橡皮泥，这串橡皮泥只有黑色和白色，小易想把这串
* 橡皮泥重新拼凑一下，让这个橡皮泥串中最长的连续的黑白相间的子串最长，但是小易有强迫症，所以他可以对橡皮泥串进
* 行以下的操作0次或多次：把橡皮泥串从某个地方切割开，将两个得到的两个串同时翻转，再拼接在一起。这个橡皮泥串可
* 能太长了，所以小易没有办法计算最终可以得到的最长的连续的黑白相间的子串的长度，希望你能帮他计算出这个长度。
*
* 输入描述：
* 一个字符串s，只包含字母'b'和字母'w'，分别表示黑色和白色的橡皮泥块。满足1<=|s|<=10^5，|s|代表字符串的长度。
*
* 输出描述：
* 一个整数，表示改变之后最长的连续的黑白相间的子串的长度。
*
* 示例
*   输入
*   bwbwb
*   wwb
*   
*   输出
*   5
*   3
*
*/

/**
* 解题思路：
* 将串首尾相连成环，计算最长子串
*/

import java.util.*;
import java.io.*;

public class Main {
	Scanner cin = new Scanner(System.in);
	{
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch(IOException e) {}
	}
	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		while(cin.hasNext()) {
			String ss = cin.next();
			int ans = 0, n = ss.length();
			for(int i=0, x=0; i<n; i++) {
				if(ss.charAt(i) == ss.charAt((i+1)%n)) {
					x = 0;
				} else x++;
				ans = Math.max(ans, x);
			} System.out.println(ans+1);
		}
	}
}
