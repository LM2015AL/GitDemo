package design.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Employee {

	private String name;
	private String dept;
	private int salary;
	private List<Employee> subordinates;
	
	public Employee(String name, String dept, int salary) {
		super();
		this.name = name;
		this.dept = dept;
		this.salary = salary;
		this.subordinates = new ArrayList<Employee>();
	}

	public List<Employee> getSubordinates() {
		return subordinates;
	}

	public void add(Employee employee) {
		subordinates.add(employee);
	}
	
	public void remove(Employee employee) {
		subordinates.remove(employee);
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", dept=" + dept + ", salary=" + salary + ", subordinates=" + subordinates
				+ "]";
	}
}
