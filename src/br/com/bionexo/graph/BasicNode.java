package br.com.bionexo.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Gabriel Nobrega de Lima
 */

public class BasicNode implements Node {

	private List<Edge> edgeList;
	
	public BasicNode(BasicNode node) {		
		this.edgeList = node.getEdgeList();
	}
	
	public BasicNode() {
		edgeList = new LinkedList<Edge>();
	}
	
	public void addEdge(Node toNode, int weight) {		
		edgeList.add(new Edge(toNode, weight));		
	}	

	public List<Edge> getEdgeList() {
		return edgeList;
	}	
	
	public boolean hasNeighbor(Node neighbor) {		
		for(Edge edge: edgeList) {
			if(edge.getDstNode() == neighbor) {
				return true;
			}
		}		
		return false;
	}
		
	public Edge getEdge(GraphNode dstNode) {		
		for(Edge edge: edgeList) {
			if(edge.getDstNode() == dstNode) {
				return edge;
			}
		}		
		return null;
	}	
	
}
