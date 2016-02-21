package br.com.bionexo.structures;

import java.util.Arrays;

/**
 * @author Gabriel Nobrega de Lima
 */

public class BinaryHeap<T extends Comparable<T>> {

	private static final int INTIAL_SIZE = 50;
	private T vector[];
	private int currentSize;

	@SuppressWarnings("unchecked")
	public BinaryHeap() {
		vector = (T[]) new Comparable[INTIAL_SIZE];
		currentSize = 0;
	}

	private T[] resizeVector() {
		return Arrays.copyOf(vector, vector.length * 2);
	}

	private void moveDown(int index) {
		int minChild;
		T top = vector[index];

		while (index < currentSize / 2) {
			int leftChild = 2 * index + 1;
			int rightChild = leftChild + 1;

			if (rightChild < currentSize
					&& vector[leftChild].compareTo(vector[rightChild]) > 0) {
				minChild = rightChild;
			} else {
				minChild = leftChild;
			}

			if (top.compareTo(vector[minChild]) <= 0) {
				break;
			}

			vector[index] = vector[minChild];
			index = minChild;
		}

		vector[index] = top;
	}

	public void updateDecreasedValue(T item) {		
		for (int i = 0; i < currentSize; i++) {
			if (vector[i] == item) {
				moveUp(i);
			}
		}
	}

	private void moveUp(int index) {
		int parent = (index - 1) / 2;
		T bottom = vector[index];

		while (index > 0 && vector[parent].compareTo(bottom) > 0) {
			vector[index] = vector[parent];
			index = parent;
			parent = (parent - 1) / 2;
		}

		vector[index] = bottom;
	}

	public boolean isEmpty() {
		return currentSize == 0;
	}

	public T get() {
		T firstElement = vector[0];
		vector[0] = vector[--currentSize];
		moveDown(0);

		return firstElement;
	}

	public void add(T item) {
		if (currentSize == vector.length) {
			vector = resizeVector();
		}

		vector[currentSize] = item;
		moveUp(currentSize++);
	}

}
