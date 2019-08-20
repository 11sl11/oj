/**
* 题目描述：
* 牛牛去犇犇老师家补课，出门的时候面向北方，但是现在他迷路了。虽然他手里有一张地图，但是他需要知
* 道自己面向哪个方向，请你帮帮他。
*
* 输入描述：
* 每个输入包含一个测试用例。每个测试用例的第一行包含一个正整数，表示转方向的次数N(N<=1000)。接下
* 来的一行包含一个长度为N的字符串，由L和R组成，L表示向左转，R表示向右转。
*
* 输出描述：
* 输出牛牛最后面向的方向，N表示北，S表示南，E表示东，W表示西。
*
* 示例
*   输入
*   3
*   LRR
*
*   输出
*   E
*
*/

import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }
    
    void run() {
        cin.nextInt();
        String ss = cin.next();
        int dir = 0;
        for(int i=0; i<ss.length(); i++) {
            if(ss.charAt(i) == 'L') {
                dir = (dir + 1) % 4;
            } else dir = (dir + 3) % 4;
        }
        char ans = 'N';
        switch(dir) {
            case 1: ans = 'W'; break;
            case 2: ans = 'S'; break;
            case 3: ans = 'E'; break;
        } System.out.println(ans);
    }
}
