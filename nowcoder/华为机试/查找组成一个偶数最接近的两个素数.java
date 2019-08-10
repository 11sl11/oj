/**
* 题目描述
* 任意一个偶数（大于2）都可以由2个素数组成，组成偶数的2个素数有很多种情况，
* 本题目要求输出组成指定偶数的两个素数差值最小的素数对。
*
* 输入描述：
* 输入一个偶数
*
* 输出描述：
* 输出两个素数
*
* 示例
*   输入
*   20
*
*   输出
*   7
*   13
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
            int x = cin.nextInt();
            for(int i=x/2; i>1; i--) {
                if(dosth(i) && dosth(x-i)) {
                    System.out.println(i + "\n" + (x-i));
                    break;
                }
            }
        }
    }
    
    boolean dosth(int x) {
        if(x == 2) return true;
        for(int i=2; i<=Math.sqrt(x); i++) {
            if((x%i) == 0) return false;
        } return true;
    }
}
