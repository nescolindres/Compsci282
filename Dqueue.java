package homework;

public class Dqueue {

	public long[] theArray;
	private int front;
	private int rear;
	private int arrayElements;
	public int size;

	public Dqueue(int size) {
		theArray = new long[size];
		front = -1;
		rear = 0;
		this.size = size;
	
	}

	public static void main(String[] args) {
		Dqueue que = new Dqueue(10);

		System.out.println("Front");
		que.insertLeft(4);
		que.insertLeft(20);
		que.insertLeft(5);
		que.insertLeft(44);
		que.insertLeft(21);
		que.insertLeft(27);
		que.insertLeft(78);
		que.insertRight(13);
		que.insertRight(55);
		que.insertRight(67);
		System.out.println("Elements in the array " + que.arrayElements);
		System.out.println("Is it full? " + que.isFull());

		 System.out.println("The front of the array has the element of " +
		 que.peekFront());
		 System.out.println("The rear of the array has the element of " +
		 que.peekRear());

		 que.removeRight();
		 System.out.println("After removing from the rear, the element at the rear is " + que.peekRear());
		 
		 que.removeRight();
		 que.removeRight();
		 que.removeRight();
		 que.removeRight();
		 que.removeRight();
		 que.removeRight();
		 
		 while (!que.isEmpty()) {
			 long n = que.removeRight();
			 System.out.print(n);
			 System.out.println("");
		 }
		 

	
		System.out.println("Rear");
		System.out.println("Is it empty? " + que.isEmpty());

	}

	public void insertRight(int j) { // This method inserts from the rear of the array

		if (front == -1) {
			front = 0;
			rear = 0;
		}

		else if (rear == size -1)
			rear = 0;
		else 
			rear = rear +1;
		theArray[rear] = j;
		arrayElements++;

	}

	 void insertLeft (int k) { // this method inserts from the front of the array

		if (!isFull()) {
			if (front == -1) { // Deals with wrap around.
				front = 0;
				front = 0;
			}
			else if (front == 0)
				front = size - 1;
			else 
				front = front -1;
			
			theArray[front] = k;
			arrayElements++;

		}
		else 
			System.out.println("Array is full");
	}

	public long removeRight() {
	/*  if(!isEmpty()) {
		if (front == rear) {
			front = -1;
			rear = -1;
		}
		else if (rear == 0)
			rear = size -1;
		else 
			rear = rear - 1;
			
	}
	*/
		
		long temp = theArray[rear]; 
		rear--;
		if (rear < 0)
			rear = size - 1;
		arrayElements--;
		return temp;
		
		
	}

	public long removeLeft() {
	/*	if (!isEmpty()) {
			if (front == rear) {
				front = -1;
				rear = -1;
			}
			else 
				if (front == size -1)
					front =0;
				else 
					front = front + 1;
		}
		arrayElements--;
		*/
		
		long temp = theArray[front++];
		if (front == size)
			front = 0;
		arrayElements--;
		return temp;

	}

	public boolean isEmpty() {

		return arrayElements == 0;

	}

	public boolean isFull() {

		return arrayElements == theArray.length;
	}

	public long peekFront() {
		return theArray[front];
	}

	public long peekRear() {
		return theArray[rear];
	}

}
