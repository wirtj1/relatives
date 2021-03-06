package ch.bfh.bti7081.s2017.orange.presentation.views;

import ch.bfh.bti7081.s2017.orange.persistence.entity.Person;
import ch.bfh.bti7081.s2017.orange.persistence.entity.PinBoardEntry;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Type;
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
public class PinCreationView extends BaseView implements IPinboardView
{

    private List<IPinCreationViewListener> listeners;

    private Binder<PinBoardEntry> binderPinBoardEntry = new Binder<>();
    private Binder<Person> binderPerson = new Binder<>();

    private TextField txtAuthor;
    private TextField txtTitle;
    private ComboBox<Type> cmdMsgType;
    private TextArea txtaMessage;

    public PinCreationView()
    {
        listeners = new ArrayList<>();
        VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.setSizeFull();

        setViewTitle(mainLayout);

        mainLayout.addComponent(createFormLayout());
        setCompositionRoot(mainLayout);
    }


    public void setAuthorName(String author)
    {
        if (author.isEmpty()) author = "Current User";
        txtAuthor.setValue(author);
    }


    @Override
    public String getViewName()
    {
        return "PinboradCreationView";
    }

    @Override
    public String getCaption()
    {
        return "Pinnwand Eintrag erstellen";
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent)
    {
        for (IPinCreationViewListener listener : listeners)
        {
            listener.onViewEnter();
        }
    }

    private FormLayout createFormLayout()
    {
        FormLayout form = new FormLayout();
        form.setSizeFull();

        txtAuthor = new TextField("Author");
        form.addComponent(txtAuthor);
        txtAuthor.setEnabled(false);

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

        Button pin = new Button("Post new entry");
        pin.addClickListener(this::saveNewPinEntry);
        form.addComponent(pin);

        return form;
    }

    private PinBoardEntry bindFieldsToPinEntry()
    {
        String title = txtTitle.getValue();
        String message = txtaMessage.getValue();
        Type type = cmdMsgType.getSelectedItem().get();

        return new PinBoardEntry(type, title, message, null, getCurrentDate());
    }


    private void saveNewPinEntry(Button.ClickEvent event)
    {

        PinBoardEntry newPinBoardEntry = bindFieldsToPinEntry();

        for (IPinCreationViewListener listener : listeners)
        {
            listener.createPinEntry(newPinBoardEntry);
        }
    }


    private Date getCurrentDate()
    {
        return new Date();
    }


    @Override
    public void addListener(IBaseViewListener listener)
    {
        if (listener instanceof IPinCreationViewListener)
        {
            listeners.add((IPinCreationViewListener) listener);
        }
    }
}
