/**
* 题目描述：
* 查找两个字符串a,b中的最长公共子串。若有多个，输出在较短串中最先出现的那个。
*
* 示例
*   输入
*   abcdefghijklmnop
*   abcsafjklmnopqrstuvw
*
*   输出
*   jklmnop
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
            String sa = cin.next(), sb = cin.next(), sc, ans = "";
            if(sa.length() > sb.length()) {
                sc = sa; sa = sb; sb = sc;
            }
            for(int i=0; i<sa.length(); i++) {
                for(int j=i+1; j<=sa.length(); j++) {
                    sc = sa.substring(i, j);
                    if(sb.indexOf(sc) != -1 && ans.length()<sc.length()) {
                        ans = sc;
                    }
                }
            } System.out.println(ans);
        }
    }
}
