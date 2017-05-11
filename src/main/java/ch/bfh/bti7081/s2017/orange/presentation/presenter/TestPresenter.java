package ch.bfh.bti7081.s2017.orange.presentation.presenter;

import ch.bfh.bti7081.s2017.orange.businesslogic.models.TestModel;
import ch.bfh.bti7081.s2017.orange.presentation.views.ITestView;
import ch.bfh.bti7081.s2017.orange.presentation.views.TestView;

/**
 * Test presenter for navigation development
 */
public class TestPresenter  extends BasePresenter<TestView, TestModel> implements ITestView.ITestViewListener {

    public TestPresenter(TestView view, TestModel model){
        super(view, model);

        view.addListener(this);
    }


}
