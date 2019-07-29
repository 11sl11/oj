/**
* 题目描述
* 密钥规则：小写字母对应：abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9，
* 把密码中出现的小写字母都变成对应的数字，数字和其他的符号都不做变换。密码中没有空格，而密码中出
* 现的大写字母则变成小写之后往后移一位，如：X，先变成小写，再往后移一位，为y，z往后移是a。
*
* 输入描述：
* 输入包括多个测试数据。输入是一个明文，密码长度不超过100个字符，输入直到文件结尾
*
* 输出描述：
* 输出真正密码
*
* 示例
*   输入
*   YUANzhi1987
*   
*   输出
*   zvbo9441987
*
*/

import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }
    
    String[] dic = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    void run() {
        while(cin.hasNext()) {
            String s = cin.nextLine(), ans = "";
            for(int i=0; i<s.length(); i++) {
                char ch = s.charAt(i);
                String ss = String.valueOf(ch);
                if(Character.isLowerCase(ch)) {
                    for(int j=2; j<dic.length; j++) {
                        if(dic[j].contains(ss)) ans += String.valueOf(j);
                    }
                } else if(Character.isUpperCase(ch)) {
                    if(ch == 'Z') {
                        ans += "a";
                    } else ans += String.valueOf((char)((ch|0x20)+1));
                } else ans += ss;
            } System.out.println(ans);
        }
    }
}
