/**
* 输入描述：
* 一组输入整数序列I和一组规则整数序列R，I和R序列的第一个整数为序列的个数（个数不包含第一个整数）；
* 整数范围为0~0xFFFFFFFF，序列个数不限。
*
* 输出描述：
* 从R依次中取出R<i>，对I进行处理，找到满足条件的I<j>： 
* I<j>整数对应的数字需要连续包含R<i>对应的数字。比如R<i>为23，I<j>为231，那么I<j>包含了R<i>，条件满足 。 
* 按R<i>从小到大的顺序:
* (1)先输出R<i>；
* (2)再输出满足条件的I<j>的个数； 
* (3)然后输出满足条件的I<j>在I序列中的位置索引(从0开始)； 
* (4)最后再输出I<j>。 
* 附加条件： 
* (1)R<i>需要从小到大排序。相同的R<i>只需要输出索引小的以及满足条件的I<j>，索引大的需要过滤掉 
* (2)如果没有满足条件的I<j>，对应的R<i>不用输出 
* (3)最后需要在输出序列的第一个整数位置记录后续整数序列的个数(不包含“个数”本身)
*
* 示例
*   输入
*   15 123 456 786 453 46 7 5 3 665 453456 745 456 786 453 123
*   5 6 3 6 3 0
*
*   输出
*   30 3 6 0 123 3 453 7 3 9 453456 13 453 14 123 6 7 1 456 2 786 4 46 8 665 9 453456 11 456 12 786
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
            int n = cin.nextInt(), m;
            String[] ins = new String[n];
            for(int i=0; i<n; i++) ins[i] = cin.next();
            m = cin.nextInt();
            Set<String> set = new TreeSet<>(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    long i1 = Long.parseLong(o1);
                    long i2 = Long.parseLong(o2);
                    if(i1 == i2) return 0;
                    return i1 < i2 ? -1 : 1;
                }
            });
            for(int i=0; i<m; i++) set.add(cin.next());

            m = 0;
            Map<String, ArrayList<String>> map = new HashMap<>();
            for(String s: set) {
                for(int i=0; i<n; i++) {
                    if(!ins[i].contains(s)) continue;
                    if(!map.containsKey(s)) map.put(s, new ArrayList<>());
                    m += 2;
                    map.get(s).add(i + " " + ins[i]);
                }
                if(map.containsKey(s)) m += 2;
            }

            System.out.print(m);
            for(String s: set) {
                if(!map.containsKey(s)) continue;
                n = map.get(s).size();
                System.out.print(" " + s + " " + n);
                for(int i=0; i<n; i++) {
                    System.out.print(" " + map.get(s).get(i));
                }
            } System.out.println();
        }
    }
}
