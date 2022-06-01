/**
 * JAVA-based configuration
 * 
 */

package registration.config;
//
//import javax.sql.DataSource;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.format.FormatterRegistry;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.web.servlet.ViewResolver;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import org.springframework.web.servlet.view.JstlView;
//
//import registration.conversion.DepartmentToStringConversion;
//import registration.conversion.StringToDepartmentConversion;
//import registration.dao.DepartmentDao;
//import registration.dao.EmployeeDao;
//import registration.daoImpl.DepartmentDaoImpl;
//import registration.daoImpl.EmployeeDaoImpl;

//@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = {"registration"})
public class AppConfig extends WebMvcConfigurerAdapter{
	
	
//	@Bean
//	public ViewResolver resolver() {
//		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		resolver.setViewClass(JstlView.class);
//		resolver.setPrefix("/WEB-INF/views/");
//		resolver.setSuffix(".jsp");
//		return resolver;
//	}
//	
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
//    }
// 
//    @Bean
//    public DataSource getDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        dataSource.setUrl("jdbc:sqlserver://localhost;database=EmployeeRecords;");
//        dataSource.setUsername("ROOT*123");
//        dataSource.setPassword("ROOT*123"); 
//        return dataSource;
//    }
//    
//    @Bean
//    public DepartmentDao getDepartmentDao() {
//        return new DepartmentDaoImpl();
//    }
//    @Bean
//    public EmployeeDao getEmployeeDao() {
//        return new EmployeeDaoImpl();
//    }
//    
//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverter(new StringToDepartmentConversion());
//        registry.addConverter(new DepartmentToStringConversion());
//    }
}
