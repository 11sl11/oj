/**
* 题目描述
* 计算最少出列多少位同学，使得剩下的同学排成合唱队形
* 说明：
* N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。 
* 合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK，
* 则他们的身高满足存在i（1<=i<=K）使得T1<T2<......<Ti-1<Ti>Ti+1>......>TK。 
* 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
*
* 输入描述：
* 若干组整数N
* 
* 输出描述：
* 最少需要几位同学出列
*
* 示例
*   输入
*   8
*   186 186 150 200 160 130 197 200
* 
*   输出
*   4
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
            int n = cin.nextInt(), ans = 0;
            int[] arr = new int[n], dp0 = new int[n], dp1 = new int[n];
            for(int i=0; i<n; i++) {
                arr[i] = cin.nextInt();
            }
            dosth(arr, dp0, 0);
            dosth(arr, dp1, 1);
            for(int i=0; i<n; i++) {
                ans = Math.max(ans, dp0[i]+dp1[i]);
            } System.out.println(n-ans+1);
        }
    }
    
    void dosth(int[] bf, int[] dp, int comp) {
        for(int i=0; i<bf.length && comp==0; i++) {
            dp[i] = 1;
            for(int j=0; j<i; j++) {
                if(bf[i] > bf[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        for(int i=bf.length-1; i>=0 && comp==1; i--) {
            dp[i] = 1;
            for(int j=bf.length-1; j>i; j--) {
                if(bf[i] > bf[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
    }
}
