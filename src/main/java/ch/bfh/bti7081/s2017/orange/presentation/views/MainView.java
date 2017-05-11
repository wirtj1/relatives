package ch.bfh.bti7081.s2017.orange.presentation.views;

import ch.bfh.bti7081.s2017.orange.BaseNavigator;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.TextField;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy MainView
 */
public class MainView extends BaseView implements IMainView {

    private List<IMainViewListener> listeners;
    private Label lblUserName;
    private Button btnLogout;
    private TextField pwdTxt;

    public MainView(){
        listeners = new ArrayList<>();
        lblUserName = new Label();
        btnLogout = new Button("Logout");
        btnLogout.addClickListener(clickEvent -> this.logout(getUI().getNavigator()));
        pwdTxt = new TextField();

        VerticalLayout layout = new VerticalLayout();
        layout.addComponent(lblUserName);
        layout.addComponent(pwdTxt);
        layout.addComponent(btnLogout);

        setCompositionRoot(layout);
    }

    @Override
    public void setUsername(String value) {
        lblUserName.setValue(value);
    }

    @Override
    public void addListener(IMainViewListener listener) {
        listeners.add(listener);
    }

    public void logout(BaseNavigator navigator) {
        for (IMainViewListener listener : listeners){
            listener.logout(getUI().getNavigator());
        }
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }

    @Override
    public String getViewName() {
        return "Main";
    }

    @Override
    public String getCaption() {
        return "Main";
    }
}
