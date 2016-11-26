package database;

import java.util.ArrayList;

public class OpenHashTable
{
	public ArrayList<Employee>[] buckets;
	
	/**
	 * Public constructor for initializing the array of buckets and the contents of each bucket.
	 * @param bucketCount
	 */
	public OpenHashTable (int bucketCount)
	{
		buckets = new ArrayList[bucketCount];
		
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new ArrayList<Employee>();
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
	
	public boolean addEmployee(Employee subject) {
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
	public Employee searchEmployee(int employeeNum) {
		int bIndex = -1;
		int sIndex = -1;
		for (ArrayList<Employee> bucket : buckets) {
			bIndex++;
			for (Employee employee : bucket) {
				sIndex++;
				if (employeeNum == employee.getNum()) {
					//System.out.println("Found employee " + sIndex + " at bucket " + bIndex);
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
	public Employee removeEmployee (int target) {
		for (ArrayList<Employee> bucket : buckets) {
			for (Employee employee : bucket) {
				if (target == employee.getNum()) {
					Employee grab = employee;
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
		for (ArrayList<Employee> bucket : buckets) {
			index++;
			System.out.print("Bucket " + index + " [");
			for (int i = 0; i < bucket.size(); i++) {
				System.out.print(bucket.get(i).getNum() + ":" + bucket.get(i).getFirst() + (i == bucket.size() - 1 ? "]" : ", " ));
			}
			System.out.println();
		}
	}
	
	/**
	 * Translates the hash table into a single dimension ArrayList.
	 * Even though the structure of the hash table is not preserved, a reconstruction will be effortless to create.
	 * @return The hash table in ArrayList form.
	 */
	public ArrayList<Employee> toList () {
		ArrayList<Employee> out = new ArrayList<Employee>();
		for (ArrayList<Employee> bucket : buckets) {
			for (Employee emp : bucket) {
				out.add(emp);
			}
		}
		return out;
	}
}
