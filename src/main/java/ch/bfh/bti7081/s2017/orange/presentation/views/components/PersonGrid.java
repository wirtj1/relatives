package ch.bfh.bti7081.s2017.orange.presentation.views.components;

import ch.bfh.bti7081.s2017.orange.persistence.entity.Address;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Person;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Salutation;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Title;
import com.vaadin.data.Binder;
import com.vaadin.server.ClientConnector;
import com.vaadin.ui.*;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Component for showing the Person
 *
 * @param <P>
 * @author Joy Wirth
 */
public abstract class PersonGrid<P extends Person> extends VerticalLayout {

    private final SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");

    private Binder<P> binder;
    private P person;
    private GridLayout personalGrid;
    private GridLayout addressGrid;
    private GridLayout buttonGrid;

    private ComboBox<Salutation> salutation = new ComboBox<>("Anrede");
    private ComboBox<Title> title = new ComboBox<>("Titel");
    private TextField firstName = new TextField("Vorname", "");
    private TextField lastName = new TextField("Nachname", "");
    private TextField birthdate = new TextField("Geburtstag", "");
    private TextField phone = new TextField("Telefon Nummer", "");

    //Address
    private TextField company = new TextField("Firma", "");
    private TextField streetName = new TextField("Strasse", "");
    private TextField streetNumber = new TextField("Nr", "");
    private TextField postBox = new TextField("Postfach", "");
    private TextField postalCode = new TextField("PLZ", "");
    private TextField city = new TextField("Ort", "");
    private TextField country = new TextField("Land", "");

    private Button editButton = new Button("Bearbeiten");
    private Button saveButton = new Button("Speichern");
    private Button cancelButton = new Button("Abbrechen");
    private Button deleteButton = new Button("Löschen");

    public PersonGrid(P person) {
        this.person = person;
        personalGrid = new GridLayout(2, 3);
        addressGrid = new GridLayout(2, 6);
        buttonGrid = new GridLayout();
        binder = new Binder<>();

        binder.bind(salutation, Person::getSalutation, Person::setSalutation);
        salutation.setItems(Arrays.asList(Salutation.values()));
        binder.bind(title, Person::getTitle, Person::setTitle);
        title.setItems(Arrays.asList(Title.values()));


        binder.bind(firstName, Person::getFirstName, Person::setFirstName);
        binder.bind(lastName, Person::getLastName, Person::setLastName);
        binder.bind(birthdate,
                p -> person.getBirthdateAsString(),
                (p, date) -> {
                    try {
                        person.setBirthdateAsString(date);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                });
        binder.forField(phone).bind(Person::getPhone, Person::setPhone);

        Address address = person.getAddress();
        binder.bind(company, ad -> address.getCompany(), (ad, co) -> address.setCompany(co));
        binder.bind(streetName, ad -> address.getStreetName(), (ad, sn) -> address.setStreetName(sn));
        binder.bind(streetNumber, ad -> address.getStreetNumber(), (ad, sn) -> address.setStreetNumber(sn));
        binder.bind(postalCode, ad -> address.getPostalCode(), (ad, pc) -> address.setPostalCode(pc));
        binder.bind(postBox, ad -> address.getPostBox(), (ad, pb) -> address.setPostBox(pb));
        binder.bind(city, ad -> address.getCity(), (ad, cy) -> address.setCity(cy));
        binder.bind(country, ad -> address.getCountry(), (ad, co) -> address.setCountry(co));

        personalGrid.addComponent(salutation);
        personalGrid.addComponent(title);
        personalGrid.addComponent(firstName);
        personalGrid.addComponent(lastName);
        personalGrid.addComponent(birthdate);
        //address
        addressGrid.addComponent(company, 0, 0);
        addressGrid.addComponent(streetName, 0, 1);
        addressGrid.addComponent(streetNumber, 1, 1);
        addressGrid.addComponent(postBox, 0, 2);
        addressGrid.addComponent(postalCode, 0, 3);
        addressGrid.addComponent(city, 1, 3);
        addressGrid.addComponent(country, 0, 4);
        addressGrid.addComponent(phone, 0, 5);

        buttonGrid.addComponent(editButton);
        buttonGrid.addComponent(deleteButton);
        buttonGrid.addComponent(saveButton);
        buttonGrid.addComponent(cancelButton);

        this.addComponent(personalGrid);
        this.addComponent(addressGrid);
        this.addComponent(buttonGrid);
        binder.readBean(person);
    }


    public void setToEditMode() {
        editButton.setVisible(false);
        deleteButton.setVisible(false);
        cancelButton.setVisible(true);
        saveButton.setVisible(true);

        salutation.setEnabled(true);
        title.setEnabled(true);
        firstName.setEnabled(true);
        lastName.setEnabled(true);
        birthdate.setEnabled(true);

        company.setEnabled(true);
        streetName.setEnabled(true);
        streetNumber.setEnabled(true);
        postBox.setEnabled(true);
        postalCode.setEnabled(true);
        city.setEnabled(true);
        country.setEnabled(true);

        phone.setEnabled(true);
    }

    public void setToViewMode() {
        editButton.setVisible(true);
        deleteButton.setVisible(true);
        cancelButton.setVisible(false);
        saveButton.setVisible(false);

        salutation.setEnabled(false);
        title.setEnabled(false);
        firstName.setEnabled(false);
        lastName.setEnabled(false);
        birthdate.setEnabled(false);

        company.setEnabled(false);
        streetName.setEnabled(false);
        streetNumber.setEnabled(false);
        postBox.setEnabled(false);
        postalCode.setEnabled(false);
        city.setEnabled(false);
        country.setEnabled(false);

        phone.setEnabled(false);
        firstName.setValue(this.person.getFirstName());
        lastName.setValue(this.person.getLastName());
    }

    public P getPerson() {
        return person;
    }

    public void setPerson(P person) {
        this.person = person;
    }

    public GridLayout getGrid() {
        return personalGrid;
    }

    public GridLayout getAddressGrid() {
        return addressGrid;
    }

    public GridLayout getButtonGrid() {
        return buttonGrid;
    }

    public Button getEditButton() {
        return editButton;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public Button getCancelButton() {
        return cancelButton;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public Binder<P> getBinder(){
        return binder;
    }

}
