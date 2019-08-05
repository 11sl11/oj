/**
* 题目描述：
* 有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问每个月的兔子总数为多少？
*
* 输入描述：
* 输入int型表示month
*
* 输出描述：
* 输出兔子总数int型
*
* 示例
*   输入
*   9
*
*   输出
*   34
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
            int n = cin.nextInt();
            int[] arr = new int[n+1];
            arr[0] = arr[1] = 1;
            for(int i=2; i<n; i++) {
                arr[i] = arr[i-1] + arr[i-2];
            } System.out.println(arr[n-1]);
        }
    }
}
