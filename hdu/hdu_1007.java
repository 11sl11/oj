package hdu;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Quoit Design
 * @author 11sl11
 *	分治 + 最近点对
 */
public class hdu_1007 {
	static Scanner cin = new Scanner(System.in);
	static {
		try {
			cin = new Scanner(new FileInputStream("./data.txt"));
		} catch (Exception ex) {}
	}

	static ArrayList<Point> points = new ArrayList<>();
	public static void main(String[] args) {
		while(cin.hasNext()) {
			int n = cin.nextInt();
			if(n <= 0) break;
			points.clear();
			for(int i=0; i<n; i++) {
				Point p = new Point();
				p.x = cin.nextDouble();
				p.y = cin.nextDouble();
				points.add(p);
			}
			Collections.sort(points, new Comparator<Point>() {
				@Override
				public int compare(Point o1, Point o2) {
					return o1.x <o2.x ? -1:1;
				}
			});
			System.out.println(String.format("%.2f", divide(0, n-1)/2));
		}
	}

	static double divide(int left, int right) {
		if(left >= right) return Double.POSITIVE_INFINITY;
		if(left +1 == right) return points.get(left).dist(points.get(right));
		
		int mid = (left +right) /2;
		double leftRadius = divide(left, mid), rightRadius = divide(mid+1, right);
		double res = Math.min(leftRadius, rightRadius);
		
		ArrayList<Point> temp = new ArrayList<>();
		for(int i=left; i<=right; i++) {
			if(Math.abs(points.get(mid).x - points.get(i).x) < res) {
				temp.add(points.get(i));
			}
		}
		Collections.sort(temp, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				return o1.y <o2.y ? -1: 1;
			}
		});
		for(int i=0; i<temp.size(); i++) {
			for(int j=i+1; j<temp.size(); j++) {
				if(Math.abs(temp.get(i).y - temp.get(j).y) > res) break;
				res = Math.min(res, temp.get(i).dist(temp.get(j)));
			}
		}
		return res;
	}
	
	static class Point {
		double x, y;
		
		double dist(Point p) {
			return Math.sqrt((x-p.x)*(x-p.x) + (y-p.y)*(y-p.y));
		}
	}
}
