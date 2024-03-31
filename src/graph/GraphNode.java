package graph;

import lombok.Data;

import java.util.List;

@Data
public class GraphNode {
  private int value;
  private List<GraphNode> connectedTo;
  private List<GraphNode> connectedFrom;
}
