/**
* 题目描述：
* 给出一个名字，该名字有26个字符串组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。 
* 每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个字母拥有相同的“漂亮度”。字母忽略大小写。 
* 给出多个名字，计算每个名字最大可能的“漂亮度”。
*
* 输入描述：
* 整数N，后续N个名字
*
* 输出描述：
* 每个名称可能的最大漂亮程度
*
* 示例
*   输入
*   2
*   zhangsan
*   lisi
*
*   输出
*   192
*   101
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
            int nCase = cin.nextInt();
            while(nCase-- >0) {
                String s = cin.next().toLowerCase();
                int[] arr = new int[26];
                for(int i=0; i<s.length(); i++) {
                    arr[s.charAt(i)-'a']++;
                }
                Arrays.sort(arr);
                int ans = 0;
                for(int i=25, k=26; i>=0; i--, k--) {
                    ans += k*arr[i];
                } System.out.println(ans);
            }
        }
    }
}
