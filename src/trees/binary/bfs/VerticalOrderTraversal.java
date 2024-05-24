package trees.binary.bfs;

import trees.binary.*;

import java.util.*;

public class VerticalOrderTraversal {

  public static void main(String[] args) {}

  private static List<List<Integer>> verticalOrder(TreeNode root) {
    if (root == null) return Collections.emptyList();
    TreeMap<Integer, List<Integer>> columnValues = new TreeMap<>();
    Queue<Map.Entry<Integer, TreeNode>> treeNodes = new ArrayDeque<>();
    treeNodes.offer(Map.entry(0, root));
    while (!treeNodes.isEmpty()) {
      Map.Entry<Integer, TreeNode> nodeEntry = treeNodes.poll();
      int column = nodeEntry.getKey();
      TreeNode node = nodeEntry.getValue();
      columnValues.computeIfAbsent(column, _ -> new ArrayList<>()).add(node.val);
      if (node.left != null) {
        treeNodes.offer(Map.entry(column - 1, node.left));
      }
      if (node.right != null) {
        treeNodes.offer(Map.entry(column + 1, node.right));
      }
    }
    return new ArrayList<>(columnValues.values());
  }
}
