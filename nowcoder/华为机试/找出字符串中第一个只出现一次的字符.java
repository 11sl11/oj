/**
* 题目描述：
* 找出字符串中第一个只出现一次的字符
*
* 输入描述：
* 输入一个非空字符串
* 
* 输出描述：
* 输出第一个只出现一次的字符，如果不存在输出-1
*
* 示例
*   输入
*   asdfasdfo
*
*   输出
*   o
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
            String s = cin.nextLine();
            int[] arr = new int[128];
            for(int i=0; i<s.length(); i++) {
                arr[(int)s.charAt(i)]++;
            }
            boolean flag = true;
            for(int i=0; i<s.length() && flag; i++) {
                if(arr[(int)s.charAt(i)] == 1) {
                    System.out.print(s.charAt(i));
                    flag = false;
                }
            }
            if(flag) System.out.print(-1);
            System.out.println();
        }
    }
}
