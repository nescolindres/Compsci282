package hashtables;

public class SortedList {
private Link first;
//------------------------
public void SortedList() {		//constructor 
	first = null;
}
//----------------------
public void insert(Link theLink) { 	//insert link, in order
	int key = theLink.getKey();
	Link previous = null;		//start at first
	Link current = first;
							//until end of list
	while (current != null && key > current.getKey()) {
		previous = current;
		current = current.next;
	}
	if(previous == null) {
		first = theLink;
	}
	else 
		previous.next = theLink;
	theLink.next = current;
}
public void delete (int key) {
	Link previous = null;
	Link current = first;
	
	while (current != null && key != current.getKey()) {
		previous = current;
		current = current.next;
	}
	if(previous == null) 
		first = first.next;
	else
		previous.next = current.next;
}
//-------------------------------------
public Link find (int key)   { //find link
	Link current = first;
	
	while(current != null && current.getKey() <= key ) {
		if(current.getKey() == key)
			return current;
		current = current.next;
	}
	return null;
}
public void displayList() {
	System.out.print("List (first-->last): ");
	Link current = first;
	while (current != null) {
		current.displayLink();
		current = current.next;
	}
	System.out.println("");
}

}
