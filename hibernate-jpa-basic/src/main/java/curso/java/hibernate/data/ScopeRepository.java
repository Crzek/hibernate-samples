package curso.java.hibernate.data;

import curso.java.hibernate.data.entity.Scope;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScopeRepository extends JpaRepository<Scope, Long> {
}
