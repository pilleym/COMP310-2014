//binary search tree

public class BinaryTreeNode<DataType extends Comparable<DataType>>
{
	DataType data;
	BinaryTreeNode<DataType> left, right;
	BinaryTreeNode(DataType data) {
		this.data = data;
	}
	void add(DataType moreData) {
		// figure out which side to place it
		if (data.compareTo(moreData) <= 0) {
			// it goes to the right
			if (right == null) {
				// create a node with the data and call it a day
				right = new BinaryTreeNode<DataType>(moreData);
			} else {
				// keep looking recursively
				right.add(moreData);
			}
		} else {
			// it goes to the left
			if (left == null) {
				// create a node and call it a day
				left = new BinaryTreeNode<DataType>(moreData);
			} else {
				// keep looking recursively
				left.add(moreData);
			}
		}
	}
	// Can you write this function?
	// Hint: try doing what you do in the add function
	boolean contains (DataType data) {
		//if(this.data.compareTo(data){
			int result = data.compareTo(data);
			if (result < 0)
				if(right ==null)
				{
					return false;
				}
				else if (result == 0){
					return true;
				}
				else {
					if(left == null){
						return false;
					}
					else{
						return left.contains(data);
					}
						
			}
			return false;
		}
		
	
	public static void main(String[] args) {
		System.out.println("Hello".compareTo("World"));
	}

	@SuppressWarnings({ "unused" })
	private BinaryTreeNode<DataType> remove(DataType x, BinaryTreeNode<DataType> t)
	{
		if (t == null)
		{
			return t;
		}
		
		int compareResult = x.compareTo(t.data);
		
		if(compareResult < 0)
		{
			t.left = remove(x, t.left);
		}
		else if (compareResult > 0)
		{
			t.right = remove(x,t.right);
		}
		else
			t = (t.left != null) ? t.left : t.right;
			return t;
			
	}
}