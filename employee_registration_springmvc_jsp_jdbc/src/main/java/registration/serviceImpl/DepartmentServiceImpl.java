package registration.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import registration.dao.DepartmentDao;
import registration.model.Department;
import registration.service.DepartmentService;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentDao departmentDao;
	   
	public List<Department> list(){
		   return departmentDao.list();
	 }
}
