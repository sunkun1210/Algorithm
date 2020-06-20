package com.mashibing.linkedlist;

public class Node {
	int value;
	Node next;
	
	Node(int value) {
		this.value = value;
	}

	/***
	 * 链表反转：反转函数一定有返回值，返回值是新header
	 * 视频34分钟
	 * @return
	 */
	public static Node reverseLinkList(Node head){
			Node pre=null;
			Node next=null;
			while(head!=null){
				next=head.next;

				head.next=pre;
				pre=head;

				head=next;
			}
			return pre;
	}


	@Override
	public String toString() {
		return " "+value+ " ";
	}
	
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		n1.next = n2;
		n2.next = n3;
		
		Node n = n1;
		while(n != null) {
			System.out.print(n);
			n = n.next;
		}
	}
}
