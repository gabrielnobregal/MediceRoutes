package br.com.bionexo.graph;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class GraphNexo {
	
	private Map<String, GraphNode> nodeMap;
	
	public GraphNexo() {
		nodeMap = new LinkedHashMap<String, GraphNode>();
	}	
	
	public Collection<GraphNode> getNodes() {
		return nodeMap.values();
	}
	
	public int getNumberOfNodes() {
		return nodeMap.size();
	}

	public GraphNode getNodeFromName(String nodeName) {
		return nodeMap.get(nodeName);
	}
	
	// Todo: Poderia ser jogado para a classe ListaAdjacencia
	public void addEdge(String srcNodeName, String dstNodeName, int weight) {		
		GraphNode srcNode = null;
		GraphNode dstNode = null;
		

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
	
	// Grafo é uma estrutura, ela poderia conter este algoritmo?????
	public int getPathDistance(String ... nodeNames ) throws GraphNexoException {
		
		if(nodeNames == null || nodeNames.length == 0) {
			throw new GraphNexoException("Caminho inválido.");
		}
		
		GraphNode node; 
		
		// Obtenho nó atraves do hash
		if( (node = nodeMap.get(nodeNames[0])) == null) {
			throw new GraphNexoException("Nó '" + nodeNames[0]  + "' inicial não encontrado.");
		}
				
		Edge edge;		
		int distance = 0;
		
		for(int i=1; i<nodeNames.length; i++) {			
			
			edge = node.getEdge(nodeNames[i]);	
			
			if(edge == null) {
				throw new GraphNexoException("Não existe aresta entre " + nodeNames[i-1] + " e " + nodeNames[i]);
			}
			
			distance += edge.getWeight();			
			node = edge.getDstNode();			
		}		
		
		return distance;
	}
	
	
	public int getNumberOfTripsWithMaxStops(String srcNodeName, String dstNodeName, int numberOfStops) {
		return getNumberOfTrips(srcNodeName, dstNodeName, numberOfStops, false);
	}
	
	public int getNumberOfTripsWithExactStops(String srcNodeName, String dstNodeName, int numberOfStops) throws GraphNexoException {
		return getNumberOfTrips(srcNodeName, dstNodeName, numberOfStops, true);
	}
	
	private int getNumberOfTrips(String srcNodeName, String dstNodeName, int numberOfStops, boolean onlyEqualStops) throws GraphNexoException {
		
		GraphNode srcNode, dstNode;
		
		if((srcNode = nodeMap.get(srcNodeName)) == null || (dstNode = nodeMap.get(dstNodeName)) == null ) {		
			throw new GraphNexoException("Nó " + srcNodeName + " ou " + dstNodeName + " não pertence ao grafo.");
		}		
		
		Stack<TripNode> stack = new Stack<TripNode>();
		
		
		stack.push(new TripNode(srcNode, 0, srcNodeName));
		int tripCount = 0;
		
		while(!stack.isEmpty()) {		
			
			TripNode tripNode = stack.pop();
			
			if(tripNode.node == dstNode && tripNode.count != 0) {				
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
				List<Edge> edges = tripNode.node.getEdgeList();
				
				for(Edge edge : edges) {
					stack.push(new TripNode(edge.getDstNode(), tripNode.count+1,tripNode.path + edge.getDstNode().getName()));
				}
			}			
			
		}
		
		
		
		return tripCount;
	}
	

	protected class TripNode {
		private GraphNode node;
		private int count;
		private String path;
		
		public TripNode(GraphNode node, int count, String path) {
			super();
			this.node = node;
			this.count = count;
			this.path = path;
		}
		
		
	}
	
}



