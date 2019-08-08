/**
* 题目描述：
*             1
*          1  1  1
*       1  2  3  2  1
*    1  3  6  7  6  3  1
* 1  4  10 16 19 16 10 4  1
* 以上三角形的数阵，第一行只有一个数1，以下每行的每个数，是恰好是它上面的数，左上角数到右上角的数，
* 3个数之和（如果不存在某个数，认为该数就是0）。求第n行第一个偶数出现的位置。如果没有偶数，则输出
* -1。例如输入3,则输出2，输入4则输出3。输入n<=1000000000
*
* 示例
*   输入
*   4
* 
*   输出
*   3
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
            int n = cin.nextInt(), ans;
            if(n < 3) {
                ans = -1;
            } else if(n%2 == 1) {
                ans = 2;
            } else if(n%4 == 0) {
                ans = 3;
            } else ans = 4;
            System.out.println(ans);
        }
    }
}
