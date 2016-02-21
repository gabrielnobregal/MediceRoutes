package br.com.bionexo.graph.dijkstra;

import br.com.bionexo.graph.Edge;
import br.com.bionexo.graph.GraphNexo;
import br.com.bionexo.graph.GraphNode;
import br.com.bionexo.graph.Node;
import br.com.bionexo.graph.exception.GraphNexoException;
import br.com.bionexo.graph.exception.NoSuchPathException;
import br.com.bionexo.structures.BinaryHeap;

/**
 * @author Gabriel Nobrega de Lima
 */

public class Dijkstra {
	
	public static final int INFINITY = Integer.MAX_VALUE;

	private static void initDijkstra(GraphNexo graph, GraphNode srcNode, BinaryHeap<GraphNode> heap) {
		
		for (Node node : graph.getNodes()) {
			GraphNode graphNode = (GraphNode) node;
			
			if (srcNode == graphNode) {
				graphNode.setDistance(0);
			} else {
				graphNode.setDistance(Dijkstra.INFINITY);
			}

			graphNode.setVisited(false);
			heap.add(graphNode);		
		}

	}

	private static void relax(GraphNode parentNode, int weight, GraphNode childNode, GraphNode dstNode, BinaryHeap<GraphNode> heap) {

		/*
		 * Se parentNode está com distancia infinito, somar qualquer número a
		 * ele deve resultar em infinito. Esta verificação foi realizada para
		 * previnir que ocorra overflow na soma. Ex: Integer.MAX_VALUE + 1 =
		 * -2147483648
		 */
		int newDistance = parentNode.getDistance() != Dijkstra.INFINITY ? (parentNode.getDistance() + weight) : Dijkstra.INFINITY;

		if (!childNode.isVisited()) {

			if (childNode.getDistance() > newDistance) {
				childNode.setDistance(newDistance);
				heap.updateDecreasedValue(childNode);
				// heap.debug();
			}

		}

	}

	private static int doDijkstra(GraphNexo graph, String srcNodeName, String dstNodeName) {
		BinaryHeap<GraphNode> heap = new BinaryHeap<GraphNode>();
		GraphNode srcNode = (GraphNode) graph.getNodeFromName(srcNodeName);

		if (srcNode == null) {
			throw new GraphNexoException("O parâmetro srcNodeName(nó origem) deve ser válido.");
		}

		GraphNode dstNode = (GraphNode) graph.getNodeFromName(dstNodeName);
		initDijkstra(graph, srcNode, heap);

		while (!heap.isEmpty()) {

			// Remove
			GraphNode node = heap.get();
			node.setVisited(true);

			/*
			 * Caso o menor caminho requerido seja entre dois nós distintos, o
			 * algoritmo deve terminar quando este caminho for encontrado. Nos
			 * casos onde os nós origem e destino são iguais ou o nó destino é
			 * indeterminado, obtem-se a menor distância para todos os nós do
			 * grafo.
			 */
			if (node == dstNode && srcNode != dstNode) {
				break;
			}

			for (Edge edge : node.getEdgeList()) {
				relax(node, edge.getWeight(), (GraphNode) edge.getDstNode(),
						dstNode, heap);
			}

		}

		return dstNode.getDistance(); // srcNode == dstNode ?
										// dummyDistance:dstNode.getDistance();
	}

	public static int getShortestPathDistance(GraphNexo graph, String srcNodeName, String dstNodeName) throws NoSuchPathException {	
		
		if(srcNodeName.equals(dstNodeName)) {
			return distanceOfShortestCiclePath(graph, srcNodeName); 
		}
		
		int distance = doDijkstra(graph, srcNodeName, dstNodeName);
		
		if(distance == Dijkstra.INFINITY) {
			throw  new NoSuchPathException("Não existe caminho entre " + srcNodeName + " e " + dstNodeName + ".");
		}
		
		return distance;														
	}

	private static int distanceOfShortestCiclePath(GraphNexo graph, String nodeName) throws NoSuchPathException {
		doDijkstra(graph, nodeName, nodeName);
		
		GraphNode srcDstNode = (GraphNode) graph.getNode(nodeName);		

		int minCicleDistance = Dijkstra.INFINITY;

		for (Node node : graph.getNodes()) {
			GraphNode gSrcNode = (GraphNode) node;

			for (Edge edge : gSrcNode.getEdgeList()) {
				if (srcDstNode == (GraphNode) edge.getDstNode()) {					
					
					if (gSrcNode.getDistance() != Dijkstra.INFINITY) {
						if (minCicleDistance > gSrcNode.getDistance() + edge.getWeight()) {
							minCicleDistance = gSrcNode.getDistance() + edge.getWeight();
						}
					}
				}

			}

		}
		
		if(minCicleDistance == Dijkstra.INFINITY) {
			throw new NoSuchPathException("Não existe caminho partindo e voltando do nó " + nodeName + ".");
		}

		return minCicleDistance;
	}

}
