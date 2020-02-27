package StudeerFX.view.Menu;

/**
 * @author Alex Van Dijck on 25/02/2020
 * @project StudeerFX
 */

import StudeerFX.model.StudeerModel;
import StudeerFX.view.Invoeren.InvoerenPresenter;
import StudeerFX.view.Invoeren.InvoerenView;
import StudeerFX.view.Start.StartView;
import StudeerFX.view.TestVoorbereiden.TestVoorbereidenPresenter;
import StudeerFX.view.TestVoorbereiden.TestVoorbereidenView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class MenuPresenter {
    private StudeerModel model;
    private MenuView view;

    public MenuPresenter(StudeerModel model, MenuView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        view.getKnop1().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                InvoerenView invoerenView = new InvoerenView();
                InvoerenPresenter invoerenPresenter = new InvoerenPresenter(model, invoerenView);
                view.getScene().setRoot(invoerenView);
               invoerenView.getScene().getWindow().sizeToScene();
            }
        });
        view.getKnop2().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TestVoorbereidenView testVoorbereidenView = new TestVoorbereidenView();
                TestVoorbereidenPresenter testVoorbereidenPresenter = new TestVoorbereidenPresenter(model, testVoorbereidenView);
                view.getScene().setRoot(testVoorbereidenView);
                testVoorbereidenView.getScene().getWindow().sizeToScene();
            }
        });
    }

    private void updateView() {

    }
}


