/**
* 题目描述：
* 读入用户输入的一串先序遍历字符串，根据此字符串建立一个二叉树（以指针方式存储）。 例如如下的先序遍
* 历字符串：ABC##DE#G##F### 其中“#”表示的是空格，空格字符代表空树。建立起此二叉树以后，再对二叉树
* 进行中序遍历，输出遍历结果。
*
* 输入描述：
* 输入包括1行字符串，长度不超过100。
*
* 输出描述：
* 可能有多组测试数据，对于每组数据，输出将输入字符串建立二叉树后中序遍历的序列，每个字符后面都有一个
* 空格。每个输出结果占一行。
*
* 示例
*   输入
*   abc##de#g##f###
*
*   输出
*   c b e g d f a 
*
*/

/**
* 解题思路：
* 先序遍历与中序遍历呈入栈和出栈关系
*/

import java.util.*;

public class Main {
	Scanner cin = new Scanner(System.in);
	public static void main(String[] args) {
		new Main().run();
	}

	void run() {	
		while(cin.hasNext()) {
			String ss = cin.next();
			Stack<Character> stack = new Stack<>();
			for(int i=0; i<ss.length(); i++) {
				char c = ss.charAt(i);
				if(c == '#' && !stack.isEmpty()) {
					System.out.print(stack.pop() + " ");
				} else stack.push(c);
			} System.out.println();
		}
	}
}
