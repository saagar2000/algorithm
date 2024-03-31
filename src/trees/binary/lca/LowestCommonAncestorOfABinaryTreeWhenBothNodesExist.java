package trees.binary.lca;


import trees.binary.*;

public class LowestCommonAncestorOfABinaryTreeWhenBothNodesExist {

  public static void main(String[] args) {
    Integer[] values = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
    // 1,2,3,4 // i = 1; 2i + 1 = 3, 2i + 2 = 4
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
