package hdu;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Safecracker
 * @author 11sl11
 *	Ã¶¾Ù
 */
public class hdu_1015 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch (Exception ex) { }
	}

	public static void main(String[] args) {
		while(cin.hasNext()) {
			int target = cin.nextInt();
			String letter = cin.next();
			if(target == 0) break;
			System.out.println(decrypt(target, letter));
		}
	}
	
	static String decrypt(int target, String letter) {
		boolean[] hash = new boolean[27];
		for(int i=0; i<letter.length(); i++) {
			hash[letter.charAt(i)-'A'+1] = true;
		}
		String ans = "";
		for(int v=1; v<=26; v++) {
			if(!hash[v]) continue;
			for(int w=1; w<=26; w++) {
				if(!hash[w] || v==w) continue;
				int ww = w*w;
				for(int x=1; x<=26; x++) {
					if(!hash[x] || v==x || w==x) continue;
					int xxx = x*x*x;
					for(int y=1; y<=26; y++) {
						if(!hash[y] || v==y || w==y || x==y) continue;
						int yyyy = y*y*y*y;
						for(int z=1; z<=26; z++) {
							if(!hash[z] || v==z || w==z || x==z || y==z) continue;
							if(target == (v - ww + xxx - yyyy + z*z*z*z*z)) {
								ans = new StringBuilder()
										.append((char)(v+'A'-1)).append((char)(w+'A'-1))
										.append((char)(x+'A'-1)).append((char)(y+'A'-1))
										.append((char)(z+'A'-1)).toString();
							}
						}
					}
				}
			}
		}
		return (ans.equals("") ? "no solution":ans);
	}
}
