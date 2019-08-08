/** 
* 有n 个人排成了一行队列，每个人都有一个站立的方向：面向左或面向右。由于这n 个人中每个人都很讨厌其他的人，
* 所以当两个人面对面站立时，他们会发生争吵，然后其中一个人就会被踢出队列，谁被踢出队列都是有可能的。我们用
* 字符L 来表示一个面向左站立的人，用字符R 来表示一个面向右站立的人，那么这个队列可以用一个字符串描述。比如
* RLLR 就表示一个四个人的队列，其中第一个人和第二个人是面对面站立的。他们发生争吵后队列可能会变成LLR，也可
* 能变成RLR；若变成RLR，则第一个人与第二个人还会发生争吵，队列会进一步变成LR 或者RR。若在某个时刻同时可能
* 有很多的争吵会发生时，接下来只会发生其中的一个，且任意一个都是有可能发生的。你想知道经过一系列的争吵后，
* 这个队列最少会剩下多少人？
*
* 输入描述：
* 第一行包含一个有字符L 和R 构成的字符串。（1 ≤字符串长度≤ 100000）
*
* 输出队列中最少会剩下多少人。
*
* 示例
*   输入
*   LRRLRL
*
*   输出
*   2
*   (说明： LRRLRL -> LRRLL -> LRRL -> LRL -> LR)
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
            String ss = cin.next();
            int ans = 0, i, j;
            for(i=0; i<ss.length(); i++) {
                if(ss.charAt(i) == 'R') break;
                ans++;
            }
            for(j=ss.length()-1; j>=0 && j>i; j--) {
                if(ss.charAt(j) == 'L') break;
                ans++;
            }
            if(i<ss.length() && j>=0) ans++;
            System.out.println(ans);
        }
    }
}
