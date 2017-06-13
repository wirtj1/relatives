package ch.bfh.bti7081.s2017.orange.presentation.views;

import ch.bfh.bti7081.s2017.orange.presentation.utils.ParameterSet;
import com.vaadin.event.ShortcutAction;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Page;
import com.vaadin.shared.Position;
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
    private Window win;

    public LogonView(){
        listeners = new ArrayList<>();
        _userName = new TextField("User");
        _userName.setWidth(250, Unit.PIXELS);
        _password = new PasswordField("Password");
        _password.setWidth(250, Unit.PIXELS);
        _doLogon = new Button("Logon");
        _doLogon.addClickListener(clickEvent -> doLogonClick(clickEvent));
        _doLogon.setClickShortcut(ShortcutAction.KeyCode.ENTER);

        VerticalLayout windowContent = new VerticalLayout();

        windowContent.addComponent(_userName);
        windowContent.addComponent(_password);
        windowContent.addComponent(_doLogon);

        win = new Window("Login");
        win.setContent(windowContent);
        win.center();
        win.setModal(true);
        win.setClosable(false);
        win.setResizable(false);
        win.setIcon(VaadinIcons.SIGN_IN);
    }

    private void doLogonClick(Button.ClickEvent event){

        

        for (ILogonViewListener listener : listeners){
            listener.doLogin(_userName.getValue(), _password.getValue());
        }
    }

    public void closeWindow() {
        UI.getCurrent().removeWindow(win);
    }

    @Override
    public void addListener(ILogonViewListener listener) {
        listeners.add(listener);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        ParameterSet parameter = ParameterSet.decode(viewChangeEvent.getParameters());
        // Logout was due to timeout
        if (!parameter.getParameter("timeout").isEmpty()){
            Notification timeoutMsg = new Notification("Timeout", "You have been logged out due to inactivity");
            timeoutMsg.setPosition(Position.TOP_CENTER);
            timeoutMsg.setIcon(VaadinIcons.INFO_CIRCLE_O);
            timeoutMsg.setDelayMsec(15 * 1000);
            timeoutMsg.show(Page.getCurrent());
        }

        _password.setValue("");
        _userName.focus();
        UI.getCurrent().addWindow(win);
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
