/**
* 题目描述：
* 功能:输入一个正整数，按照从小到大的顺序输出它的所有质数的因子（如180的质数因子为2 2 3 3 5）
*
* 输入描述：
* 输入一个long型整数
*
* 输出描述：
* 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。
*
*/

import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }
    
    void run() {
        long x = cin.nextLong();
        for(long i=2; i<=(long)Math.sqrt(x); i++) {
            if(isPrime(i)) {
                while((x % i) == 0) {
                    System.out.print(i + " ");
                    x /= i;
                }
            }
        } if(x > 1) System.out.print(x + " ");
        System.out.println();
    }
    
    boolean isPrime(long x) {
        if(x == 2) return true;
        for(long i=2; i<=Math.sqrt(x); i++) {
            if((x % i) == 0) return false;
        } return true;
    }
}
