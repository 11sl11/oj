/**
* 题目描述：
* 有n对球队进入总决赛，现在要进行淘汰赛，每每两队都进行一场比赛，最终前n/2队进入下一轮淘汰赛。
* 其排名规则如下
* 球队胜一场得3分，平一场得1分，输一次得0分。
* 积分越高排名越前，积分相同，按净胜球数，越多越靠前，净胜球数相同，按进球数，进球越多越靠前。
* 求最终进入淘汰赛的球队。
*
* 输入描述：
* 测试数据有多组，每组测试数据的第一行为一个整数n（1≤n≤50），为参与总决赛的球队数，随后的n行
* 为球队的名字，由不超过30个的大小写拉丁字母构成。随后的n*(n-1)/2行为赛事的开展情况，每行的
* 格式为name1-name2 num1:num2，表示两支队伍的比分情况（1≤num1, num2≤100）。确保不会有两支
* 队伍同名，也不会出现队伍自己通自己比赛的情况，且每场比赛仅出现一次。
*
* 输出描述：
* 对每组测试数据，输出n/2行，为按字母序排列的进入淘汰赛的n/2支队伍的名单，每个名字在单独的行中
* 输出。
*
* 示例
*   输入
*   4
*   A
*   B
*   C
*   D
*   A-B 1:1
*   A-C 2:2
*   A-D 1:0
*   B-C 1:0
*   B-D 0:3
*   C-D 0:3
*   2
*   a
*   A
*   a-A 2:1
*
*   输出
*   A
*   D
*   a
*
*/


import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }
    
    void run() {
        while(cin.hasNext()) {
            int n = cin.nextInt();
            Map<String, Integer> map = new HashMap<>();
            ArrayList<Cell> cells = new ArrayList<>();
            for(int i=0; i<n; i++) {
                Cell cell = new Cell(cin.next());
                cells.add(cell);
                map.put(cell.s, i);
            }
            for(int i=0; i<n*(n-1)/2; i++) {
                String[] sa = cin.next().trim().split("-");
                String[] sb = cin.next().trim().split(":");
                int x = Integer.parseInt(sb[0]), y = Integer.parseInt(sb[1]);
                if(x == y) {
                    cells.get(map.get(sa[0])).a += 1;
                    cells.get(map.get(sa[1])).a += 1;
                } else if(x > y) {
                    cells.get(map.get(sa[0])).a += 3;
                    cells.get(map.get(sa[0])).b += 1;
                } else {
                	cells.get(map.get(sa[1])).a += 3;
                	cells.get(map.get(sa[1])).b += 1;
                }
                cells.get(map.get(sa[0])).c += x;
                cells.get(map.get(sa[1])).c += y;
            }
            Collections.sort(cells);
            if((n&1) == 1) n++;
            Collections.sort(cells.subList(0, n/2), new Comparator<Cell>() {
				@Override
				public int compare(Cell o1, Cell o2) {
					return o1.s.compareTo(o2.s);
				}
			});
            for(int i=0; i<n/2; i++) {
            	System.out.println(cells.get(i).s);
            }
        }
    }
    
    class Cell implements Comparable<Cell> {
        int a, b, c;
        String s;
        
        Cell(String s) { this.s = s; }
        @Override
        public int compareTo(Cell o) {
            if(a == o.a) {
            	if(b == o.b) {
            		return c < o.c ? 1:-1;
            	} return b < o.b ? 1:-1;
            } return a < o.a ? 1:-1;
        }
    }
}
