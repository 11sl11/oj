/**
* 题目描述：
* 对给定的任意字符串，找出其最长回文字符串最大长度。
* 
* 示例
*   输入
*   ABAKK
*   abaaab
*
*   输出
*   3
*   5
*
*/

/*
// runtime: 964ms
import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }
    
    void run() {
        while(cin.hasNext()) {
            String ss = cin.next();
            boolean[][] dp = new boolean[ss.length()][ss.length()];
            int ans = 0;
            for(int i=0; i<ss.length(); i++) {
                for(int j=0; j<=i; j++) {
                    if(i == j) {
                        dp[i][j] = true;
                    } else if(i - j == 1) {
                        dp[i][j] = ss.charAt(i)==ss.charAt(j);
                    } else dp[i][j] = (ss.charAt(i)==ss.charAt(j) && dp[i-1][j+1]);
                    ans = dp[i][j] ? Math.max(ans, i-j+1): ans;
                }
            } System.out.println(ans);
        }
    }
}
*/

// runtime: 240ms
import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }
    
    void run() {
        while(cin.hasNext()) {
            String ss = cin.next();
            StringBuilder sb = new StringBuilder("#");
            for(int i=0; i<ss.length(); i++) {
                sb.append(ss.charAt(i));
                sb.append("#");
            }
            ss = sb.toString();
            int ans = 0;
            int[] p = new int[ss.length()];
            for(int i=0, j=0, k=0; i<ss.length(); i++) {
                p[i] = k>i ? Math.min(k-i, p[2*j-i]) : 1;
                while(i-p[i]>=0 && i+p[i]<ss.length()) {
                    if(ss.charAt(i-p[i]) != ss.charAt(i+p[i])) break;
                    p[i]++;
                }
                if(i+p[i] > k) {
                    j = i;
                    k = i+p[i];
                }
                ans = Math.max(ans, p[i]-1);
            } System.out.println(ans);
        }
    }
}
