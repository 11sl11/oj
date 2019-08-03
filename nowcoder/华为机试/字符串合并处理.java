/**
* 题目描述：
* 将输入的两个字符串合并。对合并后的字符串进行排序，要求为：下标为奇数的字符和下标为偶数的字符分别
* 从小到大排序。这里的下标意思是字符在字符串中的位置。对排序后的字符串进行操作，如果字符为‘0’——‘9’
* 或者‘A’——‘F’或者‘a’——‘f’，则对他们所代表的16进制的数进行BIT倒序的操作，并转换为相应的大写字符。
* 如字符为‘4’，为0100b，则翻转后为0010b，也就是2。转换后的字符为‘2’； 如字符为‘7’，为0111b，则翻
* 转后为1110b，也就是e。转换后的字符为大写‘E’。
*
* 示例
*   输入
*   dec fab
*
*   输出
*   5D37BF
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
            String ss = cin.next()+cin.next();
            List<Character> ca = new ArrayList<>();
            List<Character> cb = new ArrayList<>();
            for(int i=0; i<ss.length(); i++) {
                if((i&1) == 1) {
                    ca.add(ss.charAt(i));
                } else cb.add(ss.charAt(i));
            }
            Collections.sort(ca);
            Collections.sort(cb);
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<ca.size() || i<cb.size(); i++) {
            	if(i < cb.size()) sb.append(dosth(cb.get(i)));
            	if(i < ca.size()) sb.append(dosth(ca.get(i)));
            } System.out.println(sb.toString());
        }
    }
    
    char dosth(char c) {
    	String s = String.valueOf(c).toUpperCase();
    	if(!"0123456789ABCDEF".contains(s)) return c;
    	int x = Integer.parseInt(s, 16), y =x&1;
    	x >>= 1;
    	for(int i=0; i<3; i++) {
    		y <<= 1; y |= (x&1); x >>= 1;
    	}
    	return "0123456789ABCDEF".charAt(y);
    }
}
