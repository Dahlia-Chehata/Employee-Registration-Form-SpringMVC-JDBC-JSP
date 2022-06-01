package registration.service;

import java.util.List;

import registration.model.Department;
import registration.model.Employee;

public interface EmployeeService {
	public void insert(Employee employee);
	public List<Employee> list(List<Department>departmentList);
	public void delete(int ID);
	public Employee get(int ID, List<Department>departmentList);
}
