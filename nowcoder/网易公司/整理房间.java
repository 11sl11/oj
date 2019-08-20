/**
* 题目描述：
* 又到了周末，小易的房间乱得一团糟。他希望将地上的杂物稍微整理下，使每团杂物看起来都紧凑一些，没有那么乱。
* 地上一共有n团杂物，每团杂物都包含4个物品。第i物品的坐标用(ai,bi)表示，小易每次都可以将它绕着(xi,yi)逆
* 时针旋转90度，这将消耗他的一次移动次数。如果一团杂物的4个点构成了一个面积不为0的正方形，我们说它是紧凑
* 的。因为小易很懒，所以他希望你帮助他计算一下每团杂物最少需要多少步移动能使它变得紧凑。
*
* 输入描述：
* 第一行一个数n(1 <= n <= 100)，表示杂物的团数。接下来4n行，每4行表示一团杂物，每行4个数ai, bi，xi, yi, 
* (-10^4 <= xi, yi, ai, bi <= 10^4)，表示第i个物品旋转的它本身的坐标和中心点坐标。
*
* 输出描述：
* n行，每行1个数，表示最少移动次数。
*
* 示例
*   输入
*   4
*   1 1 0 0
*   -1 1 0 0
*   -1 1 0 0
*   1 -1 0 0
*   1 1 0 0
*   -2 1 0 0
*   -1 1 0 0
*   1 -1 0 0
*   1 1 0 0
*   -1 1 0 0
*   -1 1 0 0
*   -1 1 0 0
*   2 2 0 1
*   -1 0 0 -2
*   3 0 0 -2
*   -1 1 -2 0
*
*   输出
*   1
*   -1
*   3
*   3
*   说明：对于第一团杂物，我们可以旋转第二个或者第三个物品1次。
*
*/

/**
* 解题思路：
* 点(x,y)绕原点逆时针旋转α得到(x',y')的公式：
* x'=xcosα-ysinα
* y'=xsinα+ycosα
* 现在顺时针旋转α,即逆时针旋转-α,用-α代替上面的α,并根据公式cos(-α)=cosα,sin(-α)=-sinα 得
* x'=xcosα+ysinα
* y'=-xsinα+ycosα
* 最后如果旋转中心为(a,b),在利用上面的公式时,需要把(a,b)沿向量(-a,-b)移动到原点,此时(x,y)
* 变成(x-a,y-b),(x',y')变成(x'-a,y'-b),整理得
* x'=(x-a)cosα+(y-b)sinα+a
* y'=-(x-a)sinα+(y-b)cosα+b
*/
