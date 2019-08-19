/**
* 题目描述：
* 在某条线路上有N个火车站，有三种距离的路程，L1，L2，L3,对应的价格为C1,C2,C3.其对应关系如下: 
*     距离S       0<S<=L1       L1<S<=L2       L2<S<=L3
*     票价          C1             C2             C3 
* 输入保证0<L1<L2<L3<10^9,0<C1<C2<C3<10^9。 每两个站之间的距离不超过L3。 当乘客要移动的两个
* 站的距离大于L3的时候，可以选择从中间一个站下车，然后买票再上车，所以乘客整个过程中至少会买两
* 张票。 现在给你一个 L1，L2，L3，C1，C2,C3。然后是A B的值，其分别为乘客旅程的起始站和终点站。
* 然后输入N，N为该线路上的总的火车站数目，然后输入N-1个整数，分别代表从该线路上的第一个站，到第
* 2个站，第3个站，……，第N个站的距离。 根据输入，输出乘客从A到B站的最小花费。
*
* 输入描述：
* 以如下格式输入数据：
* L1  L2  L3  C1  C2  C3
* A  B
* N
* a[2]
* a[3]
* ……
* a[N]
*
* 输出描述：
* 可能有多组测试数据，对于每一组数据，
* 根据输入，输出乘客从A到B站的最小花费。
*
* 示例
*   输入
*   1 2 3 1 2 3
*   1 2
*   2
*   2
*
*   输出
*   2
*
*/

import java.util.*;

public class Main {
	Scanner cin = new Scanner(System.in);
	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		int[] L = new int[3], C = new int[3];
		while(cin.hasNext()) {
			for(int i=0; i<3; i++) L[i] = cin.nextInt();
			for(int i=0; i<3; i++) C[i] = cin.nextInt();
			int a=cin.nextInt(), b=cin.nextInt(), n = cin.nextInt();
			int[] D = new int[n+1], dp = new int[n+1];
			for(int i=2; i<=n; i++) D[i] = cin.nextInt();
			for(int i=a+1; i<=b; i++) {
				dp[i] = Integer.MAX_VALUE;
				for(int j=a; j<i; j++) {
					for(int k=0; k<3; k++) {
						if((D[i] - D[j]) <= L[k]) {
							dp[i] = Math.min(dp[i], dp[j]+C[k]);
							break;
						}
					}
				}
			} System.out.println(dp[b]);
		}
	}
}
