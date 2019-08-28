/**
* 题目描述：（快手机试）
* 给出满二叉树，编写算法将其转化为求和树。
* 什么是求和树：二叉树的求和树， 是一颗同样结构的二叉树，其树中的每个节点将包含原始树中的左子树和右子树的和。
* 二叉树：
*                  10
*               /      \
*             -2        6
*           /   \      /  \ 
*          8    -4    7    5
*
* 求和树：
*                 20(4-2+12+6)
*               /      \
*           4(8-4)      12(7+5)
*            /   \      /  \ 
*          0      0    0    0
*
* 二叉树给出前序和中序输入，求和树要求中序输出；所有处理数据不会大于int；
*
* 输入描述：
* 2行整数，第1行表示二叉树的前序遍历，第2行表示二叉树的中序遍历，以空格分割。
*
* 输出描述：
* 1行整数，表示求和树的中序遍历，以空格分割。
*
* 示例
*   输入
*   10 -2 8 -4 6 7 5
*   8 -2 -4 10 7 6 5
*
*   输出
*   0 4 0 20 0 12 0
*
*/

/**
* 解题思路：
* 求和树的根节点 = 除本身外原二叉树所有子节点之和，本题中根节点为中序遍历数组中正中间项（满二叉树）
* 递归求得左右子树，直到子树节点个数为1返回[0]。
*/

import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }
 
    void run() {
        String[] s1 = cin.nextLine().trim().split(" ");
        String[] s2 = cin.nextLine().trim().split(" ");
        int[][] tree = new int[3][s1.length];
        for(int i=0; i<s1.length; i++) {
            tree[0][i] = Integer.parseInt(s1[i]);
            tree[1][i] = Integer.parseInt(s2[i]);
        }
        dfs(tree, 0, s1.length-1, 0, s1.length-1);
        for(int i=0; i<s1.length; i++) {
            System.out.print(tree[2][i] + " ");
        } System.out.println();
    }
    
    void dfs(int[][] tree, int Lpre, int Rpre, int Lin, int Rin) {
        if(Lpre >= Rpre) return;
        int i = Lin, j;
        for(; tree[0][Lpre] != tree[1][i]; i++);
        for(j=Lin; j<=Rin; j++) {
            if(j != i) tree[2][i] += tree[1][j];
        }
        dfs(tree, Lpre+1, Lpre+i-Lin, Lin, i-1);
        dfs(tree, Lpre+1+i-Lin, Rpre, i+1, Rin);
    }
}
