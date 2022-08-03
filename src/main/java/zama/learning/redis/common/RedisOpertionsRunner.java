package zama.learning.redis.common;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import lombok.extern.slf4j.Slf4j;
import zama.learning.redis.dao.IEmployeeDao;
import zama.learning.redis.entity.Employee;

@Slf4j
public class RedisOpertionsRunner implements CommandLineRunner {

    @Autowired
    private IEmployeeDao empDao;

    @Override
    public void run(String... args) throws Exception {

       empDao.saveEmployee(new Employee(500, "Emp0", 2150.0));

       empDao.saveAllEmployees(
            Map.of( 501, new Employee(501, "Emp1", 2396.0),
                    502, new Employee(502, "Emp2", 2499.5),
                    503, new Employee(503, "Emp4", 2324.75)
                  )
       );

       empDao.updateEmployee(new Employee(503, "Emp3", 2325.25));

       empDao.deleteEmployee(500);

       empDao.getAllEmployees().forEach((k,v)-> log.info(k +" : "+v));

       log.info("Emp details for 501 : "+empDao.getOneEmployee(501));
    }
}