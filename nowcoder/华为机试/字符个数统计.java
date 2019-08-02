/**
* 题目描述：
* 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)。不在范围内的不作统计。
*
* 输入描述：
* 输入N个字符，字符在ACSII码范围内。
*
* 输出描述：
* 输出范围在(0~127)字符的个数。
*
* 示例
*   输入
*   abc
*
*   输出
*   3
*
*/

import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }
     
    void run() {
        String ss = cin.nextLine();
        Set<Character> set = new HashSet<>();
        for(int i=0; i<ss.length(); i++) {
            set.add(ss.charAt(i));
        } System.out.println(set.size());
    }
}
