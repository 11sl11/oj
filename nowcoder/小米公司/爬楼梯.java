/**
* 题目描述：
* 有一个n阶的楼梯，你一步只能上1阶或2阶。请问计算出你可以采用多少种不同的方式爬完这个楼梯。
*
* 输入描述：
* 一个正整数n(n<=100)，表示这个楼梯一共有多少阶
*
* 输出描述：
* 一个正整数，表示有多少种不同的方式爬完这个楼梯
*
* 示例
*   输入
*   5
*   100
*
*   输出
*   8
*   573147844013817084101
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
            int n = cin.nextInt();
            if(n < 3) {
                System.out.println(n);
                continue;
            }
            BigInteger a = BigInteger.ONE, b = BigInteger.valueOf(2), c;
            for(int i=3; i<=n; i++) {
                c = a.add(b);
                a = b;
                b = c;
            } System.out.println(b);
        }
    }
}
