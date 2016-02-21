package br.com.bionexo.graph;

/**
 * @author Gabriel Nobrega de Lima
 */

public class GraphNode extends BasicNode implements Comparable<GraphNode> {
	private String name;
	private int distance;
	private boolean visited;

	public GraphNode(GraphNode node) {
		super(node);
		this.name = node.getName();
		this.distance = node.getDistance();
		this.visited = node.isVisited();
	}

	public GraphNode(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public Edge getEdge(String nodeName) {
		for (Edge edge : super.getEdgeList()) {
			GraphNode gNode = (GraphNode) edge.getDstNode();
			if (gNode.getName().equals(nodeName)) {
				return edge;
			}
		}
		return null;
	}

	@Override
	public int compareTo(GraphNode other) {
		return this.distance - other.distance;
	}
}
