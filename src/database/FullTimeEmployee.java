package database;

public class FullTimeEmployee extends EmployeeInfo {

	private double salary;
	private long seniority;
	private double deductible;
	
	public FullTimeEmployee (int num, double money, double ded, long time, String... params) {
		super(num, params[0], params[1], params[2], params[3]);
		salary = money;
		seniority = time;
		deductible = ded;
	}
	
	public int getNum () { return super.getNum(); }
	public String getFirst () { return super.getFirst(); }
	public String getLast () { return super.getLast(); }
	public String getSex  () { return super.getSex(); }
	public String getWorkLoc () { return super.getWorkLoc(); }
	public double getSalary () { return salary; }
	public long getSenior () { return seniority; }
	
	public void setWork (String value) { super.setWork(value); }
	public void setNum (int value) { super.setNum(value); }
	public void setSalary (float value) { salary = value; }
	
	public double calcAnnualSalary () {
		return salary * (1 - deductible);
	}
}
