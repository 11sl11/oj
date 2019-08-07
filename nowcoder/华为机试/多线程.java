/**
* 题目描述：
* 有4个线程和1个公共的字符数组。线程1的功能就是向数组输出A，线程2的功能就是向字符输出B，
* 线程3的功能就是向数组输出C，线程4的功能就是向数组输出D。要求按顺序向数组赋值ABCDABCDABCD
*
* 示例
*   输入
*   10
*
*   输出
*   ABCDABCDABCDABCDABCDABCDABCDABCDABCDABCD
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
    		Server server = new Server();
    		Thread t1 = new Thread(new Runnable() {
    			public void run() {
    				for(int i=0; i<n; i++) server.printA();
    			}
    		});
    		Thread t2 = new Thread(new Runnable() {
    			public void run() { 
    				for(int i=0; i<n; i++) server.printB();
    			}
    		});
    		Thread t3 = new Thread(new Runnable() {
    			public void run() { 
    				for(int i=0; i<n; i++) server.printC();
    			}
    		});
    		Thread t4 = new Thread(new Runnable() {
    			public void run() { 
    				for(int i=0; i<n; i++) server.printD();
    			}
    		});
    		t1.start(); t2.start(); t3.start(); t4.start();
    		try {
    			t1.join(); t2.join(); t3.join(); t4.join();
    		} catch(InterruptedException e) {}
    		System.out.println();
    	}
    }
    
    class Server {
    	volatile int i = 0;
    	synchronized void printA() {
    		try {
    			while(i != 0) wait();
    			System.out.print('A');
    			i = 1;
    			notifyAll();
    		} catch(InterruptedException e) {}
    	}
    	
    	synchronized void printB() {
    		try {
    			while(i != 1) wait();
    			System.out.print('B');
    			i = 2;
    			notifyAll();
    		} catch(InterruptedException e) {}
    	}
    	
    	synchronized void printC() {
    		try {
    			while(i != 2) wait();
    			System.out.print('C');
    			i = 3;
    			notifyAll();
    		} catch(InterruptedException e) {}
    	}
    	
    	synchronized void printD() {
    		try {
    			while(i != 3) wait();
    			System.out.print('D');
    			i = 0;
    			notifyAll();
    		} catch(InterruptedException e) {}
    	}
    }
}
