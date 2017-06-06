package ch.bfh.bti7081.s2017.orange.presentation.views;

import ch.bfh.bti7081.s2017.orange.businesslogic.models.PinboardModel;
import ch.bfh.bti7081.s2017.orange.persistence.entity.PinBoardEntry;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


/**
 * Created by Jasmin on 16.05.2017.
 */
public class PinboardView extends BaseView implements IPinboardView {


    private List<IPinboardViewListener> listeners;

    private VerticalLayout mainLayout;


    VerticalLayout pinboardLayoutWithPins;


    public PinboardView() {

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
    public String getViewName() {
        return "PinboradView";
    }

    @Override
    public String getCaption() {
        return "Pinnwand";
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        for (IPinboardViewListener listener : listeners) {
            listener.onViewEnter();
        }
    }

    private void updatePinboardLayoutWithPins(PinboardModel pinboard) {
        pinboardLayoutWithPins.removeAllComponents();
        pinboardLayoutWithPins.setSizeFull();

        pinboard.getEntries().forEach(entry ->
                pinboardLayoutWithPins.addComponent(createPinEntry(entry)));

    }


    private static Panel createPinEntry(PinBoardEntry entry) {
        Panel pinPanel = new Panel(entry.getTitle());
        VerticalLayout panelLayout = new VerticalLayout();

        panelLayout.setSizeFull();

        pinPanel.setContent(panelLayout);
        pinPanel.setSizeFull();

        Label lblType = new Label(entry.getType().name().toUpperCase(Locale.ENGLISH));
        String nameAuthor = entry.getAuthor().getFirstName() + entry.getAuthor().getLastName();
        String formattedDate = new SimpleDateFormat("dd.MM.yyyy").format(entry.getCreationDate());


        panelLayout.addComponents(lblType, new Label(nameAuthor), new Label(formattedDate), new Label(entry.getMessage()));
        panelLayout.setComponentAlignment(lblType, Alignment.TOP_RIGHT);

        return pinPanel;
    }

    private void navigateToAddPinEntryView(Button.ClickEvent event) {
        for (IPinboardViewListener listener : listeners)
            listener.navigateToAddPinEntry();
    }


    public void setPinboardModel(PinboardModel pinboardModel) {

        updatePinboardLayoutWithPins(pinboardModel);
        mainLayout.addComponent(pinboardLayoutWithPins);
    }

    @Override
    public void addListener(IBaseViewListener listener) {
        if (listener instanceof IPinboardViewListener) {
            listeners.add((IPinboardViewListener) listener);
        }

    }
}
