package com.wanli.linkedlist;
/**
 * ˫���������
 * @author ����
 *
 */
public class DoubleLinkedListDemo {
	public static void main(String[] args) {
		// ����
		// 1.�ȴ����ڵ�
		HeroNode2 hero1 = new HeroNode2(1, "�ν�", "��ʱ��");
		HeroNode2 hero2 = new HeroNode2(2, "¬����", "������");
		HeroNode2 hero3 = new HeroNode2(3, "����", "�Ƕ���");
		HeroNode2 hero4 = new HeroNode2(4, "�ֳ�", "����ͷ");
		// 2.��������
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
		// 3.���뵽����β��
		doubleLinkedList.add(hero1);
		doubleLinkedList.add(hero4);
		doubleLinkedList.add(hero2);
		doubleLinkedList.add(hero3);
		// 4.����������
		doubleLinkedList.list();
		// 5.��������
		doubleLinkedList = new DoubleLinkedList();
		// 6.����no���򣬽ڵ�ı��
		doubleLinkedList.addByOrder(hero1);
		doubleLinkedList.addByOrder(hero3);
		doubleLinkedList.addByOrder(hero2);
		doubleLinkedList.addByOrder(hero4);
		// 7.����������
		doubleLinkedList.list();
		// 8.�޸Ľڵ�Ĵ���
		HeroNode2 newHeroNode = new HeroNode2(2, "С¬", "������~~");
		doubleLinkedList.update(newHeroNode);
		// 9.����������
		doubleLinkedList.list();
		// 10.ɾ��һ���ڵ�
		doubleLinkedList.del(1);
		// 11.����������
		doubleLinkedList.list();
	}
}
/**
 * ����һ��˫���������ڹ�����ɽ�ú�
 * @author ����
 *
 */
class DoubleLinkedList {
	// 1.��ʼ��һ��ͷ�ڵ�, ͷ�ڵ㲻��ž�������ݣ�ͷ�ڵ�Ҳ���ı�
	private HeroNode2 head = new HeroNode2(0, "", "");

	// 2.���巽������ͷ�ڵ�
	public HeroNode2 getHead() {
		return head;
	}
	// 3.��ӽڵ㵽�����β��
	public void add(HeroNode2 heroNode) {
		// 3.1 ��Ϊhead�ڵ㲻�ܶ������������Ҫһ���������� temp
		HeroNode2 temp = head;
		// 3.2 ��Ϊ����ӵ�β��������Ҫ���ҵ������β��
		while (true) {
			if (temp.next == null) {// β���ڵ��nextû��ָ���¸��ڵ㣬����Ϊnull
				break;
			}
			// ���û���ҵ����, temp����
			temp = temp.next;
		}
		// 3.3 ��ʱtempΪ���һ���ڵ㣬�ڴ˽ڵ������½ڵ㣬�����½ڵ�Ҳָ��ǰһ���ڵ�
		temp.next = heroNode;
		heroNode.pre=temp;
	}	
	// 4.������ɽ�ú���no˳����ӽڵ�
	public void addByOrder(HeroNode2 heroNode) {
		// 4.1��Ϊhead�ڵ㲻�ܶ������������Ҫһ���������� temp
		HeroNode2 temp = head;
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
			// 4.4.1 ��ԭ��temp����Ľڵ�ת���½ڵ���,������ָ��
			heroNode.next = temp.next;
			if(temp.next!=null){
				temp.next.pre =heroNode;
			}
			// 4.4.2 ��temp��������½ڵ�,������ָ��
			temp.next = heroNode;
			heroNode.pre =temp;
		}
	}	
	// 5.�޸Ľڵ����Ϣ, ����no������޸ģ���no��Ų��ܸ�
	public void update(HeroNode2 newHeroNode) {
		// 5.1 ��Ϊhead�ڵ㲻�ܶ������������Ҫһ���������� temp,���ڱ�ʾ��һ���ڵ�
		HeroNode2 temp = head.next;
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
		// 6.1 ��Ϊhead�ڵ㲻�ܶ������������Ҫһ���������� temp,���ڱ�ʾ��һ���ڵ�
		HeroNode2 temp = head.next;
		// 6.2 ����flag��־�����ж��Ƿ��ҵ��ýڵ㣬Ĭ��Ϊfalse
		boolean flag = false;
		// 6.3 �ҵ�Ҫɾ���Ľڵ�
		while (true) {
			if (temp == null) {// �Ѿ�����������
				break;
			}
			if (temp.no == no) {// �ҵ�ɾ���ڵ�
				flag = true;
				break;
			}
			// ���û���ҵ����, temp����
			temp = temp.next;
		}
		// 6.4
		if (flag) {// �ҵ�
			// ����ɾ��
			temp.pre.next = temp.next;
			//��������һ���ڵ㣬�Ͳ���Ҫִ��������仰
			if(temp.next!=null){
				temp.next.pre =temp.pre;
			}				
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
		HeroNode2 temp = head.next;
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
 * ����HeroNode2 �� ÿ��HeroNode2 �������һ���ڵ�
 * @author ����
 *
 */
class HeroNode2 {
	public int no;
	public String name;
	public String nickname;
	public HeroNode2 next; // ָ����һ���ڵ�, Ĭ��Ϊnull
	public HeroNode2 pre; // ָ��ǰһ���ڵ�, Ĭ��Ϊnull
	// ������

	public HeroNode2(int no, String name, String nickname) {
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