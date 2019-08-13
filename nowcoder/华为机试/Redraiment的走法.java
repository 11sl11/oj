/**
* 题目描述：
* Redraiment是走梅花桩的高手。Redraiment总是起点不限，从前到后，往高的桩子走，但走的步数最多，不知道为什么？
* 你能替Redraiment研究他最多走的步数吗？ 
* 
* 示例
*   输入
*   6
*   2 5 1 5 4 5
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

    void run() {
    	while(cin.hasNext()) {
    		int n = cin.nextInt(), ans = 0;
    		int[] arr = new int[n], dp = new int[n];
    		for(int i=0; i<n; i++) {
    			arr[i] = cin.nextInt();
    		}
    		for(int i=0; i<n; i++) {
    			dp[i] = 1;
    			for(int j=0; j<i; j++) {
    				if(arr[i] > arr[j]) {
    					dp[i] = Math.max(dp[i], dp[j]+1);
    				}
    			}
    			ans = Math.max(ans, dp[i]);
    		} System.out.println(ans);
        }
    }
}
