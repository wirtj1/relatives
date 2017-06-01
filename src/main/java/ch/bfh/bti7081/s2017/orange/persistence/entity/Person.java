package ch.bfh.bti7081.s2017.orange.persistence.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yvesbeutler
 * Representation of a person. This abstract class is used by {@link Patient},
 * {@link Professional} and {@link Relative}.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person extends Identity {

    private Salutation salutation;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private Date birthdate;
    @OneToOne
    private Address address;
    private String phone;
    private Title title;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    protected Person() {
    }

    public Salutation getSalutation() {
        return salutation;
    }

    public void setSalutation(Salutation salutation) {
        this.salutation = salutation;
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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public String getBirthdateAsString() {
        return new SimpleDateFormat("dd.MM.YYYY").format(getBirthdate());
    }
    public void setBirthdateAsString(String bday) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.YYYY");
        Date date = sdf.parse(bday);
        this.birthdate = date;
    }
}
