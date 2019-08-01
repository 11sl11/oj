/**
* 题目描述
* 输入两个字符串。第一个为短字符，第二个为长字符。判断短字符串中的所有字符是否在长字符串中全部出现
*
* 示例
*   输入
*   ab
*   abc
*
*   输出
*   true
*
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
            Set<Character> set1 = new HashSet<>(), set2 = new HashSet<>();
            for(int i=0; i<sa.length(); i++) set1.add(sa.charAt(i));
            for(int i=0; i<sb.length(); i++) set2.add(sb.charAt(i));
            boolean flag = true;
            for(Character c: set1) {
                if(!set2.contains(c)) {
                    flag = false; break;
                }
            } System.out.println(flag);
        }
    }
}
