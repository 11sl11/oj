/**
* 题目描述：
* 输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数。
*
* 示例
*   输入
*   1qazxsw23 edcvfr45tgbn hy67uj m,ki89ol.\\/;p0-=\\][
*
*   输出
*   26
*   3
*   10
*   12
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
            String s = cin.nextLine();
            int[] ans = new int[4];
            for(int i=0; i<s.length(); i++) {
                char c = s.charAt(i);
                if(Character.isLetter(c)) {
                    ans[0]++;
                } else if(c == ' ') {
                    ans[1]++;
                } else if(Character.isDigit(c)) {
                    ans[2]++;
                } else ans[3]++;
            }
            for(int i=0; i<4; i++) {
                System.out.println(ans[i]);
            }
        }
    }
}
