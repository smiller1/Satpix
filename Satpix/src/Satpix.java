import java.io.*;
import java.util.*;

public class Satpix {

	public static void main(String[] args) throws IOException {
		// convert the input file into an array of booleans.
		boolean[][] booleanArray = fileToBoolArray("satpix.txt");

		// create variables needed to find largest pasture
		int sizeOfLargestPasture = 0;
		int currentSize = 0;
		
		//compare all pastures to find the largest one.
		for (int i = 0; i < booleanArray.length; i++) {

			for (int j = 0; j < booleanArray[i].length; j++) {
				currentSize = recursivelyMeasureAndMarkPasture(i, j, booleanArray);

				if (currentSize > sizeOfLargestPasture) {
					sizeOfLargestPasture = currentSize;
				}
			}
		}

		System.out.println(sizeOfLargestPasture);

		// print the size of largest pasture to a file "satpix.out"
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("satpix.out")));
		out.println(sizeOfLargestPasture);
		
		
		out.close();
	}

	private static boolean[][] fileToBoolArray(String fileName) throws FileNotFoundException, IOException {

		// create scanner
		Scanner scan = new Scanner(new File(fileName));

		// create 2D boolean array
		int col = scan.nextInt();
		int row = scan.nextInt();
		boolean[][] arr = new boolean[row][col];

		// fill in 2D boolean array
		for (int i = 0; i < row; i++) {
			String str = new String(scan.next());
			for (int j = 0; j < col; j++) {
				if (str.charAt(j) == ('*')) {
					arr[i][j] = true;
				} else {
					arr[i][j] = false;
				}
			}
		}
		scan.close();

		return arr;

	}

	private static int recursivelyMeasureAndMarkPasture(int row, int col, boolean[][] arr) {

		if (row >= 0 && col >= 0 && row < arr.length && col < arr[0].length && arr[row][col] == true) {
			arr[row][col] = false;
			return 1 + recursivelyMeasureAndMarkPasture(row + 1, col, arr)
					+ recursivelyMeasureAndMarkPasture(row - 1, col, arr)
					+ recursivelyMeasureAndMarkPasture(row, col + 1, arr)
					+ recursivelyMeasureAndMarkPasture(row, col - 1, arr);
		}

		return 0;
	}

}