/**
* 题目描述：
* 将由数字、大小写字母组成字符串按照ASCII码顺序从大到小排序（要求用C语言）
*
* 示例
*   输入
*   Ihave1nose2hands10fingers
* 
*   输出
*   0112Iaadeeefghhinnnorsssv
*
*/

/*
#include <stdio.h>
#include <string.h>

int main() {
    char chs[1025];
    while(scanf("%s", chs) != EOF) {
        int n = strlen(chs);
        for(int i=0; i<n-1; i++) {
            for(int j=0; j<n-i-1; j++) {
                if(chs[j] > chs[j+1]) {
                    char c = chs[j];
                    chs[j] = chs[j+1];
                    chs[j+1] = c;
                }
            }
        }
        puts(chs);
    }
    return 0;
}
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
            char[] chs = new char[ss.length()];
            for(int i=0; i<ss.length(); i++) {
                chs[i] = ss.charAt(i);
            }
            Arrays.sort(chs);
            for(int i=0; i<chs.length; i++) {
                System.out.print(chs[i]);
            } System.out.println();
        }
    }
}
