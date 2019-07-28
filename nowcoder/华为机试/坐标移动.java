/**
* 题目描述
* 开发一个坐标计算工具，A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，
* 从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
*
* 输入描述：
* 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
* 坐标之间以;分隔。非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
* 
* 下面是一个简单的例子 如：
* A10;S20;W10;D30;X;A1A;B10A11;;A10;
* 处理过程：
* 起点（0,0）
* +   A10   =  （-10,0）
* +   S20   =  (-10,-20)
* +   W10  =  (-10,-10)
* +   D30  =  (20,-10)
* +   x    =  无效
* +   A1A   =  无效
* +   B10A11   =  无效
* +  一个空 不影响
* +   A10  =  (10,-10)
* 结果 （10， -10）
*
* 输出描述：
* 最终坐标，以,分隔
*
* /

import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }
    
    void run() {
        while(cin.hasNext()) {
            String[] ss = cin.next().trim().split(";");
            int x = 0, y = 0;
            for(int i=0; i<ss.length; i++) {
                if(isVaild(ss[i])) {
                    char dir = ss[i].charAt(0);
                    int dist = Integer.parseInt(ss[i].substring(1));
                    if(dir == 'A') x -= dist;
                    if(dir == 'D') x += dist;
                    if(dir == 'W') y += dist;
                    if(dir == 'S') y -= dist;
                }
            } System.out.println(x + "," + y);
        }
    }
    
    boolean isVaild(String ss) {
        if(ss == null || ss.length() <= 1) return false;
        char c = ss.charAt(0);
        if(c != 'A' && c != 'D' && c != 'W' && c != 'S') return false;
        for(int i=1; i<ss.length(); i++) {
            if(!Character.isDigit(ss.charAt(i))) return false;
        }
        return true;
    }
}
