/**
* 题目描述：（快手机试）
* 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。("回文串”是一个正读和反读都一样的字符串，比如
* “level”或者“noon”等等就是回文串。)具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是
* 不同的子串。
*
* 输入描述：
* 输入一个字符串S 例如“aabcb”(1 <= |S| <= 50), |S|表示字符串S的长度。
*
* 输出描述：
* 符合条件的字符串有"a","a","aa","b","c","b","bcb"，所以答案:7
*
* 示例
*   输入
*   aabcb
*
*   输出
*   7
*
*/

/**
* 解题思路：（回文子串的个数）
* 分别枚举长度为奇数和偶数两种情况的子串，判断是否为回文。例如：a 和 aa
*/

import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }
    
    void run() {
        String ss = cin.next();
        int ans = 0;
        for(int i=0; i<ss.length(); i++) {
            ans += dosth(ss, i, i);
            ans += dosth(ss, i, i+1);
        } System.out.println(ans);
    }
    
    int dosth(String ss, int start, int end) {
        int count = 0;
        while(start>=0 && end<ss.length() && ss.charAt(start)==ss.charAt(end)) {
            count++;
            start--; end++;
        } return count;
    }
}
