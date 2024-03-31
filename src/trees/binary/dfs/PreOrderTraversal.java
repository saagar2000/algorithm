package trees.binary.dfs;

import trees.binary.TreeNode;

import java.util.*;

public class PreOrderTraversal {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
     /*
                       root 12
                 //              \\
              left 7              right 1
              //     \\          //      \\
              left 9   right     left 10 right 5
      */

    System.out.println(preOrderTraversal(root));
  }

  private static List<Integer> preOrderTraversal(TreeNode root) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    List<Integer> results = new ArrayList<>();
    if(root == null) return Collections.emptyList();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      if(node.right != null) stack.push(node.right);
      if(node.left != null) stack.push(node.left);
      results.add(node.val);
    }
    return results;
  }
}
