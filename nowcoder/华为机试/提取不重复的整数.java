/**
* 题目描述:
* 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
*
* 输入描述：
* 输入一个int型整数
*
* 输出描述：
* 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
*
* 示例
*   输入
*   9876673
*
*   输出
*   37689
*/

import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }
    
    void run() {
        int x = cin.nextInt();
        if(x == 0) {
            System.out.println(0); return;
        }
        boolean[] tab = new boolean[10];
        while(x > 0) {
            if(!tab[x%10]) {
                tab[x%10] = true;
                System.out.print(x%10);
            } x/= 10;
        } System.out.println();
    } 
}
