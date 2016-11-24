package database;

import java.util.ArrayList;

public class Database {
	
	public static final String empSplitter = ",";
	public static final int bucketCount = 2;
	public static OpenHashTable table;

	public static void main(String[] args) {
		
	}
	
	public static void newDatabase () {
		table = new OpenHashTable(bucketCount);
	}
	
	public static void saveDatabase () {
		
	}
	
	public static void loadDatabase () {
		ArrayList<String> contents = new ArrayList<String>();
		for (String str : contents) {
			table.addEmployee(storageToEmployee(str));
		}
	}
	
	/**
	 * Translates a employee data string read from a database file into an employee object.
	 * @param storage The string to be translated.
	 * @return The resultant employee object.
	 */
	public static Employee storageToEmployee (String storage) {
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
	public static String employeeToString (Employee employee) {
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
	public static String fullTimeToString (FullTimeEmployee employee) {
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
	public static String partTimeToString (PartTimeEmployee employee) {
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
