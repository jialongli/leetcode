package 树;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * *         a
 *  *      b   c
 *  *    d  e  f
 * 使用队列.先进先出
 *
 * @author jialong2.li
 * @version 1.0.0, 2021/1/26-2:52 PM.
 * @since 2021/1/26-2:52 PM
 */
public class 广度遍历 {
    public static void main(String[] args) {
        Queue<TreeNode1> s = new ArrayDeque<>();
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
        s.add(treeNode1);
        TreeNode1 tmp = s.poll();
        while (tmp != null) {
            System.out.println(tmp.getValue());
            if (tmp.getLeft() != null) {
                s.add(tmp.getLeft());
            }
            if (tmp.getRight() != null) {
                s.add(tmp.getRight());
            }
            tmp = s.poll();
        }

    }


}

class TreeNode1 {
    private String value;
    private TreeNode1 left;
    private TreeNode1 right;

    public TreeNode1(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TreeNode1 getLeft() {
        return left;
    }

    public void setLeft(TreeNode1 left) {
        this.left = left;
    }

    public TreeNode1 getRight() {
        return right;
    }

    public void setRight(TreeNode1 right) {
        this.right = right;
    }
}