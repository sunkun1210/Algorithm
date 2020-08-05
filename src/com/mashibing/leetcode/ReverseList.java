package com.mashibing.leetcode;

//206 203 24 19
public class ReverseList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    public ListNode reverseList(ListNode head) {
        ListNode cur = head; //当前节点
        ListNode pre = null; //前一个节点
        ListNode temp;
        while (cur!=null){
            temp=cur.next;
            cur.next=pre;
            pre=cur; //前一个节点右移到当前位置
            cur=temp;//当前右移到临时的next中
        }
        return pre;
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
                prev=curr;  //如果不等 pre右移
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
            firstNode.next = secondNode.next;//1指向3
            secondNode.next = firstNode; //2指向1
            // Reinitializing the head and prevNode for next swap
            prev = firstNode;
            curr = firstNode.next; // jump
        }
        return  sentinel.next;
    }

    //19
    /***
     * 采取双重遍历肯定是可以解决问题的，但题目要求我们一次遍历解决问题，那我们的思路得发散一下。
     * 设定双指针 p 和 q，初始都指向虚拟节点 sentinel
     * 移动 q，直到 p 与 q 之间相隔的元素个数为 n
     * 同时移动 p 与 q，直到 q 指向的为 NULL
     * 将 p 的下一个节点指向下下个节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode first = sentinel;
        ListNode second = sentinel;
        // 移动 q，直到 p 与 q 之间相隔的元素个数为 n (n+1)
        for (int i = 0; i < n+1 ; i++) {
            first = first.next;
        }
        // 同时移动 p 与 q，直到 q 指向的为 NULL
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        //将 p 的下一个节点指向下下个节点
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
        ListNode listNode1=reverseList.swapPairs(listNode);
        ListNode cur =listNode1;
        while(cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }
    }

}
