package hdu;
import java.io.*;
import java.util.*;

public class hdu_1038 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch (Exception ex) { }
	}
	
	static final double P = 3.1415927;
	public static void main(String[] args) {
		int cnt = 0;
		while(cin.hasNext()) {
			double diameter = cin.nextDouble();
			int revolutions = cin.nextInt();
			double time = cin.nextDouble();
			if(revolutions == 0) break;
			double distance = revolutions*P*diameter/(12*5280);
			double MPH = distance/(time/3600.0);
			System.out.println(String.format(
				"Trip #%d: %.2f %.2f",++cnt, distance, MPH));
		}
	}
}
