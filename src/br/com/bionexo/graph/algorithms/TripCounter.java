package br.com.bionexo.graph.algorithms;

import java.util.List;
import java.util.Stack;

import br.com.bionexo.graph.Edge;
import br.com.bionexo.graph.GraphNexo;
import br.com.bionexo.graph.GraphNexoException;
import br.com.bionexo.graph.GraphNode;


public class TripCounter {
	
	/*
	private GraphNexo graph;
	
	public TripCounter(GraphNexo graph) {
		this.graph = graph;
	}
	*/

	public static int getNumberOfTripsWithMaxStops(GraphNexo graph, String srcNodeName, String dstNodeName, int numberOfStops) {
		return getNumberOfTrips(graph, srcNodeName, dstNodeName, numberOfStops, false);
	}
	
	public static int getNumberOfTripsWithExactStops(GraphNexo graph, String srcNodeName, String dstNodeName, int numberOfStops) throws GraphNexoException {
		return getNumberOfTrips(graph, srcNodeName, dstNodeName, numberOfStops, true);
	}
	
	private static int getNumberOfTrips(GraphNexo graph, String srcNodeName, String dstNodeName, int numberOfStops, boolean onlyEqualStops) throws GraphNexoException {
		
		GraphNode srcNode, dstNode;
		
		if((srcNode = (GraphNode) graph.getNode(srcNodeName)) == null || (dstNode = (GraphNode) graph.getNode(dstNodeName)) == null ) {		
			throw new GraphNexoException("Nó " + srcNodeName + " ou " + dstNodeName + " não pertence ao grafo.");
		}		
		
		Stack<TripNode> stack = new Stack<TripNode>();
		
		
		stack.push(new TripNode((GraphNode)srcNode, 0, srcNodeName));
		int tripCount = 0;
		
		while(!stack.isEmpty()) {		
			
			TripNode tripNode = stack.pop();
			
			if(tripNode.hasNode(dstNode) && tripNode.count != 0) {				
				if(onlyEqualStops) {
					if(numberOfStops == tripNode.count) {
						tripCount++;
						System.out.println("Path:" + tripNode.path);
					} 					
				} else {
					tripCount++;
					System.out.println("Path:" + tripNode.path);
				}
			}			
			
			
			if(tripNode.count < numberOfStops) {
				List<Edge> edges = tripNode.getEdgeList();
				
				for(Edge edge : edges) {
					GraphNode  edgeDstNode = (GraphNode)edge.getDstNode();
					stack.push(new TripNode(edgeDstNode, tripNode.count+1, tripNode.path + edgeDstNode.getName()));
				}
			}			
			
		}
		
		
		
		return tripCount;
	}
	

	protected static class TripNode extends GraphNode {
		
		public int count;
		public String path;
		
		public TripNode(GraphNode node, int count, String path) {			
			super(node);
			this.count = count;
			this.path = path;
		}
		
		public boolean hasNode(GraphNode node) {
			return super.getName().equals(node.getName());
		}
	}
		
}
