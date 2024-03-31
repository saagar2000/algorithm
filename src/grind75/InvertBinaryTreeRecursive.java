package grind75;

import java.util.*;
import trees.binary.*;

public class InvertBinaryTreeRecursive {
    
	public static void main(String [] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        TreeNode result = InvertBinaryTreeRecursive.invertBinaryTree(root);
        System.out.println(result);
	}
	
	private static TreeNode invertBinaryTree(TreeNode treeNode) {
       if(treeNode == null) {
           return null;
       }
       TreeNode leftNode = invertBinaryTree(treeNode.left);
       TreeNode rightNode = invertBinaryTree(treeNode.right);
       treeNode.right = leftNode;
       treeNode.left = rightNode;
       return treeNode;
	}
}
