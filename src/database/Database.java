package database;


import java.util.ArrayList;

import display.MainMenu;
import display.SaveDatabaseAs;

public class Database {
	public static final String empSplitter = ",";
	public static String workingFile;
	public static OpenHashTable table;

	public static void main(String[] args) {
		try {
			MainMenu frame = new MainMenu();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void newDatabase (int count) {
		table = new OpenHashTable(count);
		workingFile = null;

	}
	
	public static void newDatabase (int count, String name) {
		table = new OpenHashTable(count);
		workingFile = name;
	}
	
	/**
	 * Attempts to save the database with a previously defined working file name.
	 * If no name is found, an attempt to save as will be made.
	 */
	public static void saveDatabase () {
		if (workingFile != null) {
			ArrayList<Employee> empOut = table.toList();
			ArrayList<String> strOut = new ArrayList<String>();
			for (Employee emp : empOut) {
				strOut.add(employeeToString(emp));
			}
			FileLoader.writeFile(strOut, workingFile);
		} else {
			saveDatabaseAs();
		}
	}
	
	/**
	 * Opens a dialog to define the name of the database that is to be saved.
	 */
	public static void saveDatabaseAs () {
		try {
			SaveDatabaseAs frame = new SaveDatabaseAs();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Called once the user has finished inputting data, which it will then use to write the current database to file.
	 * @param fileName The name of the file to be written to.
	 */
	public static void finishSaveAs (String fileName) {
		ArrayList<Employee> empOut = table.toList();
		ArrayList<String> strOut = new ArrayList<String>();
		for (Employee emp : empOut) {
			strOut.add(employeeToString(emp));
		}
		FileLoader.writeFile(strOut, fileName);
	}
	
	/**
	 * Attempts to read the provided file from the filesystem, and translate its contents into the hash table.
	 * @param fileName The file to be read from.
	 */
	public static void loadDatabase (String fileName) {
		ArrayList<String> contents = FileLoader.readFile(fileName);
		for (String str : contents) {
			table.addEmployee(storageToEmployee(str));
		}
		workingFile = fileName;
	}
	
	public static void submitEmployee (Employee subject) {
		
	}

	/**
	 * Removes an employee containing the provided ID.
	 * @param ident the identification number of the employee that is to be removed.
	 * @return the employee object that has been removed from the hash table.
	 */
	public static Employee deleteEmployee (int ident) {
		Employee target = table.searchEmployee(ident);
		Employee out;
		if (!(target == null)) {
			out = table.removeEmployee(ident);
			return out;
		} else {
			return null;
		}
	}
	
	public static void editEmployeee (int ident) {
		// open edit record dialog
	}
	
	public static void finishEdit (Employee subject) {
		// edit record dialog call this with object to change
	}
	
	public static void replaceEmployee (int oldEmp) {
		// open replace record dialog
	}
	
	public static void finishReplace (Employee subject) {
		// replace record dialog call
	}
	
	public static Employee searchEmployee (int ident) {
		return table.searchEmployee(ident);
	}
	
	/**
	 * Translates a employee data string read from a database file into an employee object.
	 * @param storage The string to be translated.
	 * @return The resultant employee object.
	 */
	private static Employee storageToEmployee (String storage) {
		String[] split = storage.split(empSplitter);
		if (split.length == 10) {
			return new PartTimeEmployee(Integer.parseInt(split[0]),
					split[1],
					split[2],
					split[3],
					split[4],
					Float.parseFloat(split[5]),
					Float.parseFloat(split[6]),
					Float.parseFloat(split[7]),
					Float.parseFloat(split[8]),
					Integer.parseInt(split[9]));
		} else if (split.length == 8) {
			return new FullTimeEmployee(Integer.parseInt(split[0]),
					split[1],
					split[2],
					split[3],
					split[4],
					Float.parseFloat(split[5]),
					Float.parseFloat(split[6]),
					Integer.parseInt(split[7]));
		} else if (split.length == 5) {
			return new Employee(Integer.parseInt(split[0]),
					split[1],
					split[2],
					split[3],
					split[4]);
		} else {
			return null;
		}
		
	}
	
	/**
	 * Translates a base employee object into a write-capable string.
	 * @param employee The employee object to be transformed.
	 * @return The string to be written to file.
	 */
	private static String employeeToString (Employee employee) {
		String out = employee.getNum() + empSplitter
				+ employee.getFirst() + empSplitter
				+ employee.getLast() + empSplitter
				+ employee.getSex() + empSplitter
				+ employee.getWorkLoc();
		return out;
	}
	
	/**
	 * Translate a full time employee into a write-capable string.
	 * @param employee The employee object to be transformed.
	 * @return The string to be written to file.
	 */
	private static String fullTimeToString (FullTimeEmployee employee) {
		String out = employee.getNum() + empSplitter
				+ employee.getFirst() + empSplitter
				+ employee.getLast() + empSplitter
				+ employee.getSex() + empSplitter
				+ employee.getWorkLoc() + empSplitter
				+ employee.getSalary() + empSplitter
				+ employee.getDeductible() + empSplitter
				+ employee.getSeniority();
		return out;
	}
	
	/**
	 * Translate a part time employee into a write-capable string.
	 * @param employee The employee object to be transformed.
	 * @return The string to be written to file.
	 */
	private static String partTimeToString (PartTimeEmployee employee) {
		String out = employee.getNum() + empSplitter
				+ employee.getFirst() + empSplitter
				+ employee.getLast() + empSplitter
				+ employee.getSex() + empSplitter
				+ employee.getWorkLoc() + empSplitter
				+ employee.getHourlyWage() + empSplitter
				+ employee.getDeductible() + empSplitter
				+ employee.getHoursPerWeek() + empSplitter
				+ employee.getHoursPerYear() + empSplitter
				+ employee.getWorkTerm();
		return out;
	}
}
