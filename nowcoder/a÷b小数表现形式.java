/**
* 题目描述：（快手机试）
* 求a/b的小数表现形式。如果a可以整除b则不需要小数点。如果是有限小数，则可以直接输出。如果是无限循环小数，则需
* 要把小数循环的部分用"()"括起来。
*
* 输入描述：
* 两个整数a和b，其中 0<=a<=10^6, 1<=b<=10^4
*
* 输出描述：
* 一个字符串，该分数的小数表现形式
*
* 示例
*   输入
*   10 1
*   1  2
*   1  3
*   1  6
*   1  7
*
*   输出
*   10
*   0.5
*   0.(3)（说明：1/3 = 0.333333...）
*   0.1(6)（说明：1/6 = 0.16666666...）
*   0.(142857)（说明：1/7 = 0.1428571428...）
*
*/

/**
* 解题思路：
* 循环部分只出现在小数点后，因此将分数转换为真分数，以 5/112 为例：
* (10*5)/112=0...50,  (10*50)/112=4...52, (10*52)/112=4...72, (10*72)/112=6...48, (10*48)/112=4...32,
* (10*32)/112=2...96, (10*96)/112=8...64, (10*64)/112=5...80, (10*80)/112=7...16, (10*16)/112=1...48.
* 余数 48 出现循环节, 因此从6...48到7...16为一个循环.
*/

import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }
    
    void run() {
        int a = cin.nextInt(), b = cin.nextInt();
        if(a % b != 0) {
            System.out.println(a/b + "." + dosth(a%b, b));
        } else System.out.println(a/b);
    }
    
    String dosth(int a, int b) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();
        int x = a, y;
        while(a > 0) {
            a *= 10;
            if(map.containsKey(a)) {
                x = a; break;
            }
            arr.add(a);
            map.put(a, (a%b)*10);
            a %= b;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.size() && arr.get(i)!=x; i++) {
            sb.append(arr.get(i) / b);
        }
        if(a > 0) {
            sb.append('(');
            y = x;
            do {
                sb.append(x / b);
                x = map.get(x);
            } while(x != y);
            sb.append(')');
        }

        return sb.toString();
    }
}
