import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {


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

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] pathToFile) {
		if ((pathToFile != null) && (pathToFile.length == 1) && (!pathToFile[0].isEmpty())) {
			loadFile(pathToFile[0]);
		}
	}
}