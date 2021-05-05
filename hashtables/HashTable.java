package hashtables;

public class HashTable {

private int arraySize;
private Node [] table;
private int size;

//---------------------------------------------
public HashTable(int tableSize) {
	table = new Node[tableSize];
	size = 0;
}

//------------------------------------------------------


public int hashFunc(Integer x) {
	int hashVal = x.hashCode();
	hashVal %= table.length;
	if (hashVal < 0)
		hashVal += table.length;
	return hashVal;
}

public void insert (int key) {  //inserting link 
								
	size++;
	int pos = hashFunc(key);
	Node root = table[pos];
	root = insert(root, key);
	table[pos] = root;
}

private Node insert (Node node, int data) { //TODO: need to address duplicate keys
	if (node == null) {
		node = new Node(data);
	}
	else {
		if (data <= node.data)
			node.leftChild = insert(node.leftChild, data);
		else
			node.rightChild = insert(node.rightChild, data);
	}
	return node;
}

public void printHashTable () {
	System.out.println();
	for (int i = 0; i < table.length; i++) {
		System.out.print("Index " + i + ":  ");
		inOrder(table[i]);
		System.out.println();
	}
}

private void inOrder(Node current) {
	if (current != null) {
		inOrder(current.leftChild);
		System.out.print(current.data + " ");
		inOrder(current.rightChild);
	}
}

public int getSize () {
	return size;
}

public boolean isEmpty () {
	return size == 0 ;
}

//TODO: Implememnt a find() method

}
