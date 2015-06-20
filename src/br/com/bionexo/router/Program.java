package br.com.bionexo.router;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import br.com.bionexo.graph.GraphNexo;
import br.com.bionexo.graph.GraphNexoException;
import br.com.bionexo.graph.GraphNexoFactory;
import br.com.bionexo.graph.Node;

public class Program {


	
	public static void main(String[] args) {			
		
		Scanner scanner = new Scanner(System.in);		
		
		
		
		
		
		/*
		System.out.print("Graph: ");
		String graphInput = scanner.nextLine();
		*/
		
		String graphInput = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
		System.out.println("Graph: " + graphInput);

		GraphNexo graph = GraphNexoFactory.createGraph(graphInput);
		
		
		System.out.print("Output #1: ");	
		
		try {
			int distance = graph.getPathDistance("A", "B", "C");
			System.out.println(distance);
		} catch(GraphNexoException e) {
			//TODO: Imprimir a exceção apenas quando o usuario quiser usar o modo debug
			System.out.println("NO SUCH ROUTE");
			System.out.println(e.getCause());
			e.printStackTrace();						
		}		
		
		System.out.print("Output #2: ");
		try {
			int distance = graph.getPathDistance("A", "D");
			System.out.println(distance);
		} catch(GraphNexoException e) {
			System.out.println("NO SUCH ROUTE");
			System.out.println(e.getCause());
			e.printStackTrace();						
		}
		
		System.out.print("Output #3: ");
		try {
			int distance = graph.getPathDistance("A", "D", "C");
			System.out.println(distance);
		} catch(GraphNexoException e) {
			System.out.println("NO SUCH ROUTE");
			System.out.println(e.getCause());
			e.printStackTrace();						
		}
		
		System.out.print("Output #4: ");
		try {
			int distance = graph.getPathDistance("A", "E", "B", "C", "D");
			System.out.println(distance);
		} catch(GraphNexoException e) {
			System.out.println("NO SUCH ROUTE");
			System.out.println(e.getCause());
			e.printStackTrace();						
		}
		
		System.out.print("Output #5: ");
		try {
			int distance = graph.getPathDistance("A", "E", "D");
			System.out.println(distance);
		} catch(GraphNexoException e) {
			System.out.println("NO SUCH ROUTE");
			/*System.out.println(e.getCause());
			e.printStackTrace();*/						
		}
		
		
		
		System.out.print("Output #6: ");
		try {
			int numTrips = graph.getNumberOfTripsWithMaxStops("C", "C", 3);
			System.out.println(numTrips);
		} catch(GraphNexoException e) {
			System.out.println("NO SUCH ROUTE");
			System.out.println(e.getCause());
			e.printStackTrace();						
		}
		
		
		System.out.print("Output #7: ");
		try {
			int numTrips = graph.getNumberOfTripsWithExactStops("A", "C", 4);
			System.out.println(numTrips);
		} catch(GraphNexoException e) {
			System.out.println("NO SUCH ROUTE");
			System.out.println(e.getCause());
			e.printStackTrace();						
		}
		]
				
				
		/*
		Queue<Node> heap = new PriorityQueue<Node>(graph.getNumberOfNodes());
		Node a = new Node("a");
		//a.setDistance(0);
		
		Node b = new Node("b");
		b.setDistance(5);
		heap.add(b);
		heap.add(a);
		
		System.out.println("teste");
		System.out.println(heap.poll().getDistance());
		System.out.println(heap.poll().getDistance());
		System.out.println(heap.isEmpty());
		*/
		
		
		
	}

}
