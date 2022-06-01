package registration.daoImpl;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import registration.dao.EmployeeDao;
import registration.mapper.EmployeeMapper;
import registration.model.Department;
import registration.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao{
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private DataSource dataSource;
	
	@PostConstruct
	public void initEmployeeDaoImpl() {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	public void insertOrUpdate(Employee employee) {
		
	    if (employee.getID() > 0) {
	        // update
	        String sql = "UPDATE MegaClass.Employee SET FirstName=?, LastName=?, Age=?, "
	                    + "Email=?, Phone=?, Salary=?, DepartmentID=? WHERE ID=?";
	        jdbcTemplate.update(sql, employee.getFirstName(), 
	        		employee.getLastName(), 
	        		employee.getAge(),
	        		employee.getEmail(), 
	        		employee.getPhone(), 
	        		employee.getSalary(), 
	        		employee.getDepartment().getID(),
	                employee.getID());
	    } else {
	        // insert
	        String sql = "INSERT INTO MegaClass.Employee" +
	                " (FirstName, LastName, Age, Email, Phone, Salary, DepartmentID)" +
	                " VALUES (?, ?, ?, ?, ?, ?, ?);";
	        jdbcTemplate.update(sql, employee.getFirstName(), 
					        		employee.getLastName(), 
					        		employee.getAge(),
					        		employee.getEmail(), 
					        		employee.getPhone(), 
					        		employee.getSalary(), 
					        		employee.getDepartment().getID());
	    } 
	}
	
	public void delete(int ID) {
	    String sql = "DELETE FROM MegaClass.Employee WHERE ID=?";
	    jdbcTemplate.update(sql, ID);
	}
	
	public List<Employee> list(List<Department>departmentList) {
	    String sql = "SELECT * FROM MegaClass.Employee";
	    List<Employee> listEmployee = 
	    		jdbcTemplate.query(sql, new EmployeeMapper(departmentList));
	    return listEmployee;
	}
	
	public Employee get(int ID, List<Department>departmentList) {
	    String sql = "SELECT * FROM MegaClass.Employee WHERE ID=" + ID;
	    return jdbcTemplate.query(sql, new EmployeeMapper(departmentList)).get(0);
	}
}
