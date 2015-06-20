package br.com.bionexo.graph;

import java.util.List;

public interface Node {
	
	public void addEdge(Node toNode, int weight);
	public boolean isVisited();
	public List<Edge> getEdgeList();
	
}
