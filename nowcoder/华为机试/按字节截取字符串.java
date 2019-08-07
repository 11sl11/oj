/**
* 题目描述：
* 编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节截取的字符串。但是要保证汉字不被截半个，
* 如"我ABC"4，应该截为"我AB"，输入"我ABC汉DEF"6，应该输出为"我ABC"而不是"我ABC+汉的半个"。 
*
* 输入描述：
* 输入待截取的字符串及长度
*
* 输出描述：
* 截取后的字符串
*
* 示例
*   输入
*   我ABC汉DEF
*   6
*
*   输出
*   我ABC
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
            String s = cin.next();
            int n = cin.nextInt();
            for(int i=0, j=0; i<n && j<s.length(); i++, j++) {
                if((s.charAt(j)&0xFF00) != 0) i++;
                if(i >= n) break;
                System.out.print(s.charAt(j));
            } System.out.println();
        }
    }
}
