/**
* 题目描述：
* N<k时，root(N,k) = N，否则，root(N,k) = root(N',k)。N'为N的k进制表示的各位数字之和。输入x,y,k，
* 输出root(x^y,k)的值 (这里^为乘方，不是异或)，2=<k<=16，0<x,y<2000000000，有一半的测试点里 x^y 
* 会溢出int的范围(>=2000000000)
*
* 示例
*   输入
*   4 4 10
*   449332490 796895588 8
*
*   输出
*   4
*   4
*
*/

/**
* 解题思路：
* N 的 k 进制表示的各位数字之和除以 k 取余，即为 N%(k-1)。
* (ab)%c = ((a%c)*(b%c))%c
* (a^b)%c = ((a%c)^b)%c
*/

import java.util.*;

public class Main {
	Scanner cin = new Scanner(System.in);
	public static void main(String[] args) {
		new Main().run();
	}

	void run() {	
		while(cin.hasNext()) {
			int x=cin.nextInt(), y=cin.nextInt(), k=cin.nextInt()-1, t=1;
			while(y > 0) {
				if((y&1) == 1) t = ((t%k)*(x%k))%k;
				x = ((x%k)*(x%k))%k;
				y >>= 1;
			}
			System.out.println(t==0 ? k:t);
		}
	}
}
