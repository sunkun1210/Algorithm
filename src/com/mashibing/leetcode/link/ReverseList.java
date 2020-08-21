package com.mashibing.leetcode.link;

//206 203 24 19

/**
 * ֪��ʵ�ʵĽڵ㽻����ı�ԭ�����Ľṹ�������Ҫһ�������ڱ��ڵ�listNodeָ��ʵ������ͷ��
 */
public class ReverseList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    //206

    /**
     * ���ǿ�����������ָ�룬��һ��ָ��� pre�������ָ�� null �ġ�
     * �ڶ���ָ�� cur ָ�� head��Ȼ�󲻶ϱ��� cur��
     * ÿ�ε����� cur������ cur �� next ָ�� pre��Ȼ�� pre �� cur ǰ��һλ��
     * ����������(cur ��� null ��)��pre �������һ���ڵ��ˡ�
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode cur = head; //��ǰ�ڵ�
        ListNode pre = null; //ǰһ���ڵ�
        ListNode temp;
        while (cur!=null){
            temp=cur.next;
            cur.next=pre;
            pre=cur; //ǰһ���ڵ����Ƶ���ǰλ��
            cur=temp;//��ǰ���Ƶ���ʱ��next��
        }
        return pre;
    }
    public boolean hasCycle(ListNode head) {
        if (head==null||head.next==null){
            return false;
        }
        ListNode slow=head;
        ListNode fast=head.next;
        while (slow!=fast){
            if (fast.next==null||fast.next.next==null){
                return false;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return true;
    }
    ListNode init(){
        ListNode listNode1= new ListNode(1);
        ListNode listNode2= new ListNode(2);
        ListNode listNode3= new ListNode(3);
        ListNode listNode4= new ListNode(4);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        return listNode1;
    }
    //203
    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode prev = sentinel, curr = head;
        while (curr != null) {
            if (curr.val == val){
                prev.next = curr.next;
            }else{
                prev=curr;  //������� pre����
            }
            curr = curr.next;
        }
        return sentinel.next; // return head TODO
    }
    //24
    public ListNode swapPairs(ListNode head) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode prev= sentinel , curr = head;//TODO
        while(curr!=null&&curr.next!=null){
            // Nodes to be swapped
            ListNode firstNode = curr;
            ListNode secondNode = curr.next;
            // Swapping
            prev.next = secondNode;
            firstNode.next = secondNode.next;//1ָ��3
            secondNode.next = firstNode; //2ָ��1
            // Reinitializing the head and prevNode for next swap
            prev = firstNode;
            curr = firstNode.next; // jump
        }
        return  sentinel.next;
    }

    //19
    /***
     * ��ȡ˫�ر����϶��ǿ��Խ������ģ�����ĿҪ������һ�α���������⣬�����ǵ�˼·�÷�ɢһ�¡�
     * �趨˫ָ�� p �� q����ʼ��ָ������ڵ� sentinel
     * �ƶ� q��ֱ�� p �� q ֮�������Ԫ�ظ���Ϊ n
     * ͬʱ�ƶ� p �� q��ֱ�� q ָ���Ϊ NULL
     * �� p ����һ���ڵ�ָ�����¸��ڵ�
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode first = sentinel;
        ListNode second = sentinel;
        // �ƶ� q��ֱ�� p �� q ֮�������Ԫ�ظ���Ϊ n (n+1)
        for (int i = 0; i < n+1 ; i++) {
            first = first.next;
        }
        // ͬʱ�ƶ� p �� q��ֱ�� q ָ���Ϊ NULL
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        //�� p ����һ���ڵ�ָ�����¸��ڵ�
        second.next = second.next.next;
       // return head; TODO
        return sentinel.next;
    }
    //160
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            if (pA == null){
                pA=headB;
            }else {
                pA=pA.next;
            }
         //   pA = (pA == null ? headB : pA.next);
            pB = (pB == null ? headA : pB.next);
        }
        return pA;
    }

    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        ListNode listNode = reverseList.init();
        ListNode listNode1=reverseList.swapPairs2(listNode);
        ListNode cur =listNode1;
        while(cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }
    }
    public ListNode swapPairs2(ListNode head) {
        ListNode sentinel=new ListNode(-1);
        sentinel.next=head;

        ListNode pre=sentinel;
        while (pre!=null&&pre.next!=null){
            ListNode node1=pre.next;
            ListNode node2=node1.next;
            ListNode nex=node2.next;

            node2.next=node1;
            node1.next=nex;

            pre.next=node2;////////////????????????TODO

            pre=node1;
        }
        return sentinel.next;
    }


}