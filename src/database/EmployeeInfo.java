package database;
import java.util.Random;

public class EmployeeInfo {
	private int empNumber;
	private String firstName;
	private String lastName;
	private String sex;
	private String workLocation;
	
	public EmployeeInfo () {
		Random rand = new Random();
		empNumber = rand.nextInt();
		firstName = rand.toString().substring(0, rand.toString().length() / 2);
		lastName = rand.toString().substring(rand.toString().length() / 2, rand.toString().length());
	}
	
	public EmployeeInfo (int num, String... params) {
		empNumber = num;
		switch (params.length) {
		case 0:
			break;
		case 1:
			firstName = params[0];
			lastName = null;
			sex = null;
			workLocation = null;
			break;
		case 2:
			firstName = params[0];
			lastName = params[1];
			sex = null;
			workLocation = null;
			break;
		case 3:
			firstName = params[0];
			lastName = params[1];
			sex = params[2];
			workLocation = null;
			break;
		case 4:
			firstName = params[0];
			lastName = params[1];
			sex = params[2];
			workLocation = params[3];
			break;
		}
	}
	
	public int getNum () { return empNumber; }
	public String getFirst () { return firstName; }
	public String getLast () { return lastName; }
	public String getSex  () { return sex; }
	public String getWorkLoc () { return workLocation; }
	
	public void setWork (String value) { workLocation = value; }
	public void setNum (int value) { empNumber = value; }
}
