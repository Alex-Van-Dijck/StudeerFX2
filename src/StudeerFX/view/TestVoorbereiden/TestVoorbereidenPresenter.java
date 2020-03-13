package StudeerFX.view.TestVoorbereiden;

import StudeerFX.model.Spel;
import StudeerFX.model.Vragen;
import StudeerFX.view.Menu.MenuPresenter;
import StudeerFX.view.Menu.MenuView;
import StudeerFX.view.TestInvullen.TestInvullenPresenter;
import StudeerFX.view.TestInvullen.TestInvullenView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * @author Alex Van Dijck on 27/02/2020
 * @project StudeerFX
 */
public class TestVoorbereidenPresenter {
    private Spel model;
    private Vragen vragen;
    private TestVoorbereidenView view;

    public TestVoorbereidenPresenter(Spel model, TestVoorbereidenView view) {
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
        view.getAfnemen().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TestInvullenView testInvullenView = new TestInvullenView();
                TestInvullenPresenter testInvullenPresenter = new TestInvullenPresenter(model, testInvullenView);
                view.getScene().setRoot(testInvullenView);
                testInvullenView.getScene().getWindow().sizeToScene();
            }
        });
    }

    private void updateView() {

    }
}



