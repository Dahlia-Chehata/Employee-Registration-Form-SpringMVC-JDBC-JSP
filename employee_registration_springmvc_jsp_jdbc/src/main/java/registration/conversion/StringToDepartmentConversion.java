package registration.conversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import registration.model.Department;
import registration.service.DepartmentService;

@Component
public class StringToDepartmentConversion implements Converter<String, Department> {
	
	@Autowired
	DepartmentService departmentService;
	 
	@Override
	 public Department convert (String departmentString) {
			String [] department = departmentString.split("\\.");
			return new Department(Integer.parseInt(department[0]), department[1]);
	}
	 
}
