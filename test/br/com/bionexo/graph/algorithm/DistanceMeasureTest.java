package br.com.bionexo.graph.algorithm;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import br.com.bionexo.graph.GraphNexo;
import br.com.bionexo.graph.GraphNexoFactory;
import br.com.bionexo.graph.algorithm.DistanceMeasure;
import br.com.bionexo.graph.exception.NoSuchPathException;

public class DistanceMeasureTest {

	@Test
	public void reachableNodesTest() {		
		String graphInput = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
		GraphNexo graph = GraphNexoFactory.createGraph(graphInput);	
		assertEquals(9, DistanceMeasure.getPathDistance(graph, "A", "B", "C"));
		assertEquals(5, DistanceMeasure.getPathDistance(graph, "A", "B"));
		assertEquals(0, DistanceMeasure.getPathDistance(graph, "A")); 
		assertEquals(0, DistanceMeasure.getPathDistance(graph, "A"));
		assertEquals(23, DistanceMeasure.getPathDistance(graph, "A", "B", "C", "D", "E"));
		assertEquals(21, DistanceMeasure.getPathDistance(graph, "E", "B", "C", "D", "E"));		
	}
	
	
	@Test
	public void reachableNodesTest1() {		
		String graphInput = "AB5, BD3, CD2, CA1, EC1, DE4";
		GraphNexo graph = GraphNexoFactory.createGraph(graphInput);		
		assertEquals(9, DistanceMeasure.getPathDistance(graph, "C", "A", "B", "D"));
		assertEquals(10, DistanceMeasure.getPathDistance(graph, "E", "C", "A", "B", "D"));
		assertEquals(7, DistanceMeasure.getPathDistance(graph, "D", "E", "C", "D"));
		
		graphInput = "BH1, HB1, GH1, CE1, FG1, DG1, GD1, DB1, AE1, DC1, AB1, BD1, AD1, EC1, CF1, EF1, HK1";
		graph = GraphNexoFactory.createGraph(graphInput);	
		assertEquals(3, DistanceMeasure.getPathDistance(graph, "A", "B", "D", "G"));		
		assertEquals(4, DistanceMeasure.getPathDistance(graph, "A", "B", "D", "G", "D"));		
		assertEquals(5, DistanceMeasure.getPathDistance(graph, "A", "B", "D", "G", "D", "G"));
		assertEquals(2, DistanceMeasure.getPathDistance(graph, "B", "H", "K"));
		assertEquals(4, DistanceMeasure.getPathDistance(graph, "A", "D", "G", "H", "K"));
	}
	
	
	@Test  
	public void unreachableNodesTest() {
		
		String graphInput = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
		GraphNexo graph = GraphNexoFactory.createGraph(graphInput);
			
		try {
			DistanceMeasure.getPathDistance(graph, "C", "A");
			Assert.fail("Exceção era esperada!");
		} catch(NoSuchPathException e) {}
		
		
		try {
			DistanceMeasure.getPathDistance(graph, "B", "A");			
			Assert.fail("Exceção era esperada!");
		} catch(NoSuchPathException e) {}
		
		
		try {
			DistanceMeasure.getPathDistance(graph, "A", "A");
			Assert.fail("Exceção era esperada!");
		} catch(NoSuchPathException e) {}
		
		
	}
	
	@Test  
	public void unreachableNodesTest1() {
		
		String graphInput = "FA2, AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
		GraphNexo graph = GraphNexoFactory.createGraph(graphInput);
			
		try {
			DistanceMeasure.getPathDistance(graph, "A", "F");
			Assert.fail("Exceção era esperada!");
		} catch(Exception e) {}		
		
		
		
	}


}
