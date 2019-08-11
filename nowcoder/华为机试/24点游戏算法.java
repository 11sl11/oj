/**
* 题目描述：
* 给出4个1-10的数字，通过加减乘除，得到数字为24就算胜利。
*
* 输入描述：
* 输入4个int整数
*
* 输出描述：
* 返回能否得到24点，能输出true，不能输出false
*
* 示例
*   输入
*   7 2 1 10
*
*   输出
*   true
*
*/

/**
* 解题思路：
* 本示例中 7*2*1+10=24 或 (7*2)+(1*10)=24
*/

/** 存在运算优先级
import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }
    
    void run() {
    	while(cin.hasNext()) {
            int a=cin.nextInt(),b=cin.nextInt(),c=cin.nextInt(),d=cin.nextInt();
            boolean flag = true;
            for(int i=0; i<4 && flag; i++) {
                for(int j=0; j<4 && flag; j++) {
                    for(int k=0; k<4 && flag; k++) {
                        if(exp_value(a, b, c, d, i, j, k) == 24) {
                            System.out.println(true);
                            flag = false;
                        }
                    }
                }
            } if(flag) System.out.println(false);
        }
    }
    
    int exp_value(int... as) {
    	Stack<Integer> stack = new Stack<>();
    	stack.push(as[0]);
    	for(int i=4, j=1; i<7; i++, j++) {
    		if(as[i] < 2) {
    			stack.push(as[i]==0 ? as[j]:-1*as[j]);
    		} else stack.push(dosth(stack.pop(), as[j], as[i]));
    	}
    	int result = 0;
    	while(!stack.isEmpty()) {
    		result += stack.pop();
    	} return result;
    }
    
    int dosth(int a, int b, int i) {
    	switch(i) {
	    	case 0: return a+b;
	    	case 1: return a-b;
	    	case 2: return a*b;
	    	case 3: return a/b;
    	} return 0;
    }
}
*/

/* 不存在运算优先级
import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }
    
    void run() {
    	while(cin.hasNext()) {
            int a=cin.nextInt(),b=cin.nextInt(),c=cin.nextInt(),d=cin.nextInt();
            boolean flag = true;
            for(int i=0, x; i<4 && flag; i++) {
            	x = dosth(a, b, i);
            	for(int j=0; j<4 && flag; j++) {
            		x = dosth(x, c, j);
            		for(int k=0; k<4 && flag; k++) {
            			if(dosth(x, d, k) == 24) {
            				System.out.println(true);
            				flag = false;
            			}
            		}
            	}
            } if(flag) System.out.println(false);
        }
    }
    
    int dosth(int a, int b, int i) {
    	switch(i) {
			case 0: return a+b;
			case 1: return a-b;
			case 2: return a*b;
			case 3: return a/b;
    	} return 0;
    }
}
*/
