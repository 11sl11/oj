package hdu;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Easier Done Than Said?
 * @author 11sl11
 *	Ä£Äâ
 */
public class hdu_1039 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch (Exception ex) { }
	}

	public static void main(String[] args) {
		while(cin.hasNext()) {
			String ss;
			while((ss = cin.next()) != null) {
				if(ss.equals("end")) break;
				System.out.print("<" + ss + ">");
				if(acceptable(ss)) {
					System.out.println(" is acceptable.");
				} else System.out.println(" is not acceptable.");
			}
		}
	}
	
	static String vowels = "aeiou";
	static boolean acceptable(String ss) {
		ss = ss.toLowerCase();
		boolean containsVowels = false;
		for(int i=0; i<ss.length(); i++) {
			if(vowels.contains(String.valueOf(ss.charAt(i)))) {
				containsVowels = true;
				break;
			}
		}
		if(!containsVowels) return false;
		
		int vowelsNum=0, consonantNum=0;
		for(int i=0; i<ss.length(); i++) {
			if(vowels.contains(String.valueOf(ss.charAt(i)))) {
				vowelsNum++;
				consonantNum = 0;
			} else {
				vowelsNum = 0;
				consonantNum++;
			}
			if(vowelsNum > 2 || consonantNum > 2) return false;
		}
		
		char c = ss.charAt(0);
		for(int i=1; i<ss.length(); i++) {
			if(ss.charAt(i) == c && c != 'e' && c !='o') {
				return false;
			}
			c = ss.charAt(i);
		}
		return true;
	}
}
