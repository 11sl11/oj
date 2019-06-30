package hdu;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Average is not Fast Enough! 
 * @author 11sl11
 *	Ä£Äâ
 */
public class hdu_1036 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch (Exception ex) { }
	}

	public static void main(String[] args) {
		int n = cin.nextInt();
		double d = cin.nextDouble();
		while(cin.hasNext()) {
			int id = cin.nextInt(), runtime=0, k;
			boolean flag = true;
			for(int i=0; i<n; i++) {
				k = toMinute(cin.next());
				if(k == -1) flag = false;
				runtime += k;
			}
			System.out.print(String.format("%3d: ", id));
			if(flag) {
				int ans = (int) (runtime/d + 0.5);
				System.out.println(new StringBuilder()
					.append(ans/60)
					.append(':')
					.append(String.format("%02d min/km", ans%60)));
			} else System.out.println('-');
		}
	}
	
	static int toMinute(String timer) {
		if(timer.charAt(0) == '-') return -1;
		String[] times = timer.trim().split(":");
		return Integer.parseInt(times[0])*3600 +
				Integer.parseInt(times[1])*60 +
				Integer.parseInt(times[2]);
	}
}
