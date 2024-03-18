package curso.java.hibernate.data.entity;

import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity  // Define que esta clase es una entidad persistente
@Table(name = "TBL_EMPLOYEE")  // Define el nombre de la tabla en la base de datos
public class Employee implements Serializable { // Interfaz para poder Serializar

  @Serial
  private static final long serialVersionUID = -1;

  @Id  // Marca el campo como clave primaria
  @GeneratedValue(strategy = GenerationType.IDENTITY)  // Genera valores automáticamente para el campo
  @Column  // Define la columna en la base de datos
  private Integer id;

  @Column  // Define la columna en la base de datos
  private String email;

  @Column  // Define la columna en la base de datos
  private String firstName;

  @Column  // Define la columna en la base de datos
  private String lastName;


  // Esto no es un Columno de la DB, define la relacion Solo
  // oneEmployee to many task
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)  // Define una relación (one to many) con otra entidad
  @JoinColumn(name = "employeeId")  // Define la columna que actúa como clave externa
  private Set<Task> tasks = new HashSet<>();  // Una colección de tareas asociadas al empleado

  // Métodos de acceso (getters y setters)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Set<Task> getTasks() {
    return tasks;
  }

  public void setTasks(Set<Task> tasks) {
    this.tasks = tasks;
  }

  @Override  // Sobrescribe el método toString para representar la información del objeto como una cadena
  public String toString() {
    return "\n------ " +
            "Employee{" +
            "id=" + id +
            ", email='" + email + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", tasks=" + tasks +
            '}';
  }
}

