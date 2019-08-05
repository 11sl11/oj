/**
* 题目描述
* 蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
*
* 示例
*   输入
*   5
*
*   输出
*   1 3 6 10 15
*   2 5 9 14
*   4 8 13
*   7 12
*   11
*
*/

import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }
    
    final int N = 100;
    int[][] A = new int[N+1][N+1];
    {
        for(int i=0; i<N; i++) {
            A[i][0] = i>0 ? (A[i-1][0]+i):1;
            for(int j=1, k=i+2; j<N-i; j++, k++) {
                A[i][j] = A[i][j-1] + k;
            }
        }
    }
    
    void run() {
        while(cin.hasNext()) {
            int n = cin.nextInt();
            for(int i=0; i<n; i++) {
                System.out.print(A[i][0]);
            	for(int j=1; j<n-i; j++) {
            		System.out.print(" " + A[i][j]);
            	} System.out.println();
            }
        }
    }
}
