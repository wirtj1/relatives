package ch.bfh.bti7081.s2017.orange;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

/**
 * @author yvesbeutler
 * Base class for all entities in the application.
 */
public abstract class Identity {

    @Id
    @GeneratedValue
    private String id;


    public String getId() {
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
        return this.getClass().getSimpleName() + "[id=]" + id.substring(0,8) + "...]";
    }
}
