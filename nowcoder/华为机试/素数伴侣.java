/**
* 题目描述
* 若两个正整数的和为素数，则这两个正整数称之为“素数伴侣”，如2和5、6和13，它们能应用于通信加密。
* 现在密码学会请你设计一个程序，从已有的N（N为偶数）个正整数中挑选出若干对组成“素数伴侣”，挑选
* 方案多种多样，例如有4个正整数：2，5，6，13，如果将5和6分为一组中只能得到一组“素数伴侣”，而将
* 2和5、6和13编组将得到两组“素数伴侣”，能组成“素数伴侣”最多的方案称为“最佳方案”。
*
* 输入描述：
* 有一个正偶数N（N≤100），表示待挑选的自然数的个数。后面给出具体的数字，范围为[2,30000]。
*
* 输出描述：
* 输出一个整数K，表示你求得的“最佳方案”组成“素数伴侣”的对数。
*
*/

import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }
    
    final int MAXN = 2*30000;
    boolean[] primes = new boolean[MAXN+1];
    { boolean[] visited = new boolean[MAXN+1];
        for(int i=2; i<=MAXN; i++) {
            if(!visited[i]) {
                for(int j=i<<1; j<=MAXN; j+=i) visited[j] = true;
                primes[i] = true;
            }
        }
    }
    
    int n;
    boolean[][] graph = null;
    void run() {
        while(cin.hasNext()) {
            n = cin.nextInt();
            graph = new boolean[n][n];
            int[] arr = new int[n];
            for(int i=0; i<n; i++) {
                arr[i] = cin.nextInt();
                for(int j=0; j<i; j++) {
                    if(primes[arr[i]+arr[j]]) {
                        if((arr[i] & 1) == 1) {
                            graph[i][j] = true;
                        } else graph[j][i] = true;
                    }
                }
            }

            int ans = 0;
            pre = new int[n+1];
            visited = new boolean[n+1];
            Arrays.fill(pre, -1);
            for(int i=0; i<n; i++) {
                Arrays.fill(visited, false);
                if(dfs(i)) ans++;
            } System.out.println(ans);
        }
    }
    
    int[] pre;
    boolean[] visited;
    boolean dfs(int u) {
        for(int i=0; i<n; i++) {
            if(!visited[i] && graph[u][i]) {
                visited[i] = true;
                if(pre[i]==-1 || dfs(pre[i])) {
                    pre[i] = u;
                    return true;
                }
            }
        } return false;
    }
}
