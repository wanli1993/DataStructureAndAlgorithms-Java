package com.wanli.linkedlist;

/**
 * 单向链表测试
 * 
 * @author 万里
 *
 */
public class SingleLinkedListDemo {
	public static void main(String[] args) {
		// 测试
		// 1.先创建节点
		HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
		HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
		HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
		HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
		// 2.创建链表
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		// 3.加入到链表尾部
		singleLinkedList.add(hero1);
		singleLinkedList.add(hero4);
		singleLinkedList.add(hero2);
		singleLinkedList.add(hero3);
		// 4.遍历单链表
		singleLinkedList.list();
		// 5.创建链表
		singleLinkedList = new SingleLinkedList();
		// 6.按照no排序，节点的编号
		singleLinkedList.addByOrder(hero1);
		singleLinkedList.addByOrder(hero4);
		singleLinkedList.addByOrder(hero2);
		singleLinkedList.addByOrder(hero3);
		// 7.遍历单链表
		singleLinkedList.list();
		// 8.修改节点的代码
		HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~");
		singleLinkedList.update(newHeroNode);
		// 9.遍历单链表
		singleLinkedList.list();
		// 10.删除一个节点
		singleLinkedList.del(1);
		// 11.遍历单链表
		singleLinkedList.list();
	}
}

/**
 * 定义一个单向链表，用于管理梁山好汉
 * 
 * @author 万里
 *
 */
class SingleLinkedList {
	// 1.初始化一个头节点, 头节点不存放具体的数据，头节点也不改变
	private HeroNode head = new HeroNode(0, "", "");

	// 2.定义方法返回头节点
	public HeroNode getHead() {
		return head;
	}

	// 3.添加节点到链表的尾部
	public void add(HeroNode heroNode) {
		// 3.1 因为head节点不能动，因此我们需要一个辅助遍历 temp
		HeroNode temp = head;
		// 3.2 因为是添加到尾部，所以要先找到链表的尾部
		while (true) {
			if (temp.next == null) {// 尾部节点的next没有指向下个节点，所以为null
				break;
			}
			// 如果没有找到最后, temp后移
			temp = temp.next;
		}
		// 3.3 此时temp为最后一个节点，在此节点后添加新节点
		temp.next = heroNode;
	}

	// 4.按照梁山好汉的no顺序添加节点
	public void addByOrder(HeroNode heroNode) {
		// 4.1因为head节点不能动，因此我们需要一个辅助遍历 temp
		HeroNode temp = head;
		// 4.2 定义flag标志用于判断添加的编号是否存在，默认为false
		boolean flag = false;
		// 4.3 找到要添加的位置的前一个节点
		while (true) {
			if (temp.next == null) {// 如果遍历完所有节点还没找到，说明是要添加到最后
				break;
			}
			if (temp.next.no > heroNode.no) {// 当第一次出现已有节点的no大于新节点的no
				break; // 那么新节点就要添加到此节点的前面，这里是temp的后面
			} else if (temp.next.no == heroNode.no) {
				flag = true; // 说明编号存在
				break;
			}
			// 如果没有找到最后, temp后移
			temp = temp.next;
		}
		// 4.4 先判断新添加的编号是否存在
		// 如果不存在就将原来temp后面的节点转到新节点上，并在temp后面添加新节点
		if (flag) {
			System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", heroNode.no);
		} else {
			// 4.4.1 将原来temp后面的节点转到新节点上
			heroNode.next = temp.next;
			// 4.4.2 在temp后面添加新节点
			temp.next = heroNode;
		}
	}

	// 5.修改节点的信息, 根据no编号来修改，即no编号不能改
	public void update(HeroNode newHeroNode) {
		// 5.1 因为head节点不能动，因此我们需要一个辅助遍历 temp,用于表示第一个节点
		HeroNode temp = head.next;
		// 5.2 判断是否空
		if (head.next == null) {
			System.out.println("链表为空~");
			return;
		}
		// 5.3 定义flag标志用于判断是否找到该节点，默认为false
		boolean flag = false;
		// 5.4 找到要修改的节点
		while (true) {
			if (temp == null) {// 已经遍历完链表
				break;
			}
			if (temp.no == newHeroNode.no) {// 找到修改节点
				flag = true;
				break;
			}
			// 如果没有找到最后, temp后移
			temp = temp.next;
		}
		if (flag) {// 找到
			// 进行修改
			temp.name = newHeroNode.name;
			temp.nickname = newHeroNode.nickname;
		} else {// 没有找到
			System.out.printf("没有找到 编号 %d 的节点，不能修改\n", newHeroNode.no);
		}
	}

	// 6.删除节点
	// 根据指定的no去删除节点
	public void del(int no) {
		// 6.1 因为head节点不能动，因此我们需要一个辅助遍历 temp
		HeroNode temp = head;
		// 6.2 定义flag标志用于判断是否找到该节点，默认为false
		boolean flag = false;
		// 6.3 找到要删除的节点
		while (true) {
			if (temp.next == null) {// 已经遍历完链表
				break;
			}
			if (temp.next.no == no) {// 找到删除节点
				flag = true;
				break;
			}
			// 如果没有找到最后, temp后移
			temp = temp.next;
		}
		// 6.4
		if (flag) {// 找到
			// 进行删除
			temp.next = temp.next.next;
		} else {// 没有找到
			System.out.printf("要删除的 %d 节点不存在\n", no);
		}
	}

	// 7.显示链表[遍历]
	public void list() {
		// 判断链表是否为空
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		// 因为头节点，不能动，因此我们需要一个辅助变量来遍历
		HeroNode temp = head.next;
		while (true) {
			// 判断是否到链表最后
			if (temp == null) {
				break;
			}
			// 输出节点的信息
			System.out.println(temp);
			// 将temp后移
			temp = temp.next;
		}
	}
}

/**
 * 定义HeroNode ， 每个HeroNode 对象就是一个节点
 * 
 * @author 万里
 *
 */
class HeroNode {
	public int no;
	public String name;
	public String nickname;
	public HeroNode next; // 指向下一个节点
	// 构造器

	public HeroNode(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}

	// 为了显示方法，我们重新toString
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
}