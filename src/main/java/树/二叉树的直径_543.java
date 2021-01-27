package 树;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * <p>
 *  
 * <p>
 * 示例 :
 * 给定二叉树
 * <p>
 * 1
 * / \
 * 2  3
 * / \
 * 4  5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 * <p>
 * 思路:
 * 和二叉树的最大深度类似.
 * 首先  一个节点的最大深度: 就是这个节点到其子树的某个叶子节点经历的最大的节点数量.
 * 一个节点的最大直径呢? 就是以这个节点为根节点,左子树的最大深度+右子树的最大深度+1.
 *
 * @author jialong2.li
 * @version 1.0.0, 2021/1/27-1:44 PM.
 * @since 2021/1/27-1:44 PM
 */
public class 二叉树的直径_543 {
    int max = 0;

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode1.setLeft(treeNode2);
        treeNode1.setRight(treeNode3);
        treeNode2.setLeft(treeNode4);
        treeNode2.setRight(treeNode5);
        treeNode3.setLeft(treeNode6);
        int max = new 二叉树的直径_543().diameterOfBinaryTree(treeNode1);
        System.out.println(max);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dsf(root);
        return max - 1;
    }

    private int dsf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxLength = dsf(root.left);
        int rightMaxLength = dsf(root.right);
        //左子树的深度+右子树的深度+1.
        max = Math.max(leftMaxLength + rightMaxLength + 1, max);
        return Math.max(leftMaxLength, rightMaxLength) + 1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }


}