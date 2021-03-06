package com.mashibing.leetcode.link;

//206 203 24 19

/**
 * 知晓实际的节点交换会改变原链表的结构，因此需要一个辅助哨兵节点listNode指向实际链表头部
 */
public class ReverseList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    //206

    /**
     * 我们可以申请两个指针，第一个指针叫 pre，最初是指向 null 的。
     * 第二个指针 cur 指向 head，然后不断遍历 cur。
     * 每次迭代到 cur，都将 cur 的 next 指向 pre，然后 pre 和 cur 前进一位。
     * 都迭代完了(cur 变成 null 了)，pre 就是最后一个节点了。
     * @param head
     * @return
     */
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
