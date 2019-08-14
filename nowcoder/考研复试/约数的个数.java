/**
* 题目描述：
* 输入n个整数,依次输出每个数的约数的个数
*
* 输入描述：
* 输入的第一行为N，即数组的个数(N<=1000)接下来的1行包括N个整数，其中每个数的范围为(1<=Num<=1000000000)
* 当N=0时输入结束。
*
* 输出描述：
* 可能有多组输入数据，对于每组输入数据，输出N行，其中每一行对应上面的一个数的约数的个数。
*
* 示例
*   输入
*   5
*   1 3 4 6 12
*
*   输出
*   1
*   2
*   3
*   4
*   6
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
    		int n = cin.nextInt(), x;
    		for(int i=0, k; i<n; i++) {
    			x = cin.nextInt();
    			k = 1;
    			for(int j=2; j<=(int)Math.sqrt(x); j++) {
    				if(x%j == 0) {
    					if(j*j == x) {
    						k += 1;
    					} else k += 2;
    				}
    			} if(x > 1) k++;
    			System.out.println(k);
    		}
    	}
    }
}
