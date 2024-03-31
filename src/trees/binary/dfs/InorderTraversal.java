package trees.binary.dfs;

import trees.binary.TreeNode;

import java.util.*;

public class InorderTraversal {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    System.out.println(inorderTraversal(root));
  }

  /**
   * Traverse to the leftmost node and remove the node at the leftmost and add to result and mark
   * the node as visited. If leftmost has right child add it to the stack and repeat the process.
   *
   * @param root
   * @return
   */
  public static List<Integer> inorderTraversal(TreeNode root) {
    if (root == null) return Collections.emptyList();
    Deque<TreeNode> stack = new ArrayDeque<>();
    List<Integer> result = new ArrayList<>();
    Set<TreeNode> visited = new HashSet<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.peek();
      if (!visited.contains(node.left) && node.left != null) {
        stack.push(node.left);
        continue;
      }
      TreeNode leftMostNode = stack.remove();
      result.add(leftMostNode.val);
      visited.add(leftMostNode);
      if (leftMostNode.right != null) {
        stack.push(leftMostNode.right);
      }
    }
    return result;
  }
}
