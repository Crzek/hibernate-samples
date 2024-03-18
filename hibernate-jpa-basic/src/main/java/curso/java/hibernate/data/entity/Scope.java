package curso.java.hibernate.data.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TBL_SCOPE")
public class Scope implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;


    @Column
    private String name;


    @Column
    private String description;

    // one Scope to Many Task
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)  // Define una relación (one to many) con otra entidad
    @JoinColumn(name = "idScope")  // Define la columna que actúa como clave externa
    private Set<Task> tasks = new HashSet<>();  // Una colección de tareas asociadas al empleado

    public Scope(){}

    public Scope(String name, String description){
        this.name = name;
        this.description = description;
    }

    // setter and getter
    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Scope{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", tasks=" + tasks +
                '}';
    }

    public void setDescription(String description) {
        this.description = description;
    }
}