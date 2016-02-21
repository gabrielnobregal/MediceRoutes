package br.com.bionexo.graph.algorithm;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import br.com.bionexo.graph.GraphNexo;
import br.com.bionexo.graph.GraphNexoFactory;
import br.com.bionexo.graph.algorithm.TripCounter;
import br.com.bionexo.graph.exception.NoSuchPathException;

public class TripCounterTest {

	@Test
	public void numberOfTripsWithMaxStopsTest() {		
		String graphInput = "AB1, BD1, AD1, EC1, CF1, EF1";
		GraphNexo graph = GraphNexoFactory.createGraph(graphInput);		
		
		assertEquals(0, TripCounter.getNumberOfTripsWithMaxStops(graph, "A", "E", 3));
		assertEquals(1, TripCounter.getNumberOfTripsWithMaxStops(graph, "A", "B", 3));
		assertEquals(2, TripCounter.getNumberOfTripsWithMaxStops(graph, "A", "D", 3));		
		
		graphInput = "DB1, AE1, DC1, AB1, BD1, AD1, EC1, CF1, EF1";
		graph = GraphNexoFactory.createGraph(graphInput);		
		assertEquals(1, TripCounter.getNumberOfTripsWithMaxStops(graph, "A", "E", 3));
		assertEquals(3, TripCounter.getNumberOfTripsWithMaxStops(graph, "A", "B", 3));
		assertEquals(3, TripCounter.getNumberOfTripsWithMaxStops(graph, "A", "D", 3));
		assertEquals(2, TripCounter.getNumberOfTripsWithMaxStops(graph, "B", "D", 3));		
		
		
		graphInput = "CE1, FG1, DG1, GD1, DB1, AE1, DC1, AB1, BD1, AD1, EC1, CF1, EF1";
		graph = GraphNexoFactory.createGraph(graphInput);		
		assertEquals(3, TripCounter.getNumberOfTripsWithMaxStops(graph, "A", "E", 3));
		assertEquals(3, TripCounter.getNumberOfTripsWithMaxStops(graph, "A", "G", 3));
		assertEquals(1, TripCounter.getNumberOfTripsWithMaxStops(graph, "E", "D", 3));
		assertEquals(3, TripCounter.getNumberOfTripsWithMaxStops(graph, "C", "F", 3));
		
		
	}
	
	@Test
	public void numberOfTripsWithExactStops() {		
		String graphInput = "CE1, FG1, DG1, GD1, DB1, AE1, DC1, AB1, BD1, AD1, EC1, CF1, EF1, HK1";
		GraphNexo graph = GraphNexoFactory.createGraph(graphInput);		
		assertEquals(0, TripCounter.getNumberOfTripsWithExactStops(graph, "A", "H", 3));
		assertEquals(2, TripCounter.getNumberOfTripsWithExactStops(graph, "A", "D", 3));
		assertEquals(2, TripCounter.getNumberOfTripsWithExactStops(graph, "A", "F", 3));
		assertEquals(2, TripCounter.getNumberOfTripsWithExactStops(graph, "A", "G", 3));
		
		graphInput = "BH1, HB1, GH1, CE1, FG1, DG1, GD1, DB1, AE1, DC1, AB1, BD1, AD1, EC1, CF1, EF1, HK1";
		graph = GraphNexoFactory.createGraph(graphInput);			
		assertEquals(2, TripCounter.getNumberOfTripsWithExactStops(graph, "A", "H", 3));
		assertEquals(0, TripCounter.getNumberOfTripsWithExactStops(graph, "H", "F", 3));
		assertEquals(0, TripCounter.getNumberOfTripsWithExactStops(graph, "K", "K", 3));
		assertEquals(0, TripCounter.getNumberOfTripsWithExactStops(graph, "C", "C", 3));
	}
	
	@Test
	public void numberOfTripsWithMaxDistance() {
		
		String graphInput = "CE1, FG1, DG1, GD1, DB1, AE1, DC1, AB1, BD1, AD1, EC1, CF1, EF1, HK1, BH1";
		GraphNexo graph = GraphNexoFactory.createGraph(graphInput);	
		assertEquals(2, TripCounter.getNumberOfTripsWithLessThanDistance(graph, "A", "H", 4));
		assertEquals(0, TripCounter.getNumberOfTripsWithLessThanDistance(graph, "A", "A", 4));
		assertEquals(3, TripCounter.getNumberOfTripsWithLessThanDistance(graph, "A", "B", 4));
		assertEquals(2, TripCounter.getNumberOfTripsWithLessThanDistance(graph, "E", "G", 4));
		assertEquals(0, TripCounter.getNumberOfTripsWithLessThanDistance(graph, "H", "B", 4));
				
		graphInput = "AC1, CA2, CD2, DC1, BD2, DB1, BA1, AB2, AD1, DA4, KL1";
		graph = GraphNexoFactory.createGraph(graphInput);	
		assertEquals(2, TripCounter.getNumberOfTripsWithLessThanDistance(graph, "A", "D", 4));
		assertEquals(107, TripCounter.getNumberOfTripsWithLessThanDistance(graph, "A", "D", 10));
		assertEquals(3, TripCounter.getNumberOfTripsWithLessThanDistance(graph, "A", "A", 4));
		assertEquals(1, TripCounter.getNumberOfTripsWithLessThanDistance(graph, "K", "L", 4));
		
				
		try {
			TripCounter.getNumberOfTripsWithLessThanDistance(graph, "A", "G", 20);
			Assert.fail("Exceção era esperada!");
		} catch(NoSuchPathException e) {}		
		
	}

}
