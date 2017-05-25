package ch.bfh.bti7081.s2017.orange.presentation.views;

import ch.bfh.bti7081.s2017.orange.businesslogic.models.PinboardModel;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Patient;
import ch.bfh.bti7081.s2017.orange.persistence.entity.PinBoardEntry;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Relative;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Type;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by Jasmin on 16.05.2017.
 */
public class PinboardView extends BaseView implements IPinboardView
{


    private List<IPinboardViewListener> listeners;
    private Navigator navigator;

    public PinboardView()
    {

        listeners = new ArrayList<>();

        VerticalLayout mainLayout = new VerticalLayout();

        navigator = new Navigator(UI.getCurrent(), mainLayout);


        HorizontalLayout titleBar = new HorizontalLayout();
        Label title = new Label("Pinnwand");
        title.setStyleName("toolbarTitle");

        titleBar.addComponent(title);
        titleBar.setExpandRatio(title, 1.0f); // Expand
        mainLayout.addComponent(titleBar);
        mainLayout.setComponentAlignment(titleBar, Alignment.TOP_CENTER);


        Button addButton = new Button(VaadinIcons.PLUS_CIRCLE);
        mainLayout.addComponent(addButton);
        mainLayout.setComponentAlignment(addButton, Alignment.TOP_RIGHT);
//        addButton.addClickListener(c -> navigator.navigateTo(PinCreationView.class));


        mainLayout.addComponent(createPinboardLayoutWithPins(getPinBoardTEST()));
        setCompositionRoot(mainLayout);
    }

    private PinboardModel getPinBoardTEST()
    {
        PinboardModel pinboard = new PinboardModel();
        Relative relative = new Relative();
        Patient patient = new Patient("Hans", "Muster");

        pinboard.addEntry(new PinBoardEntry(Type.WARNING, "TitleBlabla", "blablablabla", relative, new Date()));
        pinboard.addEntry(new PinBoardEntry(Type.ALERT, "TitleBlabla2", "blablablabla2", patient, new Date()));
        pinboard.addEntry(new PinBoardEntry(Type.INFORMATION, "TitleBlabla3", "blablablabla3", patient, new Date()));
        pinboard.addEntry(new PinBoardEntry(Type.WARNING, "TitleBlabla", "blablablabla", relative, new Date()));

        return pinboard;
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
    }

    private static Layout createPinboardLayoutWithPins(PinboardModel pinboard)
    {
        Layout pinboardLayout = new VerticalLayout();
        pinboardLayout.setSizeFull();


        pinboard.getEntries().forEach(entry ->
                pinboardLayout.addComponent(createPinEntry(entry)));

        return pinboardLayout;
    }

//    private static Panel createPinboardEntryPanel(PinboardModel pinboard)
//    {
//        Panel pinEntryPanel = new Panel();
//        pinEntryPanel.setScrollLeft(10);
//        Layout entriesLayout = new VerticalLayout();
//        pinEntryPanel.setContent(entriesLayout);
//
//        pinboard.getEntries().forEach(entry ->
//                entriesLayout.addComponent(createPinEntry(entry)));
//
//
//        return pinEntryPanel;
//    }


    private static Panel createPinEntry(PinBoardEntry entry)
    {
        Panel pinPanel = new Panel(entry.getTitle());
        Layout panelLayout = new VerticalLayout();
        panelLayout.setSizeFull();

        pinPanel.setContent(panelLayout);
        pinPanel.setSizeFull();

        String nameAuthor = entry.getAuthor().getFirstName() + entry.getAuthor().getLastName();
        String formattedDate = new SimpleDateFormat("dd.MM.yyyy").format(entry.getCreationDate());

        panelLayout.addComponents(new Label(nameAuthor), new Label(formattedDate), new Label(entry.getMessage()));

        return pinPanel;
    }

}
