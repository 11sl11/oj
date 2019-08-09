/**
* 题目描述：
* 0-1背包问题
*
* 输入描述：
* 资产总量,资产种类,资产A条数 资产B条数 资产C条数,资产A价值 资产B价值 资产C价值！
* 举例，资产总量为12，资产种类3种，3种资产条数分别为4，5，7，三种资产价值分别是500元，600元，800元，输入如下：
* 12,3,4 5 7,500 600 800
* 资产总量和资产种类都不超过1000，资产条数不超过1000，资产价值不超过10000，所有数值均为正整数。
*
* 输出描述：
* 资产包中资产最大总价值
*
* 示例
*   输入
*   12,3,4 5 7,500 600 800
*
*   输出
*   1400
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
            String[] ss = cin.nextLine().trim().split("[, ]");
            int C = Integer.parseInt(ss[0]), n = Integer.parseInt(ss[1]);
            int[] W = new int[n], V = new int[n], dp = new int[C+1];
            for(int i=0; i<n; i++) W[i] = Integer.parseInt(ss[2+i]);
            for(int i=0; i<n; i++) V[i] = Integer.parseInt(ss[2+n+i]);
            for(int i=0; i<n; i++) {
                for(int j=C; j>=W[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j-W[i]]+V[i]);
                }
            } System.out.println(dp[C]);
        }
    }
}
