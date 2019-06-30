package hdu;

import java.io.*;
import java.util.*;

public class hdu_1037 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch(Exception e) {}
	}
	
	static final int standar = 168;
	public static void main(String[] args) {
		while(cin.hasNext()) {
			int a=cin.nextInt(), b=cin.nextInt(), c=cin.nextInt();
			if(a < standar) {
				System.out.println("CRASH " + a);
				continue;
			}
			if(b < standar) {
				System.out.println("CRASH " + b);
				continue;
			}
			if(c < standar) {
				System.out.println("CRASH " + c);
				continue;
			}
			System.out.println("NO CRASH");
		}
	}
}
