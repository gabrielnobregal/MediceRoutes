package br.com.bionexo.router;

import java.util.Scanner;

import br.com.bionexo.graph.GraphNexo;
import br.com.bionexo.graph.GraphNexoFactory;
import br.com.bionexo.graph.algorithm.DistanceMeasure;
import br.com.bionexo.graph.algorithm.TripCounter;
import br.com.bionexo.graph.dijkstra.Dijkstra;
import br.com.bionexo.graph.exception.GraphNexoException;
import br.com.bionexo.graph.exception.NoSuchPathException;

/**
 * @author Gabriel Nobrega de Lima
 */


public class Program {

	private static boolean DEBUG = false;

	
	public static void printException(Throwable e) {		
		if(DEBUG) {
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}
	
	public static void execute(GraphNexo graph) {

		System.out.print("Output #1: ");			
		try {
			int distance = DistanceMeasure.getPathDistance(graph, "A", "B", "C");
			System.out.println(distance);
		} catch(GraphNexoException | NoSuchPathException e) {
			System.out.println("NO SUCH ROUTE");
			printException(e);					
		}		
		
		System.out.print("Output #2: ");
		try {
			int distance = DistanceMeasure.getPathDistance(graph, "A", "D");
			System.out.println(distance);
		} catch(GraphNexoException | NoSuchPathException e) {
			System.out.println("NO SUCH ROUTE");
			printException(e);					
		}
		
		System.out.print("Output #3: ");
		try {
			int distance = DistanceMeasure.getPathDistance(graph, "A", "D", "C");
			System.out.println(distance);
		} catch(GraphNexoException | NoSuchPathException e) {
			System.out.println("NO SUCH ROUTE");
			printException(e);						
		}
		
		System.out.print("Output #4: ");
		try {
			int distance = DistanceMeasure.getPathDistance(graph, "A", "E", "B", "C", "D");
			System.out.println(distance);
		} catch(GraphNexoException | NoSuchPathException e) {
			System.out.println("NO SUCH ROUTE");
			printException(e);						
		}
		
		System.out.print("Output #5: ");
		try {
			int distance = DistanceMeasure.getPathDistance(graph, "A", "E", "D");
			System.out.println(distance);
		} catch(GraphNexoException | NoSuchPathException e) {
			System.out.println("NO SUCH ROUTE");
			printException(e);				
		}		
		
		System.out.print("Output #6: ");
		try {
			int numTrips = TripCounter.getNumberOfTripsWithMaxStops(graph, "C", "C", 3);
			System.out.println(numTrips);
		} catch(GraphNexoException | NoSuchPathException e) {			
			printException(e);						
		}		
		
		System.out.print("Output #7: ");
		try {
			int numTrips = TripCounter.getNumberOfTripsWithExactStops(graph, "A", "C", 4);
			System.out.println(numTrips);
		} catch(GraphNexoException | NoSuchPathException e) {			
			printException(e);					
		}			
		
		System.out.print("Output #8: ");
		try {
			int distance = Dijkstra.getShortestPathDistance(graph, "A", "C");
			System.out.println(distance);
		} catch(GraphNexoException | NoSuchPathException e) {
			System.out.println("NO SUCH ROUTE");
			printException(e);						
		}		
		
		System.out.print("Output #9: ");
		try {
			int distance = Dijkstra.getShortestPathDistance(graph, "B", "B");
			System.out.println(distance);
		} catch(GraphNexoException | NoSuchPathException e) {
			System.out.println("NO SUCH ROUTE");
			printException(e);						
		}	
		
		System.out.print("Output #10: ");
		try {
			int distance = TripCounter.getNumberOfTripsWithLessThanDistance(graph, "C", "C", 30);
			System.out.println(distance);
		} catch(GraphNexoException | NoSuchPathException e) {			
			printException(e);						
		}			
		
	}
	
	public static void main(String[] args) {			
		
		if(args.length > 0 && args[0].equalsIgnoreCase("-debug")) {
			DEBUG = true;
		}
		
		Scanner scanner = new Scanner(System.in);		
		String graphInput; 		
		GraphNexo graph = null;
		
		
		while(true) {			
			
			try {
				System.out.print("Graph: ");
				graphInput = scanner.nextLine();
				
				if(graphInput.equalsIgnoreCase("exit")) {
					break;
				}
				
				graph = GraphNexoFactory.createGraph(graphInput);				
				
			} catch(Exception e) {
				System.out.println("Formato de entrada inválido.");
				continue;
			}		
			
			
			Program.execute(graph);
			
		}
		
		scanner.close();
		
	}

}
