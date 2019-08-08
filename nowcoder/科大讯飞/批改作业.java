/**
* 题目描述：
* 批改一份作业会得到m元，如果该份作业批改正确则会从中扣除k元复查费；如果批改中出现了错误会从中扣除x元当做惩罚费，
* 此时这份作业不再扣除复查费。如果有一份作业批改错误扣了x元，那么可以抵消一份批改正确作业的复查费。例如，有两份
* 作业，一份批改正确一份批改错误，那么错误的那份可以得到m-x元，正确的那份可以得到m元，不用再扣除复查费。
*
* 输入描述：
* 第一行四个整数n、m、x、k，n表示批改作业的总份数，m、x、k含义如题面描述，n的取值[1,100000]，1<=m,x,k<=100, 
* x,k<=m
*
* 输出描述：
* 输出一个整数，表示最后一共可以得到的批改费用
*
* 示例
*   输入
*   4 5 2 1
*   1 1 1 0
* 
*   输出
*   16
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
            int n=cin.nextInt(),m=cin.nextInt(),x=cin.nextInt(),k=cin.nextInt();
            int ans = 0, a = 0, b = 0;
            for(int i=0; i<n; i++) {
            	if(cin.nextInt() == 1) {
            		a++;
            	} else b++;
            }
            if(a >= b) {
            	ans = (a-b)*(m-k) + b*(m-x) + b*m;
            } else ans = a*m + b*(m-x);
            System.out.println(ans);
        }
    }
}
