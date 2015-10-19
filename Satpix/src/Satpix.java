import java.io.*;
import java.util.*;

public class Satpix {

	public static void main(String[] args) throws IOException
	{
		boolean[][] booleanArr = fileToBoolArray("satpix.in");
		int sizeOfLargestPasture;
		
		/* YOUR CODE GOES HERE */
		
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
	}

	private static int recursivelyMeasureAndMarkPasture(int row, int col, boolean[][] arr)
	{
		//This recursive method employs the flood-fill algorithm to
		//count the size of a single pasture and "mark" it so it is not double-counted
		return 0;
	}
	
}