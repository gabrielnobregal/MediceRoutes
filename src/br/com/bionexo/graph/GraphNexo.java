package br.com.bionexo.graph;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class GraphNexo {
	
	private Map<String, Node> nodeMap;
	
	
	public GraphNexo() {
		nodeMap = new LinkedHashMap<String, Node>();
	}	
	
	public Collection<Node> getNodes() {
		return nodeMap.values();
	}
	
	public int getNumberOfNodes() {
		return nodeMap.size();
	}

	public Node getNodeFromName(String nodeName) {
		return nodeMap.get(nodeName);
	}
	
	// Todo: Poderia ser jogado para a classe ListaAdjacencia
	public void addEdge(String srcNodeName, String dstNodeName, int weight) {		
		Node srcNode = null;
		Node dstNode = null;
		

		if((srcNode = nodeMap.get(srcNodeName)) == null) {		
			srcNode = new GraphNode(srcNodeName);
			nodeMap.put(srcNodeName, srcNode);
		}		
		
		if((dstNode = nodeMap.get(dstNodeName)) == null ) {		
			dstNode = new GraphNode(dstNodeName);
			nodeMap.put(dstNodeName, dstNode);
		}		
		
		srcNode.addEdge(dstNode, weight);		
	}
	
	public Node getNode(String name) {
		return nodeMap.get(name);
	}
	
	
	/*
	public String getName(Node node) {
		Collection<Node> nodes = nodeMap.values();
		for(Node pNode : nodes) {
			if(pNode == node) {
				pNode.ge
			}
		}
	}
	
	
	public Edge getEdge(String srcNodeName, String dstNodeName) {
		
		Node srcNode = nodeMap.get(srcNodeName);
		Node dstNode = nodeMap.get(dstNodeName);
		
		Collection<Node> nodes = nodeMap.values();
		
		for(Edge edge : srcNode.getEdgeList()) {
			for(Node node : nodes) {
				if(node == dstNode)
					return edge;
			}
			
		}
		
		return null;
	}
	*/
	
	
		
	
	
}



