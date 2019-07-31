/**
* 题目描述
* 编写一个程序，将输入字符串中的字符按如下规则排序。
* 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
*   如，输入： Type   输出： epTy
* 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
*   如，输入： BabA   输出： aABb
* 规则 3 ：非英文字母的其它字符保持原来的位置。
*   如，输入： By?e   输出： Be?y
*
* 示例
*   输入
*   A Famous Saying: Much Ado About Nothing(2012/8).
*
*   输出
*   A aaAAbc dFgghh: iimM nNn oooos Sttuuuy(2012/8).
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
            String ss = cin.nextLine();
            ArrayDeque<Character> que = new ArrayDeque<>();
            for(int i=0; i<26; i++) {
                for(int j=0; j<ss.length(); j++) {
                    char c = ss.charAt(j);
                    if((c-'A')==i || (c-'a')==i) que.add(c);
                }
            }
            for(int i=0; i<ss.length(); i++) {
                if(Character.isLetter(ss.charAt(i))) {
                    System.out.print(que.poll());
                } else System.out.print(ss.charAt(i));
            } System.out.println();
        }
    }
}
