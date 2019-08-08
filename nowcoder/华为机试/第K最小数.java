/**
* 题目描述：
* 输入n个整数，输出其中最小的k个。
*
* 输入描述：
* 1. 输入两个整数 
* 2. 输入一个整数数组
*
* 输出描述：
* 输出一个整数数组
*
* 示例
*   输入
*   5 2
*   1 3 5 7 2
*
*   输出
*   1 2
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
            int n = cin.nextInt(), k = cin.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++) arr[i] = cin.nextInt();
            for(int i=0; i<k; i++) {
                if(i > 0) System.out.print(" ");
                System.out.print(elem_k(arr, i));
            } System.out.println();
        }
    }
    
    int elem_k(int[] A, int k) {
        int left = 0, right = A.length-1, i, j, x;
        while(left < right) {
            i = left-1; j = right+1;
            for(int a=A[(i+j)>>1]; i<j; ) {
                for(j--; a<A[j]; j--);
                for(i++; a>A[i]; i++);
                if(i < j) {
                    x = A[i]; A[i] = A[j]; A[j] = x;
                }
            }
            if(k > j) {
                left = j+1;
            } else right = j;
        } return A[k];
    }
}
