/**
* 题目描述：
* A是一个50×10的矩阵，B是10×20的矩阵，C是20×5的矩阵。计算A*B*C有两种顺序：（（AB）C）或者（A（BC）），
* 前者需要计算15000次乘法，后者只需要3500次。编写程序计算不同的计算顺序需要进行的乘法次数。
*
* 输入描述：
* 输入多行，先输入要计算乘法的矩阵个数n，每个矩阵的行数，列数，总共2n的数，最后输入要计算的法则。
*
* 输出描述：
* 输出需要进行的乘法次数。
*
* 示例
*   输入
*   3
*   50 10
*   10 20
*   20 5
*   (A(BC))
*
*   输出
*   3500
*
*/

import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }
    
    String ss;
    int n, idx, ans;
    int[][] arr = null;
    void run() {
    	while(cin.hasNext()) {
    		n = cin.nextInt();
    		arr = new int[n][2];
    		for(int i=0; i<n; i++) {
    			arr[i][0] = cin.nextInt();
    			arr[i][1] = cin.nextInt();
    		}
    		ss = cin.next();
    		idx = ans = 0;
    		exp_value();
    		System.out.println(ans);
        }
    }
    
    int[] exp_value() {
    	int[] result = term_value();
    	while(idx < ss.length()) {
    		char c = ss.charAt(idx);
    		if(Character.isLetter(c) || c == '(') {
    			int[] value = term_value();
    			ans += result[0]*result[1]*value[1];
    			result[1] = value[1];
    		} else break;
    	}
    	return result;
    }
    
    int[] term_value() {
    	int[] result;
    	char c = ss.charAt(idx++);
    	if(c == '(') {
    		result = exp_value();
    		++idx;
    	} else {
    		result = arr[c - 'A'];
    	} return result;
    }
}
