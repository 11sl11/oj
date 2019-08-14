/**
* 题目描述：
* 判断从1990到2010年中的润年？并打印
*
*/

import java.util.*;

public class Main {
	Scanner cin = new Scanner(System.in);
	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		for(int year=1990; year<=2010; year++) {
			if((year%400==0) || (year%4==0 && year%100!=0)) {
				System.out.println(year);
			}
		}
	}
}
