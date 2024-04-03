package grind75;

import trees.binary.*;

public class BalancedBinaryTree {
    public static void main(String[] args){
        Integer[] values = {1,2,null,3,null,4,null,5};
        //            3
        //        5,      1,
        //     6    2   0   8
        //        7   4
        // 1,2,3,4 // i = 1; 2i + 1 = 3, 2i + 2 = 4
        TreeNode root = Util.createTree(values);
        System.out.println(height(root) > 0);
    }

    private static int height(TreeNode node) {
        if(node == null) return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        if(leftHeight == -1) {
            return -1;
        }
        if(rightHeight == -1) {
            return -1;
        }
        if(Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
