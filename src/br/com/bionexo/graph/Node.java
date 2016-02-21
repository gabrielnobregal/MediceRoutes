package br.com.bionexo.graph;

import java.util.List;

/**
 * @author Gabriel Nobrega de Lima
 */

public interface Node {
	
	public void addEdge(Node toNode, int weight);
	public List<Edge> getEdgeList();

}
