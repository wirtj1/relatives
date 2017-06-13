package ch.bfh.bti7081.s2017.orange.presentation.presenter;

import ch.bfh.bti7081.s2017.orange.businesslogic.models.ChangePasswordModel;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Account;
import ch.bfh.bti7081.s2017.orange.persistence.repository.impl.AccountRepository;
import ch.bfh.bti7081.s2017.orange.presentation.utils.ParameterSet;
import ch.bfh.bti7081.s2017.orange.presentation.utils.Session;
import ch.bfh.bti7081.s2017.orange.presentation.views.ChangePasswordView;
import ch.bfh.bti7081.s2017.orange.presentation.views.IChangePasswordView;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.Page;
import com.vaadin.shared.Position;
import com.vaadin.ui.Notification;

/**
 * Created by Sascha on 12/06/2017.
 */
public class ChangePasswordPresenter extends BasePresenter<ChangePasswordView, ChangePasswordModel> implements IChangePasswordView.IChangePasswordViewListener {
    public ChangePasswordPresenter(ChangePasswordView view, ChangePasswordModel model) {
        super(view, model);
        view.addListener(this);
    }

    @Override
    public void onEnter(ParameterSet parameter) {

    }

    @Override
    public void changePassword(String password, String password2) {

        if (password.isEmpty()){
            Notification noValueEnteredMsg = new Notification("Warning", "Password must contain any characters", Notification.Type.WARNING_MESSAGE);
            noValueEnteredMsg.setPosition(Position.TOP_CENTER);
            noValueEnteredMsg.setIcon(VaadinIcons.WARNING);
            noValueEnteredMsg.setDelayMsec(15 * 1000);
            noValueEnteredMsg.show(Page.getCurrent());
            return;
        }

        if (!password.equals(password2)){
            Notification noMatchMsg = new Notification("Warning", "Passwords do not match!", Notification.Type.WARNING_MESSAGE);
            noMatchMsg.setPosition(Position.TOP_CENTER);
            noMatchMsg.setIcon(VaadinIcons.WARNING);
            noMatchMsg.setDelayMsec(15 * 1000);
            noMatchMsg.show(Page.getCurrent());
            return;
        }

        Session session = view.getUI().getSession().getAttribute(Session.class);
        Account account = session.getAccount();
        account.setPassword(password);
        AccountRepository repo = new AccountRepository(Account.class);
        repo.persist(account);

        view.closeWindow();

        Notification successMsg = new Notification("Success", "Password has been changed. Please log-in again", Notification.Type.TRAY_NOTIFICATION);
        successMsg.setPosition(Position.TOP_CENTER);
        successMsg.setIcon(VaadinIcons.INFO_CIRCLE_O);
        successMsg.setDelayMsec(15 * 1000);
        successMsg.show(Page.getCurrent());

        view.getUI().doLogout();
    }

    @Override
    public void cancel() {
        view.closeWindow();
        view.getUI().getNavigator().navigateBack();
    }
}
