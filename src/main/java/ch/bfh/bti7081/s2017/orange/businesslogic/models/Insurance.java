package ch.bfh.bti7081.s2017.orange.businesslogic.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by djboris on 09.05.17.
 */
@Entity
public class Insurance implements Serializable {
    @Id
    private Long id;

    private String name;
    private String description;
}
