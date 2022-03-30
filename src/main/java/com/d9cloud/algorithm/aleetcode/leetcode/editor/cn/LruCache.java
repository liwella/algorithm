//请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。 
//
// 实现 LRUCache 类： 
//
// 
// 
// 
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 ke
//y-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。 
// 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
// 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 105 
// 最多调用 2 * 105 次 get 和 put 
// 
// Related Topics 设计 哈希表 链表 双向链表 
// 👍 2060 👎 0

  
package com.d9cloud.algorithm.aleetcode.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LruCache{
    
//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

    class Node {
        private int key;
        private int data;
        private Node prev;
        private Node next;
        public Node(int key, int data) {
            this.key = key;
            this.data = data;
        }
    }

    private Map<Integer, Node> container;
    private Node head;
    private Node tail;
    private int capacity;
    private int size;

    public LRUCache(int capacity) {
        container = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        this.capacity = capacity;
        this.size = 0;
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
    }
    
    public int get(int key) {
        Node node = container.get(key);
        if (node == null) return -1;
        removeNode(node);
        addNodeAtHead(node);
        return node.data;
    }
    
    public void put(int key, int value) {
        Node node = container.get(key);
        if (node != null) {
            removeNode(node);
            node.data = value;
            addNodeAtHead(node);
            return;
        }
        Node newNode = new Node(key, value);
        container.put(key, newNode);
        if (size == capacity) {
            container.remove(tail.prev.key);
            removeNode(tail.prev);
            addNodeAtHead(newNode);
            return;
        }
        addNodeAtHead(newNode);
        size++;
    }

    private void removeNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        node.next = null;
        node.prev = null;
    }

    private void addNodeAtHead(Node node) {
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        // Solution solution = new LruCache().new Solution();
    }

}