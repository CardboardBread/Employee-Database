package database;

public class FullTimeEmployee extends EmployeeInfo {

	private float salary;
	private int seniority;
	private float deductible;
	
	public FullTimeEmployee (int num, String first, String last, String s, String work, float money, float ded, int time) {
		super(num, first, last, s, work);
		salary = money;
		deductible = ded;
		seniority = time;
	}
	
	public double getSalary () { return salary; }
	public double getDeductible () { return deductible; }
	public long getSeniority () { return seniority; }
	
	public void setSalary (float value) { salary = value; }
	public void setDeductible (float value) { deductible = value; }
	public void setSeniority (int value) { seniority = value; }
	
	public double calcAnnualSalary () {
		return salary * (1 - deductible);
	}
}
