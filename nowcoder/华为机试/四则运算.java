/**
* 题目描述：
* 字符串格式的算术表达式，如: "3+2*{1+2*[-4/(8-6)+7]}"，字符串中的有效字符包括
* [‘0’-‘9’],‘+’,‘-’, ‘*’,‘/’ ,‘(’， ‘)’,‘[’, ‘]’,‘{’ ,‘}’。
*
* 示例
*   输入
*   3+2*{1+2*[-4/(8-6)+7]}
*
*   输出
*   25
*
*/

import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }

    int idx;
    String exp;
    void run() {
    	while(cin.hasNext()) {
    		exp = cin.nextLine();
    		idx = 0;
    		System.out.println(expression_value());
    	}
    }
    
    int expression_value() {
    	int result = term_value(), value;
    	while(idx < exp.length()) {
    		char op = exp.charAt(idx);
    		if(op=='+' || op=='-') {
    			idx++;
    			value = term_value();
    			if(op == '+') {
    				result += value;
    			} else result -= value;
    		} else break;
    	}
    	return result;
    }
    
    int term_value() {
    	int result = factor_value(), value;
    	while(idx < exp.length()) {
    		char op = exp.charAt(idx);
    		if(op=='*' || op=='/') {
    			idx++;
    			value = factor_value();
    			if(op == '*') {
    				result *= value;
    			} else result /= value;
    		} else break;
    	}
    	return result;
    }
    
    int factor_value() {
    	int result = 0, i;
    	char c = exp.charAt(idx);
    	if(c=='{' || c=='[' || c=='(') {
    		idx++;
    		result = expression_value();
    		idx++;
    	} else {
    		i = idx;
    		if(exp.charAt(idx)=='-' || exp.charAt(idx)=='+') idx++;
    		while(idx<exp.length() && Character.isDigit(exp.charAt(idx))) idx++;
    		result = Integer.parseInt(exp.substring(i, idx));
    	}
    	return result;
    }
}
