/**
* 题目描述：
* 求正整数N(N>1)的质因数的个数。 相同的质因数需要重复计算。如120=2*2*2*3*5，共有5个质因数。
*
* 输入描述：
* 可能有多组测试数据，每组测试数据的输入是一个正整数N，(1<N<10^9)。
*
* 输出描述：
* 对于每组数据，输出N的质因数的个数。
*
*/

import java.util.*;

public class Main {
	Scanner cin = new Scanner(System.in);
	public static void main(String[] args) {
		new Main().run();
	}

	ArrayList<Integer> primes = new ArrayList<>();
	{
		int n = (int)Math.sqrt((1<<31)-1);
		boolean[] visited = new boolean[n+1]; 
		for(int i=2; i<=n; i++) {
			if(!visited[i]) {
				for(int j=i<<1; j<=n; j+=i) visited[j] = true;
				primes.add(i);
			}
		}
	}
	void run() {	
		while(cin.hasNext()) {
			int x = cin.nextInt(), ans=0, i=0;
			while(x > 1) {
				if(x%primes.get(i) == 0) {
					ans++;
					x /= primes.get(i);
				} else i++;
				if(i >= primes.size()) primes.add(x);
			}
			System.out.println(ans);
		}
	}
}
