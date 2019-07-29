/**
* 题目描述
*   密码要求:
*    1.长度超过8位
*    2.包括大小写字母.数字.其它符号,以上四种至少三种
*    3.不能有相同长度超2的子串重复
*
* 输入描述：
* 一组或多组长度超过2的子符串。每组占一行
*
* 输出描述：
* 如果符合要求输出：OK，否则输出NG
*
* 示例
*   输入
*   021Abc9000
*   021Abc9Abc1
*   021ABC9000
*   021$bc9000
* 
*   输出
*   OK
*   NG
*   NG
*   OK
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
            if(s.length() <= 8) {
                System.out.println("NG");
                continue;
            }
            int a = 0, b = 0, c = 0, d = 0;
            for(int i=0; i<s.length(); i++) {
                char ch = s.charAt(i);
                if(Character.isLowerCase(ch)) a = 1;
                else if(Character.isUpperCase(ch)) b = 1;
                else if(Character.isDigit(ch)) c = 1;
                else d = 1;
            }
            if(a+b+c+d < 3) {
                System.out.println("NG");
                continue;
            }
            a = 0;
            for(int i=0; i<s.length()-3 && a == 0; i++) {
                if(s.indexOf(s.substring(i, i+3), i+3) != -1) {
                    System.out.println("NG");
                    a = 1;
                }
            }
            if(a == 0) System.out.println("OK");
        }
    }
}
