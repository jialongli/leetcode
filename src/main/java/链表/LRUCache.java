package 链表;

import java.util.HashMap;
import java.util.Map;

/**
 * 146题
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 * <p>
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *  
 * <p>
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 *
 *
 * 总结下刚开始的错误:
 *
 * @author jialong2.li
 * @version 1.0.0, 2020/12/3-2:22 PM.
 * @since 2020/12/3-2:22 PM
 */
class LRUCache {
    private Map<Integer, Node> data = new HashMap();
    private Node head = new Node();
    private Node tail = new Node();
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.setNext(tail);
        tail.setPre(head);
    }

    public int get(int key) {
        Node v = data.get(key);
        if (v == null) {
            return -1;
        } else {
            //注意这里也需要移动node到头
            v.getNext().setPre(v.getPre());
            v.getPre().setNext(v.getNext());
            //2.把当前节点移动到头节点
            v.setNext(head.getNext());
            v.setPre(head);
            v.getNext().setPre(v);
            head.setNext(v);
            return v.getValue();
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1);
        lruCache.put(2, 1);
        System.out.println(lruCache.get(2));
        lruCache.put(3, 2);
        System.out.println(lruCache.get(2));


    }

    public void put(int key, int value) {
        Node v = data.get(key);
        //说明是新增的1.判断长度是否超长,如果超长,那么淘汰尾部数据
        if (v == null) {
            //数据满了 删除最后一个节点
            if (data.size() == capacity) {
                //-1
                Node last = tail.getPre();
                //-2
                Node lastPre = last.getPre();
                lastPre.setNext(tail);
                tail.setPre(lastPre);
                data.remove(last.getKey());
            }
            //不管满不满都要进行的操作1.插入数据 2.将数据移动到head
            Node currentNode = new Node(key, value);
            data.put(key, currentNode);
            //当前的上一个设置为头节点
            currentNode.setPre(head);
            //设置当前的下一个节点为oldFirst,oldFirst的下一个节点是当前节点
            Node first = head.getNext();
            currentNode.setNext(first);
            first.setPre(currentNode);
            head.setNext(currentNode);
        } else {
            //说明是已有数据,不会涉及到数据淘汰,只涉及到节点移动.
            //1.把当前节点前后节点处理了
            v.getNext().setPre(v.getPre());
            v.getPre().setNext(v.getNext());
            //2.把当前节点移动到头节点
            v.setNext(head.getNext());
            v.setPre(head);
            v.getNext().setPre(v);
            head.setNext(v);
            v.setValue(value);
        }
    }
}

class Node {
    private Node next;
    private Node pre;
    private int value;
    private int key;

    public Node(int key, int value) {
        this.value = value;
        this.key = key;
    }

    public Node() {
        super();
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
