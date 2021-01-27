package 树;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *         a
 *      b    c
 *    d  e  f
 * 使用队列.先进先出
 *
 * @author jialong2.li
 * @version 1.0.0, 2021/1/26-2:52 PM.
 * @since 2021/1/26-2:52 PM
 */
public class 深度遍历 {
    public static void main(String[] args) {
        TreeNode1 treeNode1 = new TreeNode1("a");
        TreeNode1 treeNode2 = new TreeNode1("b");
        TreeNode1 treeNode3 = new TreeNode1("c");
        TreeNode1 treeNode4 = new TreeNode1("d");
        TreeNode1 treeNode5 = new TreeNode1("e");
        TreeNode1 treeNode6 = new TreeNode1("f");
        treeNode1.setLeft(treeNode2);
        treeNode1.setRight(treeNode3);
        treeNode2.setLeft(treeNode4);
        treeNode2.setRight(treeNode5);
        treeNode3.setLeft(treeNode6);
        pri(treeNode1);

    }


    public static void pri(TreeNode1 treeNode1) {
        if (treeNode1 != null) {
            System.out.println(treeNode1.getValue());
            pri(treeNode1.getLeft());
            pri(treeNode1.getRight());
        }
    }

}

