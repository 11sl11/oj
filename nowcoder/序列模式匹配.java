/**
* 题目描述：（小米机试）
* 给定文本text和待匹配字符串pattern，二者皆只包含小写字母，并且不为空。在text中找出匹配pattern的最短字符串，
* 匹配指按序包含pattern，但不要求pattern连续。如text为abaacxbcbbbbacc，pattern为cbc，text中满足条件的是
* cxbc部分。
*
* 输入描述：
* 多行，每行一个text和一个pattern，用空格分隔。
* 保证1<=|text|,|pattern|<=1000，Σ|text|,Σ|pattern|<=10000。
*
* 输出描述：
* 输出最短匹配序列起止位置（位置下标从0开始），用空格分隔。若有多个答案，输出起止位置最小的答案；若无满足条件的
* 答案，则起止均为-1。
*
* 示例
*   输入
*   abaacxbcbbbbacc cbc
*   abc x
*   aaabcac ac
*
*   输出
*   4 7
*   -1 -1
*   5 6
*
*/

/**
* 解题思路：
* 设dp[i][i+k]为text从i到i+k匹配到的pattern最长的长度，其状态转移方程为：
* dp[i][i+k]=dp[i][i+k-1]+1 当text[i+k]==pattern[dp[i][i + k - 1]]时;
* dp[i][i+k]=dp[i][i+k-1].
* 边界条件：k=0时，dp[i][i] = (text[i] == pattern[0]);
*/

import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }

    void run() {
        while(cin.hasNext()) {
        	String sa = cin.next(), sb = cin.next();
        	int n = sa.length(), m = sb.length(), a, b;
        	int[][] dp = new int[n][n];
        	
        	if(sb.length() == 1) {
        		int k = sa.indexOf(sb);
        		System.out.println(k + " " + k);
        		continue;
        	}
        	
        	boolean flag = true;
        	for(int k=1; k<n && flag; k++) {
        		for(int i=0; i+k<n && flag; i++) {
        			dp[i][i] = (sa.charAt(i) == sb.charAt(0) ? 1:0);
        			if(sa.charAt(i+k) == sb.charAt(dp[i][i+k-1])) {
        				dp[i][i+k] = dp[i][i+k-1] + 1;
        			} else dp[i][i+k] = dp[i][i+k-1];
        			if(dp[i][i+k] == m) {
        				System.out.println(i + " " + (i+k));
        				flag = false;
        			}
        		}
        	} if(flag) System.out.println("-1 -1");
        }
    }
}
