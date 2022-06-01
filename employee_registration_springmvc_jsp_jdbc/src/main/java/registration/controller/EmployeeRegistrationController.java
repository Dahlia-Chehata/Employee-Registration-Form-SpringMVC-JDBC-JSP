package registration.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import registration.model.Department;
import registration.model.Employee;
import registration.service.DepartmentService;
import registration.service.EmployeeService;

@Controller
public class EmployeeRegistrationController {
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentService departmentService;
	static List <Department> departmentList = null;
	
	@RequestMapping(value="/")
	public ModelAndView home(ModelAndView model) throws IOException{
		model.setViewName("home");
		return model;
	}
	
	@RequestMapping(value="/admin")
	public ModelAndView listEmployee(ModelAndView model) throws IOException{
		String welcomeMessage = "Welcome to Admin Page!";
		departmentList = departmentService.list();
		List<Employee> employeeList = employeeService.list(departmentList);
		model.addObject("employeeList", employeeList);
		model.addObject("welcomeMessage", welcomeMessage);
		model.setViewName("admin");
		return model;
	}
	
	@RequestMapping(value = "/admin/newEmployee", method = RequestMethod.GET)
	public ModelAndView newEmployee(ModelAndView model) {
		Employee employee = new Employee();
		model.addObject("employee", employee);
		model.addObject("listDepartment", departmentList);
		model.setViewName("RegistrationForm");
		return model;
	}
	
	@RequestMapping(value = "/admin/register", method = RequestMethod.POST)
	public ModelAndView register(
			@ModelAttribute Employee employee, ModelAndView model) {
		employeeService.insert(employee);		
		return new ModelAndView("redirect:/admin");
	}
	
	@RequestMapping(value="admin/delete/{ID}", 
			method= {RequestMethod.DELETE, RequestMethod.GET},
			produces = MediaType.APPLICATION_JSON_VALUE)
//			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Employee deleteEmployee(@PathVariable int ID) {
		Employee e = employeeService.get(ID, departmentList);
		employeeService.delete(ID);
		return e;
	}
	
	/** Another working solution for delete without AJAX */
	
//	@RequestMapping(value = "/admin/deleteEmployee", 
//			method = RequestMethod.GET)
//	public ModelAndView deleteEmployee(HttpServletRequest request) {
//		int ID = Integer.parseInt(request.getParameter("ID"));
//		employeeService.delete(ID);
//		return new ModelAndView("redirect:/admin");
//	}
	
	@RequestMapping(value = "/admin/editEmployee", method = RequestMethod.GET)
	public ModelAndView editEmployee(
			HttpServletRequest request) {
		int ID = Integer.parseInt(request.getParameter("ID"));
		Employee employee = employeeService.get(ID, departmentList);
		ModelAndView model = new ModelAndView("RegistrationForm");
		model.addObject("listDepartment", departmentList);
		model.addObject("employee", employee);
		//model.addObject("SelectedDepartmentID", employee.getDepartment().getID());
		return model;
	}

    @RequestMapping("/error")
    public String error(ModelMap model){
        model.addAttribute("error", "true");
        return "login";
    }

    @RequestMapping("/login")
    public String login(){
        System.out.println("Inside login");
        return "login";
    }

    @RequestMapping(value = "/admin/logout", method = RequestMethod.GET)
	public ModelAndView logout() {
		return new ModelAndView("redirect:/");
	}
}