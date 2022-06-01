package registration.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import registration.model.Department;
import registration.model.Employee;

public class EmployeeMapper implements RowMapper<Employee>{
	
	private List<Department> departmentList;
	
	public EmployeeMapper(List<Department> departmentList) {
		this.departmentList = departmentList;
	}

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
        employee.setID(rs.getInt("ID"));
        employee.setFirstName(rs.getString("FirstName"));
        employee.setLastName(rs.getString("LastName"));
        employee.setAge(rs.getString("Age"));
        employee.setPhone(rs.getString("Phone"));
        employee.setEmail(rs.getString("Email"));
        employee.setSalary(rs.getFloat("Salary"));
        int departmentID = rs.getInt("DepartmentID");
        employee.setDepartment(departmentList.get(departmentID-1));

        return employee;
	}

}
