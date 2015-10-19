import java.io.*;
import java.util.*;

public class Satpix {

	public static void main(String[] args) throws IOException
	{
		boolean[][] booleanArr = fileToBoolArray("satpix.in");
		int sizeOfLargestPasture;
		
		//fileToBoolArray("satpix.in");
		//recursivelyMeasureAndMarkPasture(row, int col, boolean[][] booleanArray)
		
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
		boolean[][] booleanArray = new boolean[row][col];
		
		// fill in 2D boolean array
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (fr.read() == ('*'))
					booleanArray[i][j] = true;
				
				if (fr.read() == ('.'))
					booleanArray[i][j] = false;
			}
		}
		
		return booleanArray;
	}

	private static int recursivelyMeasureAndMarkPasture(int row, int col, boolean[][] booleanArray)
	{
		int pastureSize = 0;
		if (row >= 0 && col >= 0 && row < booleanArray.length && col < booleanArray[0].length && booleanArray[row][col] == true)
		{
			booleanArray[row][col] = false;
			pastureSize=1 +
				recursivelyMeasureAndMarkPasture(row - 1, col, booleanArray) +
				recursivelyMeasureAndMarkPasture(row + 1, col, booleanArray) +
				recursivelyMeasureAndMarkPasture(row, col + 1, booleanArray) +
				recursivelyMeasureAndMarkPasture(row, col - 1, booleanArray);
		}
		
		return pastureSize ;
	}
	
}