/**
* 题目描述：
* 实现如下2个通配符：
*  *：匹配0个或以上的字符（字符由英文字母和数字0-9组成，不区分大小写。下同）
*  ？：匹配1个字符
*
* 输入描述：
* 通配符表达式；
* 一组字符串。
*
* 输出描述：
* 返回匹配的结果，正确输出true，错误输出false
*
* 示例
*   输入
*   te?t*.*
*   txt12.xls
*
*   输出
*   false
*
*/

/*
import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }

    void run() {
    	while(cin.hasNext()) {
    		String sa = cin.next(), sb = cin.next();
    		sa = sa.replaceAll("\\?", "[0-9a-zA-Z]{1}");
    		sa = sa.replaceAll("\\*", "[0-9a-zA-Z]*");
    		System.out.println(sb.matches(sa));
        }
    }
}
*/

/**
* 解题思路：
* s代表匹配需要匹配的字符串，p代表有通配符的字符串
* dp[i+1][j+1]代表p[...i]与s[...j]是匹配，当两个字符串为空时dp[0][0] = true，
* p[i]='*'时，dp[i+1][j+1] = dp[i][j] || dp[i+1][j];(*为任意字符 || *为空)
* p[i]='?'或p[i]=s[j]时，dp[i+1][j+1] = dp[i][j];
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
    		boolean[][] dp = new boolean[sa.length()+1][sb.length()+1];
    		dp[0][0] = true;
    		for(int i=0; i<sa.length(); i++) {
    			if(sa.charAt(i) == '*') dp[i+1][0] = dp[i][0];
    		}
    		for(int i=0; i<sa.length(); i++) {
    			for(int j=0; j<sb.length(); j++) {
    				if(sa.charAt(i) == '*') {
//    					dp[i+1][j+1] = dp[i][j+1] || dp[i][j] || dp[i+1][j];
                dp[i+1][j+1] = dp[i][j] || dp[i+1][j];
    				} else if(sa.charAt(i)=='?' || sa.charAt(i)==sb.charAt(j)) {
    					dp[i+1][j+1] = dp[i][j];
    				}
    			}
    		} System.out.println(dp[sa.length()][sb.length()]);
        }
    }
}
