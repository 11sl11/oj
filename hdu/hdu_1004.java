package hdu;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Let the Balloon Rise
 * @author 11sl11
 *	¼ÆÊý
 */
public class hdu_1004 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch (Exception ex) { }
	}

	public static void main(String[] args) {
		int n;
		while(cin.hasNext()) {
			if((n = cin.nextInt()) == 0) break;
			HashMap<String, Integer> num = new HashMap<>();
			for(int i=0; i<n; i++) {
				String ss = cin.next();
				if(ss != null && !ss.isEmpty()) {
					if(num.containsKey(ss)) {
						num.put(ss, num.get(ss)+1);
					} else {
						num.put(ss, 1);
					}
				}
			}
			int max = 0;
			String res = null;
			for(String ss: num.keySet()) {
				if(num.get(ss) > max) {
					max = num.get(ss);
					res = ss;
				}
			}
			System.out.println(res);
		}
	}
}
