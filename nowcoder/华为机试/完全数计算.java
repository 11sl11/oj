/**
* 题目描述：
* 完全数（Perfect number），又称完美数或完备数，是一些特殊的自然数。它所有的真因子（即除了自身以外的约数）
* 的和（即因子函数），恰好等于它本身。例如：28，它有约数1、2、4、7、14、28，除去它本身28外，其余5个数相加，
* 1+2+4+7+14=28。给定函数count(int n),用于计算n以内(含n)完全数的个数。计算范围, 0 < n <= 500000 返回n以
* 内完全数的个数。 异常情况返回-1。
*
* 示例
*   输入
*   1000
*
*   输出
*   3
*
*/

import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }
    
    final int MAXN = 500000;
    ArrayList<Integer> arr = new ArrayList<>();
    {
        for(int i=2; i<=MAXN; i++) {
            if(dosth(i)) arr.add(i);
        }
    }
    void run() {
        while(cin.hasNext()) {
            int x = cin.nextInt(), ans = 0;
            for(int i=0; i<arr.size() && arr.get(i)<=x; i++, ans++);
            System.out.println(ans);
        }
    }
    
    boolean dosth(int x) {
        int s = 0;
        for(int i=2; i<=(int)Math.sqrt(x); i++) {
            if((x%i) == 0) {
                s += i; s += (x/i);
            }
        } return (s+1) == x;
    }
}
