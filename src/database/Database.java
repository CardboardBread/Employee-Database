package database;


import java.util.ArrayList;

public class Database {
	public static final String empSplitter = ",";
	public static final int bucketCount = 2;
	public static String workingFile;
	public static OpenHashTable table;

	public static void main(String[] args) {
		table = new OpenHashTable(bucketCount);
	}
	
	public static void newDatabase () {
		table = new OpenHashTable(bucketCount);
		workingFile = null;
	}
	
	public static void saveDatabase () {
		if (workingFile != null) {
			ArrayList<Employee> empOut = table.toList();
			ArrayList<String> strOut = new ArrayList<String>();
			for (Employee emp : empOut) {
				strOut.add(employeeToString(emp));
			}
			FileLoader.saveFile(strOut, workingFile);
		} else {
			// open save database as dialog
		}
	}
	
	public static void saveDatabaseAs (String fileName) {
		ArrayList<Employee> empOut = table.toList();
		ArrayList<String> strOut = new ArrayList<String>();
		for (Employee emp : empOut) {
			strOut.add(employeeToString(emp));
		}
		FileLoader.saveFile(strOut, fileName);
	}
	
	public static void loadDatabase (String fileName) {
		ArrayList<String> contents = FileLoader.readFile(fileName);
		for (String str : contents) {
			table.addEmployee(storageToEmployee(str));
		}
		workingFile = fileName;
	}
	
	public static void addEmployee () {
		// Open add record dialog
	}
	
	public static void finishAdd (Employee subject) {
		// add record dialog calls this with object to add
	}

	/**
	 * Removes the employee containing the provided ID.
	 * @param ident The employee number of the employee that is to be removed.
	 * @return The removed employee.
	 */
	public static Employee deleteEmployee (int ident) {
		// removes  the employee at the specified
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
		
	}
	
	public static Employee searchEmployee (String searchTerm) {
		// called every time the search term changes in its field
		// cannot be empty
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
