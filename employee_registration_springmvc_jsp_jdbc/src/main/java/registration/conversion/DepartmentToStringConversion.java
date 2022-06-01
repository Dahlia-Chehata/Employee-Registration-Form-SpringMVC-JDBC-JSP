package registration.conversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import registration.model.Department;
import registration.service.DepartmentService;

@Component
public class DepartmentToStringConversion  implements Converter<Department, String> {
	
	@Autowired
	DepartmentService departmentService;
	 

	@Override
	public String convert(Department department) {
		return Integer.toString(department.getID())+"."+department.getName();
	}
	 
}
