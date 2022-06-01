package registration.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import registration.model.Department;

public class DepartmentMapper implements RowMapper<Department>{
	
	@Override
    public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
        Department department = new Department(rs.getInt("ID"), 
        		                               rs.getString("Name"));	 
        return department;
    }
}
