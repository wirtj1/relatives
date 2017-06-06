package ch.bfh.bti7081.s2017.orange.presentation.views;

import ch.bfh.bti7081.s2017.orange.persistence.entity.PinBoardEntry;
import ch.bfh.bti7081.s2017.orange.presentation.views.IBaseView.IBaseViewListener;
import com.vaadin.navigator.View;

/**
 * Created by Jasmin on 16.05.2017.
 */
public interface IPinboardView extends View {

    interface IPinboardViewListener extends IBaseViewListener {
        void navigateToAddPinEntry();
        void onViewEnter();
    }

    interface IPinCreationViewListener extends IBaseViewListener {
        void createPinEntry(PinBoardEntry entry);
        void onViewEnter();
    }

    void addListener(IBaseViewListener listener);
}
