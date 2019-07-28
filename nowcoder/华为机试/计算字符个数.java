/**
* 题目描述
* 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
*
* 输入描述：
* 第一行输入一个有字母和数字以及空格组成的字符串，第二行输入一个字符。
*
* 输出描述：
* 输出输入字符串中含有该字符的个数。
*
* 示例：
*   输入
*   ABCDEF
*   A
*
*   输出
*   1
*
*/

import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }
    
    void run() {
        String ss = cin.next().toLowerCase(), sc = cin.next().toLowerCase();
        int ans = 0;
        for(int i=0; i<ss.length(); i++) {
            if(ss.charAt(i) == sc.charAt(0)) ans++;
        } System.out.println(ans);
    }
}
