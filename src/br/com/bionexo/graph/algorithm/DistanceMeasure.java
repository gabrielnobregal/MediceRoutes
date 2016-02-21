package br.com.bionexo.graph.algorithm;

import br.com.bionexo.graph.Edge;
import br.com.bionexo.graph.GraphNexo;
import br.com.bionexo.graph.GraphNode;
import br.com.bionexo.graph.Node;
import br.com.bionexo.graph.exception.GraphNexoException;
import br.com.bionexo.graph.exception.NoSuchPathException;

/**
 * @author Gabriel Nobrega de Lima
 */

public class DistanceMeasure {

	public static int getPathDistance(GraphNexo graph, String... nodeNames)	throws GraphNexoException, NoSuchPathException {

		if (nodeNames == null || nodeNames.length == 0) {
			throw new GraphNexoException("Caminho inválido.");
		}

		Node node;

		if ((node = graph.getNode(nodeNames[0])) == null) {
			throw new GraphNexoException("Nó '" + nodeNames[0]
					+ "' inicial não encontrado.");
		}

		Edge edge;
		int distance = 0;

		for (int i = 1; i < nodeNames.length; i++) {
			GraphNode tmpNode = (GraphNode) node;

			edge = tmpNode.getEdge(nodeNames[i]);

			if (edge == null) {
				throw new NoSuchPathException("Não existe aresta entre "	+ nodeNames[i - 1] + " e " + nodeNames[i]);
			}

			distance += edge.getWeight();
			node = edge.getDstNode();
		}

		return distance;
	}
}
