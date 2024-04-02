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
    TreeNode q = Util.dfs(root, 7);
    System.out.println(lowestCommonAncestor(p, q));
  }

  private static TreeNode lowestCommonAncestor(TreeNode p, TreeNode q) {
    Set<TreeNode> pNodes = new HashSet<>();
    recursive(p, pNodes);
    TreeNode lca = recursive(q, pNodes);
    return lca;
  }

  private static TreeNode recursive(TreeNode n, Set<TreeNode> nodes) {
    if (n.parent == null) {
      return null;
    }
    recursive(n.parent, nodes);
    if (nodes.contains(n)) {
      return n;
    } else {
      nodes.add(n);
    }
    return null;
  }
}
