package dataStructuresPractice;

//Properties of BST:
// 	-each parent may have at most two nodes
// 	-the left child is less than the parent 
// 	-the right is greater than the parent
// BASIC OPERATIONS: 
// 	create, insert, search, delete

public class BinaryTree {
	Node root;
	
	private Node addRecursive(Node currentNode, int data) {
		if(currentNode == null){ 		//if currentNode is null, meaning node is leaf node, we can insert new Node at that point
		return new Node(data);	
		}
		
		if(data < currentNode.data) {		//if data we want to insert is less than data at current node, keep moving left until we find an open space
			currentNode.left = addRecursive(currentNode.left, data);
		}
		
		else if (data > currentNode.data) {		//if data we want to insert is greater than data at current node, 
													//	keep moving right until we find an open space
			currentNode.right = addRecursive(currentNode.right, data);
		}
		
		else {
			return currentNode;				//if we reach this point, we conclude the data is already present in the tree
		}
		
		return currentNode; 
	
	}
	
	
	public void add(int data) {				//public user method ensures user can't access program dependent functionality/variables and alter or break program
		root = addRecursive(root,data);
	}
	
	

	private boolean containsNodeRecursive(Node current, int data) {
		if(current == null) {
			return false;
		}
		
		if(current.data == data) {
			return true;
		}
		
		return current.data < data
			? containsNodeRecursive(current.right, data)
			: containsNodeRecursive(current.left, data);
		
		
	}
	
	public boolean containsNode(int data) {
		return containsNodeRecursive(root, data);
	}
	
	
	public static void main (String[]args) {
		BinaryTree bt = new BinaryTree();
		
		bt.add(7);
		bt.add(23);
		bt.add(29);
		bt.add(56);
		bt.add(2);
		
		System.out.print(bt.containsNode(100));
	}
	
	
	
	


}
