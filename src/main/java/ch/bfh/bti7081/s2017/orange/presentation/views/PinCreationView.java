package ch.bfh.bti7081.s2017.orange.presentation.views;

import ch.bfh.bti7081.s2017.orange.persistence.entity.Type;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jasmin on 16.05.2017.
 */
public class PinCreationView extends BaseView implements IPinboardView
{
    private List<IPinboardViewListener> listeners;

    public PinCreationView()
    {
        listeners = new ArrayList<>();

        VerticalLayout mainLayout = new VerticalLayout();

        HorizontalLayout titleBar = new HorizontalLayout();
        Label title = new Label("Pinnwand");

        titleBar.addComponent(title);
        titleBar.setExpandRatio(title, 1.0f); // Expand
        mainLayout.addComponent(titleBar);
        mainLayout.setComponentAlignment(titleBar, Alignment.TOP_CENTER);

        mainLayout.addComponent(createForm());

        setCompositionRoot(mainLayout);
    }

    @Override
    public String getViewName()
    {
        return "PinboradCreationView";
    }

    @Override
    public String getCaption()
    {
        return "";
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent)
    {
    }

    private static FormLayout createForm()
    {
        FormLayout form = new FormLayout();
        TextField tf1 = new TextField("Title");
        tf1.setRequiredIndicatorVisible(true);
        form.addComponent(tf1);

        List<Type> entryTypes = new ArrayList<>();
        entryTypes.add(Type.ALERT);
        entryTypes.add(Type.INFORMATION);
        entryTypes.add(Type.WARNING);

        ComboBox<Type> select =
                new ComboBox<>("Select type...");
        select.setItems(entryTypes);
        form.addComponent(select);

        TextArea area = new TextArea("Message");
        area.setRequiredIndicatorVisible(true);
        form.addComponent(area);

        return form;
    }

}
