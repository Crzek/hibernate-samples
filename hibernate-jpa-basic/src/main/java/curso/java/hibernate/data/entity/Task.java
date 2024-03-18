package curso.java.hibernate.data.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity  // Define que esta clase es una entidad persistente
@Table(name = "TBL_TASK")  // Define el nombre de la tabla en la base de datos
public class Task implements Serializable { // para poder Serializar
    @Id  // Marca el campo como clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Genera valores automáticamente para el campo
    @Column  // Define la columna en la base de datos
    private Integer id;

    @Column  // Define la columna en la base de datos
    private String taskName;

    @Column  // Define la columna en la base de datos
    private String taskDescription;

    @Column
    private Integer employeeId;

//    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)  // Define una relación (one to many) con otra entidad
//    @JoinColumn(name = "id") // este es id de "TBL_SCOPE"
    @Column
    private Integer idScope;

    // Constructor vacío, requerido por JPA
    public Task() {
    }

    public void addScope(Scope scope){
        this.setIdScope(scope.getId());
    }

    public void  setIdScope(int scope){
        this.idScope = scope;
    }
    public Integer getIdScope(){
        return  this.idScope;
    }

    // Métodos de acceso (getters y setters)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    @Override  // Sobrescribe el método toString para representar la información del objeto como una cadena
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", idScope='" + idScope + '\'' +
                '}';
    }
}
