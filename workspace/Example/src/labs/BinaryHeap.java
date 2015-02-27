package labs;

import java.util.Arrays;
import java.util.NoSuchElementException;


// http://en.wikipedia.org/wiki/Binary_heap
public class BinaryHeap<T extends Comparable<T>> {

	BinaryTree<T> tree = new BinaryTree<T>();
	private static final int d = 5;
	private int size;
	private int[] heaping;


	
	public void insert(T item)
	{
		if(heapfull())
		{
			throw new NoSuchElementException("full");
		}
		
		//heaping[size++];
		heapifyup(size - 1);
	}


	private void heapifyup(int i) {
		// TODO Auto-generated method stub
		int temp = heaping[i];
		while(i >0 && temp < heaping[parent(i)])
		{
			heaping[i] = heaping[parent(i)];
			i = parent(i);
		}
					
					
		
	}


	private int parent(int i) {
		// TODO Auto-generated method stub
		return (i - 1)/d;
	}


	public int remove(int item)
	{
		if(heapempty())
		{
			throw new NoSuchElementException("no overflow");
		}
		int key = heaping[item];
		heaping[item] = heaping[size  -1];
		size--;
		heapifyup(item);
		return key;
	}

	// Does the heap have the item?
	public boolean contains (T item) {
		return false;

	}
	public void heap(int cap)
	{
		size = 0;
		heaping = new int[cap + 1];
		Arrays.fill(heaping, -1);
	}
	public Boolean heapempty()
	{
		return size == 0;
	}
	public Boolean heapfull()
	{
		return size == heaping.length;
	}
	//children
	private int childnum(int i, int k)
	{
		return d + i + k;
	}
	public int min()
	{
		if(heapempty())
		{
			throw new NoSuchElementException("no overflow");
		}
		return heaping[0];
	}

}