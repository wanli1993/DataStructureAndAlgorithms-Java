package com.wanli.queue;

import java.util.Scanner;

/**
 * 环形队列:数组实现
 * 
 * @author 万里
 *
 */
public class CircleArrayQueueDemo {
	public static void main(String[] args) {
		// 测试一把
		System.out.println("测试数组模拟环形队列的案例~~~");

		// 创建一个环形队列
		CircleArray queue = new CircleArray(4); // 说明设置4, 其队列的有效数据最大是4
		char key = ' '; // 接收用户输入
		Scanner scanner = new Scanner(System.in);//
		boolean loop = true;
		// 输出一个菜单
		while (loop) {
			System.out.println("s(show): 显示队列");
			System.out.println("e(exit): 退出程序");
			System.out.println("a(add): 添加数据到队列");
			System.out.println("g(get): 从队列取出数据");
			key = scanner.next().charAt(0);// 接收一个字符
			switch (key) {
			case 's': // 显示队列
				queue.showQueue();
				break;
			case 'a': // 添加数据
				System.out.println("输出一个数");
				int value = scanner.nextInt();
				queue.addQueue(value);
				break;
			case 'g': // 取出数据
				try {
					int res = queue.getQueue();
					System.out.printf("取出的数据是%d\n", res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case 'e': // 退出
				scanner.close();
				loop = false;
				break;
			default:
				break;
			}
		}
		System.out.println("程序退出~~");
	}
}

/**
 * 自定义：环形队列
 * 
 * @author 万里
 *
 */
class CircleArray {
	private int maxSize; // 数组的最大容量
	private int addIndex; // 向队列添加元素的索引
	private int removeIndex; // 向队列取出元素的索引
	private int length;// 用于表示队列现有元素个数
	private int[] arr; // 用于模拟队列

	// 1.声明构造方法;传入队列的容量
	public CircleArray(int queueSize) {
		// 1.1 给容量变量赋值
		maxSize = queueSize;
		// 1.2 给数组赋值
		arr = new int[queueSize];
	}

	// 2.判断队列是否满
	public boolean isFull() {
		return length == maxSize;
	}

	// 3.判断队列是否为空
	public boolean isEmpty() {
		return length == 0;
	}

	// 4.添加数据到队列
	public void addQueue(int i) {
		// 4.1 判断队列是否已满
		if (isFull()) {
			System.out.println("队列满，不能加入数据~");
			return;
		}
		arr[addIndex] = i;
		length++;
		addIndex = (addIndex + 1) % maxSize;
	}

	// 5.获取队列的数据, 出队列
	public int getQueue() {
		// 5.1 判断队列是否为空
		if (isEmpty()) {
			// 抛出异常
			throw new RuntimeException("队列空，不能取数据");
		}
		int i = arr[removeIndex];
		length--;
		removeIndex = (removeIndex + 1) % maxSize;
		return i;
	}

	// 6.显示队列的所有数据
	public void showQueue() {
		// 6.1判断队列是否为空
		if (isEmpty()) {
			System.out.println("队列空的，没有数据~~");
			return;
		}
		for (int i = removeIndex; i < removeIndex + length; i++) {
			System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
		}
	}
}