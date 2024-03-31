package trees.binary.bfs;

import trees.binary.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
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
    List<List<Integer>> result = BinaryTreeLevelOrderTraversal.traverse(root);
    System.out.println(result);
  }

  public static List<List<Integer>> traverse(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
        int len = 0;
        int size = queue.size();
        List<Integer> levelResult = new ArrayList<>(size);
        while( len < size) {
            TreeNode node = queue.poll();
            levelResult.add(node.val);
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
            len++;
        }
        result.add(levelResult);
    }
    return result;
  }
}
