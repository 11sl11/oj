/**
* 题目描述：（UVA-455）
* 如果一个字符串可以由某个长度为k 的字符串重复多次得到，则称该串以k 为周期，例如，abcabcabcabc以3 为周期（注
* 意，它也是以6 和12 为周期）。
*
* 输入描述：
* 第一行为测试用例数n，之后输入n 行长度不超过80 的字符串
*
* 输出描述：
* 输出其最小周期
*
* 示例
*   输入
*   1
*   HoHoHo
*
*   输出
*   2
*
*/

/**
* 解题思路：
* 暴力枚举周期t 为[1,|s|/2]内所有子串ss，并将原字符串s 划分成|s|/t个子串逐个匹配ss 是否相等。
*/

import java.util.Scanner;

public class Main {
	static Scanner cin = new Scanner(System.in);

	public static void main(String[] args) {
		int nCase = cin.nextInt();
		while(nCase-- >0) {
			String ss = cin.next();
			for(int i=1; i<=ss.length(); i++) {
				if(ss.length() % i != 0) continue;
				if(period(ss, i)) {
					System.out.println(i);
					break;
				}
			}
			if(nCase > 0) System.out.println();
		}
	}
	
	static boolean period(String ss, int period) {
		for(int k=1; k<ss.length()/period; k++) {
			for(int i=0; i<period; i++) {
				if(ss.charAt(i) != ss.charAt(k*period + i)) {
					return false;
				}
			}
		}
		return true;
	}
}
