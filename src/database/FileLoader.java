package database;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileLoader {
	
	/**
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static ArrayList<String> readFile(String fileName) throws IOException, FileNotFoundException {
		ArrayList<String> fileLoad = new ArrayList<String>();
		String line;
		FileReader fileReader = new FileReader(fileName);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		while ((line = bufferedReader.readLine()) != null) {
			fileLoad.add(line);
		}
		bufferedReader.close();
		return fileLoad;
	}

	/**
	 * 
	 * @param load
	 * @param fileName
	 * @throws FileNotFoundException
	 */
	public static void writeFile(ArrayList<String> load, String fileName) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(fileName);
		for (int i = 0; i < load.size(); i++){
			writer.println(load.get(i));
		}
		writer.close();
	}
}
