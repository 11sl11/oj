/**
* 题目描述：（网易机试）
* 小易在学校中学习了关于字符串的理论, 于是他基于此完成了一个字典的项目。小易的这个字典很奇特, 字典内的每个单词
* 都包含n个'a'和m个'z', 并且所有单词按照字典序排列。小易现在希望你能帮他找出第k个单词是什么。
*
* 输入描述：
* 输入包括一行三个整数n, m, k(1 <= n, m <= 100, 1 <= k <= 10^9), 以空格分割。
*
* 输出描述：
* 输出第k个字典中的字符串，如果无解，输出-1。
*
* 示例
*   输入
*   2 2 6
*
*   输出
*   zzaa（说明：字典中的字符串依次为aazz azaz azza zaaz zaza zzaa）
*
*/

/**
* 解题思路：
* 假设第一个字符为a，则剩下n-1个'a'和m个'z'组成的子序列只能构成C(n-1,n-1+m)个单词，且是字典中前C(n-1,n-1+m)
* 个单词。比较k和C(n-1,n-1+m)，若k小，说明k是前C(n-1,n-1+m)个单词，则第一个字符必为'a'。子问题化为在子序列
* (n-1个'a'和m个'z')找到第k个单词若k大，则说明第一个字符必为'z',单词是以'z'开头的单词中的第k-C(n-1,n-1+m)个。
* 子问题化为在子序列(n个'a'和m-1个'z')找到第k-C(m-1,n+m-1)个单词。
*
* 求 C(n, n+m): (n+m)!/n!m! = (n+m)(n+m-1)...(m+1)/n!
* res = 1;
* for(i=1; i<=n; i++) {
*   res *= (n+m-i+1)
*   res /= i;
* }
*/

import java.util.*;

public class Main {
	Scanner cin = new Scanner(System.in);
	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		while(cin.hasNext()) {
			int n=cin.nextInt(), m=cin.nextInt(), k=cin.nextInt();
			StringBuilder sb = new StringBuilder();
			while(n>0 && m>0) {
				long res = 1;
				for(int i=1; i<n; i++) {
					res *= (n+m-i);
					res /= i;
					if(res > k) break;
				}
				if(k <= res) {
					sb.append('a');
					n--;
				} else {
					sb.append('z');
					m--;
					k -= res;
				}
			}
			if(k != 1) {
				System.out.println(-1);
				break;
			}
			while(n-- > 0) sb.append('a');
			while(m-- > 0) sb.append('z');
			System.out.println(sb.toString());
		}
	}
}
