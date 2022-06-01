package registration.serviceImpl;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import registration.dao.EmployeeDao;
import registration.daoImpl.EmployeeDaoImpl;
import registration.model.Department;
import registration.model.Employee;
import registration.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDao employeeDao;
	
	private String calculateAge(Employee employee) {
		Date date = employee.getDateOfBirth();
		Instant instant = date.toInstant();
	    ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
	    LocalDate givenDate = zone.toLocalDate();
	    //Calculating the difference between given date to current date.
	    Period period = Period.between(givenDate, LocalDate.now());
	    return "P"+period.getYears()+"Y"+period.getMonths()+"M"+period.getDays()+"D";
	}
	
	private Date calculateDateOfBirth(Employee employee) {
		Period period = Period.parse(employee.getAge());
		LocalDate now = LocalDate.now();
		LocalDate dateOfBirth = now.minus(period);
		
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(dateOfBirth.atStartOfDay(defaultZoneId).toInstant());     
		return date;
	}
	public void insert(Employee employee) {
		employee.setAge(calculateAge(employee));
		employeeDao.insertOrUpdate(employee);
	}
	public List<Employee> list(List<Department>departmentList) {
		return employeeDao.list(departmentList);
	}
	public void delete(int ID) {
		employeeDao.delete(ID);
	}
	public Employee get(int ID, List<Department>departmentList) {
		Employee employee = employeeDao.get(ID, departmentList);
		employee.setDateOfBirth(calculateDateOfBirth(employee));
		return employee;
	}
}
