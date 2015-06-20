package br.com.bionexo.graph;

public class Edge {

	private int weight;
	private GraphNode dstNode; 
	
	public Edge(GraphNode toNode, int weight) {
		this.weight = weight;		
		this.dstNode = toNode; 
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public GraphNode getDstNode() {
		return dstNode;
	}

	public void setDstNode(GraphNode dstNode) {
		this.dstNode = dstNode;
	}
	
	
}
