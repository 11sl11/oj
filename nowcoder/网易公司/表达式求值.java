/**
* 题目描述：
* 今天上课，老师教了小易怎么计算加法和乘法，乘法的优先级大于加法，但是如果一个运算加了括号，那么它的
* 优先级是最高的。例如：
* 1+2*3=7
* 1*(2+3)=5
* 1*2*3=6
* (1+2)*3=9
* 现在小易希望你帮他计算给定3个数a，b，c，在它们中间添加"+"， "*"， "("， ")"符号，能够获得的最大值。
*
* 输入描述：
* 一行三个数a，b，c (1 <= a, b, c <= 10)
*
* 输出描述：
* 能够获得的最大值
*
* 示例
*   输入
*   1 2 3
*
*   输出
*   9
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
			int a=cin.nextInt(), b=cin.nextInt(), c=cin.nextInt(), ans=Integer.MIN_VALUE;
			ans = Math.max(ans, a+b+c);
			ans = Math.max(ans, a*b*c);
			ans = Math.max(ans, (a+b)*c);
			ans = Math.max(ans, a*(b+c));
			System.out.println(ans);
		}
	}
}
