/**
* 题目描述：
* 计算一个数字的立方根，不使用库函数
*
* 示例
*   输入
*   216
*
*   输出
*   6.0
*
*/

/**
* 解题思路
* 牛顿迭代法，设方程f(x)=x^3 - y, f(x)=0时，x^3=y；
* 对 x 求偏积分,f(xn)+f'(xn)(x-xn)=0，迭代 xn+1 = xn - f(xn)/f'(xn)；
*/

import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }

    void run() {
    	while(cin.hasNext()) {
    		double x = cin.nextDouble(), k=1;
    		for(; Math.abs(k*k*k-x)>1e-7; k=(2*k+x/(k*k))/3);
    		System.out.println(String.format("%.1f", k));
        }
    }
}
