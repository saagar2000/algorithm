package trees.binary.bfs;

import java.util.*;

public class BinaryZigzagTreeLevelOrderTraversal {
  public static void main(String[] args) {
    // 12,
    // 7, 1
    // 9, 10, 5
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    List<List<Integer>> result = BinaryZigzagTreeLevelOrderTraversal.traverse(root);
    System.out.println(result);
  }

  private static List<List<Integer>> traverse(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int len = 0;
      int size = queue.size();
      List<Integer> levelResult = new LinkedList<>();
      boolean oddOrEven = size % 2 != 0;
      while (len < size) {
        TreeNode node = queue.poll();
        if (oddOrEven) {
          levelResult.add(node.val);
        } else {
          levelResult.add(0, node.val);
        }
        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
        len++;
      }
      result.add(levelResult);
    }
    return result;
  }

  static class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int val) {
      this.val = val;
    }
  }
}
