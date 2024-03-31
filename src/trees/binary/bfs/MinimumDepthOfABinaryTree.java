package trees.binary.bfs;

import java.util.*;

public class MinimumDepthOfABinaryTree {
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
    int result = MinimumDepthOfABinaryTree.traverse(root);
    System.out.println(result);
  }

  private static int traverse(TreeNode root) {
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    int minDepth = 0;
    while (!queue.isEmpty()) {
        int len = 0;
        minDepth++;
        int size = queue.size();
        while( len < size) {
            TreeNode node = queue.poll();
            if(node.left != null &&  node.right != null) return minDepth;
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
            len++;
        }
    }
    return minDepth;
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
