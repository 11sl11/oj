/**
* 题目描述
* 输出7有关数字的个数，包括7的倍数，还有包含7的数字（如17，27，37...70，71，72，73...）
* 的个数（一组测试用例里可能有多组数据，请注意处理）
*
* 输入描述：
* 一个正整数N。(N不大于30000)
*
* 输出描述：
* 不大于N的与7有关的数字个数，例如输入20，与7有关的数字包括7,14,17.
*
*/

import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }
    
    final int MAXN = 30000;
    boolean[] set = new boolean[MAXN];
    {
        for(int i=7; i<=MAXN; i++) {
            if(i%7 == 0  || dosth(i)) {
                set[i] = true;
            }
        }
    }
    void run() {
        while(cin.hasNext()) {
            int x = cin.nextInt(), ans = 0;
            for(int i=7; i<=x; i++) {
                if(set[i]) ans++;
            } System.out.println(ans);
        }
    }
    
    boolean dosth(int x) {
        while(x > 0) {
            if(x%10 == 7) return true;
            x /= 10;
        }
        return false;
    }
}
