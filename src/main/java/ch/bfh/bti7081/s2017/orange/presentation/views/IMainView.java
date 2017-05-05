package ch.bfh.bti7081.s2017.orange.presentation.views;

/**
 * Created by Sascha on 01/05/2017.
 */
public interface IMainView {
    void setUsername(String username);

    interface IMainViewListener {
        void logout();
    }

    void addListener(IMainViewListener listener);
}
