package hashtables;

public class Link {

	private int iData;
	public Link next;
	
	//--------------------------------------------
	public Link(int it) {			//constructor
		iData = it;
	}
	
	//--------------------------------------------
	public int getKey() {
		return iData;
	}
	
	//--------------------------------------------
	public void displayLink() {		//display this link
		System.out.print(iData + " ");
	}
	
}
