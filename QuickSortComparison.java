
package homework;

public class QuickSortComparison {

	private static int count = 0;
	private static int copied = 0;

	static int[] ab = {7, 18, 80, 86, 13, 0, 3, 94, 68, 17, 53, 74, 61, 32, 82, 47};

	public static void main(String[] args) {
		printArray();
		quickSort(0, ab.length - 1);
		printArray();
		System.out.println("The total amount copied is " + copied);
		System.out.println("The total amount of comparisons is " + count);
	}

	private static void quickSort(int left, int right) {
		if (right - left + 1 <= 3) // Base Case for Recursion
			manualSort(left, right);
		else {
			int pivotValue = medianOfThree(left, right);
			int part = partitionIt(left, right, pivotValue);

			quickSort(left, part - 1);
			quickSort(part + 1, right);
		}
	}

	private static void manualSort(int left, int right) {
		int size = right - left + 1;

		if (size == 1)
			return;
		else if (size == 2) {
			count++;
			if (ab[left] > ab[right]) {
				swap(left, right);

			}

		} else {
			count += 3;

			if (ab[left] > ab[right - 1]) {
				swap(left, right - 1);

			}
			if (ab[left] > ab[right]) {
				swap(left, right);

			}
			if (ab[right - 1] > ab[right]) {
				swap(right - 1, right);

			}
		}
	}

	private static int medianOfThree(int left, int right) {
		int middle = (left + right) / 2;
		count += 3;
		if (ab[left] > ab[middle]) {
			swap(left, middle);

		}
		if (ab[left] > ab[right]) {
			swap(left, right);

		}
		if (ab[middle] > ab[right]) {
			swap(middle, right);

		}
		swap(middle, right);
		return ab[right];

	}

	private static int partitionIt(int left, int right, int pivotValue) {
		int leftPtr = left - 1;
		int rightPtr = right;

		while (true) {
			count += 2;
			while (ab[++leftPtr] < pivotValue)
				count++;
			// No operation done in this while loop
			while (ab[--rightPtr] > pivotValue)

				count++;// No operation
			count++;
			if (leftPtr >= rightPtr) {

				break;
			} else {
				swap(leftPtr, rightPtr);
			}
		}
		swap(leftPtr, right);

		return leftPtr;
	}

	private static void swap(int leftPtr, int rightPtr) {
		int temp = ab[leftPtr];
		ab[leftPtr] = ab[rightPtr];
		ab[rightPtr] = temp;
		copied += 3;

	}

	private static void printArray() {
		for (int i = 0; i < ab.length; i++) {
			System.out.print(ab[i] + " ");
		}
		System.out.println();
	}
}
