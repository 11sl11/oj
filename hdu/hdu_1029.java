package hdu;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Ignatius and the Princess IV
 * @author 11sl11
 *	���ҳ��ִ���Ϊ����һ�����ϵ���
 */
public class hdu_1029 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch (Exception ex) { }
	}

	public static void main(String[] args) {
		while(cin.hasNext()) {
			int cnt = 0, n = cin.nextInt(), x, ans = 0;
			for(int i=0; i<n; i++) {
				x = cin.nextInt();
				if(cnt == 0) {
					ans = x;
					cnt++;
				} else {
					if(ans == x) {
						cnt++;
					} else cnt--;
				}
			}
			System.out.println(ans);
		}
	}
}
