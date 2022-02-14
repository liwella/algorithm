package com.d9cloud.algorithm.link;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 *
 * @author: litianyi
 * @date: Created on 2022/01/15
 */
public class LinkedList {

    private int size;

    private Node head;

    private Node tail;

    private class Node {
        private int data;
        private Node next;
    }

    public boolean add(int data) {
        size++;
        Node node = new Node();
        node.data = data;
        if (head == null) {
            head = node;
            tail = head;
            return true;
        }
        tail.next = node;
        tail = node;
        return true;
    }

    public boolean remove(int data) {
        if (head == null) {
            return false;
        }
        Node prev = null;
        Node cur = head;
        while (cur != null && cur.data != data) {
            prev = cur;
            cur = cur.next;
        }
        if (cur == null) {
            return false;
        }
        if (prev == null) {
            prev = head;
            head = head.next;
            prev.next = null;
        } else {
            prev.next = prev.next.next;
        }
        size--;
        return true;
    }

    public Integer get(int index) {
        if (size == 0 || index >= size) {
            throw new RuntimeException("超出范围！");
        }
        int curIndex = 0;
        Node cur = head;
        while (cur != null) {
            if (curIndex == index) {
                break;
            }
            curIndex++;
            cur = cur.next;
        }
        if (cur == null) {
            return null;
        } else {
            return cur.data;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(5);
        linkedList.add(4);
        linkedList.add(3);
        System.out.println("size = " + linkedList.size);
        System.out.println("index 2: " + linkedList.get(2));
        linkedList.remove(4);
        for (int i = 0; i < linkedList.size; i++) {
            System.out.println("index i: " + linkedList.get(i));
        }
    }



    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    /**
     * 环形链表 - 解法1
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        if (head == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        while (head.next != null) {
            if (set.contains(head.next)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }
    /**
     * 环形链表 - 解法2
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }



    /**
     * 合并两个有序链表 - 解法1
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode head = null, result = null;
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                if (head == null) {
                    head = result = list2;
                } else {
                    result.next = list2;
                    result = result.next;
                }
                list2 = list2.next;
            } else {
                if (result == null) {
                    head = result = list1;
                } else {
                    result.next = list1;
                    result = result.next;
                }
                list1 = list1.next;
            }
        }
        if (list1 == null) {
            while (list2 != null) {
                result.next = list2;
                result = result.next;
                list2 = list2.next;
            }
        }
        if (list2 == null) {
            while (list1 != null) {
                result.next = list1;
                result = result.next;
                list1 = list1.next;
            }
        }
        return head;
    }
    /**
     * 合并两个有序链表 - 解法2
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists2(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists2(list1, list2.next);
            return list2;
        }
    }


    /**
     * 链表中倒数第k个节点 - 解法1
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd1(ListNode head, int k) {
        int i = 0;
        ListNode tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
            i++;
        }
        int s = 0;
        while (i - s != k && head != null) {
            head = head.next;
            s++;
        }
        return head;
    }
    /**
     * 链表中倒数第k个节点 - 解法2
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode formatter = head, latter = head;
        for (int i = 1; i <= k; i++) {
            formatter = formatter.next;
        }
        while (formatter != null) {
            formatter = formatter.next;
            latter = latter.next;
        }
        return latter;
    }


    /**
     * 链表的中间节点 - 解法1
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode latter = head;
        ListNode faster = head.next;
        while (faster != null) {
            latter = latter.next;
            if (faster.next == null) {
                faster = faster.next;
            } else {
                faster = faster.next.next;
            }
        }
        return latter;
    }
}