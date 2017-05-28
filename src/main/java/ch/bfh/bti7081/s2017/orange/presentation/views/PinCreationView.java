package ch.bfh.bti7081.s2017.orange.presentation.views;

import ch.bfh.bti7081.s2017.orange.persistence.entity.Person;
import ch.bfh.bti7081.s2017.orange.persistence.entity.PinBoardEntry;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Relative;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Type;
import ch.bfh.bti7081.s2017.orange.presentation.views.IPinboardView.IPinCreationViewListener;
import com.vaadin.data.Binder;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Jasmin on 16.05.2017.
 */
public class PinCreationView extends BaseView {

    private List<IPinCreationViewListener> listeners;

    private Binder<PinBoardEntry> binderPinBoardEntry = new Binder<>();
    private Binder<Person> binderPerson = new Binder<>();

    private TextField txtAuthor;
    private TextField txtTitle;
    private ComboBox<Type> cmdMsgType;
    private TextArea txtaMessage;

    public PinCreationView() {
        listeners = new ArrayList<>();
        VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.setSizeFull();

        setViewTitle(mainLayout);

        //TODO test
        Relative relative = new Relative();
        relative.setFirstName("TESTAuthor");
        setAuthor(relative);

        mainLayout.addComponent(createFormLayout());
        setCompositionRoot(mainLayout);
    }


    public void setAuthor(Person author) {
        PinBoardEntry pinBoardEntry =
                new PinBoardEntry(null, null, null, author, null);

        binderPinBoardEntry.readBean(pinBoardEntry);
    }

    @Override
    public String getViewName() {
        return "PinboradCreationView";
    }

    @Override
    public String getCaption() {
        return "Pinnwand Eintrag erstellen";
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }

    private FormLayout createFormLayout() {
        FormLayout form = new FormLayout();
        form.setSizeFull();

        txtAuthor = new TextField("Author");
        txtAuthor.setRequiredIndicatorVisible(true);
        form.addComponent(txtAuthor);

        txtTitle = new TextField("Title");
        txtTitle.setRequiredIndicatorVisible(true);
        form.addComponent(txtTitle);

        List<Type> entryTypes = Arrays.asList(Type.values());

        cmdMsgType =
                new ComboBox<>("Entry type", entryTypes);
        cmdMsgType.setEmptySelectionAllowed(false);
        form.addComponent(cmdMsgType);

        txtaMessage = new TextArea("Message");
        txtaMessage.setRequiredIndicatorVisible(true);
        form.addComponent(txtaMessage);
//        //TODO normally comes from validation by Binder
//        txtaMessage.setComponentError(new UserError("TESTESTEST!"));

        Button pin = new Button("Post new entry");
        pin.addClickListener(this::saveNewPinEntry);
        form.addComponent(pin);

        return form;
    }

    /**
     * TODO they say only one binder per instance....
     */
    private void bindFieldsToPinEntry() {


        binderPinBoardEntry.forField(txtTitle)
                // Shorthand for requiring the field to be non-empty
                .asRequired("Title cannot be empty")
                .bind(PinBoardEntry::getTitle, PinBoardEntry::setTitle);

        binderPinBoardEntry.forField(cmdMsgType)
                .bind(PinBoardEntry::getType, PinBoardEntry::setType);

        binderPinBoardEntry.forField(txtaMessage)
                .asRequired("Message cannot be empty")
                .bind(PinBoardEntry::getMessage, PinBoardEntry::setMessage);

        binderPerson.bind(txtAuthor, Person::getFirstName, Person::setFirstName);
    }

    private void saveNewPinEntry(Button.ClickEvent event) {

        bindFieldsToPinEntry();

        PinBoardEntry newPinBoardEntry = binderPinBoardEntry.getBean();

        if (newPinBoardEntry == null) return;

        newPinBoardEntry.setCreationDate(getCurrentDate());
        newPinBoardEntry.setAuthor(binderPerson.getBean());

        for (IPinCreationViewListener listener : listeners) {
            listener.createPinEntry(newPinBoardEntry);
        }
    }


    private Date getCurrentDate() {
        return new Date();
    }

}
