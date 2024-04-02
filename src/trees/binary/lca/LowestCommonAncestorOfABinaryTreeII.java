package trees.binary.lca;

import trees.binary.*;

public class LowestCommonAncestorOfABinaryTreeII {

  public static void main(String[] args) {
    Integer[] values = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
    //            3
    //        5,      1,
    //     6    2   0   8
    //        7   4
    // 1,2,3,4 // i = 1; 2i + 1 = 3, 2i + 2 = 4
    TreeNode root = Util.createTree(values);
    Integer[] pValues = {1, 0, 8};
    Integer[] qValues = {2, 7, 4};
    TreeNode p1 = Util.createTree(pValues);
    TreeNode q1 = Util.createTree(qValues);
    System.out.println(lowestCommonAncestor(root, p1, q1));
    System.out.println(lowestCommonAncestor(root, p1, new TreeNode(9)));
    System.out.println(lowestCommonAncestor(root, new TreeNode(9), q1));
    System.out.println(lowestCommonAncestor(root, new TreeNode(9), new TreeNode(5)));
  }

  private static TreeNode lowestCommonAncestor(TreeNode current, TreeNode p, TreeNode q) {
    TreeNode result = LowestCommonAncestorOfABinaryTree.findLca(current, p, q);
    if (result == null) return null;
    if (result.equals(p)) {
      return LowestCommonAncestorOfABinaryTree.findLca(p, q, q) != null ? p : null;
    } else if (result.equals(q)) {
      return LowestCommonAncestorOfABinaryTree.findLca(q, p, p) != null ? q : null;
    }
    return result;
  }
}
