/**
* 题目描述
* 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
*
* 输入描述：
* 输入一个整数（int类型）
*
* 输出描述：
* 这个数转换成2进制后，输出1的个数
*
* 示例
*   输入
*   5
*
*   输出
*   2
* 
*/

import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }
    
    void run() {
        int x = cin.nextInt(), ans = 0;
        while(x > 0) {
            ans += (x&1);
            x >>= 1;
        } System.out.println(ans);
    }
}
