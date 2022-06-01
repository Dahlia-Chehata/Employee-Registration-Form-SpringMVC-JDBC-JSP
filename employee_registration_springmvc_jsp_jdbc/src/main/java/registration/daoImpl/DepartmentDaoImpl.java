package registration.daoImpl;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import registration.dao.DepartmentDao;
import registration.mapper.DepartmentMapper;
import registration.model.Department;

public class DepartmentDaoImpl implements DepartmentDao{
	
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	@PostConstruct
	public void initDepartmentDaoImpl() {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }	
	public List<Department> list() {
	    String sql = "SELECT * FROM MegaClass.Department";
	    List<Department> listDepartment = jdbcTemplate.query(sql, new DepartmentMapper());
	    return listDepartment;
	}
}
