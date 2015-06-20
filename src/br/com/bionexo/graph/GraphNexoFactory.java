package br.com.bionexo.graph;

public class GraphNexoFactory {
		
	public static GraphNexo createGraph(String graphInput) {
		String edges[] = graphInput.split(",");
		GraphNexo graph = new GraphNexo();
		
		System.out.println("Numero de nós no grafo: " + edges.length);
		for(String edge : edges) {
			edge = edge.trim();
			String srcNodeName = edge.substring(0, 1);
			String dstNodeName = edge.substring(1, 2);			
			int weight = Integer.parseInt(edge.substring(2, edge.length()));
			
			graph.addEdge(srcNodeName, dstNodeName, weight);			
		}
		
		return graph;	
	}
	
	
}
