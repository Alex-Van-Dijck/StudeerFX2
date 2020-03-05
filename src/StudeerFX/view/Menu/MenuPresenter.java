package StudeerFX.view.Menu;

/**
 * @author Alex Van Dijck on 25/02/2020
 * @project StudeerFX
 */

import StudeerFX.model.StudeerModel;
import StudeerFX.view.Highscores.HighscoresPresenter;
import StudeerFX.view.Highscores.HighscoresView;
import StudeerFX.view.Invoeren.InvoerenPresenter;
import StudeerFX.view.Invoeren.InvoerenView;
import StudeerFX.view.Start.StartView;
import StudeerFX.view.TestVoorbereiden.TestVoorbereidenPresenter;
import StudeerFX.view.TestVoorbereiden.TestVoorbereidenView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.WindowEvent;


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
        view.getKnop3().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HighscoresView highscoresView = new HighscoresView();
                HighscoresPresenter highscoresPresenter = new HighscoresPresenter(model, highscoresView);
                view.getScene().setRoot(highscoresView);
                highscoresView.getScene().getWindow().sizeToScene();
            }
        });
//        view.getScene().getWindow().setOnCloseRequest(
//                new EventHandler<WindowEvent>() {
//                    @Override
//                    public void handle(WindowEvent event) {
//                        Alert alert = new Alert(Alert.AlertType.WARNING);
//                        alert.setHeaderText("Wil je het spel sluiten?");
//                        alert.setContentText("Ben je zeker?");
//                        ButtonType no = new ButtonType("No");
//                        ButtonType yes = new ButtonType("Yes");
//                        alert.getButtonTypes().addAll(no, yes);
//                        alert.showAndWait();
//                        if (alert.getResult() == null || alert.getResult().equals(no)) {
//                            event.consume();
//                        }
//                    }
//                }
//        );
    }

    private void updateView() {

    }
}


