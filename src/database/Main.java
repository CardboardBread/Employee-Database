package database;

public class Main {
	
	public static final String empSplitter = ",";
	public static final int bucketCount = 2;
	public static OpenHashTable table;

	public static void main(String[] args) {
		table = new OpenHashTable(bucketCount);
		
	}
	
	public static void saveTable () {
		
	}
	
	public static void loadTable () {
		
	}

	public static EmployeeInfo buildEmp (String line) {
		
	}
	
	public static EmployeeInfo storageToEmployee (String storage) {
		String[] split = storage.split(empSplitter);
		return new EmployeeInfo(Integer.parseInt(split[0]), split[1], split[2], split[3], split[4]);
	}
	
	public static String employeeToStorage (EmployeeInfo employee) {
		String out = employee.getNum() + empSplitter
				+ employee.getFirst() + empSplitter
				+ employee.getLast() + empSplitter
				+ employee.getSex() + empSplitter
				+ employee.getWorkLoc();
		return out;
	}
}
