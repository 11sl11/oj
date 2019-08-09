/**
* 题目描述：
* 给定任意一个较短的子串，和另一个较长的字符串，判断短的字符串是否能够
* 由长字符串中的字符构建出来，且长串中的每个字符只能用一次。
*
* 输入描述：
* 一行数据包括一个较短的字符串S和一个较长的字符串T，用一个空格分隔。
* 保证1<=|S|<=|T|<=100000。
*
* 输出描述：
* 如果短的字符串可以由长字符串中的字符构建出来，输出字符串 “true”，
* 否则输出字符串 "false"。
*
* 示例
*   输入
*   fj jfiejfiejfie
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
            int[] arr = new int[128];
            for(int i=0; i<sb.length(); i++) {
                arr[sb.charAt(i)]++;
            }
            boolean flag = true;
            for(int i=0; i<sa.length(); i++) {
                if(arr[sa.charAt(i)] == 0) {
                    flag = false; break;
                }
                arr[sa.charAt(i)]--;
            }
            System.out.println(flag);
        }
    }
}
