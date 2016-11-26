package database;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileLoader {
	
	public static ArrayList<String> readFile(String fileName) {
		ArrayList<String> fileLoad = new ArrayList<String>();
		String line;
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while ((line = bufferedReader.readLine()) != null) {
				fileLoad.add(line);
			}
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'.");
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return fileLoad;
	}

	public static void writeFile(ArrayList<String> load, String fileName) {
		try {
			PrintWriter writer = new PrintWriter(fileName);
			for (int i = 0; i < load.size(); i++){
				writer.println(load.get(i));
			}
			writer.close();
		} catch (Exception e) {
			System.out.println("Could not create a file with the name " + fileName + ".");
			e.printStackTrace();
		}
	}
}
