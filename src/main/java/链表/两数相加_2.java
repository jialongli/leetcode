package 链表;

import java.util.Stack;

/**
 * <pre>
 * 2.两数相加
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 * </pre>
 *
 * @author jialong2.li
 * @version 1.0.0, 2021/1/28-2:26 PM.
 * @since 2021/1/28-2:26 PM
 */
public class 两数相加_2 {
    public static void main(String[] args) {
        SListNode l = new SListNode(2);
        SListNode l1 = new SListNode(4);
        SListNode l2 = new SListNode(3);
        l.next = l1;
        l1.next = l2;

        SListNode n1 = new SListNode(5);
        SListNode n2 = new SListNode(6);
        SListNode n3 = new SListNode(4);
        n1.next = n2;
        n2.next = n3;

//        SListNode result = new 两数相加_2().addTwoNumbers(l, n1);
//        System.out.println(result);
    }
//
//    public SListNode addTwoNumbers(SListNode l1, SListNode l2) {
//
//
//    }

    private Stack<Integer> getStack(SListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        SListNode tmp = listNode;
        while (tmp != null) {
            stack.push(tmp.val);
            tmp = tmp.next;
        }
        return stack;
    }

}


class SListNode {
    int val;
    SListNode next;

    SListNode() {
    }

    SListNode(int val) {
        this.val = val;
    }

    SListNode(int val, SListNode next) {
        this.val = val;
        this.next = next;
    }
}