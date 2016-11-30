package database;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import display.MainMenu;
import display.Record;
import display.Global;

public class Database {

	public static final String empSplitter = ",";
	public static final int databaseWidth = 2;

	public static String workingFile;
	public static OpenHashTable table;
	public static MainMenu menu;

	public static void main(String[] args) {
		try {
			menu = new MainMenu("Database");
			menu.setVisible(true);
			newDatabase();
			menu.populate(table.toList());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Clears the database by recycling its hashtable handler.
	 */
	public static void newDatabase() {
		System.out.println("Creating a new Database.");
		table = new OpenHashTable(databaseWidth);
		workingFile = null;
		menu.populate(table.toList());
	}

	/**
	 * Attempts to save the database with a previously defined working file
	 * name. If no name is found, an attempt to save as will be made.
	 */
	public static void saveDatabase() {
		if (workingFile != null) {
			finishSaveAs(workingFile);
		} else {
			saveDatabaseAs();
		}
	}

	/**
	 * Opens a dialog to define the name of the database that is to be saved.
	 */
	public static void saveDatabaseAs() {
		try {
			Global frame = new Global("Save As...", true, "");
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Called once the user has finished inputting data, which it will then use
	 * to write the current database to file.
	 * 
	 * @param fileName
	 *            the name of the file to be written to.
	 */
	public static void finishSaveAs(String fileName) {
		ArrayList<Employee> empOut = table.toList();
		ArrayList<String> strOut = new ArrayList<String>();
		for (Employee emp : empOut) {
			if (emp.getClass() == FullTimeEmployee.class) {
				strOut.add(fullTimeToString((FullTimeEmployee) emp));
			} else if (emp.getClass() == PartTimeEmployee.class) {
				strOut.add(partTimeToString((PartTimeEmployee) emp));
			} else {
				strOut.add(employeeToString(emp));
			}
		}
		try {
			FileLoader.writeFile(strOut, fileName);
		} catch (FileNotFoundException e) {
			System.out.println("Failed to save file to " + fileName);
			e.printStackTrace();
		}
	}

	/**
	 * Initiates the load database GUI.
	 */
	public static void loadDatabase() {
		try {
			Global frame = new Global("Load...", false, "");
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			menu.populate(table.toList());
		}
	}

	/**
	 * Attempts to read the provided file from the filesystem, and translate its
	 * contents into the hashtable.
	 * 
	 * @param fileName
	 *            the file to be read from.
	 */
	public static boolean finishLoad(String fileName) {
		ArrayList<String> contents = null;
		try {
			contents = FileLoader.readFile(fileName);
			for (String str : contents) {
				table.addEmployee(storageToEmployee(str));
			}
			workingFile = fileName;
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("File " + fileName + " not found.");
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			menu.populate(table.toList());
		}
	}

	/**
	 * Called from external classes to submit an employee object to either
	 * replace an existing or add an employee.
	 * 
	 * @param subject
	 *            the employee object that will enter the database.
	 */
	public static void submitEmployee(Employee subject) {
		if (table.searchEmployee(subject.getNum()) != null) {
			replaceEmployee(subject);
		} else {
			table.addEmployee(subject);
		}
		menu.populate(table.toList());
	}

	/**
	 * Removes an employee containing the provided ID.
	 * 
	 * @param ident
	 *            the identification number of the employee that is to be
	 *            removed.
	 * @return the employee object that has been removed from the hashtable.
	 */
	public static Employee deleteEmployee(int ident) {
		Employee out = table.removeEmployee(ident);
		menu.populate(table.toList());
		return out;
	}

	/**
	 * Using the identification of the provided employee, the original employee
	 * will be removed and the new one is put in the previous's place.
	 * 
	 * @param subject
	 *            the employee to replace the older version
	 * @return the employee pulled out of the hashtable
	 */
	public static Employee replaceEmployee(Employee subject) {
		Employee old = table.searchEmployee(subject.getNum());
		table.removeEmployee(old.getNum());
		table.addEmployee(subject);
		menu.populate(table.toList());
		return old;
	}
	
	public static void newEmployee () {
		try {
			Record frame = new Record("New Employee...", null);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Translates a employee data string read from a database file into an
	 * employee object.
	 * 
	 * @param storage
	 *            The string to be translated.
	 * @return The resultant employee object.
	 */
	private static Employee storageToEmployee(String storage) {
		String[] split = storage.split(empSplitter);
		if (split.length == 10) {
			return new PartTimeEmployee(Integer.parseInt(split[0]), split[1], split[2], split[3], split[4],
					Float.parseFloat(split[5]), Float.parseFloat(split[6]), Float.parseFloat(split[7]),
					Float.parseFloat(split[8]), Integer.parseInt(split[9]));
		} else if (split.length == 8) {
			return new FullTimeEmployee(Integer.parseInt(split[0]), split[1], split[2], split[3], split[4],
					Float.parseFloat(split[5]), Float.parseFloat(split[6]), Integer.parseInt(split[7]));
		} else if (split.length == 5) {
			return new Employee(Integer.parseInt(split[0]), split[1], split[2], split[3], split[4]);
		} else {
			return null;
		}

	}

	/**
	 * Translates a base employee object into a write-capable string.
	 * 
	 * @param employee
	 *            The employee object to be transformed.
	 * @return The string to be written to file.
	 */
	private static String employeeToString(Employee employee) {
		String out = employee.getNum() + empSplitter + employee.getFirst() + empSplitter + employee.getLast()
				+ empSplitter + employee.getSex() + empSplitter + employee.getWorkLoc();
		return out;
	}

	/**
	 * Translate a full time employee into a write-capable string.
	 * 
	 * @param employee
	 *            The employee object to be transformed.
	 * @return The string to be written to file.
	 */
	private static String fullTimeToString(FullTimeEmployee employee) {
		String out = employee.getNum() + empSplitter + employee.getFirst() + empSplitter + employee.getLast()
				+ empSplitter + employee.getSex() + empSplitter + employee.getWorkLoc() + empSplitter
				+ employee.getSalary() + empSplitter + employee.getDeductible() + empSplitter + employee.getSeniority();
		return out;
	}

	/**
	 * Translate a part time employee into a write-capable string.
	 * 
	 * @param employee
	 *            The employee object to be transformed.
	 * @return The string to be written to file.
	 */
	private static String partTimeToString(PartTimeEmployee employee) {
		String out = employee.getNum() + empSplitter + employee.getFirst() + empSplitter + employee.getLast()
				+ empSplitter + employee.getSex() + empSplitter + employee.getWorkLoc() + empSplitter
				+ employee.getHourlyWage() + empSplitter + employee.getDeductible() + empSplitter
				+ employee.getHoursPerWeek() + empSplitter + employee.getHoursPerYear() + empSplitter
				+ employee.getWorkTerm();
		return out;
	}
}
