package ch.bfh.bti7081.s2017.orange.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * @author yvesbeutler
 *         Representation of a single pinboard entry. This allows a direct
 *         communication between {@link Relative} and {@link Professional}.
 */
@Entity
public class PinBoardEntry extends Identity {
    private static final long serialVersionUID = 1L;

    private Type type;
    private String title;
    private String message;
    @ManyToOne
    private Person author;
    private Date creationDate;


    public PinBoardEntry(Type type, String title, String message, Person author, Date creationDate) {
        this.type = type;
        this.title = title;
        this.message = message;
        this.author = author;

        // Prevent storing a object which is mutable from outside
        this.creationDate = new Date(creationDate.getTime());
    }

    public PinBoardEntry() {
    }


    public Type getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public Date getCreationDate() {
        // Return a new object to prevent mutations from outside
        return new Date(creationDate.getTime());
    }

    public void setCreationDate(Date creationDate) {
        // Prevent storing a object which is mutable from outside
        this.creationDate = new Date(creationDate.getTime());
    }


    @Override
    public String toString() {
        return "PinBoardEntry{" +
                "type=" + type.name() +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", author=" + author.getFirstName() +
                ", creationDate=" + creationDate +
                '}';
    }
}
