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
 * <p>
 * <p>
 * <p>
 * 总结下刚开始的错误:
 *
 * @author jialong2.li
 * @version 1.0.0, 2020/12/3-2:22 PM.
 * @since 2020/12/3-2:22 PM
 */
class LFUCache {
    private Map<Integer, LFUNode> data = new HashMap();
    /**
     * ---相比lru,增加一个计数器
     */
    private Map<Integer, Integer> count = new HashMap();
    private LFUNode head = new LFUNode();
    private LFUNode tail = new LFUNode();
    private int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        head.setNext(tail);
        tail.setPre(head);
    }

    public int get(int key) {
        LFUNode v = data.get(key);
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
            //---增加计数
            count.put(key, count.get(key) + 1);
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
        LFUNode v = data.get(key);
        //说明是新增的1.判断长度是否超长,如果超长,那么淘汰尾部数据
        if (v == null) {
            //数据满了 删除最后一个节点
            if (data.size() == capacity) {
                //---这里有变化,删除时,不是直接删除尾巴,而是先比较谁调用的最少,再去找谁离尾巴最近.?这里有点问题..去找的话,那就是o(n)了
                //-1
                LFUNode last = tail.getPre();
                //-2
                LFUNode lastPre = last.getPre();
                lastPre.setNext(tail);
                tail.setPre(lastPre);
                data.remove(last.getKey());
            }
            //不管满不满都要进行的操作1.插入数据 2.将数据移动到head
            LFUNode currentNode = new LFUNode(key, value);
            data.put(key, currentNode);
            //当前的上一个设置为头节点
            currentNode.setPre(head);
            //设置当前的下一个节点为oldFirst,oldFirst的下一个节点是当前节点
            LFUNode first = head.getNext();
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

class LFUNode {
    private LFUNode next;
    private LFUNode pre;
    private int value;
    private int key;

    public LFUNode(int key, int value) {
        this.value = value;
        this.key = key;
    }

    public LFUNode() {
        super();
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public LFUNode getPre() {
        return pre;
    }

    public void setPre(LFUNode pre) {
        this.pre = pre;
    }

    public LFUNode getNext() {
        return next;
    }

    public void setNext(LFUNode next) {
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
