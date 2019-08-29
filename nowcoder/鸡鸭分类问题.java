/**
* 题目描述：（招商银行信用卡中心机试）
* 农场有n只鸡鸭排为一个队伍，鸡用“C”表示，鸭用“D”表示。当鸡鸭挨着时会产生矛盾。需要对所排的队伍进行调整，使鸡
* 鸭各在一边。每次调整只能让相邻的鸡和鸭交换位置，现在需要尽快完成队伍调整，你需要计算出最少需要调整多少次可以
* 让上述情况最少。例如：CCDCC->CCCDC->CCCCD这样就能使之前的两处鸡鸭相邻变为一处鸡鸭相邻，需要调整队形两次。
*
* 输入描述：
* 输入一个长度为N，且只包含C和D的非空字符串。
*
* 输出描述：
* 使得最后仅有一对鸡鸭相邻，最少的交换次数
*
* 示例
*   输入
*   CCDCC
*
*   输出
*   2
*
*/

/**
* 解题思路：
* 以CCDCDC为例：C往左移动会出现的情况CCDCDC->CCCDDC->CCCDCD->CCCCDD，移动了3次
* D往左移动会出现的情况CCDCDC->CDCCDC->DCCCDC->DCCDCC->DCDCCC->DDCCCC，移动了5次
*/

import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }
    
    void run() {
        String ss = cin.next();
        int s1 = dosth(ss, 'C'), s2 = dosth(ss, 'D');
        System.out.println(Math.min(s1, s2));
    }
    
    int dosth(String ss, char c) {
        int s = 0, t = 0;
        for(int i=0, j=0; i<ss.length(); i++) {
            if(ss.charAt(i) == c) {
                s += i; t += j; j++;
            }
        } return s - t;
    }
}

/**
*  ** 争吵问题 **
* 相似题目描述：（科大讯飞机试）
* 有 n 个人排成了一行队列，每个人都有一个站立的方向：面向左或面向右。由于这n 个人中每个人都很讨厌其他的人，
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
* 输出描述：
* 输出队列中最少会剩下多少人。
*
* 示例
*   输入
*   LRRLRL
*
*   输出
*   2（说明：LRRLRL -> LRRLL -> LRRL -> LRL -> LR）
*
*/

/**
* 解题思路：
* 对于 R...L...R...L...L 情况最终只会留下一人，要么为R, 要么为L.
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
