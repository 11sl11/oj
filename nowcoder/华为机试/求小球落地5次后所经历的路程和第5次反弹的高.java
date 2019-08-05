/**
* 题目描述
* 假设一个球从任意高度自由落下，每次落地后反跳回原高度的一半; 再落下, 求它在第5次落地时，共经历多少米?第5次反弹多高？ 
*
* 输入描述：
* 输入起始高度，int型
*
* 输出描述：
* 分别输出第5次落地时，共经过多少米第5次反弹多高（题目描述不严谨，没有限定精度）
*
* 示例
*   输入
*   1
*   
*   输出
*   2.875
*   0.03125
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
            double h = 1.0*cin.nextInt();
            System.out.println(2.875*h);
            System.out.println(0.03125*h);
        }
    }
}
