/**
* 题目描述：
* 你有3个需要完成的任务，完成这3个任务是需要付出代价的。首先，你可以不花任何代价的完成一个任务；
* 然后，在完成了第i个任务之后，你可以花费|Ai - Aj|的代价完成第j个任务。|x|代表x的绝对值。计算
* 出完成所有任务的最小代价。
*
* 输入描述：
* 一行3个整数A1,A2,A3，每个数字之间用一个空格分隔。所有数字都是整数，并且在[1,100]范围内。
*
* 输出描述：
* 一个整数，代表最小的代价。
*
* 示例
*   输入
*   1 6 3
*   10 10 10
*
*   输出
*   5
*   0
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
			int[] arr = new int[3];
			for(int i=0; i<3; i++) arr[i]=cin.nextInt();
			Arrays.sort(arr);
			System.out.println(Math.abs(arr[1]-arr[0])+Math.abs(arr[1]-arr[2]));
		}
	}
}
