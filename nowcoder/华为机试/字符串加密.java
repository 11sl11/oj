/**
* 题目描述
* 首先，选择一个单词作为密匙，如TRAILBLAZERS。如果单词中包含有重复的字母，只保留第1个，其余几个丢弃。
* 现在，修改过的那个单词属于字母表的下面，如下所示：
* A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
* T R A I L B Z E S C D F G H J K M N O P Q U V W X Y
* 上面其他用字母表中剩余的字母填充完整。在对信息进行加密时，信息中的每个字母被固定于顶上那行，并用下面
* 那行的对应字母一一取代原文的字母(字母字符的大小写状态应该保留)。因此，使用这个密匙，Attack AT DAWN
* (黎明时攻击)就会被加密为Tpptad TP ITVH.
*
* 输入描述：
* 先输入key和要加密的字符串
*
* 输出描述
* 返回加密后的字符串
*
* 示例
*   输入
*   nihao
*   ni
*
*   输出
*   le
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
            char[] keys = dosth(cin.nextLine().toLowerCase());
            String word = cin.nextLine();
            for(int i=0; i<word.length(); i++) {
                char c = word.charAt(i);
                if(!Character.isLetter(c)) {
                    System.out.print(c);
                } else if(Character.isUpperCase(c)) {
                    System.out.print((char)(keys[c-'A']&0x5F));
                } else System.out.print(keys[c-'a']);
            } System.out.println();
        }
    }
    
    char[] dosth(String key) {
        char[] keys = new char[26];
        boolean[] hash = new boolean[26];
        int i, j;
        for(i=0, j=0; i<key.length() && j<26; i++) {
            char c = key.charAt(i);
            if(!Character.isLetter(c) || hash[c-'a']) continue;
            hash[c-'a'] = true;
            keys[j++] = c;
        }
        for(i=0; i<26 && j<26; i++) {
            if(hash[i]) continue;
            keys[j++] = (char)(i+'a');
        }
        return keys;
    }
}
