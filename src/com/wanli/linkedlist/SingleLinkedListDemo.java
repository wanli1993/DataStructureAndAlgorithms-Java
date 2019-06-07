package com.wanli.linkedlist;

/**
 * �����������
 * 
 * @author ����
 *
 */
public class SingleLinkedListDemo {
	public static void main(String[] args) {
		// ����
		// 1.�ȴ����ڵ�
		HeroNode hero1 = new HeroNode(1, "�ν�", "��ʱ��");
		HeroNode hero2 = new HeroNode(2, "¬����", "������");
		HeroNode hero3 = new HeroNode(3, "����", "�Ƕ���");
		HeroNode hero4 = new HeroNode(4, "�ֳ�", "����ͷ");
		// 2.��������
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		// 3.���뵽����β��
		singleLinkedList.add(hero1);
		singleLinkedList.add(hero4);
		singleLinkedList.add(hero2);
		singleLinkedList.add(hero3);
		// 4.����������
		singleLinkedList.list();
		// 5.��������
		singleLinkedList = new SingleLinkedList();
		// 6.����no���򣬽ڵ�ı��
		singleLinkedList.addByOrder(hero1);
		singleLinkedList.addByOrder(hero4);
		singleLinkedList.addByOrder(hero2);
		singleLinkedList.addByOrder(hero3);
		// 7.����������
		singleLinkedList.list();
		// 8.�޸Ľڵ�Ĵ���
		HeroNode newHeroNode = new HeroNode(2, "С¬", "������~~");
		singleLinkedList.update(newHeroNode);
		// 9.����������
		singleLinkedList.list();
		// 10.ɾ��һ���ڵ�
		singleLinkedList.del(1);
		// 11.����������
		singleLinkedList.list();
	}
}

/**
 * ����һ�������������ڹ�����ɽ�ú�
 * 
 * @author ����
 *
 */
class SingleLinkedList {
	// 1.��ʼ��һ��ͷ�ڵ�, ͷ�ڵ㲻��ž�������ݣ�ͷ�ڵ�Ҳ���ı�
	private HeroNode head = new HeroNode(0, "", "");

	// 2.���巽������ͷ�ڵ�
	public HeroNode getHead() {
		return head;
	}

	// 3.��ӽڵ㵽�����β��
	public void add(HeroNode heroNode) {
		// 3.1 ��Ϊhead�ڵ㲻�ܶ������������Ҫһ���������� temp
		HeroNode temp = head;
		// 3.2 ��Ϊ����ӵ�β��������Ҫ���ҵ������β��
		while (true) {
			if (temp.next == null) {// β���ڵ��nextû��ָ���¸��ڵ㣬����Ϊnull
				break;
			}
			// ���û���ҵ����, temp����
			temp = temp.next;
		}
		// 3.3 ��ʱtempΪ���һ���ڵ㣬�ڴ˽ڵ������½ڵ�
		temp.next = heroNode;
	}

	// 4.������ɽ�ú���no˳����ӽڵ�
	public void addByOrder(HeroNode heroNode) {
		// 4.1��Ϊhead�ڵ㲻�ܶ������������Ҫһ���������� temp
		HeroNode temp = head;
		// 4.2 ����flag��־�����ж���ӵı���Ƿ���ڣ�Ĭ��Ϊfalse
		boolean flag = false;
		// 4.3 �ҵ�Ҫ��ӵ�λ�õ�ǰһ���ڵ�
		while (true) {
			if (temp.next == null) {// ������������нڵ㻹û�ҵ���˵����Ҫ��ӵ����
				break;
			}
			if (temp.next.no > heroNode.no) {// ����һ�γ������нڵ��no�����½ڵ��no
				break; // ��ô�½ڵ��Ҫ��ӵ��˽ڵ��ǰ�棬������temp�ĺ���
			} else if (temp.next.no == heroNode.no) {
				flag = true; // ˵����Ŵ���
				break;
			}
			// ���û���ҵ����, temp����
			temp = temp.next;
		}
		// 4.4 ���ж�����ӵı���Ƿ����
		// ��������ھͽ�ԭ��temp����Ľڵ�ת���½ڵ��ϣ�����temp��������½ڵ�
		if (flag) {
			System.out.printf("׼�������Ӣ�۵ı�� %d �Ѿ�������, ���ܼ���\n", heroNode.no);
		} else {
			// 4.4.1 ��ԭ��temp����Ľڵ�ת���½ڵ���
			heroNode.next = temp.next;
			// 4.4.2 ��temp��������½ڵ�
			temp.next = heroNode;
		}
	}

	// 5.�޸Ľڵ����Ϣ, ����no������޸ģ���no��Ų��ܸ�
	public void update(HeroNode newHeroNode) {
		// 5.1 ��Ϊhead�ڵ㲻�ܶ������������Ҫһ���������� temp,���ڱ�ʾ��һ���ڵ�
		HeroNode temp = head.next;
		// 5.2 �ж��Ƿ��
		if (head.next == null) {
			System.out.println("����Ϊ��~");
			return;
		}
		// 5.3 ����flag��־�����ж��Ƿ��ҵ��ýڵ㣬Ĭ��Ϊfalse
		boolean flag = false;
		// 5.4 �ҵ�Ҫ�޸ĵĽڵ�
		while (true) {
			if (temp == null) {// �Ѿ�����������
				break;
			}
			if (temp.no == newHeroNode.no) {// �ҵ��޸Ľڵ�
				flag = true;
				break;
			}
			// ���û���ҵ����, temp����
			temp = temp.next;
		}
		if (flag) {// �ҵ�
			// �����޸�
			temp.name = newHeroNode.name;
			temp.nickname = newHeroNode.nickname;
		} else {// û���ҵ�
			System.out.printf("û���ҵ� ��� %d �Ľڵ㣬�����޸�\n", newHeroNode.no);
		}
	}

	// 6.ɾ���ڵ�
	// ����ָ����noȥɾ���ڵ�
	public void del(int no) {
		// 6.1 ��Ϊhead�ڵ㲻�ܶ������������Ҫһ���������� temp
		HeroNode temp = head;
		// 6.2 ����flag��־�����ж��Ƿ��ҵ��ýڵ㣬Ĭ��Ϊfalse
		boolean flag = false;
		// 6.3 �ҵ�Ҫɾ���Ľڵ�
		while (true) {
			if (temp.next == null) {// �Ѿ�����������
				break;
			}
			if (temp.next.no == no) {// �ҵ�ɾ���ڵ�
				flag = true;
				break;
			}
			// ���û���ҵ����, temp����
			temp = temp.next;
		}
		// 6.4
		if (flag) {// �ҵ�
			// ����ɾ��
			temp.next = temp.next.next;
		} else {// û���ҵ�
			System.out.printf("Ҫɾ���� %d �ڵ㲻����\n", no);
		}
	}

	// 7.��ʾ����[����]
	public void list() {
		// �ж������Ƿ�Ϊ��
		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		// ��Ϊͷ�ڵ㣬���ܶ������������Ҫһ����������������
		HeroNode temp = head.next;
		while (true) {
			// �ж��Ƿ��������
			if (temp == null) {
				break;
			}
			// ����ڵ����Ϣ
			System.out.println(temp);
			// ��temp����
			temp = temp.next;
		}
	}
}

/**
 * ����HeroNode �� ÿ��HeroNode �������һ���ڵ�
 * 
 * @author ����
 *
 */
class HeroNode {
	public int no;
	public String name;
	public String nickname;
	public HeroNode next; // ָ����һ���ڵ�
	// ������

	public HeroNode(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}

	// Ϊ����ʾ��������������toString
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
}