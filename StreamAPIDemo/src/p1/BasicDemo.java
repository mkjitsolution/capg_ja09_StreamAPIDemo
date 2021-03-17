package p1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicDemo {

	public static void main(String[] args) {

		BasicDemo obj = new BasicDemo();
		// obj.basicThings();
		// obj.basicTerminalOperation();

		//obj.minOrMax();
		
		//obj.minOrMaxEmployee();
		
		// obj.filterDemo();
		
		obj.doMapThings();
	}

	public void basicThings() {
		// #1
		List<Integer> list = new ArrayList<>();
		list.add(14);
		list.add(144);
		list.add(414);

		Stream stream = list.stream();

		// #2
		Stream<Integer> stream2 = Stream.of(14, 48, 74, 85);

		// #3
		list = Arrays.asList(15, 48, 75, 15);

	}

	public void basicTerminalOperation() {

		Stream.of(14, 15, 85).forEach((i) -> System.out.println(i));

		List<Integer> list = Arrays.asList(14, 48, 75, 96);

		// ---- old approach
		for (Integer integer : list) {
			System.out.println(integer);
		}

		// ---- through streams -----

		list.stream().forEach((i) -> System.out.println(i));

		
		
		list.stream().forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
			
				System.out.println(t);

			}

			@Override
			public Consumer<Integer> andThen(Consumer<? super Integer> after) {
				return Consumer.super.andThen(after);
			}
		});
		
		
		// ---------------------------------------
		
		
		long count = Stream.of(14,74,15,62).count();
		System.out.println("---->> "+count);
		
		List<String> strlist = Stream.of("fgver","erfver0","erfref000")
				.collect(Collectors.toList());
		

	}// end of method

	public void minOrMax()
	{
		List<Integer> list = Arrays.asList(74,85,69,32,12,10,2,68,71);
		
		int x = list.stream().min((i,j)->i.compareTo(j)).get();
		System.out.println(x);
		
		//  ::
		
	}
	
	public void minOrMaxEmployee()
	{
		Employee e1 = new Employee(1, "A", 15, 200);
		Employee e2 = new Employee(2, "B", 5, 1200);
		Employee e3 = new Employee(3, "C", 3, 2500);
		Employee e4 = new Employee(4, "D", 25, 100);
		
		List<Employee> empList = Arrays.asList(e1,e2,e3,e4);
		
		
		// iterate the loop
		// getSalary 
		// compare with other salary 
		    // if find then assign to min
		
		// int x = list.stream().min((i,j)->i.compareTo(j)).get();
		
		Comparator<Employee> salaryComparator = (emp1,emp2)->(emp1.getSalary()-emp2.getSalary());
		
		Employee e = empList.stream().min(salaryComparator).get();
		System.out.println(e);
	}
	
	public void filterDemo()
	{
		
		List<Integer> intList = Stream.of(14,85,96,25,10,36,75).filter(x->x>50 && x==96).collect(Collectors.toList());
		
		intList.forEach((x)->System.out.println(x));
		
		
		
		Employee e1 = new Employee(1, "A", 15, 200);
		Employee e2 = new Employee(2, "B", 5, 1200);
		Employee e3 = new Employee(3, "A", 3, 2500);
		Employee e4 = new Employee(4, "A", 25, 100);
		
		Comparator<Employee> salaryComparator = (emp1,emp2)->(emp1.getSalary()-emp2.getSalary());
		
		List<Employee> empList = Arrays.asList(e1,e2,e3,e4);
		 int salary = empList.stream().filter(emp1->emp1.getName().equals("A")).min(salaryComparator).get().getSalary();
		System.out.println(salary);
		
		
			
	}
	
	
	public void doMapThings()
	{
		Stream.of(14,141,144).map(x->x+x).forEach(x->System.out.println(x));
		
		Stream.of("sdvds","erfwer","refrewfr").map(x->x.toUpperCase()).forEach(x->System.out.println(x));
		
		System.out.println(" ----------------------------------------------");

		Employee e1 = new Employee(1, "A", 15, 200);
		Employee e2 = new Employee(2, "B", 5, 1200);
		Employee e3 = new Employee(3, "A", 3, 2500);
		Employee e4 = new Employee(4, "A", 25, 100);
		
		List<Employee> empList = Arrays.asList(e1,e2,e3,e4);
		
	
		List<Employee> newSalaryEmpList = empList.stream().map(emp->{
			int oldsalary = emp.getSalary();
			int newSalary = oldsalary + 1000;
			emp.setSalary(newSalary);
			return emp;
		}).collect(Collectors.toList());
		System.out.println("---------------------- New Salary -----------");
		System.out.println(newSalaryEmpList);
	
	
	}//end method
	
	
}// end class

















