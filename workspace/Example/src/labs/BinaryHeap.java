package labs;

import java.awt.HeadlessException;

import javax.xml.soap.Node;

// http://en.wikipedia.org/wiki/Binary_heap
public class BinaryHeap<T extends Comparable<T>> {

	BinaryTree<T> tree = new BinaryTree<T>();
	public Node root;

	public class Node<T>
	{
		private Node leftchild;
		private Node rightChild;
		public int object;
		Node parent = null;
		
		public Node(int object)
		{
			this.object = object;
		}
	}
	public void insert (int object){
		Node node = new Node<>(object);
		if (root == null)
		{
			root = node;
			return;
		}
		insert2(root,node);

				
	}
	
	private void insert2(Node root2, Node node) {
		// TODO Auto-generated method stub
		if(root2.object > node.object)
		{
			if(root2.leftchild == null)
			{
				root2.leftchild = node;
				return;
			}
			else
				root2.rightChild = node;
		}
		else 
		{
			if(root2.rightChild == null)
			{
				root2.rightChild = node;
				return;
			}
			else
				root2.leftchild = node;
		}
		
	}

	public Node remove(T item)
	{
		return root = remove(item);
	}

	// Does the heap have the item?
	public void contains (T item) {
		content(root);
		System.out.println("");
	}
	public void content(Node Current)
	{
		if(Current == null)
		{
			return;
		}
		content(Current.leftchild);
		content(Current.rightChild);
		
	}


}