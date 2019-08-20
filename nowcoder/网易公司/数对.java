/**
* 题目描述：
* 牛牛以前在老师那里得到了一个正整数数对(x, y), 牛牛忘记他们具体是多少了。但是牛牛记得老师告诉过他
* x和y均不大于n, 并且x除以y的余数大于等于k。牛牛希望你能帮他计算一共有多少个可能的数对。
*
* 输入描述：
* 输入包括两个正整数n,k(1 <= n <= 10^5, 0 <= k <= n - 1)。
*
* 输出描述：
* 对于每个测试用例, 输出一个正整数表示可能的数对数量。
*
* 示例
*   输入
*   5 2
*
*   输出
*   7
*   说明：满足条件的数对有(2,3),(2,4),(2,5),(3,4),(3,5),(4,5),(5,3)
*/

/**
* 解题思路：
* 当 y<k 时所有余数均小于k，因此不需要考虑，枚举 y=k+1~n；当 x=1~n 时，余数是 1,2,3,...,y-1,0 
* 循环出现，循环节长度显然是y，总共出现了 [n/y] 个循环节，然后数出每个循环节里面不小于 k 的余数；
* 最后再数出不满一个循环节的不小于k的余数
* 若 y=k+1, 则 x={k, 2k+1, ..., k+i(k+1)};
* 若 y=k+2, 则 x={k,k+1, 2k+2, 2k+3, ..., k+i(k+2), k+1+i(k+2)};
* 若 y=n,   则 x={k,k+1,k+2,...,n-1};
*/

import java.util.*;

public class Main {
    int n, k;
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }
    
    void run() {
        n = cin.nextInt(); k = cin.nextInt();
        long ans = 0;
        if(k == 0) ans = (long)n*n;
        for(int y=k+1; y<=n && k>0; y++) {
            ans += (n/y)*(y-k);
            if((n%y) >= k) {
                ans += (n%y)-k + 1;
            }
        }
        System.out.println(ans);
    }
}
