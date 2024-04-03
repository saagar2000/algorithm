package trees.binary.lca;

import trees.binary.*;

import java.util.*;

public class LowestCommonAncestorOfABinaryTreeIII {
  public static void main(String[] args) {
    Integer[] values = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
    //            3
    //        5,      1,
    //     6    2   0   8
    //        7   4
    // 1,2,3,4 // i = 1; 2i + 1 = 3, 2i + 2 = 4
    TreeNode root = Util.createTree(values);
    TreeNode p = Util.dfs(root, 1);
    TreeNode q = Util.dfs(root, 88);
    System.out.println(lowestCommonAncestor(p, q).val);
  }

  private static TreeNode lowestCommonAncestor(TreeNode p, TreeNode q) {
    Set<Integer> pNodes = new HashSet<>();
    recursive(p, pNodes);
    return recursive(q, pNodes);
  }

  private static TreeNode recursive(TreeNode n, Set<Integer> nodes) {
    if (n.parent == null) {
      return null;
    }
    if (nodes.contains(n.parent.val)) {
      return n.parent;
    } else {
      nodes.add(n.parent.val);
    }
    return recursive(n.parent, nodes);
  }
}
