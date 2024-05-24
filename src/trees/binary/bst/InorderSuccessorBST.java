package trees.binary.bst;

import trees.binary.*;

import static trees.binary.bst.BST.insertIteratively;

public class InorderSuccessorBST {

    public static void main(String[] args){

        int[] keys = {15, 10, 20, 8, 12, 16, 25};
        TreeNode root = null;
        for (int key : keys) {
            root = insertIteratively(root, key);
        }

        TreeNode p = new TreeNode(10);
        TreeNode successor = null;
        while(root != null) {
            if(root.val <= p.val) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }
        System.out.println(successor);

    }

}
