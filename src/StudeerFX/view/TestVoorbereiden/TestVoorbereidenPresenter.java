package StudeerFX.view.TestVoorbereiden;

import StudeerFX.model.StudeerModel;
import StudeerFX.view.Menu.MenuPresenter;
import StudeerFX.view.Menu.MenuView;
import StudeerFX.view.TestVoorbereiden.TestVoorbereidenView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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
        view.getTerug().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MenuView menuView = new MenuView();
                MenuPresenter menuPresenter = new MenuPresenter(model, menuView);
                view.getScene().setRoot(menuView);
                menuView.getScene().getWindow().sizeToScene();
            }
        });
    }

    private void updateView() {

    }
}



