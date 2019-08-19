/**
* 题目描述：
* 给出有向边集，判断是否是树结构。
*
* 输入描述：
* 存在多组测试数据，每组数据的有向边用 a b 表示a->b(0<a,b<10000)，以 0 0 表示本组测试数据结束。以-1 -1 表示
* 结束输入。
*
* 示例：
*   输入
*   0 0
*   6 8  5 3  5 2  6 4 5 6  0 0
*   8 1  7 3  6 2  8 9  7 5 7 4  7 8  7 6  0 0
*   3 8  6 8  6 4 5 3  5 6  5 2  0 0
*   -1 -1
*
*   输出
*   Case 1 is a tree.
*   Case 2 is a tree.
*   Case 3 is a tree.
*   Case 4 is not a tree.
*
*/

/**
* 解题思路：
* 树形结构每个节点除了根节点，入度都为1；
* 空树也为树；
* 存在一个节点的入度为0，否则可能会出现环结构
*/

import java.util.*;

public class Main {
	Scanner cin = new Scanner(System.in);
	public static void main(String[] args) {
		new Main().run();
	}

	// null is tree!!!
	void run() {
		int cnt = 0;
		while(cin.hasNext()) {
			Map<Integer, Integer> map = new HashMap<>();
			while(true) {
				int x = cin.nextInt(), y = cin.nextInt();
				if(x==0 && y==0) break;
				if(x==-1 && y==-1) return;
				if(!map.containsKey(x)) map.put(x, 0);
				if(!map.containsKey(y)) {
					map.put(y, 1);
				} else map.put(y, map.get(y)+1);
			}
			int r = 0;
			boolean ans = true;
			for(Integer i: map.keySet()) {
				if(map.get(i) == 0) r++;
				if(map.get(i)>1 || r>1) {
					ans = false; break;
				}
			}
			if(r==0 && map.size()>0) ans = false;
			System.out.println(
				"Case "+(++cnt)+" is "+(ans?"":"not ")+"a tree.");
		}
	}
}
