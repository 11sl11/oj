/**
* 题目描述：
* 把N个读者依次编号为1,2,…,N，把M本书依次编号为1,2,…,M。同时，按照“臭味相投”的原则，和你喜欢读同一
* 本书的人，就是你的潜在朋友。你现在的任务是从这份借阅记录中计算出每个人有几个潜在朋友。
*
* 输入描述：
* 每个案例第一行两个整数N,M，2 <= N ，M<= 200。接下来有N行，第i(i = 1,2,…,N)行每一行有一个数，表示
* 读者i-1最喜欢的图书的编号P(1<=P<=M)
*
* 输出描述：
* 每个案例包括N行，每行一个数，第i行的数表示读者i有几个潜在朋友。如果i和任何人都没有共同喜欢的书，则
* 输出“BeiJu”。
*
* 示例
*   输入
*   4  5
*   2
*   3
*   2
*   1
*
*   输出
*   1
*   BeiJu
*   1
*   BeiJu
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
			int n = cin.nextInt(), m = cin.nextInt();
			int[] A = new int[n], B = new int[m+1];
			for(int i=0; i<n; i++) {
				A[i]=cin.nextInt();
				B[A[i]]++;
			}
			for(int i=0; i<n; i++) {
				if(B[A[i]] == 1) {
					System.out.println("BeiJu");
				} else System.out.println(B[A[i]]-1);
			}
		}
	}
}
