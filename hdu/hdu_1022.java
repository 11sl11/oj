package hdu;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Train Problem I 
 * @author 11sl11
 *	Õ»Ä£Äâ
 */
public class hdu_1022 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch (Exception ex) { }
	}

	public static void main(String[] args) {
		while(cin.hasNext()) {
			cin.nextInt();
			String ss = cin.next(), xx = cin.next();
			ArrayList<String> ans = new ArrayList<>();
			if(scheduling(ss, xx, ans)) {
				System.out.println("Yes.");
				for(int i=0; i<ans.size(); i++) {
					System.out.println(ans.get(i));
				}
			} else System.out.println("No.");
			System.out.println("FINISH");
		}
	}
	
	static boolean scheduling(String ss, String xx, ArrayList<String> ans) {
		int i, j;
		Stack<Character> stack = new Stack<>();
		for(i=j=0; i<ss.length(); i++) {
			stack.push(ss.charAt(i));
			ans.add("in");
			while(!stack.isEmpty() && stack.peek() == xx.charAt(j)) {
				ans.add("out");
				j++;
				stack.pop();
			}
		}
		return j == ss.length();
	}
}
