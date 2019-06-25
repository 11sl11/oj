package hdu;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Prime Ring Problem
 * @author 11sl11
 *	ษ๎หั
 */
public class hdu_1016 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch (Exception ex) { }
	}

	static boolean[] prime = new boolean[41];
	static {
		prime[2]  = prime[3]  = prime[5]  = prime[7]  = prime[11] = prime[13] = 
		prime[17] = prime[19] = prime[23] = prime[29] = prime[31] = prime[37] = true;
	}
	public static void main(String[] args) {
		int cnt = 0;
		while(cin.hasNext()) {
			int n = cin.nextInt();
			Arrays.fill(visited, false);
			arr[0] = 1;
			System.out.println("Case " + (++cnt) + ":");
			dfs(n, 1);
			System.out.println();
		}
	}
	
	static int[] arr = new int[41];
	static boolean[] visited = new boolean[41];
	static void dfs(int n, int m) {
		if(n==m && prime[1+arr[n-1]]) {
			for(int i=0; i<n-1; i++) {
				System.out.print(arr[i] + " ");
			}System.out.println(arr[n-1]);
		}
		for(int i=2; i<=n; i++) {
			if(visited[i] || !prime[i+arr[m-1]]) continue;
			visited[i] = true;
			arr[m++] = i;
			dfs(n, m);
			visited[i] = false;
			m--;
		}
	}
}
