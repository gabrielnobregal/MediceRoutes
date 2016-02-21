package br.com.bionexo.graph;

/**
 * @author Gabriel Nobrega de Lima
 */

public class Edge {

	private int weight;
	private Node dstNode; 
	
	public Edge(Node toNode, int weight) {
		this.weight = weight;		
		this.dstNode = toNode; 
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Node getDstNode() {
		return dstNode;
	}

	public void setDstNode(Node dstNode) {
		this.dstNode = dstNode;
	}
	
	
}
