package 树;

/**
 * *         a
 * *      b    c
 * *    d  e  f
 *
 * @author jialong2.li
 * @version 1.0.0, 2021/1/26-3:48 PM.
 * @since 2021/1/26-3:48 PM
 */
public class 求深度 {
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

        System.out.println(getMaxLength(null));
    }

    public static int getMaxLength(TreeNode1 treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return Math.max(getMaxLength(treeNode.getLeft()), getMaxLength(treeNode.getRight())) + 1;
    }
}
