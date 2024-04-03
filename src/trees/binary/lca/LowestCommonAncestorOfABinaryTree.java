package trees.binary.lca;

import trees.binary.*;

public class LowestCommonAncestorOfABinaryTree {

  public static void main(String[] args) {
    Integer[] values = {6, 5, 4, 3, null, null, 2, null, 7, null, null, null, null, 1};
    //            3
    //        5,      1,
    //     6    2   0   8
    //        7   4
    // 1,2,3,4 // i = 1; 2i + 1 = 3, 2i + 2 = 4
    TreeNode root = Util.createTree(values);
    Integer[] pValues = {3, null, 7};
    Integer[] qValues = {4, null, 2, null, null, 1};
    TreeNode p = Util.createTree(pValues);
    TreeNode q = Util.createTree(qValues);
    System.out.println(findLca(root, p, q));
  }

  public static TreeNode findLca(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }
    // determine location of p and q
    // three possible cases
    // both left, both right and left/right - find the lowest ancestor where they converge
    if (root.equals(p) || root.equals(q)) {
      return root;
    }

    TreeNode ancestorInLeft = findLca(root.left, p, q);
    TreeNode ancestorInRight = findLca(root.right, p, q);

    if (ancestorInRight != null && ancestorInLeft != null) {
      return root;
    }

    if (ancestorInRight != null) {
      return ancestorInRight;
    }
    return ancestorInLeft;
  }
}
