package database;

public class PartTimeEmployee extends Employee {
	
	private float hourlyWage;
	private int workTerm;
	private float hoursPerWeek;
	private float hoursPerYear;
	private float deductible;

	public PartTimeEmployee (int num, String first, String last, String s, String work, float money, float ded, float HPW, float HPY, int time) {
		super(num, first, last, s, work);
		hourlyWage = money;
		workTerm = time;
		deductible = ded;
		hoursPerWeek = HPW;
		hoursPerYear = HPY;
	}
	
	public float getHourlyWage () { return hourlyWage; }
	public int getWorkTerm () { return workTerm; }
	public float getHoursPerWeek () { return hoursPerWeek; }
	public float getHoursPerYear () { return hoursPerYear; }
	public float getDeductible () { return deductible; }
	
	public void setHourlyWage (float value) { hourlyWage = value; }
	public void setWorkTerm (int value) { workTerm = value; }
	public void setHoursPerWeek (float value) { hoursPerWeek = value; }
	public void setHoursPerYear (float value) { hoursPerYear = value; }
	public void setDeductible (float value) { deductible = value; }
	
	public float calcWeeklyWage () {
		return (hourlyWage * hoursPerWeek) * (1 - deductible);
	}
	
	public float calcYearlyWage () {
		return (hourlyWage * hoursPerYear) * (1 - deductible);
	}
}
