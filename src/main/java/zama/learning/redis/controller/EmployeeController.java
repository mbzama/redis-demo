package zama.learning.redis.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import zama.learning.redis.dao.IEmployeeDao;
import zama.learning.redis.entity.Employee;

@Slf4j
@Controller
@RequestMapping(path = "/employee")
public class EmployeeController {
	@Autowired
	private IEmployeeDao employeeDao;
	
	@PostMapping(value = "/create")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
		log.info("createEmployee: {}", employee);
		employeeDao.saveEmployee(employee);
		return ResponseEntity.ok().body(employee);
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<Map<Integer, Employee>> getEmployees(){
		log.info("getEmployees:");
		Map<Integer, Employee> employees = employeeDao.getAllEmployees();
		log.info("{}", employees);
		return ResponseEntity.ok().body(employees);
	}
}
