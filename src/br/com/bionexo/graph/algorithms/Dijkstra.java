package br.com.bionexo.graph.algorithms;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import br.com.bionexo.graph.BasicNode;
import br.com.bionexo.graph.GraphNexo;
import br.com.bionexo.graph.GraphNode;
import br.com.bionexo.graph.Node;

public class Dijkstra {
		
	private GraphNexo graph;
	private List<DijkstraNode> nodeList;
	 
	
	public Dijkstra(GraphNexo graph) {
		this.graph = graph;
	}	 
	
	private void initDijkstra() {
		
		nodeList = new LinkedList<DijkstraNode>();
		
		for(Node node : graph.getNodes()) {
			nodeList.add(new DijkstraNode((GraphNode)node, 0));
		}		
	}
	
	
	public int distanceOfShortestPath(String srcNodeName, String dstNodeName) {	
		
		initDijkstra();
		
		Queue<DijkstraNode> heap = new PriorityQueue<DijkstraNode>(graph.getNumberOfNodes());		 
		
		Node srcNode = graph.getNodeFromName(srcNodeName);
		Node dstNode = graph.getNodeFromName(dstNodeName);
		 	
		DijkstraNode srcNode = nodeList.get(0); ////MUDAR
		
		heap.add(srcNode);
		
		
		while(!heap.isEmpty()) {
			DijkstraNode node = heap.poll();
			
			//node.node.getEdgeList().get(0).getWeight();
			 
		}		 
		 
		return 0;
	}
	
	
	
	protected class DijkstraNode extends GraphNode implements Comparable<DijkstraNode> {	
		
		//public Node node;
		public int distance;
		
		public DijkstraNode(GraphNode node, int distance) {
			super(node);
			//this.node = node;
			this.distance = distance;
		}

		@Override
		public int compareTo(DijkstraNode other) {
			return this.distance - other.distance;
		}		
	}
	

}
