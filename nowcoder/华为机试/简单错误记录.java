/**
* 题目描述
* 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
* 处理：
* 1、 记录最多8条错误记录，循环记录，对相同的错误记录（净文件名称和行号完全匹配）只记录一条，错误计数增加；
* 2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
* 3、 输入的文件可能带路径，记录文件名称不能带路径。
* 
* 输入描述:
* 一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。
*
* 输出描述:
* 将所有的记录统计并将结果输出，格式：文件名 代码行数 数目，一个空格隔开，如：
* 
* 示例
*   输入
*   E:\V1R2\product\fpgadrive.c   1325
* 
*   输出
*   fpgadrive.c 1325 1
*
*/

import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }
    
    void run() {
        ArrayList<String> arr = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        while(cin.hasNext()) {
            String[] ss = cin.next().trim().split("\\\\");
            String line = cin.next(), file = null;
            if(ss[ss.length-1].length() > 16) {
                file = ss[ss.length-1].substring(ss[ss.length-1].length()-16);
            } else file = ss[ss.length-1];
            String s = file + " " + line;
            if(!map.containsKey(s)) {
                map.put(s, 1);
                arr.add(s);
            } else map.put(s, map.get(s)+1);
        }
        for(int i=arr.size()-8; i<arr.size(); i++) {
            if(i < 0) continue;
            System.out.println(arr.get(i) + " " + map.get(arr.get(i)));
        }
    }
}
