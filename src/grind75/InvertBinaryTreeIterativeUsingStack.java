package grind75;

import java.util.*;
import trees.binary.*;

public class InvertBinaryTreeIterativeUsingStack {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    TreeNode result = InvertBinaryTreeIterativeUsingStack.invertBinaryTree(root);
    System.out.println(result);
  }

  private static TreeNode invertBinaryTree(TreeNode treeNode) {
    Deque<TreeNode> arrayDeque = new LinkedList<>();
    arrayDeque.push(treeNode); // 4

    while (!arrayDeque.isEmpty()) {
      TreeNode node = arrayDeque.pop(); // 4

      TreeNode left = node.left; // 2
      node.left = node.right; // 7
      node.right = left; // swap

      if (node.left != null) arrayDeque.add(node.left);
      if (node.right != null) arrayDeque.add(node.right);
    }

    return treeNode;
  }
}
