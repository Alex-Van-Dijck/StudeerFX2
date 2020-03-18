package StudeerFX.view.Menu;

/**
 * @author Alex Van Dijck on 25/02/2020
 * @project StudeerFX
 */

import StudeerFX.model.Spel;
import StudeerFX.view.Highscores.HighscoresPresenter;
import StudeerFX.view.Highscores.HighscoresView;
import StudeerFX.view.Invoeren.InvoerenPresenter;
import StudeerFX.view.Invoeren.InvoerenView;
import StudeerFX.view.TestVoorbereiden.TestVoorbereidenPresenter;
import StudeerFX.view.TestVoorbereiden.TestVoorbereidenView;
import com.sun.prism.paint.Color;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class MenuPresenter {
    private Spel model;
    private MenuView view;
    public MenuPresenter(Spel model, MenuView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }
    //eventhandlers voor alle buttons van menu
    private void addEventHandlers() {
        //Handler om naar Invoeren te gaan
        view.getKnop1().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                InvoerenView invoerenView = new InvoerenView();
                InvoerenPresenter invoerenPresenter = new InvoerenPresenter(model, invoerenView);
                view.getScene().setRoot(invoerenView);
               invoerenView.getScene().getWindow().sizeToScene();
            }
        });
        //Handler om naar Test voorbereiden te gaan
        view.getKnop2().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TestVoorbereidenView testVoorbereidenView = new TestVoorbereidenView();
                TestVoorbereidenPresenter testVoorbereidenPresenter = new TestVoorbereidenPresenter(model, testVoorbereidenView);
                view.getScene().setRoot(testVoorbereidenView);
                testVoorbereidenView.getScene().getWindow().sizeToScene();
            }
        });
        //Handler om naar highscoresPresenter
        view.getKnop3().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HighscoresView highscoresView = new HighscoresView();
                HighscoresPresenter highscoresPresenter = new HighscoresPresenter(model, highscoresView);
                view.getScene().setRoot(highscoresView);
                highscoresView.getScene().getWindow().sizeToScene();
            }
        });
        //Handler om spel af te sluiten en om comfirmation te vragen.
        view.getKnop4().setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        Alert alert = new Alert(Alert.AlertType.NONE);
                        alert.setHeaderText("Wil je het spel sluiten?");
                        ButtonType nee = new ButtonType("Nee");
                        ButtonType ja = new ButtonType("Ja");
                        alert.getButtonTypes().addAll(nee, ja);
                        alert.showAndWait();
                        if (alert.getResult() == null || alert.getResult().equals(nee)) {
                            event.consume();
                        }else{
                            Platform.exit();
                        }
                    }
                }
                );

//                view.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
//                    @Override
//                    public void handle(WindowEvent event) {
//                        Alert alert = new Alert(Alert.AlertType.NONE);
//                        alert.setHeaderText("Wil je het spel sluiten?");
//                        ButtonType nee = new ButtonType("Nee");
//                        ButtonType ja = new ButtonType("Ja");
//                        alert.getButtonTypes().addAll(nee, ja);
//                        alert.showAndWait();
//                        if (alert.getResult() == null || alert.getResult().equals(nee)) {
//                            event.consume();
//                        }else{
//                            Platform.exit();
//                        }
//                    }
//                });

    }
    //Naam doorgeven als de view wordt geupdate.
    private void updateView() {
        view.getMenuNaam().setText(model.getNaam());

    }
}


