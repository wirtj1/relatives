package ch.bfh.bti7081.s2017.orange.presentation.views;

import ch.bfh.bti7081.s2017.orange.presentation.utils.ParameterSet;
import com.vaadin.data.ValidationResult;
import com.vaadin.data.Validator;
import com.vaadin.data.ValueContext;
import com.vaadin.data.validator.AbstractValidator;
import com.vaadin.event.ShortcutAction;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Page;
import com.vaadin.shared.Position;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sascha on 12/06/2017.
 */
public class ChangePasswordView extends BaseView implements IChangePasswordView {

    private List<IChangePasswordViewListener> listeners;
    private PasswordField password;
    private PasswordField passwordValidation;
    private Button changePassword;
    private Button cancel;
    private Window win;

    public ChangePasswordView()
    {
        listeners = new ArrayList<>();

        password = new PasswordField("New");
        password.setWidth(250, Unit.PIXELS);
        passwordValidation = new PasswordField("Enter again");
        passwordValidation.setWidth(250, Unit.PIXELS);
        changePassword = new Button("Change");
        changePassword.addClickListener(clickEvent -> changePassword());
        changePassword.setClickShortcut(ShortcutAction.KeyCode.ENTER);
        cancel = new Button("Cancel");
        cancel.addClickListener(clickEvent -> cancel());

        VerticalLayout windowContent = new VerticalLayout();

        windowContent.addComponent(password);
        windowContent.addComponent(passwordValidation);
        windowContent.addComponent(changePassword);
        windowContent.addComponent(cancel);

        win = new Window("Change password");
        win.setContent(windowContent);
        win.center();
        win.setModal(true);
        win.setClosable(false);
        win.setResizable(false);
        win.setIcon(VaadinIcons.PASSWORD);
    }

    @Override
    public void addListener(IChangePasswordViewListener listener) {
        listeners.add(listener);
    }

    @Override
    public String getViewName() {
        return "ChangePassword";
    }

    @Override
    public String getCaption() {
        return "Change password";
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        for (IChangePasswordViewListener listener : listeners){
            listener.onEnter(ParameterSet.decode(viewChangeEvent.getParameters()));
        }

        password.setValue("");
        passwordValidation.setValue("");

        password.focus();

        UI.getCurrent().addWindow(win);
    }

    public void closeWindow() {
        UI.getCurrent().removeWindow(win);
    }

    private void changePassword(){
        for (IChangePasswordViewListener listener : listeners){
            listener.changePassword(password.getValue(), passwordValidation.getValue());
        }
    }

    private void cancel() {
        for (IChangePasswordViewListener listener : listeners){
            listener.cancel();
        }
    }
}
