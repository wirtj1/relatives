package ch.bfh.bti7081.s2017.orange.presentation.views;

import ch.bfh.bti7081.s2017.orange.presentation.utils.ParameterSet;

/**
 * Created by Sascha on 12/06/2017.
 */
public interface IChangePasswordView extends IBaseView {
    interface IChangePasswordViewListener extends IBaseViewListener{
        void onEnter(ParameterSet parameter);
        void changePassword(String password, String password2);
        void cancel();
    }

    void addListener(IChangePasswordViewListener listener);
}
