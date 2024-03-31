package grind75;

import trees.binary.*;

public class LowestCommonAncestorOfBinarySearchTree {
  public static void main(String[] args) {
    Integer[] values = {1, 2};
    TreeNode root = Util.createTree(values);
    System.out.println(lowestCommonAncestor(root, 1, 2).val);
  }

  public static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
    if (root == null) {
      return null;
    }
    // determine location of p and q
    // three possible cases
    // both left, both right and left/right - find the lowest ancestor where they converge
    if (root.val == p || root.val == q) {
      return root;
    }

    TreeNode ancestorInLeft = lowestCommonAncestor(root.left, p, q);
    TreeNode ancestorInRight = lowestCommonAncestor(root.right, p, q);

    if (ancestorInRight != null && ancestorInLeft != null) {
      return root;
    }

    if (ancestorInRight != null) {
      return ancestorInRight;
    }
    return ancestorInLeft;
  }
}
