/**
* 题目描述：
* 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
*
* 示例
*   输入
*   5 7
*
*   输出
*   35
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
    		int x = cin.nextInt(), y = cin.nextInt();
    		int gcd = gcd(x, y);
    		if(x%gcd == 0) {
    			System.out.println(x/gcd*y);
    		} else if(y%gcd == 0) {
    			System.out.println(y/gcd*x);
    		} else System.out.println(x*y / gcd);
        }
    }
    
    int gcd(int x, int y) {
    	return y==0 ? x:gcd(y, x%y);
    }
}
