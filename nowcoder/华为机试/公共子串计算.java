/**
* 题目描述：
* 计算两个字符串的最大公共字串的长度，字符不区分大小写
*
* 示例
*   输入
*   asdfas werasdfaswer
*
*   输出
*   6
*
*/

/**
* 最长公共子序列
import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }
    
    void run() {
    	while(cin.hasNext()) {
    		String sa = cin.next(), sb = cin.next();
    		int[][] dp = new int[sa.length()+1][sb.length()+1];
    		for(int i=0; i<sa.length(); i++) {
    			for(int j=0; j<sb.length(); j++) {
    				if(sa.charAt(i) == sb.charAt(j)) {
    					dp[i+1][j+1] = dp[i][j] + 1;
    				} else dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
    			}
    		} System.out.println(dp[sa.length()][sb.length()]);
        }
    }
}
*/

import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }
    
    void run() {
    	while(cin.hasNext()) {
    		String sa = cin.next().toLowerCase(), sb = cin.next().toLowerCase();
    		int[][] dp = new int[sa.length()+1][sb.length()+1];
    		int ans = 0;
    		for(int i=0; i<sa.length(); i++) {
    			for(int j=0; j<sb.length(); j++) {
    				if(sa.charAt(i) == sb.charAt(j)) {
    					dp[i+1][j+1] = dp[i][j] + 1;
    				}
    				ans = Math.max(dp[i+1][j+1], ans);
    			}
    		} System.out.println(ans);
        }
    }
}
