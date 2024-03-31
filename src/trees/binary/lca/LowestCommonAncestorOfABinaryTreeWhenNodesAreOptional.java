package trees.binary.lca;

import trees.binary.*;

public class LowestCommonAncestorOfABinaryTreeWhenNodesAreOptional {

  public static void main(String[] args) {
    Integer[] values = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
    // 1,2,3,4 // i = 1; 2i + 1 = 3, 2i + 2 = 4
    TreeNode root = Util.createTree(values);
    System.out.println(lowestCommonAncestor(0, root, 5, 4).val);
  }

  public static TreeNode lowestCommonAncestor(int level, TreeNode root, int p, int q) {
    if (root == null) {
      return null;
    }
    // determine location of p and q
    // three possible cases
    // both left, both right and left/right - find the lowest ancestor where they converge
    if (root.val == p) {
      return root;
    }

    if(root.val == q) {

    }

    TreeNode ancestorInLeft = lowestCommonAncestor(level + 1, root.left, p, q);
    TreeNode ancestorInRight = lowestCommonAncestor(level + 1, root.right, p, q);

    if (level != 0) {
      if (ancestorInRight != null && ancestorInLeft != null) {
        return root;
      }

      if (ancestorInRight != null) {
        return ancestorInRight;
      }
      return ancestorInLeft;
    }

    if (ancestorInRight != null && ancestorInLeft != null) {
      return root;
    } else {
      return null;
    }
  }
}
