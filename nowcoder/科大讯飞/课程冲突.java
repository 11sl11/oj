/**
* 题目描述:
* 小明是一名学生，又到了学校的选课时间，他想选一些课程学习，已知课程开课时间都在每周一到周五之内，
* 早上4讲课，下午4讲课，晚上2讲课。小明担心选课时间上有所冲突。所以他希望可以对课程时间进行检查。
*
* 输入描述：
* 首先输入一个整数n（0<n≤100），表示小明选课总数。之后输入n行选课信息，每行选课信息有2个数字。
* 第一个数字表示开课时间，开课时间用2位数表示，前一位用0到4表示周一至周五，后一位用0到9表示从早到
* 晚顺序第几讲课，如12表示礼拜二第三讲课。01表示礼拜一第二讲课。每行第二个数字表示课程代码，
* 如：204521。课程代码为6位数字。输入课程代码均不重复。
*
* 输出描述：
* 如果没有冲突课程，输出YES。
* 如果有冲突课程，也就是同一个时间多于一节课，输出所有冲突的课程。输出有多行，如果多个不同的上课时
* 间都有课程冲突，按照周一到周五，早上到晚上时间先后，按行输出冲突信息。在同一行内，先输出冲突时间，
* 之后输出这一时间的所有课程，输出课程的顺序为输入中这些课程出现的顺序，课程之间以空格分隔，不要在
* 行末输出多余的空格。
*
* 示例
*   输入
*   5
*   01 204521
*   23 204523
*   22 204526
*   01 204528
*   22 204527
*
*   输出
*   01 204521 204528
*   22 204526 204527
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
            Map<Integer, ArrayList<String>> ans = new TreeMap<>();
            for(int i=0; i<n; i++) {
            	int x = cin.nextInt();
            	if(!ans.containsKey(x)) {
            		ans.put(x, new ArrayList<>());
            	} ans.get(x).add(cin.next());
            }
            boolean flag = true;
            for(Integer x: ans.keySet()) {
            	if(ans.get(x).size() < 2) continue;
            	flag = false;
            	System.out.print(String.format("%02d ", x));
            	for(int i=0; i<ans.get(x).size(); i++) {
            		System.out.print(ans.get(x).get(i) + " ");
            	} System.out.println();
            }
            if(flag) System.out.println("YES");
        }
    }
}
