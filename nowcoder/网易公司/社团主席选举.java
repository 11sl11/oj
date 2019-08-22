/**
* 题目描述：
* 随着又一届学生的毕业，社团主席换届选举即将进行。一共有n个投票者和m个候选人，小易知道每一个投票者的投票对象。
* 但是，如果小易给某个投票者一些糖果，那么这个投票者就会改变他的意向，小易让他投给谁，他就会投给谁。由于小易特
* 别看好这些候选人中的某一个大神，这个人的编号是1，所以小易希望能尽自己的微薄之力让他当选主席，但是小易的糖果
* 数量有限，所以请你帮他计算，最少需要花多少糖果让1号候选人当选。某个候选人可以当选的条件是他获得的票数比其他
* 任何候选者都多。
*
* 输入描述：
* 第一行两个整数n和m，表示投票者的个数和候选人的个数。接下来n行，每一行两个整数x和y，x表示这个投票者的投票对象，
* y表示需要花多少个糖果让这个人改变意向。满足1 <= n, m <= 3000，1 <= x <= m，1 <= y <= 10^9。
*
* 输出描述：
* 一个整数，糖果的最小花费。
*
* 示例
*   输入
*   5 5
*   2 5
*   3 5
*   4 5
*   5 6
*   5 1
*
*   输出
*   6
*
*/

/**
* 解题思路：
* DFS,每一步有两种选择：1、收买花费最少的；2、收买最多得票的支持者中花费最少的
*/

import java.util.*;

public class Main {
	Scanner cin = new Scanner(System.in);
	public static void main(String[] args) {
		new Main().run();
	}

	int n, m;
	int[] votes;
	Voter[] voters;
	void run() {
		while(cin.hasNext()) {
			n = cin.nextInt(); m = cin.nextInt();
			votes = new int[m+1];
			voters = new Voter[n];
			visited = new boolean[n];
			for(int i=0; i<n; i++) {
				voters[i] = new Voter(cin.nextInt(), cin.nextInt());
				votes[voters[i].a]++;
				if(voters[i].a == 1) visited[i] = true;
			}
			mincost = Long.MAX_VALUE;
			dfs(0);
			System.out.println(mincost);
		}
	}
	
	long mincost;
	boolean[] visited;
	void dfs(long cost) {
		if(cost >= mincost) return;
		int k = mostPopularCandidate();
		if(k == 1) {
			mincost = Math.min(mincost, cost);
			return;
		}
		
		int ii = -1, jj = -1;
		for(int i=0; i<n; i++) {
			if(visited[i]) continue;
			if(ii<0 || voters[i].b<voters[ii].b) {
				ii = i;
			}
			if(voters[i].a==k && (jj<0 || voters[i].b<voters[jj].b)) {
				jj = i;
			}
		}
		
		// 收买花费最小的
		visited[ii] = true;
		votes[1]++;
		votes[voters[ii].a]--;
		dfs(cost + voters[ii].b);
		visited[ii] = false;
		votes[1]--;
		votes[voters[ii].a]++;
		
		if(ii == jj) return;
		
		// 削弱票数最多者优势
		visited[jj] = true;
		votes[1]++;
		votes[k]--;
		dfs(cost + voters[jj].b);
		visited[jj] = false;
		votes[1]--;
		votes[k]++;
	}
	
	int mostPopularCandidate() {
		int k = 1;
		for(int i=2; i<=m; i++) {
			if(votes[k] <= votes[i]) {
				k = i;
			}
		} return k;
	}

	class Voter {
		int a, b;
		Voter(int a, int b) {
			this.a = a; this.b = b;
		}
	}
}
