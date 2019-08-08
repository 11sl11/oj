/**
* 题目描述：
* 给定一系列翻转指令，求面板上图形最终翻转结果，规则如下：
* 在 NxN 大小的面板上存在一些对称图形：‘<’、‘>’、‘^’、‘v’、‘o’、‘x’、‘|’、‘-’、‘\’、‘/’，则
* 经过旋转或翻转后，图形保持不变或变为另一个图形。
*
* 指令由若干字符组成，其定义如下：
* <：向左旋转90度；
* -：沿水平方向翻转；
* |：沿垂直方向翻转；
* >：向右旋转90度；
* \：沿对角线翻转；
* /：沿反对角线翻转
*
* 连续两个命令字符之间以单个空格分隔，命令串的长度大于0且不超过1000000。
*
* 示例
*   输入
*   3
*   o^-
*   /v|
*   vx^
*   < |
*   5
*   x>-o\
*   voooo
*   |ooo/
*   ooo/v
*   \o/vv
*   | \ |
*
*   输出
*   >-|
*   x<>
*   </o
*   <</o\
*   </ooo
*   /ooo|
*   oooo^
*   \o-<x
*
*/

import java.util.*;

public class Main {
    Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }
    
    int n;
    char[][] map, tmp;
    void run() {
        while(cin.hasNext()) {
        	n = Integer.parseInt(cin.nextLine());
        	map = new char[n][n];
        	tmp = new char[n][n];
        	for(int i=0; i<n; i++) {
        		map[i] = cin.nextLine().toCharArray();
        	}
        	String cmd = cin.nextLine();
        	for(int i=0; i<cmd.length(); i++) {
        		for(int j=0; j<n; j++) {
        			System.arraycopy(map[j], 0, tmp[j], 0, n);
        		}
        		switch(cmd.charAt(i)) {
        			case '<': dosthA(); break;
        			case '>': dosthB(); break;
        			case '-': dosthC(); break;
        			case '|': dosthD(); break;
        			case '\\': dosthE(); break;
        			case '/': dosthF(); break;
        		}
        	}
        	for(int i=0; i<n; i++) {
        		for(int j=0; j<n; j++) {
        			System.out.print(map[i][j]);
        		} System.out.println();
        	}
        }
    }
    
    void dosthA() { // 左转90度(逆时针)
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<n; j++) {
    			char c = tmp[i][j];
    			if(c == '<') {
    				c = 'v';
    			} else if(c == 'v') {
    				c = '>';
    			} else if(c == '>') {
    				c = '^';
    			} else if(c == '^') {
    				c = '<';
    			} else if(c == '|') {
    				c = '-';
    			} else if(c == '-') {
    				c = '|';
    			} else if(c == '/') {
    				c = '\\';
    			} else if(c == '\\') {
    				c = '/';
    			}
    			map[n-1-j][i] = c;
    		}
    	}
    }
    void dosthB() { // 右转90度(顺时针)
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<n; j++) {
    			char c = tmp[i][j];
    			if(c == '<') {
    				c = '^';
    			} else if(c == 'v') {
    				c = '<';
    			} else if(c == '>') {
    				c = 'v';
    			} else if(c == '^') {
    				c = '>';
    			} else if(c == '|') {
    				c = '-';
    			} else if(c == '-') {
    				c = '|';
    			} else if(c == '/') {
    				c = '\\';
    			} else if(c == '\\') {
    				c = '/';
    			}
    			map[n-1-j][i] = c;
    		}
    	}
    }
    void dosthC() { // 水平转
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<n; j++) {
       			char c = tmp[i][j];
       			if(c == 'v') {
    				c = '^';
    			} else if(c == '^') {
    				c = 'v';
    			} else if(c == '/') {
    				c = '\\';
    			} else if(c == '\\') {
    				c = '/';
    			}
    			map[n-1-i][j] = c;
    		}
    	}
    }
    void dosthD() { // 垂直转
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<n; j++) {
       			char c = tmp[i][j];
       			if(c == '<') {
    				c = '>';
    			} else if(c == '>') {
    				c = '<';
    			} else if(c == '/') {
    				c = '\\';
    			} else if(c == '\\') {
    				c = '/';
    			}
    			map[i][n-1-j] = c;
    		}
    	}
    }
    
    void dosthE() { // 对角线翻转
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<n; j++) {
       			char c = tmp[i][j];
    			if(c == '<') {
    				c = '^';
    			} else if(c == 'v') {
    				c = '>';
    			} else if(c == '>') {
    				c = 'v';
    			} else if(c == '^') {
    				c = '<';
    			} else if(c == '|') {
    				c = '-';
    			} else if(c == '-') {
    				c = '|';
    			}
    			map[j][i] = c;
    		}
    	}
    }

    void dosthF() { // 反对角线翻转
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<n; j++) {
       			char c = tmp[i][j];
    			if(c == '<') {
    				c = 'v';
    			} else if(c == 'v') {
    				c = '<';
    			} else if(c == '>') {
    				c = '^';
    			} else if(c == '^') {
    				c = '>';
    			} else if(c == '|') {
    				c = '-';
    			} else if(c == '-') {
    				c = '|';
    			}
    			map[n-j][n-i] = c;
    		}
    	}
    }
}
