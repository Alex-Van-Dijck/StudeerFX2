package StudeerFX.view.TestVoorbereiden;

import StudeerFX.model.StudeerModel;
import StudeerFX.view.TestVoorbereiden.TestVoorbereidenView;

/**
 * @author Alex Van Dijck on 27/02/2020
 * @project StudeerFX
 */
public class TestVoorbereidenPresenter {
    private StudeerModel model;
    private TestVoorbereidenView view;

    public TestVoorbereidenPresenter(StudeerModel model,TestVoorbereidenView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {

    }

    private void updateView() {

    }
}



