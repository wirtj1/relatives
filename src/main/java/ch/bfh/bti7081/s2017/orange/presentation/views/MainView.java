package ch.bfh.bti7081.s2017.orange.presentation.views;

import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sascha on 01/05/2017.
 */
public class MainView extends CustomComponent implements IMainView, IMainView.IMainViewListener {

    private List<IMainViewListener> listeners;
    private Label lblUserName;
    private Button btnLogout;
    private TextField pwdTxt;

    public MainView(){
        listeners = new ArrayList<>();
        lblUserName = new Label();
        btnLogout = new Button("Logout");
        btnLogout.addClickListener(clickEvent -> this.logout());
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

    @Override
    public void logout() {
        for (IMainViewListener listener : listeners){
            listener.logout();
        }
    }
}
