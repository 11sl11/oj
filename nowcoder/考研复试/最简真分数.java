/**
* 题目描述：
* 给出n个正整数，任取两个数分别作为分子和分母组成最简真分数，编程求共有几个这样的组合。
*
* 输入描述：
* 每组包含n（n<=600）和n个不同的整数，整数大于1且小于等于1000。
*
* 输出描述：
* 每行输出最简真分数组合的个数。
*
* 示例
*   输入
*   7
*   3 5 7 9 11 13 15
*
*   输出
*   17
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
			int n = cin.nextInt(), ans=0;
			int[] arr = new int[n];
			for(int i=0; i<n; i++) arr[i]=cin.nextInt();
			Arrays.sort(arr);
			for(int i=0; i<n; i++) {
				for(int j=i+1; j<n; j++) {
					if(gcd(arr[i], arr[j]) == 1) ans++;
				}
			} System.out.println(ans);
		}
	}
	
	int gcd(int x, int y) {
		return y==0 ? x:gcd(y, x%y);
	}
}
