/**
* 题目描述
* 数据表记录包含表索引和数值，请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
*
* 输入描述：
* 先输入键值对的个数，然后输入成对的index和value值，以空格隔开
*
* 输出描述：
* 输出合并后的键值对（多行）
*
* 示例
*   输入
*   4
*   0 1
*   0 2
*   1 2
*   3 4
*
*   输出
*   0 3
*   1 2
*   3 4
*
*/

import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }
    
    void run() {
        int n = cin.nextInt();
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i=0; i<n; i++) {
            int x = cin.nextInt(), y = cin.nextInt();
            if(map.containsKey(x)) {
                map.put(x, map.get(x)+y);
            } else map.put(x, y);
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
