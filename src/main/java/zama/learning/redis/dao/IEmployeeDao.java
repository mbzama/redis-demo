package zama.learning.redis.dao;

import java.util.Map;

import zama.learning.redis.entity.Employee;

public interface IEmployeeDao {
	void saveEmployee(Employee emp);
	Employee getOneEmployee(Integer id);
	void updateEmployee(Employee emp);
	Map<Integer, Employee> getAllEmployees();
	void deleteEmployee(Integer id);
	void saveAllEmployees(Map<Integer, Employee> map);
}
