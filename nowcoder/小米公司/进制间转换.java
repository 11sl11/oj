/**
* 题目描述：
* 设计一个函数， 可以将任意十进制的数， 转换成任意2到9的进制表示的形式
*
* 输入描述：
* 需要转换的数字x(0<=x<=1e18) 转换使用的进制k(2<=k<=9)
*
* 输出描述：
* 对应进制的结果
*
* 示例
*   输入
*   33 2
*
*   输出
*   100001
*
*/

import java.util.*;
import java.math.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }
    
    void run() {
        while(cin.hasNext()) {
            BigInteger sb = new BigInteger(cin.next());
            int k = cin.nextInt();
            System.out.println(sb.toString(k));
        }
    }
}
