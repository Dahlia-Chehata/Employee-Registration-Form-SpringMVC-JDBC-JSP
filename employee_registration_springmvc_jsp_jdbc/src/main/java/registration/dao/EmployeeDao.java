package registration.dao;

import java.util.List;

import registration.model.Department;
import registration.model.Employee;

public interface EmployeeDao {
	public void insertOrUpdate(Employee employee);
	public void delete(int ID);
	public List<Employee> list(List<Department>departmentList);
	public Employee get(int ID, List<Department>departmentList);
}
