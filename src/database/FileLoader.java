package database;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileLoader {

	FileReader fileReader;
	BufferedReader bufferedReader;
	String line;

	public FileLoader(String fileName) {

		try {
			fileReader = new FileReader(fileName);
			bufferedReader = new BufferedReader(fileReader);
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (@SuppressWarnings("hiding") IOException ex) {
			ex.printStackTrace();
		}

	}

	public ArrayList<String> readFile() {
		ArrayList<String> fileLoad = new ArrayList<String>();
		try {
			while ((line = bufferedReader.readLine()) != null) {
				fileLoad.add(line);
			}
		} catch (NumberFormatException e) {
			System.out.println("BufferedReader could not be read");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("BufferedReader could not be read");
			e.printStackTrace();
		}
		return fileLoad;
	}
}
