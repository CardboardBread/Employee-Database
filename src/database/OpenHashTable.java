package database;

import java.util.ArrayList;

public class OpenHashTable
{
	public ArrayList<EmployeeInfo>[] buckets;
	
	/**
	 * Public constructor for initializing the array of buckets and the contents of each bucket.
	 * @param bucketCount
	 */
	public OpenHashTable (int bucketCount)
	{
		buckets = new ArrayList[bucketCount];
		
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new ArrayList<EmployeeInfo>();
		}
	}
	
	/**
	 * Modulates the value of an employee's number into a possible bucket location.
	 * @param keyValue The employee's number.
	 * @return
	 */
	public int calcBucket (int keyValue) {
		return (keyValue % buckets.length);
	}
	
	public boolean addEmployee(EmployeeInfo subject) {
		try {
			int index = calcBucket(subject.getNum());
			//System.out.println("Adding " + subject.getFirst() + ":" + subject.getNum() + " to " + index + ".");
			buckets[index].add(subject);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * Searches through all buckets to find the provided employee number.
	 * @param employeeNum The target the function searches for.
	 * @return The employee that the search finds.
	 */
	public EmployeeInfo searchEmployee(int employeeNum) {
		int bIndex = -1;
		int sIndex = -1;
		for (ArrayList<EmployeeInfo> bucket : buckets) {
			bIndex++;
			for (EmployeeInfo employee : bucket) {
				sIndex++;
				if (employeeNum == employee.getNum()) {
					System.out.println("Found employee " + sIndex + " at bucket " + bIndex);
					return employee;
				}
			}
		}
		return null;
	}
	
	/**
	 * Removes the target employee from the set of buckets, based on the employee's number.
	 * @param target The ID of the employee that is to be removed.
	 * @return
	 */
	public EmployeeInfo removeEmployee (int target) {
		for (ArrayList<EmployeeInfo> bucket : buckets) {
			for (EmployeeInfo employee : bucket) {
				if (target == employee.getNum()) {
					EmployeeInfo grab = employee;
					bucket.remove(employee);
					return grab;
				}
			}
		}
		return null;
	}
	
	/**
	 * Prints out all contents of the hash table, in numerical order.
	 */
	public void displayContents () {
		int index = -1;
		for (ArrayList<EmployeeInfo> bucket : buckets) {
			index++;
			System.out.print("Bucket " + index + " [");
			for (int i = 0; i < bucket.size(); i++) {
				System.out.print(bucket.get(i).getNum() + ":" + bucket.get(i).getFirst() + (i == bucket.size() - 1 ? "]" : ", " ));
			}
			System.out.println();
		}
	}
}
