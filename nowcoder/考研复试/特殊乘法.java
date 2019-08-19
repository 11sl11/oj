/**
* 题目描述：
* 对2个小于1000000000的输入，求结果。 特殊乘法举例：123 * 45 = 1*4 +1*5 +2*4 +2*5 +3*4+3*5
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
			String sa = cin.next(), sb = cin.next();
			long ans = 0;
			for(int i=0; i<sa.length(); i++) {
				for(int j=0; j<sb.length(); j++) {
					ans += (sa.charAt(i)-'0')*(sb.charAt(j)-'0');
				}
			} System.out.println(ans);
		}
	}
}
