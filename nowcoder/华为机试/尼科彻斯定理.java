/**
* 题目描述：
* 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
* 例如：
* 1^3=1 
* 2^3=3+5 
* 3^3=7+9+11 
* 4^3=13+15+17+19 
*
* 输入描述：
* 输入一个int整数（1~100）
*
* 示例：
*   输入
*   6
*
*   输出
*   31+33+35+37+39+41
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
            int n = cin.nextInt(), x = n*(n-1)+1;
            System.out.print(x);
            for(int i=1; i<n; i++) {
                System.out.print("+" + (x+2*i));
            } System.out.println();
        }
    }
}
