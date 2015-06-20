package br.com.bionexo.graph;

import java.util.LinkedList;
import java.util.List;

public class BasicNode implements Node {
	
	private boolean visited;	
	private List<Edge> edgeList;
	
	public BasicNode(BasicNode node) {
		this.visited = node.isVisited();
		this.edgeList = node.getEdgeList();
	}
	
	public BasicNode() {
		edgeList = new LinkedList<Edge>();
	}
	
	public void addEdge(Node toNode, int weight) {		
		edgeList.add(new Edge(toNode, weight));		
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public List<Edge> getEdgeList() {
		return edgeList;
	}

	/*
	public void setEdgeList(List<Edge> edgeList) {
		this.edgeList = edgeList;
	}
	*/
	
	public boolean hasNeighbor(Node neighbor) {		
		for(Edge edge: edgeList) {
			if(edge.getDstNode() == neighbor) {
				return true;
			}
		}
		
		return false;
	}
	
	
	/*
	// Não é tão eficiente ficar comparando nomes, melhor comparar referencia de nós
	
	*/
	
	public Edge getEdge(GraphNode dstNode) {		
		for(Edge edge: edgeList) {
			if(edge.getDstNode() == dstNode) {
				return edge;
			}
		}
		
		return null;
	}	

}
