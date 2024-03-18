package curso.java.hibernate;

import curso.java.hibernate.data.EmployeeRepository;
import curso.java.hibernate.data.ScopeRepository;
import curso.java.hibernate.data.entity.Employee;
import curso.java.hibernate.data.entity.Scope;
import curso.java.hibernate.data.entity.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
@EnableJpaAuditing
public class HibernateExampleApp implements CommandLineRunner {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  EmployeeRepository repositoryEmployee;

  @Autowired
  ScopeRepository repositoryScope;

  public static void main(String[] args) { // los args se contienen dentro del [arg,arg2]
    SpringApplication.run(HibernateExampleApp.class, args);
  }

  @Override
  public void run(String... args) throws Exception // variables sueltas: agr, agr2, agr3
  {


    Employee emp2 = new Employee();
    emp2.setEmail("new Employee email");
    emp2.setFirstName("Bart");
    emp2.setLastName("Simpson");

    emp2.setTasks(getTasks());

    repositoryEmployee.save(emp2);
    Optional<Employee> emp = repositoryEmployee.findById(2L);
    emp.ifPresent(employee -> logger.info("Employee id 2 -> {}", emp.get()));

    // Ambito
    Scope scop1 = new Scope();
    scop1.setName("Developer");
    scop1.setDescription("Desarrollar app en Flutter");
    scop1.setTasks(getTasks());

    repositoryScope.save(scop1);
    Optional<Scope> scp = repositoryScope.findById(1L);
    scp.ifPresent(scope -> logger.info("Scope id 1 -> {}", scp.get()));


    repositoryEmployee.findAll().forEach(System.out::println);
    repositoryScope.findAll().forEach(System.out::println);
  }

  private Set<Task> getTasks() {

    Set<Task> tasks = new HashSet<>(); //Coleccion

    Task task1 = new Task();
    task1.setTaskName("report generation");
    task1.setTaskDescription("Daily report generation");
//    task1.addScope(scope);
    tasks.add(task1);

    Task task2 = new Task();
    task2.setTaskName("view generation");
    task2.setTaskDescription("Daily view generation");
//    task2.addScope(scope);
    tasks.add(task2);
    return tasks;
  }


}
