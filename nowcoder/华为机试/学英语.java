/**
* 题目描述：
* 编写程序将数字转换成英文：如22：twenty two，123：one hundred and twenty three。
* 数字为正整数，长度不超过九位，不考虑小数，转化结果为英文小写；
* 输出格式为twenty two；
* 非法数据请返回“error”；
* 关键字提示：and，billion，million，thousand，hundred。
*
* 输入描述：
* 输入一个long型整数
*
* 输出描述：
* 输出相应的英文写法
*
* 示例
*   输入
*   483222
*
*   输出
*   four hundred and eighty three thousand two hundred and twenty two
*
*/

import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }
    
    final String[] p1 = "zero one two three four five six seven eight nine ten eleven twelve thirteen fourteen fifteen seventeen eighteen nineteen".split(" ");
    final String[] p2 = "twenty thirty forty fifty sixty seventy eighty ninety".split(" ");
    void run() {
        while(cin.hasNext()) {
            String ss = cin.nextLine();
            long x = 0;
            try {
                x = Long.parseLong(ss);
            } catch(Exception e) {
                System.out.println("error");
                continue;
            }
            sb = new StringBuilder();
            dosth(x);
            System.out.println(sb);
        }
    }
    
    StringBuilder sb = null;
    void dosth(long x) {
    	if(x < 100) {
    		int y = (int) x;
    		if(x < 20) {
    			sb.append(p1[y]);
    		} else if((y%10) == 0) {
    			sb.append(p2[y/10 - 2]);
    		} else sb.append(p2[y/10-2] + " " + p1[y%10]);
    		return;
    	}
    	if(x >= 1000000L) {
    		dosth(x/1000000L);
    		x %= 1000000L;
    		sb.append(" million");
    	} else if(x >= 1000L) {
    		dosth(x/1000L);
    		x %= 1000L;
    		sb.append(" thousand");
    	} else if(x >= 100L) {
    		dosth(x/100L);
    		x %= 100L;
    		sb.append(" hundred");
    		if(x > 0) sb.append(" and");
    	}
    	if(x > 0) sb.append(" ");
    	dosth(x);
    }
}
