package trees.binary.dfs;

import trees.binary.TreeNode;

import java.util.*;

public class PostOrderTraversal {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    System.out.println(postOrderTraversal(root));

    /*
                root 12
            //           \\
          left 7        right 1
          //           //  \\
       left 9        left 10 right 5
    */

    // 9, 7, 10, 5, 1, 12
  }

  private static List<Integer> postOrderTraversal(TreeNode root) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    List<Integer> results = new ArrayList<>();
    Set<TreeNode> visited = new HashSet<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.peek();
      if (!visited.contains(node.left) && node.left != null) {
        stack.push(node.left);
        continue;
      }
      if (!visited.contains(node.right) && node.right != null) {
        stack.push(node.right);
        continue;
      }
      TreeNode leaf = stack.remove();
      results.add(leaf.val);
      visited.add(leaf);
    }
    return results;
  }
}
