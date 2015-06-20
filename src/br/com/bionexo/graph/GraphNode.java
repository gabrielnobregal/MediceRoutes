package br.com.bionexo.graph;

import java.util.LinkedList;
import java.util.List;

public class GraphNode extends BasicNode {
	
	private String name;	
	private boolean visited;	
	private List<Edge> edgeList;
	
	
	public GraphNode(String name) {
		edgeList = new LinkedList<Edge>();
		this.name = name;
	}
		
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void addEdge(GraphNode toNode, int weight) {		
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

	public void setEdgeList(List<Edge> edgeList) {
		this.edgeList = edgeList;
	}
	
	public boolean hasNeighbor(GraphNode neighbor) {		
		for(Edge edge: edgeList) {
			if(edge.getDstNode() == neighbor) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean hasNeighbor(String nodeName) {		
		for(Edge edge: edgeList) {
			if(edge.getDstNode().getName().equals(nodeName)) {
				return true;
			}
		}
		
		return false;
	}
	
	// Não é tão eficiente ficar comparando nomes, melhor comparar referencia de nós
	public Edge getEdge(String nodeName) {		
		for(Edge edge: edgeList) {
			if(edge.getDstNode().getName().equals(nodeName)) {
				return edge;
			}
		}
		
		return null;
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
