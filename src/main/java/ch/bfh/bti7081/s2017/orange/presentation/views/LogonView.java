package ch.bfh.bti7081.s2017.orange.presentation.views;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Login screen for application
 *
 * @author Sascha
 */
public class LogonView extends BaseView implements ILogonView {

    private List<ILogonViewListener> listeners;
    private TextField _userName;
    private PasswordField _password;
    private Button _doLogon;

    public LogonView(){
        listeners = new ArrayList<>();
        _userName = new TextField("User");
        _password = new PasswordField("Password");
        _doLogon = new Button("Logon");
        _doLogon.addClickListener(clickEvent -> doLogonClick(clickEvent));

        VerticalLayout innerContainer = new VerticalLayout();
        innerContainer.setWidth(300, Unit.PIXELS);

        innerContainer.addComponent(_userName);
        innerContainer.addComponent(_password);
        innerContainer.addComponent(_doLogon);

        VerticalLayout outerContainer = new VerticalLayout();
        outerContainer.addComponent(innerContainer);
        outerContainer.setComponentAlignment(innerContainer, Alignment.MIDDLE_CENTER);

        setCompositionRoot(outerContainer);
    }

    private void doLogonClick(Button.ClickEvent event){
        for (ILogonViewListener listener : listeners){
            listener.doLogin(_userName.getValue(), _password.getValue());
        }
    }

    @Override
    public void addListener(ILogonViewListener listener) {
        listeners.add(listener);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }

    @Override
    public String getViewName() {
        return "Logon";
    }

    @Override
    public String getCaption() {
        return "Logon";
    }
}
