package ch.bfh.bti7081.s2017.orange.presentation.views;

import ch.bfh.bti7081.s2017.orange.businesslogic.models.PinboardModel;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Movement;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Patient;
import ch.bfh.bti7081.s2017.orange.persistence.entity.PinBoardEntry;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Type;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


/**
 * Created by Jasmin on 16.05.2017.
 */
public class PinboardView extends BaseView implements IPinboardView
{


    private List<IPinboardViewListener> listeners;

    private VerticalLayout mainLayout;


    private VerticalLayout pinboardLayoutWithPins;

    private Label lblCurrMovement;


    public PinboardView()
    {
        listeners = new ArrayList<>();

        mainLayout = new VerticalLayout();
        //mainLayout.setMargin(false);
        setViewTitle(mainLayout);

        pinboardLayoutWithPins = new VerticalLayout();

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSizeFull();

        lblCurrMovement = new Label("");
        lblCurrMovement.setIcon(VaadinIcons.MAP_MARKER);
        horizontalLayout.addComponent(lblCurrMovement);
        horizontalLayout.setComponentAlignment(lblCurrMovement, Alignment.TOP_LEFT);

        Button createPinButton = new Button(VaadinIcons.PLUS_CIRCLE);
        horizontalLayout.addComponent(createPinButton);
        horizontalLayout.setComponentAlignment(createPinButton, Alignment.TOP_RIGHT);
        createPinButton.addClickListener(this::navigateToAddPinEntryView);
        mainLayout.addComponent(horizontalLayout);

        setCompositionRoot(mainLayout);
    }


    @Override
    public String getViewName()
    {
        return "PinboradView";
    }

    @Override
    public String getCaption()
    {
        return "Pinnwand";
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent)
    {
        for (IPinboardViewListener listener : listeners)
        {
            listener.onViewEnter();
        }
    }

    private void updatePinboardLayoutWithPins(PinboardModel pinboard)
    {
        pinboardLayoutWithPins.removeAllComponents();
        pinboardLayoutWithPins.setSizeFull();

        pinboard.getEntries().forEach(entry ->
                pinboardLayoutWithPins.addComponent(createPinEntry(entry)));

    }


    private Panel createPinEntry(PinBoardEntry entry)
    {
        Panel pinPanel = new Panel(entry.getTitle());
        VerticalLayout panelLayout = new VerticalLayout();
        panelLayout.setSizeFull();
        HorizontalLayout firstRowLayout = new HorizontalLayout();

        Image blackCircle;
//        try
//        {
//            URI uri = getClass().getResource("circle_black.png").toURI();
//            blackCircle = new Image(null, new FileResource(new File('circle_black.png');
//
//            firstRowLayout.addComponent(blackCircle);
//            firstRowLayout.setComponentAlignment(blackCircle, Alignment.TOP_LEFT);

//        } catch (URISyntaxException e)
//        {
//            e.printStackTrace();
//        }

        Type msgType = Type.valueOf(entry.getType());
        Label lblType = new Label(msgType.name().toUpperCase(Locale.ENGLISH));
        lblType.setStyleName(
                msgType.equals(Type.ALERT) ? "pinboardAlert" :
                        msgType.equals(Type.WARNING) ? "pinboardWarning" : "pinboardInformation");
        firstRowLayout.addComponent(lblType);
        firstRowLayout.setComponentAlignment(lblType, Alignment.MIDDLE_RIGHT);


        String nameAuthor = entry.getAuthor().getFirstName() + " " + entry.getAuthor().getLastName();
        String formattedDate = new SimpleDateFormat("dd.MM.yy").format(entry.getCreationDate());


        Label lblAuthorAndDate = new Label(nameAuthor + ", " + formattedDate);
        lblAuthorAndDate.setStyleName("pinboardSubtitle");

        panelLayout.addComponents(firstRowLayout, lblAuthorAndDate, new Label(entry.getMessage()));


        pinPanel.setContent(panelLayout);
        pinPanel.setSizeFull();

        return pinPanel;
    }

    private void navigateToAddPinEntryView(Button.ClickEvent event)
    {
        for (IPinboardViewListener listener : listeners)
            listener.navigateToAddPinEntry();
    }


    public void setPinboardModel(PinboardModel pinboardModel)
    {
        updatePinboardLayoutWithPins(pinboardModel);
        mainLayout.addComponent(pinboardLayoutWithPins);
    }

    public void setPatient(Patient patient)
    {
        Movement movement = patient.getMovement();

        movement = movement == null ? new Movement() : movement;

        ;
        lblCurrMovement.setValue("Arrival: " + movement.getArrival() + "\n" +
                "Departure: " + movement.getDeparture());
        lblCurrMovement.setContentMode(ContentMode.PREFORMATTED);
    }

    @Override
    public void addListener(IBaseViewListener listener)
    {
        if (listener instanceof IPinboardViewListener)
            listeners.add((IPinboardViewListener) listener);
    }
}
