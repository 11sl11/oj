/**
* 问题描述
* 由小写英文字母组成不包含其他字符的单词X，如果通过任意交换单词中字母的位置得到不同的单词Y，那么定义Y是X的兄弟单词，
* 例如，bca是abc的兄弟单词，abc与abc是相同单词，不是兄弟单词。
*
* 输入描述
* 先输入字典中单词的个数，再输入n个单词作为字典单词。输入一个单词，查找其在字典中兄弟单词的个数，再输入数字k，用于查
* 找字典序中第k个兄弟单词。
*
* 输出描述
* 根据输入，输出查找到的兄弟单词的个数以及第k个兄弟单词。
*
* 示例
*   输入
*   3 abc bca cab abc 1
*   
*   输出
*   2
*   bca
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
            int n = cin.nextInt(), k = 0;
            String[] arr = new String[n];
            for(int i=0; i<n; i++) arr[i] = cin.next();
            String ss = cin.next();
            n = cin.nextInt();
            
            ArrayList<String> words = new ArrayList<>();
            for(int i=0; i<arr.length; i++) {
                if(dosth(ss, arr[i])) {
                    words.add(arr[i]);
                }
            }
            Collections.sort(words);
            System.out.println(words.size());
            if(n <= words.size()) {
                System.out.println(words.get(n-1));
            }
        }
    }
    
    boolean dosth(String sa, String sb) {
        if((sa.length()!=sb.length()) || (sa.equals(sb))) return false;
        int[] A = new int[26], B = new int[26];
        for(int i=0; i<sa.length(); i++) {
            A[sa.charAt(i)-'a']++;
            B[sb.charAt(i)-'a']++;
        }
        for(int i=0; i<26; i++) {
            if(A[i] != B[i]) return false;
        }
        return true;
    }
}
