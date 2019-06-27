package hdu;

import java.io.*;
import java.math.*;
import java.util.*;

/**
 * Ignatius and the Princess II 
 * @author 11sl11
 *	ееап
 */
public class hdu_1027 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch (Exception ex) { }
	}

	static int n, m;
	public static void main(String[] args) {
		while(cin.hasNext()) {
			n = cin.nextInt(); m = cin.nextInt();
			s = w = 0;
			Arrays.fill(visited, false);
			dfs(0);
		}
	}
	
	static int s, w;
	static int[] arrs = new int[1001];
	static boolean[] visited = new boolean[1001];
	static void dfs(int k) {
		if(w == 1) return;
		if(k == n) {
			s++;
			if(s == m) {
				w = 1;
				System.out.print(arrs[0]);
				for(int i=1; i<n; i++) {
					System.out.print(" " + arrs[i]);
				} System.out.println();
			}
			return;
		}
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arrs[k] = i+1;
				dfs(k+1);
				visited[i] = false;
			}
		}
	}

//	static BigInteger factorial(int x) {
//		BigInteger ans = BigInteger.ONE;
//		for(int i=2; i<=x; i++) ans = ans.multiply(BigInteger.valueOf(i));
//		return ans;
//	}
//	
//	static LinkedList<Integer> arr = new LinkedList<>();
//	public static void main(String[] args) {
//		while(cin.hasNext()) {
//			n = cin.nextInt(); m = cin.nextInt()-1;
//			for(int i=1; i<=n; i++) arr.add(i);
//			for(int i=n-1; i>=0; i--) {
//				BigInteger x = factorial(i);
//				int idx = BigInteger.valueOf(m).divide(x).intValue();
//				System.out.print(arr.get(idx));
//				arr.remove(idx);
//				if(idx > 0) m = m - idx*x.intValue();
//				if(i > 0) System.out.print(" ");
//			}
//			System.out.println();
//		}
//	}
}
