package grind75;

import trees.binary.*;

import java.util.*;

public class InvertBinaryTreeIterativeUsingQueue {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    TreeNode result = InvertBinaryTreeIterativeUsingQueue.invertBinaryTree(root);
    System.out.println(result);
  }

  private static TreeNode invertBinaryTree(TreeNode treeNode) {
    Queue<TreeNode> arrayDeque = new LinkedList<>();
    arrayDeque.add(treeNode); // 4

    while (!arrayDeque.isEmpty()) {
      TreeNode node = arrayDeque.poll(); // 4

      TreeNode left = node.left; // 2
      node.left = node.right; // 7
      node.right = left; // swap

      if (node.left != null) arrayDeque.add(node.left);
      if (node.right != null) arrayDeque.add(node.right);
    }

    return treeNode;
  }
}
