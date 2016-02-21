package br.com.bionexo.graph;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Gabriel Nobrega de Lima
 */

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

	public void addEdge(String srcNodeName, String dstNodeName, int weight) {
		Node srcNode = null;
		Node dstNode = null;

		if ((srcNode = nodeMap.get(srcNodeName)) == null) {
			srcNode = new GraphNode(srcNodeName);
			nodeMap.put(srcNodeName, srcNode);
		}

		if ((dstNode = nodeMap.get(dstNodeName)) == null) {
			dstNode = new GraphNode(dstNodeName);
			nodeMap.put(dstNodeName, dstNode);
		}

		srcNode.addEdge(dstNode, weight);
	}

	public Node getNode(String name) {
		return nodeMap.get(name);
	}

}
