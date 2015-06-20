package br.com.bionexo.graph;


public class GraphNode extends BasicNode {
	private String name;	
	
	public GraphNode(GraphNode node) {
		super(node);
		this.name = node.getName();
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

		
	public Edge getEdge(String nodeName) {		
		for(Edge edge: super.getEdgeList()) {
			GraphNode gNode = (GraphNode)edge.getDstNode();
			if(gNode.getName().equals(nodeName)) {
				return edge;
			}
		}
		
		return null;
	}
	/*
	public boolean hasNeighbor(String nodeName) {		
		
		for(Edge edge: super.getEdgeList()) {
			if(edge.getDstNode().getName().equals(nodeName)) {
				return true;
			}
		}
		
		return false;
	}	
	*/
}
