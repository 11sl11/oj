/**
* 题目描述
* 给出一个数字N（0<N<1000000）,将N写成立方数和的形式，求出需要的最少立方数个数。
* 例如N=17，1+8+8 = 17，最少需要3个立方数，则输出3。
* N=28,1+1+1+1+8+8+8=28, 需要7个立方数，1+27=28,需要2个立方数，所以最少立方数为2，则输出2。
*
* 示例
*   输入
*   28
*   29825
*
*   输出
*   2
*   4
*
*/

import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }
    
    final int MAXN = 1000000;
    void run() {
        while(cin.hasNext()) {
            int N = cin.nextInt(), x;
            int[] dp = new int[N+1];
            for(int i=1; i<=N; i++) {
                x = Integer.MAX_VALUE;
                for(int j=1; j*j*j<=i; j++) {
                    x = Math.min(x, dp[i-j*j*j]);
                }
                dp[i] = x+1;
            } System.out.println(dp[N]);
        }
    }
}
