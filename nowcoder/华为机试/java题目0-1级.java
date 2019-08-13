/**
* 题目描述：
* 编写一个函数，传入一个int型数组，返回该数组能否分成两组，使得两组中各元素加起来的和相等，
* 并且，所有5的倍数必须在其中一个组中，所有3的倍数在另一个组中（不包括5的倍数），能满足以
* 上条件，返回true；不满足时返回false。
*
* 输入描述：
* 第一行是数据个数，第二行是输入的数据
*
* 输出描述：
* 返回true或者false
*
* 示例
*   输入
*   4
*   1 5 -5 1
*
*   输出
*   true
*
*/

import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }

    ArrayList<Integer> arr;
    void run() {
    	while(cin.hasNext()) {
    		int n = cin.nextInt(), x, a=0, b=0;
    		arr = new ArrayList<>();
    		for(int i=0; i<n; i++) {
    			x = cin.nextInt();
    			if(x%3 == 0) {
    				a += x;
    			} else if(x%5 == 0) {
    				b += x;
    			} else arr.add(x);
    		}
    		x = Math.abs(b - a);
    		ans = false;
    		dfs(0, x, 0);
    		System.out.println(ans);
        }
    }
    
    boolean ans;
    void dfs(int k, int x, int y) {
    	if(k == arr.size()) {
    		if(x == Math.abs(y)) {
    			ans = true;
    		} return;
    	}
    	for(int i=0; i<2; i++) {
    		if(i == 0) {
    			dfs(k+1, x, y+arr.get(k));
    		} else dfs(k+1, x, y-arr.get(k));
    	}
    }
}
