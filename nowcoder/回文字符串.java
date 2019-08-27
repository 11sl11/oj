/**
* 题目描述：（快手机试）
* 最大回文子串是被研究得比较多的一个经典问题。最近月神想到了一个变种，对于一个字符串，如果不要求子串连续，那么一
* 个字符串的最大回文子串的最大长度是多少呢。
*
* 输入描述：
* 每个测试用例输入一行字符串（由数字0-9，字母a-z、A-Z构成），字条串长度大于0且不大于1000.
*
* 输出描述：
* 输出该字符串的最长回文子串的长度。（不要求输出最长回文串，并且子串不要求连续）
*
* 示例
*   输入
*   adbca
*
*   输出
*   3（说明：因为在本题中，不要求回文子串连续，故最长回文子串为aba(或ada、aca)）
*
*/

/**
* 解题思路：（最长不连续回文字符串）
* dp[i][j]表示第i个字符到第j个字符中包含的最大回文子串的最大长度,转移方程：
* 若a[i]与a[j]有相同的字符，则最大长度为dp[i+1][j-1]+2;
* 否则为以下最大值 max(dp[i+1][j],dp[i][j-1])
* 临界值：dp[i][i] = 1, 当为一个字符串时为长度为1的回文字符串
*/

import java.util.*;

public class Main {
	Scanner cin = new Scanner(System.in);
	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		while(cin.hasNext()) {
			String ss = cin.next();
			int n = ss.length();
			int[][] dp = new int[n+1][n+1];
			for(int j=0; j<n; j++) {
				dp[j][j] = 1;
				for(int i=j-1; i>=0; i--) {
					if(ss.charAt(i) == ss.charAt(j)) {
						dp[i][j] = dp[i+1][j-1] + 2;
					} else dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
				}
			} System.out.println(dp[0][n-1]);
		}
	}
}
