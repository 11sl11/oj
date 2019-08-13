/**
* 题目描述：
* 输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列,相同成绩都按先录入排列在前的规则处理。
*
* 输入描述：
* 输入多行，先输入要排序的人的个数，然后输入排序方法0（降序）或者1（升序）再分别输入他们的名字和成绩，以一个空格隔开。
*
* 输出描述：
* 按照指定方式输出名字和成绩，名字和成绩之间以一个空格隔开。
*
* 示例
*   输入
*   3
*   0
*   fang 90
*   yang 50
*   ning 70
*
*   输出
*   fang 90
*   ning 70
*   yang 50
*
*/

import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }

    ArrayList<String>[] arr;
    void run() {
    	while(cin.hasNext()) {
    		int n = cin.nextInt(), k = cin.nextInt(), x;
    		arr = new ArrayList[101];
    		for(int i=0; i<n; i++) {
    			String s = cin.next();
    			x = cin.nextInt();
    			if(arr[x] == null) arr[x] = new ArrayList<>();
    			arr[x].add(s);
    		}
    		if(k == 0) { //降序
    			for(int i=100; i>=0; i--) {
    				dosth(i);
    			}
    		} else { //升序
    			for(int i=0; i<=100; i++) {
    				dosth(i);
    			}
    		}
        }
    }
    
    void dosth(int k) {
    	for(int i=0; arr[k]!=null && i<arr[k].size(); i++) {
    		System.out.println(arr[k].get(i) + " " + k);
    	}
    }
}
