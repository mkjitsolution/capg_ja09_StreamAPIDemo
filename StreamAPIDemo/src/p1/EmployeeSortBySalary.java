package p1;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeSortBySalary implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getSalary()-o2.getSalary();
	}

	
}



class ABC
{
	public List<Employee> someRenderOperation(List<Employee>  empList)
	{
		// sort the employee based on Salary
		Collections.sort(empList, new EmployeeSortBySalary());
		
		// return the sorted list
		return empList;
	}

}