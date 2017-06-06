package ch.bfh.bti7081.s2017.orange.presentation.views;

import ch.bfh.bti7081.s2017.orange.BaseUI;
import com.vaadin.ui.*;

/**
 * @author Sascha
 * @author Leandro
 */
public abstract class BaseView extends CustomComponent implements IBaseView {

    public abstract String getViewName();

    public abstract String getCaption();

    @Override
    public BaseUI getUI() {
        return (BaseUI) super.getUI();
    }


    void setViewTitle(VerticalLayout viewLayout) {
        HorizontalLayout titleBar = new HorizontalLayout();
        Label title = new Label(getCaption());

        title.setStyleName("toolbarTitle");

        titleBar.addComponent(title);
        titleBar.setExpandRatio(title, 1.0f); // Expand
        viewLayout.addComponent(titleBar);
        viewLayout.setComponentAlignment(titleBar, Alignment.TOP_CENTER);
    }

}
