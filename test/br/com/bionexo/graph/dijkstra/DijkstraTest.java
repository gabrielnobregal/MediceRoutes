package br.com.bionexo.graph.dijkstra;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import br.com.bionexo.graph.GraphNexo;
import br.com.bionexo.graph.GraphNexoFactory;
import br.com.bionexo.graph.exception.NoSuchPathException;

public class DijkstraTest {

	@Test
	public void GeneralTest() {		
		
		String graphInput = "AB5, BD3, CD2, CA1, EC1, DE4, FE1, FC3, GF4, GD5, KG1, LK1";
		GraphNexo graph = GraphNexoFactory.createGraph(graphInput);			 
		assertEquals(12, Dijkstra.getShortestPathDistance(graph, "G", "B"));		
		assertEquals(7, Dijkstra.getShortestPathDistance(graph, "D", "D"));
		assertEquals(7, Dijkstra.getShortestPathDistance(graph, "C", "C"));
		assertEquals(2, Dijkstra.getShortestPathDistance(graph, "F", "C"));
		assertEquals(7, Dijkstra.getShortestPathDistance(graph, "E", "E"));		
		
		
		graphInput = "AB1, BA2, AC3, CA2, BC1, CB1, CD3, DC4, DE1, ED1";
		graph = GraphNexoFactory.createGraph(graphInput);			 
		assertEquals(2, Dijkstra.getShortestPathDistance(graph, "C", "C"));
		assertEquals(5, Dijkstra.getShortestPathDistance(graph, "A", "D"));
		assertEquals(6, Dijkstra.getShortestPathDistance(graph, "A", "E"));
		
		
		graphInput = "AB1, BA1, AD4, AC3, BC1, DC3, DA1";
		graph = GraphNexoFactory.createGraph(graphInput);			 
		assertEquals(2, Dijkstra.getShortestPathDistance(graph, "A", "C"));
		assertEquals(3, Dijkstra.getShortestPathDistance(graph, "D", "C"));
		assertEquals(1, Dijkstra.getShortestPathDistance(graph, "D", "A"));
		
		
		graphInput = "BH1, HB1, GH1, CE1, FG1, DG1, GD1, DB1, AE1, DC1, AB1, BD1, AD1, EC1, CF1, EF1, HK1";
		graph = GraphNexoFactory.createGraph(graphInput);		
		assertEquals(2, Dijkstra.getShortestPathDistance(graph, "A", "C"));
		assertEquals(2, Dijkstra.getShortestPathDistance(graph, "A", "H"));
		assertEquals(2, Dijkstra.getShortestPathDistance(graph, "B", "K"));
		
		try {
			Dijkstra.getShortestPathDistance(graph, "A", "A");
			Assert.fail("Exceção era esperada!");
		} catch(NoSuchPathException e) {}
		
		
		
		
	}
	
	@Test
	public void DisconnectedGraphTest() {		
		String graphInput = "AB1, AC1, CB2, CD1, FG1";		
		GraphNexo  graph = GraphNexoFactory.createGraph(graphInput);		
		
		try {
			Dijkstra.getShortestPathDistance(graph, "C", "C");			
			Assert.fail("Exceção era esperada!");
		} catch(NoSuchPathException e) {}
		
		
		try {
			Dijkstra.getShortestPathDistance(graph, "A", "G");
			Assert.fail("Exceção era esperada!");
		} catch(NoSuchPathException e) {}				
		
		assertEquals(2, Dijkstra.getShortestPathDistance(graph, "C", "B"));
		
	}

}
