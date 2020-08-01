package com.mashibing.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * ������δʹ��
 * map��key���ǻ��ɵ�key
 * value������ʹ�� ָ�������Node�ڵ�
 */
public class LRUCache{

    //����˫������ڵ�
    private class ListNode {
        int key;
        int val;
        ListNode pre;
        ListNode next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            pre = null;
            next = null;
        }
    }

    private int capacity;
    private Map<Integer, ListNode> map;     //key->node
    private ListNode head;  //dummy head
    private ListNode tail;  //dummy tail

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        ListNode node = map.get(key);
        //�Ȱ�����ڵ�ɾ�����ٽӵ�β��
        node.pre.next = node.next;
        node.next.pre = node.pre;
        moveToTail(node);

        return node.val;
    }

    public void put(int key, int value) {
        //ֱ�ӵ�����ߵ�get������������ڣ�������get�ڲ����ƶ���β�ͣ��������ƶ�һ��,ֱ���޸�ֵ����
        if (get(key) != -1) {
            map.get(key).val = value;
            return;
        }
        //�����ڣ�newһ������,���������������ͷȥ��
        ListNode node = new ListNode(key, value);
        map.put(key, node);
        moveToTail(node);

        if (map.size() > capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.pre = head;
        }
    }

    private void moveToTail(ListNode node) {
        node.pre = tail.pre;
        tail.pre = node;
        node.pre.next = node;
        node.next = tail;
    }
}



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

