package database;

public class FullTimeEmployee extends Employee {
	private float salary;
	private int seniority;
	private float deductible;

	public FullTimeEmployee(int num, String first, String last, String s, String work, float money, float ded,
			int time) {
		super(num, first, last, s, work);
		salary = money;
		deductible = ded;
		seniority = time;
	}

	public float getSalary() {
		return salary;
	}

	public float getDeductible() {
		return deductible;
	}

	public int getSeniority() {
		return seniority;
	}

	public void setSalary(float value) {
		salary = value;
	}

	public void setDeductible(float value) {
		deductible = value;
	}

	public void setSeniority(int value) {
		seniority = value;
	}

	public float calcAnnualSalary() {
		return salary * (1 - deductible);
	}
}
