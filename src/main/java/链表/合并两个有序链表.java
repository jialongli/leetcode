package 链表;

/**
 * <pre>
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 *
 * 示例 1：
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 示例 2：
 *
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *  
 *
 * 提示：
 *
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 *
 * </pre>
 *
 * @author jialong2.li
 * @version 1.0.0, 2021/1/27-2:55 PM.
 * @since 2021/1/27-2:55 PM
 */
public class 合并两个有序链表 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(7);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        ListNode l21 = new ListNode(2);
        ListNode l22 = new ListNode(4);
        ListNode l23 = new ListNode(6);
        ListNode l24 = new ListNode(8);
        l21.next = l22;
        l22.next = l23;
        l23.next = l24;

        ListNode r = new 合并两个有序链表().mergeTwoLists(l1, l21);
        System.out.println(r);

    }

    /**
     * 合并两个有序链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        //当出现有一个队列为null了,那么直接把另一个放到队尾即可
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return head.next;
    }
}


