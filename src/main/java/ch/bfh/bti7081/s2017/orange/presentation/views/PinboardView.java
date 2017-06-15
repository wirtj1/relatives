package ch.bfh.bti7081.s2017.orange.presentation.views;

import ch.bfh.bti7081.s2017.orange.businesslogic.models.PinboardModel;
import ch.bfh.bti7081.s2017.orange.persistence.entity.PinBoardEntry;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Type;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Jasmin on 16.05.2017.
 */
public class PinboardView extends BaseView implements IPinboardView
{


    private List<IPinboardViewListener> listeners;

    private VerticalLayout mainLayout;


    VerticalLayout pinboardLayoutWithPins;


    public PinboardView()
    {

        listeners = new ArrayList<>();

        mainLayout = new VerticalLayout();
        //mainLayout.setMargin(false);
        setViewTitle(mainLayout);

        pinboardLayoutWithPins = new VerticalLayout();

        Button createPinButton = new Button(VaadinIcons.PLUS_CIRCLE);
        mainLayout.addComponent(createPinButton);
        mainLayout.setComponentAlignment(createPinButton, Alignment.TOP_RIGHT);
        createPinButton.addClickListener(this::navigateToAddPinEntryView);

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

        Type msgType = entry.getType();
        Label lblType = new Label(msgType.name().toUpperCase());
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

    @Override
    public void addListener(IBaseViewListener listener)
    {
        listeners.add((IPinboardViewListener) listener);

    }
}
