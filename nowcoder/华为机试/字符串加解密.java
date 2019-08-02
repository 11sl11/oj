/**
* 题目描述：
* 1、对输入的字符串进行加解密，并输出。
* 2、加密方法为：
*   当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；
*   当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
*   其他字符不做变化。
* 3、解密方法为加密的逆过程。
*
* 输入描述：
* 输入一串要加密的密码
* 输入一串加过密的密码
*
* 输出描述：
* 输出加密后的字符
* 输出解密后的字符
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
            System.out.println(encrypt(cin.next()));
            System.out.println(unEncrypt(cin.next()));
        }
    }
    
    String encrypt(String ss) {
        StringBuilder ssb = new StringBuilder();
        for(int i=0; i<ss.length(); i++) {
            char c = ss.charAt(i);
            if(Character.isLowerCase(c)) {
                ssb.append((char)(((c-'a'+1)%26 + 'a')&0x5F));
            } else if(Character.isUpperCase(c)) {
                ssb.append((char)(((c-'A'+1)%26 + 'A')|0x20));
            } else if(Character.isDigit(c)) {
                ssb.append((char)((c-'0'+1)%10 + '0'));
            }
        } return ssb.toString();
    }
    
    String unEncrypt(String ss) {
        StringBuilder ssb = new StringBuilder();
        for(int i=0; i<ss.length(); i++) {
            char c = ss.charAt(i);
            if(Character.isLowerCase(c)) {
                ssb.append((char)(((c-'a'+25)%26 + 'a')&0x5F));
            } else if(Character.isUpperCase(c)) {
                ssb.append((char)(((c-'A'+25)%26 + 'A')|0x20));
            } else if(Character.isDigit(c)) {
                ssb.append((char)((c-'0'+9)%10 + '0'));
            }
        } return ssb.toString();
    }
}
