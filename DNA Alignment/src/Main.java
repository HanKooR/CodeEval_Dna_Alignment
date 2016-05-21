import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import jdk.nashorn.internal.runtime.linker.JavaAdapterFactory;

/**
 * 
 * @author hankoor
 *
 */
public class Main {
	private static final int MATCH_VAL = 3;
	private static final int MISMATCH_VAL = -3;
	private static final int INDEL_START = -8;
	private static final int INDEL_EXTENSION = -1;
	
	private static void loadFile(String fileName) {
		File file = new File(fileName);
		if (!file.canRead() || !file.isFile()) {
			System.exit(1);
		}
		BufferedReader in;
		String row = "";
		try {
			in = new BufferedReader(new FileReader(fileName));
			while ((row = in.readLine()) != null) {
				//read line and get strings
				row.split("\\|");
				String left = row.split("\\|")[0].trim();
				String right = row.split("\\|")[1].trim();				
				System.out.println(left + " " + right);
				
				//init the matrix
				int m = left.length()+1;
				int n = right.length()+1;
				int[][] matr = new int[m][n];
				matr[0][0] = 0;
				for(int i = 1; i < m; i++){
					matr[i][0] = i*(-1);
				}
				for(int i = 1; i < n; i++){
					matr[0][i] = i*(-1);
				}
				
				//init check
				
				printArray(matr);
				
				//END init check
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void printArray(int matrix[][]) {
	    for (int row = 0; row < matrix.length; row++) {
	        for (int column = 0; column < matrix[row].length; column++) {
	            System.out.print(matrix[row][column] + " ");
	        }
	        System.out.println();
	    }
	}
	
	

	/**
	 * 
	 * @param pathToFile
	 */
	public static void main(String[] pathToFile) {
		if ((pathToFile != null) && (pathToFile.length == 1) && (!pathToFile[0].isEmpty())) {
			loadFile(pathToFile[0]);
		}
	}
}