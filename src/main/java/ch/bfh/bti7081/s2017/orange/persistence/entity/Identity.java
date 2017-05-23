package ch.bfh.bti7081.s2017.orange.persistence.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author yvesbeutler
 * Base class for all entities in the application. It provides basic functionality like
 * optimized console output with additional information.
 */
@MappedSuperclass
public abstract class Identity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    public long getId() {
        return id;
    }

    /**
     * Used for comparing any model instances of this abstract class.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identity identity = (Identity) o;
        return Objects.equals(id, identity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Generic output for logging purposes.
     */
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[id=]" + id + "]";
    }
}
