/**
* 题目描述：
* 把M个同样的苹果放在N个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？（用K表示）5，1，1和1，5，1 是同一种分法。
*
* 输入描述：
* 每个用例包含二个整数M和N。0<=m<=10，1<=n<=10。
*
* 输出描述：
* 输出结果，int型
*
* 示例
*   输入
*   7 3
*
*   输出
*   8
*
*/

/**
* 解题思路
* 对于将M个苹果放在N个盘子里，可以分为如下几种情况：
* 1.N个盘子中都有苹果
* 2.N个盘子中至少有1个盘子没有苹果
* f(m,n)=f(m,n-1)+f(m-n,n);
* 若N大于M，则肯定有空盘子，不妨把这些空盘子放在一边。转换成求解f(m,m)的问题
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
            System.out.println(dfs(n, m));
        }
    }
    
    int dfs(int n, int m) {
        if(n == 0 || m == 1) return 1;
        if(n < m) return dfs(n, n);
        return dfs(n-m, m) + dfs(n, m-1);
    }
}
