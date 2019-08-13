/**
* 题目描述：
* 对于不同的字符串，我们希望能有办法判断相似程度，我们定义了一套操作方法来把两个不相同的字符串变得相同，具体的操作方法如下：
* 1 修改一个字符，如把“a”替换为“b”。
* 2 增加一个字符，如把“abdd”变为“aebdd”。
* 3 删除一个字符，如把“travelling”变为“traveling”。
* 比如，对于“abcdefg”和“abcdef”两个字符串来说，我们认为可以通过增加和减少一个“g”的方式来达到目的。上面的两种方案，都只需要
* 一次操作。把这个操作所需要的次数定义为两个字符串的距离，而相似度等于“距离＋1”的倒数。也就是说，“abcdefg”和“abcdef”的距离
* 为1，相似度为1/2=0.5。给定任意两个字符串，你是否能写出一个算法来计算出它们的相似度呢？
*
* 输入描述：
* 输入两个字符串
*
* 输出描述：
* 输出相似度，string类型
*
* 示例
*   输入
*   abcdef
*   abcdefg
*
*   输出
*   1/2
*
*/

/**
* 解题思路
* 用d[i, j]表示source[1..i]到target[1..j]之间的最小编辑距离
* 若source[i]==target[j], d[i][j] = d[i-1][j-1];
* d[i,j-1]+1 表示对source[i]执行插入操作后计算最小编辑距离
* d[i-1,j]+1 表示对source[i]执行删除操作后计算最小编辑距离
* d[i-1,j-1]+1 表示对source[i]替换成target[i]操作后计算最小编辑距离
* d[i, j]的边界值就是当target为空字符串（m=0）或source为空字符串（n=0）时所计算出的编辑距离：
* m = 0，对于所有 i：d[i, 0] = i
* n = 0，对于所有 j：d[0, j] = j
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
    		for(int i=0; i<sa.length(); i++) {
    			for(int j=0; j<sb.length(); j++) {
    				if(sa.charAt(i) != sb.charAt(j)) {
    					dp[i+1][j+1] = 
    						Math.min(Math.min(dp[i+1][j],dp[i][j+1]),dp[i][j])+1;
    				} else dp[i+1][j+1] = dp[i][j];
    			}
    		}
    		System.out.println("1/" + (dp[sa.length()][sb.length()]+1));
        }
    }
}
