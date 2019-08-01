/**
* 题目描述
* 给定一个字符串描述的算术表达式，计算出结果值。
* 输入字符串长度不超过100，合法的字符包括”+, -, *, /, (, )”，”0-9”，字符串内容的合法性及表达式语法的合法性由做题者检查。本题目只涉及整型计算。
*
* 示例
*   输入
*   400+5
*   
*   输出
*   405
*
*/

//import java.util.*;
//import javax.script.*;
//
//public class Main {
//    public static void main(String[] args) throws ScriptException {
//       Scanner scanner = new Scanner(System.in);
//        ScriptEngineManager manager = new ScriptEngineManager();
//        ScriptEngine engine=manager.getEngineByName("JavaScript");
//        while (scanner.hasNext()) {
//            String exp = scanner.nextLine();
//            System.out.println(engine.eval(exp));
//        }
//    }
//}


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
            System.out.println(expression_value());
        }
    }
    
    int expression_value() {
        int result = term_value();
        while(idx < exp.length()) {
            char op = exp.charAt(idx);
            if(op == '+' || op == '-') {
                idx++;
                int value = term_value();
                if(op == '+') {
                    result += value;
                } else result -= value;
            } else break;
        }
        return result;
    }
    
    int term_value() {
        int result = factor_value();
        while(idx < exp.length()) {
            char op = exp.charAt(idx);
            if(op == '*' || op == '/') {
                idx++;
                int value = factor_value();
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
        if(c == '(') {
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
