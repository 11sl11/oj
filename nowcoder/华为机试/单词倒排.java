/**
* 题目描述
* 对字符串中的所有单词进行倒排。
* 说明：
* 1、每个单词是以26个大写或小写英文字母构成；
* 2、非构成单词的字符均视为单词间隔符；
* 3、要求倒排后的单词间隔符以一个空格表示；如果原字符串中相邻单词间有多个间隔符时，倒排转换后也只允许出现一个空格间隔符；
* 4、每个单词最长20个字母；
*
* 输入描述:
* 输入一行以空格来分隔的句子
*
* 输出描述:
* 输出句子的逆序
*
* 示例
*   输入
*   I am a student
* 
*   输出
*   student a am I
*
*/

import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }
    
    void run() {
        String[] ss = cin.nextLine().trim().split("[^a-zA-Z]+");
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<ss.length; i++) {
            if(ss[i].isEmpty()) continue;
            list.add(ss[i]);
        }
        for(int i=list.size()-1; i>=0; i--) {
            System.out.print(list.get(i));
            if(i > 0) System.out.print(" ");
        } System.out.println();
    }
}
