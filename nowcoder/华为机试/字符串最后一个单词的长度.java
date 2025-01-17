/**
* 题目描述：
* 计算字符串最后一个单词的长度，单词以空格隔开。
*
* 输入描述：
* 一行字符串，非空，长度小于5000。
*
* 输出描述：
* 整数N，最后一个单词的长度。
*
* 示例1
*   输入
*   hello world
*   输出
*   5
*/
 
import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }
    
    void run() {
        String ss = null;
        while(cin.hasNext()) {
            ss = cin.next();
        } System.out.println(ss.length());
    }
}
