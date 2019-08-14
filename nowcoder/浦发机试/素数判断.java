/**
* 题目描述：
* 判断一个数是不是素数
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
			int x = cin.nextInt();
			if(x == 2) {
				System.out.println(true);
				continue;
			}
			boolean flag = true;
			for(int i=2; i<=(int)Math.sqrt(x) && flag; i++) {
				if((x%i) == 0) flag = false;
			} System.out.println(flag);
		}
	}
}
