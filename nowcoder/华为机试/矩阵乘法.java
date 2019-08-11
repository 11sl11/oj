/**
* 题目描述：
* 如果A是个x行y列的矩阵，B是个y行z列的矩阵，把A和B相乘，其结果将是另一个x行z列的矩阵C。
*
* 输入描述：
* 1、第一个矩阵的行数
* 2、第一个矩阵的列数和第二个矩阵的行数
* 3、第二个矩阵的列数
* 4、第一个矩阵的值
* 5、第二个矩阵的值
*
* 输出描述：
* 输出两个矩阵相乘的结果
*
* 示例
*   输入
*   2
*   2
*   2
*   3 8
*   8 0
*   9 0
*   18 9
*
*   输出
*   171 72
*   72 0
*
*/

import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }
    
    void run() {
    	while(cin.hasNext()) {
    		int x = cin.nextInt(), y = cin.nextInt(), z = cin.nextInt();
    		int[][] A = new int[x][y], B = new int[y][z], C = new int[x][z];
    		for(int i=0; i<x; i++) {
    			for(int j=0; j<y; j++) A[i][j] = cin.nextInt();
    		}
    		for(int i=0; i<y; i++) {
    			for(int j=0; j<z; j++) B[i][j] = cin.nextInt();
    		}
    		for(int i=0; i<x; i++) {
    			for(int j=0; j<y; j++) {
    				for(int k=0; k<z; k++) {
    					C[i][k] += A[i][j]*B[j][k];
    				}
    			}
    		}
    		for(int i=0; i<x; i++) {
    			for(int j=0; j<z; j++) {
    				System.out.print(C[i][j] + " ");
    			} System.out.println();
    		}
        }
    }
}
