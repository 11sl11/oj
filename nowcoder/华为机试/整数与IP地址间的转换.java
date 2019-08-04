/**
* 题目描述：
* 将IP地址与整数IP地址相互转换
*
* 输入描述：
* 1 输入IP地址
* 2 输入10进制型的IP地址
*
* 输出描述：
* 1 输出转换成10进制的IP地址
* 2 输出转换后的IP地址
*
* 示例
*   输入
*   10.0.3.193
*   167969729
* 
*   输出
*   167773121
*   10.3.3.193
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
            String[] ip = cin.next().trim().split("\\.");
            long xip = cin.nextLong();
            System.out.println(
                (Long.parseLong(ip[0])<<24) + 
                (Long.parseLong(ip[1])<<16) + 
                (Long.parseLong(ip[2])<< 8) +
                (Long.parseLong(ip[3])));
            StringBuilder sb = new StringBuilder(String.valueOf(xip>>>24));
            sb.append('.');
            sb.append((xip & 0x00FFFFFF)>>>16);
            sb.append('.');
            sb.append((xip & 0x0000FFFF)>>>8);
            sb.append('.');
            sb.append((xip & 0x000000FF));
            System.out.println(sb.toString());
        }
    }
}
