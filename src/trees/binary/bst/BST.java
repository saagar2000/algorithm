package trees.binary.bst;

import trees.binary.TreeNode;

public class BST {

  public static void main(String[] args) {
    int[] keys = {15, 10, 20, 8, 12, 16, 25};
    TreeNode root = null;
    for (int key : keys) {
      root = insertIteratively(root, key);
    }
    /*System.out.println(min(root));
    System.out.println(max(root));
    System.out.println(search(root, 20));
    traverse(root);*/
    System.out.println(
        inOrderSuccessor(root, new TreeNode(20)));
  }

  public static TreeNode insertRecursively(TreeNode root, int key) {
    if (root == null) {
      return new TreeNode(key);
    }
    if (key < root.val) {
      root.left = insertRecursively(root.left, key);
    } else {
      root.right = insertRecursively(root.right, key);
    }
    return root;
  }

  public static TreeNode insertIteratively(TreeNode root, int key) {
    if (root == null) {
      return new TreeNode(key);
    }
    TreeNode curr = root;
    TreeNode parent = null;
    while (curr != null) {
      parent = curr;
      if (key > curr.val) {
        curr = curr.right;
      } else {
        curr = curr.left;
      }
    }
    TreeNode newNode = new TreeNode(key);
    if (key < parent.val) {
      parent.left = newNode;
    } else {
      parent.right = newNode;
    }
    return root;
  }

  public static TreeNode search(TreeNode root, int key) {
    if (root == null || root.val == key) return root;
    return key > root.val ? search(root.right, key) : search(root.left, key);
  }

  public static TreeNode min(TreeNode root) {
    if(root == null) return new TreeNode();
    if(root.left == null) return root;
    return min(root.left);
  }

  public static int max(TreeNode root) {
    if(root == null) return -1;
    if(root.right == null) return root.val;
    return max(root.right);
  }

  public static void traverse(TreeNode root) {
    if (root != null) {
      traverse(root.left);
      System.out.println(root.val);
      traverse(root.right);
    }
  }

  public static TreeNode inOrderSuccessor(TreeNode root, TreeNode key) {
    if (key.right != null) {
      return min(key.right);
    }
    TreeNode successor = null;
    TreeNode rootm = root;
    while (rootm.val != key.val) {
      if (key.val > rootm.val) {
        rootm = rootm.right;
      } else {
        successor = rootm;
        rootm = rootm.left;
      }
    }
    return successor;
  }

  /*public static void delete(TreeNode treeNode, int key) {
    TreeNode successor = null;
    while (rootm.val != key.val) {
      if (key.val > rootm.val) {
        rootm = rootm.right;
      } else {
        successor = rootm;
        rootm = rootm.left;
      }
    }
  }*/
}
