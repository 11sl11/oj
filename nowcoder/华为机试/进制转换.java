/**
* 题目描述：
* 写出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串。（多组同时输入）
*
* 输入描述：
* 输入一个十六进制的数值字符串。
*
* 输出描述：
* 输出该数值的十进制字符串。
*
* 示例
*   输入
*   0xA
*
*   输出
*   10
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
            String ss = cin.next().trim().substring(2);
            System.out.println(Integer.parseInt(ss, 16));
        }
    }
}
