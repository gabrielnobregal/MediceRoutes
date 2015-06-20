package br.com.bionexo.graph.algorithms;

import br.com.bionexo.graph.Edge;
import br.com.bionexo.graph.GraphNexo;
import br.com.bionexo.graph.GraphNexoException;
import br.com.bionexo.graph.GraphNode;
import br.com.bionexo.graph.Node;

public class DistanceMensure {


	public static int getPathDistance(GraphNexo graph, String ... nodeNames ) throws GraphNexoException {
		
		if(nodeNames == null || nodeNames.length == 0) {
			throw new GraphNexoException("Caminho inválido.");
		}
		
		Node node; 
		
		// Obtenho nó atraves do hash
		if( (node = graph.getNode(nodeNames[0])) == null) {
			throw new GraphNexoException("Nó '" + nodeNames[0]  + "' inicial não encontrado.");
		}
				
		Edge edge;		
		int distance = 0;
		
		for(int i=1; i<nodeNames.length; i++) {			
			GraphNode p = (GraphNode)node;
			
			edge = p.getEdge(nodeNames[i]);//graph.getEdge(nodeNames[i-1], nodeNames[i]);//node.getEdge(nodeNames[i]);	/////
			
			if(edge == null) {
				throw new GraphNexoException("Não existe aresta entre " + nodeNames[i-1] + " e " + nodeNames[i]);
			}
			
			distance += edge.getWeight();			
			node = edge.getDstNode();			
		}		
		
		return distance;
	}
}
