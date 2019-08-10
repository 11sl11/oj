/**
* 题目描述
* 我们来做一个简单的密码破译游戏。破译的规则很简单，将数字转换为字母，1转化为a，2转化为b，
* 依此类推，26转化为z。现在输入的密码是一串数字，输出的破译结果是该数字串通过转换规则所能
* 产生的所有字符串。
*
* 输入描述：
* 多行数据，每行为一个数字串。
* 保证数字串的总长度不超过1000，每行数据的答案至少有1个且不超过1000个。
*
* 输出描述：
* 多行数据，每行对应输出通过数字串破译得到的所有字符串，并按照字符串顺序排列，字符串之间用单
* 个空格分隔。每行开头和结尾不允许有多余的空格。
*
* 示例
*   输入
*   1
*   12
*   123
*   72486
*   759917
*   16
*   757867955
*   91910227
*   176
*   976320471829855
*   39268258818
*   5455552679
*   5
*
*   输出
*   a
*   ab l
*   abc aw lc
*   gbdhf gxhf
*   geiiag geiiq
*   af p
*   geghfgiee
*   iaijbbg iaijvg isjbbg isjvg
*   agf qf
*   igfctdgahbihee igfctdgrbihee
*   cibfhbehhah cibfhbehhr cibfhyhhah cibfhyhhr cizhbehhah cizhbehhr cizhyhhah cizhyhhr
*   edeeeebfgi edeeeezgi
*   e
*
*/

import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }

//    void run() {
//    	arr = new int[5];
//    	dfs(4, 0);
//    }
//    
//    int[] arr = null;
//    void dfs(int n, int k) {
//    	if(n == 0) {
//    		for(int i=0; i<k; i++) {
//    			System.out.print(arr[i] + " ");
//    		} System.out.println();
//    		return;
//    	}
//    	for(int i=1; i<=n; i++) {
//    		arr[k] = i;
//    		dfs(n-i, k+1);
//    	}
//    }
//
// Eg. 4 = 4
//       = 3+1
//       = 2+2、2+1+1
//       = 1+3、1+2+1、1+1+2、1+1+1+1
    
    
    String ss = null;
    void run() {
    	while(cin.hasNext()) {
    		ss = cin.next();
    		arr = new int[ss.length()+1];
    		set = new TreeSet<>();
    		dfs(ss.length(), 0);
    		boolean flag = false;
    		for(String s: set) {
    			if(flag) System.out.print(" ");
    			flag = true;
    			System.out.print(s);
    		} System.out.println();
    	}
    }
    
    int[] arr = null;
    Set<String> set = null;
    void dfs(int n, int k) {
    	if(n == 0) {
    		StringBuilder sb = new StringBuilder();
    		for(int i=0, j=0; i<k; j+=arr[i], i++) {
    			String s = ss.substring(j, arr[i]+j);
    			int x = Integer.parseInt(s);
    			if(x > 26 || x < 1 || s.charAt(0) == '0') return;
    			sb.append((char)('a'+x-1));
    		}
    		set.add(sb.toString());
    		return;
    	}
    	for(int i=1; i<=Math.min(n, 2); i++) {
    		arr[k] = i;
    		dfs(n-i, k+1);
    	}
    }
}
