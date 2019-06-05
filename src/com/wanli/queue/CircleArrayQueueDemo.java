package com.wanli.queue;

import java.util.Scanner;

/**
 * ���ζ���:����ʵ��
 * 
 * @author ����
 *
 */
public class CircleArrayQueueDemo {
	public static void main(String[] args) {
		// ����һ��
		System.out.println("��������ģ�⻷�ζ��еİ���~~~");

		// ����һ�����ζ���
		CircleArray queue = new CircleArray(4); // ˵������4, ����е���Ч���������4
		char key = ' '; // �����û�����
		Scanner scanner = new Scanner(System.in);//
		boolean loop = true;
		// ���һ���˵�
		while (loop) {
			System.out.println("s(show): ��ʾ����");
			System.out.println("e(exit): �˳�����");
			System.out.println("a(add): ������ݵ�����");
			System.out.println("g(get): �Ӷ���ȡ������");
			key = scanner.next().charAt(0);// ����һ���ַ�
			switch (key) {
			case 's': // ��ʾ����
				queue.showQueue();
				break;
			case 'a': // �������
				System.out.println("���һ����");
				int value = scanner.nextInt();
				queue.addQueue(value);
				break;
			case 'g': // ȡ������
				try {
					int res = queue.getQueue();
					System.out.printf("ȡ����������%d\n", res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case 'e': // �˳�
				scanner.close();
				loop = false;
				break;
			default:
				break;
			}
		}
		System.out.println("�����˳�~~");
	}
}

/**
 * �Զ��壺���ζ���
 * 
 * @author ����
 *
 */
class CircleArray {
	private int maxSize; // ������������
	private int addIndex; // ��������Ԫ�ص�����
	private int removeIndex; // �����ȡ��Ԫ�ص�����
	private int length;// ���ڱ�ʾ��������Ԫ�ظ���
	private int[] arr; // ����ģ�����

	// 1.�������췽��;������е�����
	public CircleArray(int queueSize) {
		// 1.1 ������������ֵ
		maxSize = queueSize;
		// 1.2 �����鸳ֵ
		arr = new int[queueSize];
	}

	// 2.�ж϶����Ƿ���
	public boolean isFull() {
		return length == maxSize;
	}

	// 3.�ж϶����Ƿ�Ϊ��
	public boolean isEmpty() {
		return length == 0;
	}

	// 4.������ݵ�����
	public void addQueue(int i) {
		// 4.1 �ж϶����Ƿ�����
		if (isFull()) {
			System.out.println("�����������ܼ�������~");
			return;
		}
		arr[addIndex] = i;
		length++;
		addIndex = (addIndex + 1) % maxSize;
	}

	// 5.��ȡ���е�����, ������
	public int getQueue() {
		// 5.1 �ж϶����Ƿ�Ϊ��
		if (isEmpty()) {
			// �׳��쳣
			throw new RuntimeException("���пգ�����ȡ����");
		}
		int i = arr[removeIndex];
		length--;
		removeIndex = (removeIndex + 1) % maxSize;
		return i;
	}

	// 6.��ʾ���е���������
	public void showQueue() {
		// 6.1�ж϶����Ƿ�Ϊ��
		if (isEmpty()) {
			System.out.println("���пյģ�û������~~");
			return;
		}
		for (int i = removeIndex; i < removeIndex + length; i++) {
			System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
		}
	}
}