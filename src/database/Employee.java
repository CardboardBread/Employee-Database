package database;

public class Employee {
	private int empNumber;
	private String firstName;
	private String lastName;
	private String sex;
	private String workLocation;
	
	public Employee (int num, String first, String last, String s, String work) {
		empNumber = num;
		firstName = first;
		lastName = last;
		sex = s;
		workLocation = work;
	}
	
	public int getNum () { return empNumber; }
	public String getFirst () { return firstName; }
	public String getLast () { return lastName; }
	public String getSex  () { return sex; }
	public String getWorkLoc () { return workLocation; }
	
	public void setWork (String value) { workLocation = value; }
	public void setNum (int value) { empNumber = value; }
	
	public String toString() {
		return getNum() + " | " +
				getFirst() + " " +
				getLast();
	}
}
