/**
* 题目描述：
* 现有一组砝码，重量互不相等，分别为m1,m2,m3…mn；
* 每种砝码对应的数量为x1,x2,x3...xn。现在要用这些砝码去称物体的重量(放在同一侧)，问能称出多少种不同的重量。
* 注：称重重量包括0
*
* 输入描述：
* 输入包含多组测试数据。
* 对于每组测试数据：
* 第一行：n --- 砝码数(范围[1,10])
* 第二行：m1 m2 m3 ... mn --- 每个砝码的重量(范围[1,2000])
* 第三行：x1 x2 x3 .... xn --- 每个砝码的数量(范围[1,6])
*
* 输出描述：
* 利用给定的砝码可以称出的不同的重量数
*
* 示例
*   输入
*   2
*   1 2
*   2 1
* 
*   输出
*   5
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
            int[] W = new int[n], N = new int[n];
            for(int i=0; i<n; i++) W[i] = cin.nextInt();
            for(int i=0; i<n; i++) N[i] = cin.nextInt();

            Set<Integer> set = new HashSet<>();
            for(int i=0; i<=N[0]; i++) set.add(i*W[0]);
            for(int i=1; i<n; i++) {
                List<Integer> arr = new ArrayList<>();
                for(int j=1; j<=N[i]; j++) {
                    for(Integer x: set) arr.add(x + j*W[i]);
                }
                set.addAll(arr);
            } System.out.println(set.size());
        }
    }
}
