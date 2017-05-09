package ch.bfh.bti7081.s2017.orange.presentation.views;

import ch.bfh.bti7081.s2017.orange.presentation.utils.ParameterSet;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sascha on 01/05/2017.
 */
public class TestView extends BaseView implements ITestView, ITestView.ITestViewListener {

    private List<ITestViewListener> listeners;
    private Label lblUserName;

    public TestView(){
        listeners = new ArrayList<>();
        lblUserName = new Label();

        lblUserName.setValue("hello world");
        VerticalLayout layout = new VerticalLayout();
        layout.addComponent(lblUserName);

        setCompositionRoot(layout);
    }

    @Override
    public void setMessage(String value) {
        lblUserName.setValue(value);
    }

    @Override
    public void addListener(ITestViewListener listener) {
        listeners.add(listener);
    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        String parameters = viewChangeEvent.getParameters();
        ParameterSet decodeParameterSet = ParameterSet.decode(parameters);
        lblUserName.setValue("Message was: " + decodeParameterSet.getParameter("message"));
    }

    @Override
    public String getViewName() {
        return "Test";
    }

    @Override
    public String getCaption() {
        return "Test";
    }
}
