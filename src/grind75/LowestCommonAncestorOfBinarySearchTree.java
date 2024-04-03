package grind75;

import trees.binary.*;

public class LowestCommonAncestorOfBinarySearchTree {
  public static void main(String[] args) {
    Integer[] values = {6,2,8,0,4,7,9,null,null,3,5};
    //            6
    //       2,       8,
    //     0   4    7   9
    //        3 5
    // 1,2,3,4 // i = 1; 2i + 1 = 3, 2i + 2 = 4
    TreeNode root = Util.createTree(values);
    Integer[] pValues = {0};
    Integer[] qValues = {4, 3, 5};
    TreeNode p1 = Util.createTree(pValues);
    TreeNode q1 = Util.createTree(qValues);
    System.out.println(lowestCommonAncestor(root, p1, q1).val);
  }

  public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null) {
      return null;
    }
    if(p.val < root.val && q.val < root.val) {
      return lowestCommonAncestor(root.left, p, q);
    } else if(q.val > root.val && p.val > root.val) {
      return lowestCommonAncestor(root.right, p, q);
    }
    return root;
  }
}
