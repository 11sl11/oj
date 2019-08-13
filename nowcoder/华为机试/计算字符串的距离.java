/**
* 题目描述：
* Levenshtein 距离，又称编辑距离，指的是两个字符串之间，由一个转换成另一个所需的最少编辑操作次数。
* 许可的编辑操作包括将一个字符替换成另一个字符，插入一个字符，删除一个字符。例如，字符串A:abcdefg
* 和字符串B: abcdef，通过增加或是删掉字符”g”的方式达到目的。这两种方案都需要一次操作。把这个操作所
* 需要的次数定义为两个字符串的距离。
*
* 示例
*   输入
*   abcdefg
*   abcdef
*
*   输出
*   1
*
*/

/**
* 算法思路：
* 设Ai为字符串A(a1a2a3 … am)的前i个字符（即为a1,a2,a3 … ai）
* 设Bj为字符串B(b1b2b3 … bn)的前j个字符（即为b1,b2,b3 … bj）
*
* 设 L(i,j)为使两个字符串和Ai和Bj相等的最小操作次数。
* 当ai==bj时 显然 L(i,j) = L(i-1,j-1)
* 当ai!=bj时
* 
*  若将它们修改为相等，则对两个字符串至少还要操作L(i-1,j-1)次
*  若删除ai或在bj后添加ai，则对两个字符串至少还要操作L(i-1,j)次
*  若删除bj或在ai后添加bj，则对两个字符串至少还要操作L(i,j-1)次
*  此时L(i,j) = min( L(i,j-1), L(i-1,j), L(i-1,j-1) ) + 1
*
* 显然，L(i,0)=i，L(0,j)=j, 再利用上述的递推公式，可以直接计算出L(i,j)值。
*/

import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }

    void run() {
    	while(cin.hasNext()) {
    		String sa = cin.next(), sb = cin.next();
    		int[][] dp = new int[sa.length()+1][sb.length()+1];
    		for(int i=0; i<=sa.length(); i++) dp[i][0] = i;
    		for(int i=0; i<=sb.length(); i++) dp[0][i] = i;
    		
    		for(int i=1; i<=sa.length(); i++) {
    			for(int j=1; j<=sb.length(); j++) {
    				if(sa.charAt(i-1) == sb.charAt(j-1)) {
    					dp[i][j] = dp[i-1][j-1];
    				} else dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
    			}
    		} System.out.println(dp[sa.length()][sb.length()]);
    	}
    }
}
