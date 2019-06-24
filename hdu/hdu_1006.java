package hdu;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Tick and Tick
 * @author 11sl11
 *	枚举 + 物理( 角速度)
 */
public class hdu_1006 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch (Exception ex) { }
	}

	public static void main(String[] args) {
		double w_s = 6.0, w_m = 1.0/10.0, w_h = 1.0/120.0;
		double w_hs = w_s-w_h, w_hm = w_m-w_h, w_ms = w_s-w_m;
		double T_hs = 360.0/w_hs, T_hm = 360.0/w_hm, T_ms = 360.0/w_ms;
		double T = 12.0*60.0*60.0;
		
		while(cin.hasNext()) {
			double D = cin.nextDouble(), ans = 0;
			if(D < 0) break;
			double T_hs1 = D/w_hs, T_hm1 = D/w_hm, T_ms1 = D/w_ms;
			double T_hs2 = (360.0-D)/w_hs, T_hm2 = (360.0-D)/w_hm, T_ms2 = (360.0-D)/w_ms;
	
			for(double hs=0; hs<=T; hs+=T_hs) {
				for(double hm=0; hm<=T; hm+=T_hm) {
					if(hm+T_hm2 < hs+T_hs1) continue;
					if(hs+T_hs2 < hm+T_hm1) break;
					for(double ms=0; ms<=T; ms+=T_ms) {
						if(ms+T_ms2 < hs+T_hs1 || ms+T_ms2 < hm+T_hm1) continue;
						if(hm+T_hm2 < ms+T_ms1 || hs+T_hs2 < ms+T_ms1) break;
						double p = Math.max(Math.max(hs+T_hs1, hm+T_hm1), ms+T_ms1);
						double q = Math.min(Math.min(hs+T_hs2, hm+T_hm2), ms+T_ms2);
						if(q > p) ans += q-p;
					}
				}
			}
			System.out.println(String.format("%.3f", 100.0*ans/T));
		}
	}
}
