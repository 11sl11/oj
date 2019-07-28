/**
* 题目描述
* 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
* 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
*
* 输入描述:
* 将一个英文语句以单词为单位逆序排放。
*
* 输出描述：
* 得到逆序的句子
*
*/

import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }
    
    void run() {
        List<String> arr = new ArrayList<>();
        while(cin.hasNext()) {
            arr.add(cin.next());
        }
        for(int i=arr.size()-1; i>=0; i--) {
            if(i < arr.size()-1) {
                System.out.print(" ");
            } System.out.print(arr.get(i));
        }
    }
}
