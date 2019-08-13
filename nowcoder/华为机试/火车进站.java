/**
* 题目描述：
* 给定一个正整数N代表火车数量，0<N<10，接下来输入火车入站的序列，一共N辆火车，每辆火车以数字1-9编号。
* 要求以字典序排序输出火车出站的序列号。
*
* 输入描述：
* 有多组测试用例，每一组第一行输入一个正整数N（0<N<10），第二行包括N个正整数，范围为1到9。
*
* 输出描述：
* 输出以字典序从小到大排序的火车出站序列号，每个编号以空格隔开，每个输出序列换行。
*
* 示例
*   输入
*   3
*   1 2 3
*
*   输出
*   1 2 3
*   1 3 2
*   2 1 3
*   2 3 1
*   3 2 1
*
*/

import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }

    int n;
    int[] arr, rcd;
    void run() {
    	while(cin.hasNext()) {
    		n = cin.nextInt();
    		arr = new int[n]; rcd = new int[n];
    		for(int i=0; i<n; i++) {
    			arr[i] = cin.nextInt();
    		}
    		visited = new boolean[n];
    		list = new ArrayList<>();
    		dfs(0);
    		Collections.sort(list);
    		for(int i=0; i<list.size(); i++) {
    			System.out.println(list.get(i));
    		}
        }
    }
    
    boolean[] visited;
    ArrayList<String> list;
    void dfs(int k) {
    	if(k == n) {
    		Stack<Integer> stack = new Stack<>();
    		for(int i=0, j=0; i<n; i++) {
    			stack.push(arr[i]);
    			while(!stack.isEmpty() && stack.peek()==rcd[j]) {
    				stack.pop(); j++;
    			}
    		}
    		if(stack.isEmpty()) {
    			StringBuilder sb = new StringBuilder();
    			for(int i=0; i<n; i++) {
    				if(i > 0) sb.append(" ");
    				sb.append(rcd[i]);
    			}
    			list.add(sb.toString());
    		}
    		return;
    	}
    	for(int i=0; i<n; i++) {
    		if(visited[i]) continue;
    		visited[i] = true;
    		rcd[k] = arr[i];
    		dfs(k+1);
    		visited[i] = false;
    	}
    }
}
