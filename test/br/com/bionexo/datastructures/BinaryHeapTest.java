package br.com.bionexo.datastructures;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import br.com.bionexo.structures.BinaryHeap;

public class BinaryHeapTest {		
	
	@Test
	public void AddGetOperationsTest() {		
		BinaryHeap<Item> heap = new BinaryHeap<Item>();		
		
		Random gerador = new Random();		 
		
        int size = 1000;
        
        for(int i=0; i<size; i++) {        	
        	heap.add(new Item(gerador.nextInt(1000) -125));
        }
        
        int ct = 0;
        int last = -999;
        
        while(ct<size) {          	
        	int actual = heap.get().valor;        
        	assertEquals("Ordem de remoção inválida.", true, last<= actual);
        	last = actual;        	
        	ct++;
        }		
	}
	
	@Test
	public void AddUpdateGetOperationsTest() {	
		BinaryHeap<Item> heap = new BinaryHeap<Item>();	
		
		Random gerador = new Random();
		
        int size = 1000;
        
        for(int i=0; i<size; i++) {        	
        	heap.add(new Item(gerador.nextInt(1000) -125));
        }
		
		Item pointer = new Item(500);
		heap.add(pointer);
		pointer.valor = -150;
		heap.updateDecreasedValue(pointer);		
		assertEquals("Atualização icorreta da heap.", true, heap.get().valor == -150);
		
		
		for(int i=0;i>500; i++) {
			pointer.valor = gerador.nextInt(1000) -125;
			heap.add(pointer);
			pointer.valor = -155-i;
			heap.updateDecreasedValue(pointer);		
			assertEquals("Atualização icorreta da heap.", true, heap.get().valor == -155-i);
		}
		
		int ct = 0;
        int last = -999;
		while(ct<size) {          	
	    	int actual = heap.get().valor;        
	    	assertEquals("Ordem de remoção inválida.", true, last<= actual);
	    	last = actual;        	
	    	ct++;
		}			
		
	}
	
	
	protected class Item implements Comparable<Item> {
		public int valor;
		
		public Item(int valor) {
			this.valor = valor;
		}
		
		@Override
		public int compareTo(Item o) {		
			return this.valor - o.valor;
		}
		
	}

}
