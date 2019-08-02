/**
* 题目描述
* •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组； 
* •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。 
*
* 输入描述：
* 连续输入字符串(输入2次,每个字符串长度小于100)
*
* 输出描述：
* 输出到长度为8的新字符串数组
*
* 示例
*   输入
*   abc
*   123456789
*
*   输出
*   abc00000
*   12345678
*   90000000
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
            int length = (int)Math.ceil(1.0*ss.length()/8);
            for(int i=0; i<length; i++) {
                for(int j=0; j<8; j++) {
                    if(j+8*i < ss.length()) {
                        System.out.print(ss.charAt(j+8*i));
                    } else System.out.print(0);
                } System.out.println();
            }
        }
    }
}
