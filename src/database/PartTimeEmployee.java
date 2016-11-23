package database;

public class PartTimeEmployee extends EmployeeInfo {
	
	private double hourlyWage;
	private long workTerm;
	private double hoursPerWeek;
	private double hoursPerYear;

	public PartTimeEmployee (int num, double money, double HPW, long time, String... params) {
		super(num, params[0], params[1], params[2], params[3]);
		hourlyWage = money;
		workTerm = time;
		hoursPerWeek = HPW;
		hoursPerYear = hoursPerWeek * 52;
	}
	
	public int getNum () { return super.getNum(); }
	public String getFirst () { return super.getFirst(); }
	public String getLast () { return super.getLast(); }
	public String getSex  () { return super.getSex(); }
	public String getWorkLoc () { return super.getWorkLoc(); }
	public double getWage () { return hourlyWage; }
	public long getWorkT () { return workTerm; }
	public double getHPW () { return hoursPerWeek; }
	public double getHPY () { return hoursPerYear; }
	
	public void setWork (String value) { super.setWork(value); }
	public void setNum (int value) { super.setNum(value); }
	public void setWage (float value) { hourlyWage = value; }
	public void setHPW (double value) { hoursPerWeek = value; }
	public void setHPY (double value) { hoursPerYear = value; }
	
	public double calcWeekly () {
		return (hourlyWage * hoursPerWeek);
	}
	
	public double calcYearly () {
		return (hourlyWage * hoursPerYear);
	}
}
