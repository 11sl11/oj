/**
* 题目描述：
* 1、中文大写金额数字前应标明“人民币”字样。中文大写金额数字应用壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、
*    佰、仟、万、亿、元、角、分、零、整等字样填写。 
* 2、中文大写金额数字到“元”为止的，在“元”之后，应写“整字，如￥ 532.00应写成“人民币伍佰叁拾贰元整”。
*    在”角“和”分“后面不写”整字。
* 3、阿拉伯数字中间有“0”时，中文大写要写“零”字，阿拉伯数字中间连续有几个“0”时，中文大写金额中间只写一个
*    “零”字，如￥6007.14，应写成“人民币陆仟零柒元壹角肆分“。
*
* 输入描述：
* 输入一个double数
*
* 输出描述：
* 输出人民币格式
*
* 示例：
*   输入
*   151121.15
*   0.85
*   0.29
*   5.07
*
*   输出
*   人民币拾伍万壹仟壹佰贰拾壹元壹角伍分
*   人民币捌角伍分
*   人民币贰角玖分
*   人民币伍元柒分
*
*/

import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }

    final String[] sa = "零、壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、拾壹、拾贰、拾叁、拾肆、拾伍、拾陆、拾柒、拾捌、拾玖".split("、");
    void run() {
    	while(cin.hasNext()) {
    		double x = cin.nextDouble();
    		System.out.print("人民币");
    		if(x >= 1.0) {
    			dosth((int)Math.floor(x));
    			System.out.print("元");
    		}
    		int y = (int)(x*1000) % 1000/10;
    		if(y != 0) {
    			if(y/10 > 0) System.out.print(sa[y/10] + "角");
    			if(y%10 >0) System.out.print(sa[y%10] + "分");
    		} else System.out.print("整");
    		System.out.println();
        }
    }
    
    void dosth(int x) {
    	int k = 0;
    	if(x >= 100000000) {
    		k += 1;
    		dosth(x/100000000);
    		x %= 100000000;
    		System.out.print("亿");
    	}
    	if(x >= 10000) {
    		k += 2;
    		dosth(x/10000);
    		x %= 10000;
    		System.out.print("万");
    	}
    	if(x >= 1000) {
    		k += 4;
    		if((k&1)==1 && (k&2)==0) {
    			System.out.print("零");
    		}
    		dosth(x/1000);
    		x %= 1000;
    		System.out.print("仟");
    	}
    	if(x >= 100) {
    		k += 8;
    		if(((k&1)==1 || (k&2)==2) && (k&4)==0) {
    			System.out.print("零");
    		}
    		dosth(x/100);
    		x %= 100;
    		System.out.print("佰");
    	}
    	if(x >= 20) {
    		System.out.print(sa[x/10] + "拾" + sa[x%10]);
    		return;
    	}
    	if((k&1)==1 || (k&2)==2 || (k&4)==4 || (k&8)==8) {
    		System.out.print("零");
    	} System.out.print(sa[x]);
    }
}
