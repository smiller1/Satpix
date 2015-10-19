import java.io.*;
import java.util.*;

public class Satpix {

	public static void main(String[] args) throws IOException
	{
		boolean[][] booleanArray = fileToBoolArray("satpix.in");
		int sizeOfLargestPasture = 0;
		int currentSize = 0;
		for (int i = 0; i < booleanArray.length; i++) {
			
			for (int j = 0; j < booleanArray[0].length; j++) {
				currentSize = recursivelyMeasureAndMarkPasture(i, j, booleanArray);
				
				if (currentSize > sizeOfLargestPasture) {
					sizeOfLargestPasture = currentSize;
				}
			}
		}
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("satpix.out")));
		out.println(sizeOfLargestPasture);
		out.close();
		}
	
	private static boolean[][] fileToBoolArray(String fileName) throws FileNotFoundException, IOException
	{
		// create FileReader/BufferedReader
		FileReader fr;
		fr = new FileReader(fileName);
		//BufferedReader br = new BufferedReader(fr);
		
		// create scanner
		Scanner scan = new Scanner(System.in);
		
		// create 2D boolean array
		int col = scan.nextInt();
		int row = scan.nextInt();
		boolean[][] arr = new boolean[row][col];
		
		// fill in 2D boolean array
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (fr.read() == ('*'))
					arr[i][j] = true;
				
				if (fr.read() == ('.'))
					arr[i][j] = false;
			}
		}
		
		return arr;
	}

	private static int recursivelyMeasureAndMarkPasture(int row, int col, boolean[][] arr)
	{
		int pastureSize = 0;
		if (row >= 0 && col >= 0 && row < arr.length && col < arr[0].length && arr[row][col] == true)
		{
			arr[row][col] = false;
			pastureSize = 1 +
				recursivelyMeasureAndMarkPasture(row - 1, col, arr) +
				recursivelyMeasureAndMarkPasture(row + 1, col, arr) +
				recursivelyMeasureAndMarkPasture(row, col + 1, arr) +
				recursivelyMeasureAndMarkPasture(row, col - 1, arr);
		}
		
		return pastureSize ;
	}
	
}